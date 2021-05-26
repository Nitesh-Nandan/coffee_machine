package config;

public interface BeverageIngredients {

    interface HotTea {
         int HOT_WATER = 50;
         int HOT_MILK = 10;
         int TEA_LEAVES_SYRUP = 10;
         int GINGER_SYRUP = 5;
         int SUGAR_SYRUP = 10;
    }

    interface ElaichiTea {
        int HOT_WATER = 50;
        int HOT_MILK = 10;
        int TEA_LEAVES_SYRUP = 10;
        int SUGAR_SYRUP = 10;
        int ELAICHI_SYRUP = 5;
    }

    interface Coffee {
        int HOT_WATER = 50;
        int HOT_MILK = 10;
        int COFFEE_SYRUP = 10;
        int SUGAR_SYRUP = 10;
    }

    interface HotMilk {
        int HOT_MILK = 50;
    }

    interface HotWater {
        int HOT_WATER = 50;
    }

    interface BlackTea {
        int HOT_WATER = 50;
        int TEA_LEAVES_SYRUP = 10;
        int GINGER_SYRUP = 5;
        int SUGAR_SYRUP = 10;
    }

    interface GreenTea {
        int HOT_WATER = 100;
        int GINGER_SYRUP = 30;
        int SUGAR_SYRUP = 10;
        int GREEN_MIXTURE = 30;
    }
}
