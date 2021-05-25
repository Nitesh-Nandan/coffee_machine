package machine;

import beverage.BeverageType;
import config.ResourceComposition;
import ingredients.Resource;
import ingredients.ResourceType;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private final int outlets;
    private final Map<Integer, CoffeeMaker> outletCoffeeMakerMap = new HashMap<>();
    private final Resource resource;

    public CoffeeMachine(int outlets) {
        this.outlets = outlets;
        Resource resource = Resource.builder()
                .hotWater(ResourceComposition.WATER)
                .hotMilk(ResourceComposition.MILK)
                .gingerSyrup(ResourceComposition.GINGER_SYRUP)
                .sugarSyrup(ResourceComposition.SUGAR_SYRUP)
                .teaLeavesSyrup(ResourceComposition.TEA_LEAVES_SYRUP)
                .coffeeSyrup(ResourceComposition.COFFEE_SYRUP)
                .greenMixture(ResourceComposition.GREEN_MIXTURE)
                .elaichiSyrup(ResourceComposition.ELAICHI_SYRUP)
                .build();
        this.resource = resource;

        for(int i = 1; i<= outlets;i++) {
            outletCoffeeMakerMap.put(i, new CoffeeMaker(resource));
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

    public void refillIngredients(ResourceType resourceType, int quantity) {
        if(resourceType == ResourceType.COFFEE_SYRUP) {
            resource.addCoffeeSyrup(quantity);
        }
        else if(resourceType == ResourceType.WATER) {
            resource.addHotWater(quantity);
        }
        else if(resourceType == ResourceType.MILK) {
            resource.addHotMilk(quantity);
        }
        else if(resourceType == ResourceType.ELAICHI_SYRUP) {
            resource.addElaichiSyrup(quantity);
        }
        else if(resourceType == ResourceType.GREEN_MIXTURE) {
            resource.addGreenMixture(quantity);
        }
        else if(resourceType == ResourceType.GINGER_SYRUP) {
            resource.addGingerSyrup(quantity);
        }
        else if(resourceType == ResourceType.TEA_LEAVES_SYRUP) {
            resource.addTeaLeavesSyrup(quantity);
        }
        else if(resourceType == ResourceType.SUGAR_SYRUP) {
            resource.addSugarSyrup(quantity);
        }
        else {
            throw new RuntimeException("No such Resource type is present");
        }
    }
}
