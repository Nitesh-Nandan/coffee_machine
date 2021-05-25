package beverage;

import ingredients.Resource;

public class HotTea extends Beverage {
    private final int hotWater;
    private final int hotMilk;
    private final int gingerSyrup;
    private final int sugarSyrup;
    private final int teaLeavesSyrup;

    HotTea(Resource resource, int hotWater, int hotMilk, int gingerSyrup, int sugarSyrup, int teaLeavesSyrup) {
        super(resource);
        this.hotWater = hotWater;
        this.hotMilk = hotMilk;
        this.gingerSyrup = gingerSyrup;
        this.sugarSyrup = sugarSyrup;
        this.teaLeavesSyrup = teaLeavesSyrup;
    }

    public static HotTeaBuilder builder() {
        return new HotTeaBuilder();
    }


    @Override
    public boolean make() {
        if (!resource.getHotWater(this.hotWater)) {
            System.out.println("Hot Tea can't be Prepared because water is not sufficient");
            return false;
        }

        if (!resource.getHotMilk(this.hotMilk)) {
            resource.addHotWater(this.hotWater);
            System.out.println("Hot Tea can't be Prepared because milk is not sufficient");
            return false;
        }

        if(!resource.getGingerSyrup(this.gingerSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addHotMilk(this.hotMilk);
            System.out.println("Hot Tea can't be Prepared because ginger syrup is not sufficient");
            return false;
        }

        if(!resource.getTeaLeavesSyrup(this.teaLeavesSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addHotMilk(this.hotMilk);
            resource.addGingerSyrup(this.gingerSyrup);
            System.out.println("Hot Tea can't be Prepared because tea-leaves syrup is not sufficient");
            return false;
        }

       if (!resource.getSugarSyrup(this.sugarSyrup)) {
           resource.addHotWater(this.hotWater);
           resource.addHotMilk(this.hotMilk);
           resource.addGingerSyrup(this.gingerSyrup);
           resource.addTeaLeavesSyrup(this.teaLeavesSyrup);
           System.out.println("Hot Tea can't be Prepared because sugar syrup is not sufficient");
           return false;
       }
        System.out.println(Thread.currentThread().getName()+ ": " + "Hot Tea is Prepared");
        return  true;
    }

    public static class HotTeaBuilder {
        private Resource resource;
        private int hotWater;
        private int hotMilk;
        private int gingerSyrup;
        private int sugarSyrup;
        private int teaLeavesSyrup;

        HotTeaBuilder() {
        }

        public HotTeaBuilder resource(Resource resource) {
            this.resource = resource;
            return this;
        }

        public HotTeaBuilder hotWater(int hotWater) {
            this.hotWater = hotWater;
            return this;
        }

        public HotTeaBuilder hotMilk(int hotMilk) {
            this.hotMilk = hotMilk;
            return this;
        }

        public HotTeaBuilder gingerSyrup(int gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            return this;
        }

        public HotTeaBuilder sugarSyrup(int sugarSyrup) {
            this.sugarSyrup = sugarSyrup;
            return this;
        }

        public HotTeaBuilder teaLeavesSyrup(int teaLeavesSyrup) {
            this.teaLeavesSyrup = teaLeavesSyrup;
            return this;
        }

        public HotTea build() {
            return new HotTea(resource, hotWater, hotMilk, gingerSyrup, sugarSyrup, teaLeavesSyrup);
        }
    }
}
