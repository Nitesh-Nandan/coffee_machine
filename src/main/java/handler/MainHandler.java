package handler;

import beverage.BeverageType;
import machine.CoffeeMachine;

public class MainHandler {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(7);
        coffeeMachine.brewBeverage(1, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.BLACK_TEA);
        coffeeMachine.brewBeverage(3, BeverageType.HOT_COFFEE);
        coffeeMachine.brewBeverage(4, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(5, BeverageType.BLACK_TEA);
        coffeeMachine.brewBeverage(6, BeverageType.GREEN_TEA);

    }
}
