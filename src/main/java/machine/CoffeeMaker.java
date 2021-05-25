package machine;

import beverage.*;
import config.BeverageComposition;
import resource.Resource;

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
                  .hotMilk(BeverageComposition.HotTea.HOT_MILK)
                  .teaLeavesSyrup(BeverageComposition.HotTea.TEA_LEAVES_SYRUP)
                  .hotWater(BeverageComposition.HotTea.HOT_WATER)
                  .sugarSyrup(BeverageComposition.HotTea.SUGAR_SYRUP)
                  .gingerSyrup(BeverageComposition.HotTea.GINGER_SYRUP)
                  .build();
          hotTea.make();
      }
       else if (this.beverageType == BeverageType.HOT_COFFEE) {
           Beverage hotCoffee = Coffee.builder()
                   .resource(resource)
                   .hotMilk(BeverageComposition.Coffee.HOT_MILK)
                   .hotWater(BeverageComposition.Coffee.HOT_WATER)
                   .sugarSyrup(BeverageComposition.Coffee.SUGAR_SYRUP)
                   .coffeeSyrup(BeverageComposition.Coffee.COFFEE_SYRUP)
                   .build();
           hotCoffee.make();
       }

       else if (this.beverageType == BeverageType.BLACK_TEA) {
           Beverage blackTea = BlackTea.builder()
                   .resource(resource)
                   .hotWater(BeverageComposition.BlackTea.HOT_WATER)
                   .teaLeavesSyrup(BeverageComposition.BlackTea.TEA_LEAVES_SYRUP)
                   .gingerSyrup(BeverageComposition.BlackTea.GINGER_SYRUP)
                   .sugarSyrup(BeverageComposition.BlackTea.SUGAR_SYRUP)
                   .build();
           blackTea.make();
       }

       else if (this.beverageType == BeverageType.GREEN_TEA) {
           Beverage greenTea = GreenTea.builder()
                   .resource(resource)
                   .hotWater(BeverageComposition.GreenTea.HOT_WATER)
                   .sugarSyrup(BeverageComposition.GreenTea.SUGAR_SYRUP)
                   .gingerSyrup(BeverageComposition.GreenTea.GINGER_SYRUP)
                   .greenMixture(BeverageComposition.GreenTea.GREEN_MIXTURE)
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
