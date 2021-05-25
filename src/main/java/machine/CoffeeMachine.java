package machine;

import beverage.BeverageType;
import config.ResourceComposition;
import resource.Resource;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private final int outlets;
    private final Map<Integer, CoffeeMaker> outletCoffeeMakerMap = new HashMap<>();

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

        for(int i = 1; i<= outlets;i++) {
            outletCoffeeMakerMap.put(i, new CoffeeMaker(resource));
            outletCoffeeMakerMap.get(i).setName("Outlet- " + i + " ");
        }
    }

    public void brewBeverage (int outletId, BeverageType beverageType) {
        if(outletId > outlets) {
            throw new RuntimeException("Outlet ");
        }
        CoffeeMaker coffeeMaker = outletCoffeeMakerMap.get(outletId);
        coffeeMaker.setBeverageType(beverageType);
        coffeeMaker.start();
    }
}
