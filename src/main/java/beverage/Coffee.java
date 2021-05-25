package beverage;

import resource.Resource;

public class Coffee extends Beverage {
    private final int hotWater;
    private final int gingerSyrup;
    private final int hotMilk;
    private final int sugarSyrup;
    private final int coffeeSyrup;

    Coffee(Resource resource, int hotWater, int gingerSyrup, int hotMilk, int sugarSyrup, int teaLeavesSyrup) {
        super(resource);
        this.hotWater = hotWater;
        this.gingerSyrup = gingerSyrup;
        this.hotMilk = hotMilk;
        this.sugarSyrup = sugarSyrup;
        this.coffeeSyrup = teaLeavesSyrup;
    }

    @Override
    public boolean make() {
        if (!resource.getHotWater(this.hotWater)) {
            System.out.println("Hot Coffee can't be Prepared because water is not sufficient");
            return false;
        }

        if (!resource.getHotMilk(this.hotMilk)) {
            resource.addHotWater(this.hotWater);
            System.out.println("Hot Coffee can't be Prepared because milk is not sufficient");
            return false;
        }

        if(!resource.getGingerSyrup(this.gingerSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addHotMilk(this.hotMilk);
            System.out.println("Hot Coffee can't be Prepared because ginger syrup is not sufficient");
            return false;
        }

        if(!resource.getCoffeeSyrup(this.coffeeSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addHotMilk(this.hotMilk);
            resource.addGingerSyrup(this.gingerSyrup);
            System.out.println("Hot Coffee can't be Prepared because coffee syrup is not sufficient");
            return false;
        }

        if (!resource.getSugarSyrup(this.sugarSyrup)) {
            resource.addHotWater(this.hotWater);
            resource.addHotMilk(this.hotMilk);
            resource.addGingerSyrup(this.gingerSyrup);
            resource.addCoffeeSyrup(this.coffeeSyrup);
            System.out.println("Hot Coffee can't be Prepared because sugar syrup is not sufficient");
            return false;
        }
        System.out.println(Thread.currentThread().getName()+ ": " + "Hot Coffee is Prepared");
        return  true;
    }

    public static CoffeeBuilder builder() {
        return new CoffeeBuilder();
    }

    public static class CoffeeBuilder {
        private Resource resource;
        private int hotWater;
        private int gingerSyrup;
        private int hotMilk;
        private int sugarSyrup;
        private int coffeeSyrup;

        CoffeeBuilder() {
        }

        public CoffeeBuilder resource(Resource resource) {
            this.resource = resource;
            return this;
        }

        public CoffeeBuilder hotWater(int hotWater) {
            this.hotWater = hotWater;
            return this;
        }

        public CoffeeBuilder gingerSyrup(int gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            return this;
        }

        public CoffeeBuilder hotMilk(int hotMilk) {
            this.hotMilk = hotMilk;
            return this;
        }

        public CoffeeBuilder sugarSyrup(int sugarSyrup) {
            this.sugarSyrup = sugarSyrup;
            return this;
        }

        public CoffeeBuilder coffeeSyrup(int coffeeSyrup) {
            this.coffeeSyrup = coffeeSyrup;
            return this;
        }

        public Coffee build() {
            return new Coffee(resource, hotWater, gingerSyrup, hotMilk, sugarSyrup, coffeeSyrup);
        }

        public String toString() {
            return "Coffee.CoffeeBuilder(resource=" + this.resource + ", hotWater=" + this.hotWater + ", gingerSyrup=" + this.gingerSyrup + ", hotMilk=" + this.hotMilk + ", sugarSyrup=" + this.sugarSyrup + ", teaLeavesSyrup=" + this.coffeeSyrup + ")";
        }
    }
}
