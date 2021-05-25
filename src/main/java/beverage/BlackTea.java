package beverage;

import resource.Resource;

public class BlackTea extends Beverage {
    private final int hotWater;
    private final int gingerSyrup;
    private final int sugarSyrup;
    private final int teaLeavesSyrup;

    BlackTea(Resource resource, int hotWater, int gingerSyrup, int sugar_syrup, int teaLeavesSyrup) {
        super(resource);
        this.hotWater = hotWater;
        this.gingerSyrup = gingerSyrup;
        this.sugarSyrup = sugar_syrup;
        this.teaLeavesSyrup = teaLeavesSyrup;
    }

    public static BlackTeaBuilder builder() {
        return new BlackTeaBuilder();
    }

    @Override
    public boolean make() {
        if (!resource.getHotWater(this.hotWater)) {
            System.out.println("Black Tea can't be Prepared because hot water is not sufficient");
            return false;
        }

        if(!resource.getGingerSyrup(this.gingerSyrup)) {
            resource.addHotWater(this.hotWater);
            System.out.println("Black Tea can't be Prepared because ginger syrup is not sufficient");
            return false;
        }

        if(!resource.getTeaLeavesSyrup(this.teaLeavesSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addGingerSyrup(this.gingerSyrup);
            System.out.println("Black Tea can't be Prepared because tea-leaves syrup is not sufficient");
            return false;
        }

        if (!resource.getSugarSyrup(this.sugarSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addGingerSyrup(this.gingerSyrup);
            resource.addTeaLeavesSyrup(this.teaLeavesSyrup);
            System.out.println("Black Tea can't be Prepared because sugar syrup is not sufficient");
            return false;
        }
        System.out.println(Thread.currentThread().getName()+ ": " + "Black Tea is Prepared");
        return  true;
    }

    public static class BlackTeaBuilder {
        private Resource resource;
        private int hotWater;
        private int gingerSyrup;
        private int sugarSyrup;
        private int teaLeavesSyrup;

        BlackTeaBuilder() {
        }

        public BlackTeaBuilder resource(Resource resource) {
            this.resource = resource;
            return this;
        }

        public BlackTeaBuilder hotWater(int hotWater) {
            this.hotWater = hotWater;
            return this;
        }

        public BlackTeaBuilder gingerSyrup(int gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            return this;
        }

        public BlackTeaBuilder sugarSyrup(int sugar_syrup) {
            this.sugarSyrup = sugar_syrup;
            return this;
        }

        public BlackTeaBuilder teaLeavesSyrup(int teaLeavesSyrup) {
            this.teaLeavesSyrup = teaLeavesSyrup;
            return this;
        }

        public BlackTea build() {
            return new BlackTea(resource, hotWater, gingerSyrup, sugarSyrup, teaLeavesSyrup);
        }

        public String toString() {
            return "BlackTea.BlackTeaBuilder(resource=" + this.resource + ", hotWater=" + this.hotWater + ", gingerSyrup=" + this.gingerSyrup + ", sugar_syrup=" + this.sugarSyrup + ", teaLeavesSyrup=" + this.teaLeavesSyrup + ")";
        }
    }
}
