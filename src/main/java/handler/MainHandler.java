package handler;

import beverage.BeverageType;
import ingredients.ResourceType;
import machine.CoffeeMachine;

public class MainHandler {
    public static void main(String[] args) {
        testAllTheOutletsCanServeTheBeverage();
        testAllTheOutletsCanServeTheSameBeverage();
        testTheCorrectMessageIfBeverageCanNotServed();
        testTheLowRunningIngredientsMessage();
        testTheRefillingResource();
    }
    private static void testAllTheOutletsCanServeTheBeverage() {
        System.out.println("TestAllTheOutletsCanServeTheBeverage");

        CoffeeMachine coffeeMachine = new CoffeeMachine(3);
        coffeeMachine.brewBeverage(1, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.HOT_COFFEE);
        coffeeMachine.brewBeverage(3, BeverageType.BLACK_TEA);
    }

    private static void testAllTheOutletsCanServeTheSameBeverage() {
        System.out.println("TestAllTheOutletsCanServeTheSameBeverage");

        CoffeeMachine coffeeMachine = new CoffeeMachine(3);
        coffeeMachine.brewBeverage(1, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(3, BeverageType.HOT_TEA);
    }

    private static void testTheCorrectMessageIfBeverageCanNotServed() {
        System.out.println("TestTheCorrectMessageIfBeverageCanNotServed");

        CoffeeMachine coffeeMachine = new CoffeeMachine(2);
        coffeeMachine.brewBeverage(1, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.GREEN_TEA);
    }

    private static void testTheLowRunningIngredientsMessage() {
        System.out.println("testTheLowRunningIngredientsMessage");

        CoffeeMachine coffeeMachine = new CoffeeMachine(5);
        coffeeMachine.brewBeverage(1, BeverageType.BLACK_TEA);
        coffeeMachine.brewBeverage(2, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(3, BeverageType.BLACK_TEA);
        coffeeMachine.brewBeverage(4, BeverageType.HOT_TEA);
        coffeeMachine.brewBeverage(5, BeverageType.HOT_COFFEE);
    }

    private static void testTheRefillingResource() {
        System.out.println("TestTheRefillingResource");

        CoffeeMachine coffeeMachine = new CoffeeMachine(3);
        coffeeMachine.brewBeverage(1, BeverageType.GREEN_TEA);
        coffeeMachine.refillIngredients(ResourceType.GREEN_MIXTURE, 50);
        coffeeMachine.brewBeverage(2, BeverageType.GREEN_TEA);
        coffeeMachine.brewBeverage(3, BeverageType.GREEN_TEA);

    }
}
