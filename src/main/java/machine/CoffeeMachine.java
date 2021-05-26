package machine;

import beverage.BeverageType;
import config.Ingredients;
import ingredients.IngredientsType;
import ingredients.Resource;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private final int outlets;
    private final Map<Integer, CoffeeMaker> outletCoffeeMakerMap = new HashMap<>();
    private final Resource resource;

    public CoffeeMachine(int outlets) {
        this.outlets = outlets;
        this.resource = Resource.builder()
                .hotWater(Ingredients.WATER)
                .hotMilk(Ingredients.MILK)
                .gingerSyrup(Ingredients.GINGER_SYRUP)
                .sugarSyrup(Ingredients.SUGAR_SYRUP)
                .teaLeavesSyrup(Ingredients.TEA_LEAVES_SYRUP)
                .coffeeSyrup(Ingredients.COFFEE_SYRUP)
                .greenMixture(Ingredients.GREEN_MIXTURE)
                .elaichiSyrup(Ingredients.ELAICHI_SYRUP)
                .build();

        for(int i = 1; i<= outlets;i++) {
            outletCoffeeMakerMap.put(i, new CoffeeMaker(this.resource));
            outletCoffeeMakerMap.get(i).setName("Outlet- " + i + " ");
        }
    }

    public void brewBeverage (int outletId, BeverageType beverageType) {
        if(outletId > outlets) {
            throw new RuntimeException("Specified outlet is not present");
        }
        CoffeeMaker coffeeMaker = outletCoffeeMakerMap.get(outletId);
        coffeeMaker.setBeverageType(beverageType);
        coffeeMaker.start();
    }

    public void refillIngredients(IngredientsType ingredientsType, int quantity) {
        if(ingredientsType == IngredientsType.COFFEE_SYRUP) {
            resource.addCoffeeSyrup(quantity);
        }
        else if(ingredientsType == IngredientsType.WATER) {
            resource.addHotWater(quantity);
        }
        else if(ingredientsType == IngredientsType.MILK) {
            resource.addHotMilk(quantity);
        }
        else if(ingredientsType == IngredientsType.ELAICHI_SYRUP) {
            resource.addElaichiSyrup(quantity);
        }
        else if(ingredientsType == IngredientsType.GREEN_MIXTURE) {
            resource.addGreenMixture(quantity);
        }
        else if(ingredientsType == IngredientsType.GINGER_SYRUP) {
            resource.addGingerSyrup(quantity);
        }
        else if(ingredientsType == IngredientsType.TEA_LEAVES_SYRUP) {
            resource.addTeaLeavesSyrup(quantity);
        }
        else if(ingredientsType == IngredientsType.SUGAR_SYRUP) {
            resource.addSugarSyrup(quantity);
        }
        else {
            throw new RuntimeException("No such Resource type is present");
        }
    }
}
