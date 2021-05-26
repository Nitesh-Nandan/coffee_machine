package handler;

import beverage.BeverageType;
import ingredients.IngredientsType;
import machine.CoffeeMachine;

public class MainHandler {
    public static void main(String[] args) {
        demoAllTheOutletsCanServeTheBeverage();
        demoAllTheOutletsCanServeTheSameBeverage();
        demoTheCorrectMessageIfBeverageCanNotServed();
        demoTheLowRunningIngredientsMessage();
        demoTheRefillingResource();
    }
    private static void demoAllTheOutletsCanServeTheBeverage() {
        System.out.println("DemoAllTheOutletsCanServeTheBeverage");

        CoffeeMachine coffeeMachine = new CoffeeMachine(3);
        coffeeMachine.brewBeverage(1, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.HOT_COFFEE);
        coffeeMachine.brewBeverage(3, BeverageType.BLACK_TEA);
    }

    private static void demoAllTheOutletsCanServeTheSameBeverage() {
        System.out.println("DemoAllTheOutletsCanServeTheSameBeverage");

        CoffeeMachine coffeeMachine = new CoffeeMachine(3);
        coffeeMachine.brewBeverage(1, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(3, BeverageType.HOT_TEA);
    }

    private static void demoTheCorrectMessageIfBeverageCanNotServed() {
        System.out.println("DemoTheCorrectMessageIfBeverageCanNotServed");

        CoffeeMachine coffeeMachine = new CoffeeMachine(2);
        coffeeMachine.brewBeverage(1, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.GREEN_TEA);
    }

    private static void demoTheLowRunningIngredientsMessage() {
        System.out.println("DemoTheLowRunningIngredientsMessage");

        CoffeeMachine coffeeMachine = new CoffeeMachine(5);
        coffeeMachine.brewBeverage(1, BeverageType.BLACK_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(3, BeverageType.BLACK_TEA);
        coffeeMachine.brewBeverage(4, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(5, BeverageType.HOT_COFFEE);
    }

    private static void demoTheRefillingResource() {
        System.out.println("DemoTheRefillingResource");

        CoffeeMachine coffeeMachine = new CoffeeMachine(3);
        coffeeMachine.brewBeverage(1, BeverageType.GREEN_TEA);
        coffeeMachine.refillIngredients(IngredientsType.GREEN_MIXTURE, 50);
        coffeeMachine.brewBeverage(2, BeverageType.GREEN_TEA);
        coffeeMachine.brewBeverage(3, BeverageType.GREEN_TEA);

    }
}
