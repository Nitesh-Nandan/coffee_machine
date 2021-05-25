package beverage;

import ingredients.Resource;

public class GreenTea extends Beverage {
    private final int hotWater;
    private final int gingerSyrup;
    private final int greenMixture;
    private final int sugarSyrup;

    GreenTea(Resource resource, int hotWater, int gingerSyrup, int greenMixture, int sugarSyrup) {
       super(resource);
        this.hotWater = hotWater;
        this.gingerSyrup = gingerSyrup;
        this.greenMixture = greenMixture;
        this.sugarSyrup = sugarSyrup;
    }

    @Override
    public boolean make() {
        if (!resource.getHotWater(this.hotWater)) {
            System.out.println("Green Tea can't be Prepared because water is not sufficient");
            return false;
        }

        if(!resource.getGingerSyrup(this.gingerSyrup)) {
            resource.addHotWater(this.hotWater);
            System.out.println("Green Tea can't be Prepared because ginger syrup is not sufficient");
            return false;
        }

        if(!resource.getGreenMixture(this.greenMixture)) {
            resource.addHotWater(this.hotWater);
            resource.addGingerSyrup(this.gingerSyrup);
            System.out.println("Green Tea can't be Prepared because green mixture is not sufficient");
            return false;
        }

        if (!resource.getSugarSyrup(this.sugarSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addGingerSyrup(this.gingerSyrup);
            resource.addGreenMixture(this.greenMixture);
            System.out.println("Green Tea can't be Prepared because sugar syrup is not sufficient");
            return false;
        }
        System.out.println(Thread.currentThread().getName()+ ": " + "Green Tea is Prepared");
        return  true;
    }

    public static GreenTeaBuilder builder() {
        return new GreenTeaBuilder();
    }

    public static class GreenTeaBuilder {
        private Resource resource;
        private int hotWater = 0;
        private int gingerSyrup = 0;
        private int greenMixture = 0;
        private int sugarSyrup = 0;

        GreenTeaBuilder() {
        }

        public GreenTeaBuilder resource(Resource resource) {
            this.resource = resource;
            return this;
        }

        public GreenTeaBuilder hotWater(int hotWater) {
            this.hotWater = hotWater;
            return this;
        }

        public GreenTeaBuilder gingerSyrup(int gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            return this;
        }

        public GreenTeaBuilder greenMixture(int greenMixture) {
            this.greenMixture = greenMixture;
            return this;
        }

        public GreenTeaBuilder sugarSyrup(int sugarSyrup) {
            this.sugarSyrup = sugarSyrup;
            return this;
        }

        public GreenTea build() {
            return new GreenTea(resource, hotWater, gingerSyrup, greenMixture, sugarSyrup);
        }

        public String toString() {
            return "GreenTea.GreenTeaBuilder(resource=" + this.resource + ", hotWater=" + this.hotWater + ", gingerSyrup=" + this.gingerSyrup + ", greenMixture=" + this.greenMixture + ", sugarSyrup=" + this.sugarSyrup + ")";
        }
    }
}
