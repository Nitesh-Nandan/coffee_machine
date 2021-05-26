package machine;

import beverage.*;
import config.BeverageIngredients;
import ingredients.Resource;

public class CoffeeMaker extends Thread {
  private final Resource resource;
  private BeverageType beverageType;

    public Resource getResource() {
        return resource;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(BeverageType beverageType) {
        this.beverageType = beverageType;
    }

    public CoffeeMaker(Resource resource) {
    this.resource = resource;
  }

   private void brewBeverage () {
       if (this.beverageType == BeverageType.HOT_TEA) {
          Beverage hotTea = HotTea.builder()
                  .resource(resource)
                  .hotMilk(BeverageIngredients.HotTea.HOT_MILK)
                  .teaLeavesSyrup(BeverageIngredients.HotTea.TEA_LEAVES_SYRUP)
                  .hotWater(BeverageIngredients.HotTea.HOT_WATER)
                  .sugarSyrup(BeverageIngredients.HotTea.SUGAR_SYRUP)
                  .gingerSyrup(BeverageIngredients.HotTea.GINGER_SYRUP)
                  .build();
          hotTea.make();
      }
       else if (this.beverageType == BeverageType.HOT_COFFEE) {
           Beverage hotCoffee = Coffee.builder()
                   .resource(resource)
                   .hotMilk(BeverageIngredients.Coffee.HOT_MILK)
                   .hotWater(BeverageIngredients.Coffee.HOT_WATER)
                   .sugarSyrup(BeverageIngredients.Coffee.SUGAR_SYRUP)
                   .coffeeSyrup(BeverageIngredients.Coffee.COFFEE_SYRUP)
                   .build();
           hotCoffee.make();
       }

       else if (this.beverageType == BeverageType.BLACK_TEA) {
           Beverage blackTea = BlackTea.builder()
                   .resource(resource)
                   .hotWater(BeverageIngredients.BlackTea.HOT_WATER)
                   .teaLeavesSyrup(BeverageIngredients.BlackTea.TEA_LEAVES_SYRUP)
                   .gingerSyrup(BeverageIngredients.BlackTea.GINGER_SYRUP)
                   .sugarSyrup(BeverageIngredients.BlackTea.SUGAR_SYRUP)
                   .build();
           blackTea.make();
       }

       else if (this.beverageType == BeverageType.GREEN_TEA) {
           Beverage greenTea = GreenTea.builder()
                   .resource(resource)
                   .hotWater(BeverageIngredients.GreenTea.HOT_WATER)
                   .sugarSyrup(BeverageIngredients.GreenTea.SUGAR_SYRUP)
                   .gingerSyrup(BeverageIngredients.GreenTea.GINGER_SYRUP)
                   .greenMixture(BeverageIngredients.GreenTea.GREEN_MIXTURE)
                   .build();
           greenTea.make();
       }
       else {
           throw new RuntimeException("Right now Beverage is not present soon we will add in the list");
       }
      this.beverageType = null;
  }

  @Override
  public void run() {
        if(this.beverageType == null) {
            throw new RuntimeException("Please Set the beverage type");
        }
        brewBeverage();
  }
}
