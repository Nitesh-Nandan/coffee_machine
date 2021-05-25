package ingredients;

import config.ResourceLowIndicator;

public class Resource {
    private int hotWater;
    private int hotMilk;
    private int teaLeavesSyrup;
    private int gingerSyrup;
    private int sugarSyrup;
    private int elaichiSyrup;
    private int greenMixture;
    private int coffeeSyrup;

    public Resource(int hotWater, int hotMilk, int teaLeavesSyrup, int gingerSyrup, int sugarSyrup, int elaichiSyrup, int greenMixture, int coffeeSyrup) {
        this.hotWater = hotWater;
        this.hotMilk = hotMilk;
        this.teaLeavesSyrup = teaLeavesSyrup;
        this.gingerSyrup = gingerSyrup;
        this.sugarSyrup = sugarSyrup;
        this.elaichiSyrup = elaichiSyrup;
        this.greenMixture = greenMixture;
        this.coffeeSyrup = coffeeSyrup;
    }

    public Resource() {
    }

    public static ResourceBuilder builder() {
        return new ResourceBuilder();
    }


    public void addHotWater(int hotWater) {
        synchronized (this) {
            this.hotWater += hotWater;
        }
    }

    public void addHotMilk(int milk) {
        synchronized (this) {
            this.hotMilk = milk;
        }
    }

    public void addElaichiSyrup(int elaichiSyrup) {
        synchronized (this) {
            this.elaichiSyrup += elaichiSyrup;
        }
    }

    public void addGreenMixture(int greenMixture) {
        synchronized (this) {
            this.greenMixture += greenMixture;
        }
    }

    public void addCoffeeSyrup(int coffeeSyrup) {
        synchronized (this) {
            this.coffeeSyrup += coffeeSyrup;
        }
    }


    public void addTeaLeavesSyrup(int teaLeavesSyrup) {
        synchronized (this) {
            this.teaLeavesSyrup += teaLeavesSyrup;
        }
    }

    public void addGingerSyrup(int gingerSyrup) {
        synchronized (this) {
            this.gingerSyrup += gingerSyrup;
        }
    }

    public void addSugarSyrup(int sugarSyrup) {
        synchronized (this) {
            this.sugarSyrup += sugarSyrup;
        }
    }

    public boolean getHotWater(int hotWater) {
        boolean success = false;
        synchronized (this) {
            if(this.hotWater >= hotWater) {
                this.hotWater -= hotWater;
                success = true;
            }
        }
        if(this.hotWater  <=  ResourceLowIndicator.WATER) {
            System.out.println("Alert: HotWater is running low");
        }

        return success;
    }

    public boolean getHotMilk(int hotMilk) {
        boolean success = false;
        synchronized (this) {
            if(this.hotMilk >= hotMilk) {
                this.hotMilk -= hotMilk;
                success = true;
            }
        }

        if(this.hotMilk  <=  ResourceLowIndicator.MILK) {
            System.out.println("Alert: Milk is running low");
        }

        return success;
    }

    public boolean getTeaLeavesSyrup(int teaLeavesSyrup) {
        boolean success = false;
        synchronized (this) {
            if(this.teaLeavesSyrup >= teaLeavesSyrup) {
                this.teaLeavesSyrup -= teaLeavesSyrup;
                success = true;
            }
        }

        if(this.teaLeavesSyrup  <= ResourceLowIndicator.TEA_LEAVES_SYRUP) {
            System.out.println("Alert: Tea Leaves Syrup is running low");
        }

        return success;
    }

    public boolean getGingerSyrup(int gingerSyrup) {
        boolean success = false;
        synchronized (this) {
            if(this.gingerSyrup >= gingerSyrup) {
                this.gingerSyrup -= gingerSyrup;
                success = true;
            }
        }

        if(this.gingerSyrup  <= ResourceLowIndicator.GINGER_SYRUP) {
            System.out.println("Alert: Ginger Syrup is running low");
        }

        return success;
    }

    public boolean getSugarSyrup(int sugarSyrup) {
        boolean success = false;
        synchronized (this) {
            if(this.sugarSyrup >= sugarSyrup) {
                this.sugarSyrup -= sugarSyrup;
                success = true;
            }
        }

        if(this.sugarSyrup  < ResourceLowIndicator.SUGAR_SYRUP) {
            System.out.println("Alert: Sugar Syrup is running low");
        }

        return success;
    }

    public boolean getGreenMixture(int greenMixture) {
        boolean success = false;
        synchronized (this) {
            if(this.greenMixture >= greenMixture) {
                this.greenMixture -= greenMixture;
                success = true;
            }
        }

        if(this.greenMixture  < ResourceLowIndicator.GREEN_MIXTURE) {
            System.out.println("Alert: Green Mixture is running low");
        }

        return success;
    }

    public boolean getCoffeeSyrup(int coffeeSyrup) {
        boolean success = false;
        synchronized (this) {
            if(this.coffeeSyrup >= coffeeSyrup) {
                this.coffeeSyrup -= coffeeSyrup;
                success = true;
            }
        }

        if(this.coffeeSyrup  < ResourceLowIndicator.COFFEE_SYRUP) {
            System.out.println("Alert: Coffee Syrup is running low");
        }

        return success;
    }

    public boolean getEalichiSyrup(int elaichiSyrup) {
        boolean success = false;
        synchronized (this) {
            if(this.elaichiSyrup >= elaichiSyrup) {
                this.elaichiSyrup -= elaichiSyrup;
                success = true;
            }
        }

        if(this.elaichiSyrup  < ResourceLowIndicator.ELAICHI_SYRUP) {
            System.out.println("Alert: Elaichi Syrup is running low");
        }

        return success;
    }


    public static class ResourceBuilder {
        private int hotWater = 0;
        private int hotMilk = 0;
        private int teaLeavesSyrup = 0;
        private int gingerSyrup = 0;
        private int sugarSyrup = 0;
        private int elaichiSyrup = 0;
        private int greenMixture = 0;
        private int coffeeSyrup = 0;

        ResourceBuilder() {
        }

        public ResourceBuilder hotWater(int hotWater) {
            this.hotWater = hotWater;
            return this;
        }

        public ResourceBuilder hotMilk(int hotMilk) {
            this.hotMilk = hotMilk;
            return this;
        }

        public ResourceBuilder teaLeavesSyrup(int teaLeavesSyrup) {
            this.teaLeavesSyrup = teaLeavesSyrup;
            return this;
        }

        public ResourceBuilder gingerSyrup(int gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            return this;
        }

        public ResourceBuilder sugarSyrup(int sugarSyrup) {
            this.sugarSyrup = sugarSyrup;
            return this;
        }

        public ResourceBuilder elaichiSyrup(int elaichiSyrup) {
            this.elaichiSyrup = elaichiSyrup;
            return this;
        }

        public ResourceBuilder greenMixture(int greenMixture) {
            this.greenMixture = greenMixture;
            return this;
        }

        public ResourceBuilder coffeeSyrup(int coffeeSyrup) {
            this.coffeeSyrup = coffeeSyrup;
            return this;
        }

        public Resource build() {
            return new Resource(hotWater, hotMilk, teaLeavesSyrup, gingerSyrup, sugarSyrup, elaichiSyrup, greenMixture, coffeeSyrup);
        }
    }

}
