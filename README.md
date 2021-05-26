# coffee_machine

- The end customer will interact with `CoffeMachine.java` for getting beverage and refelling the ingredients.

- To create the instance of CoffeMachine we need to pass the number of outlets in the constructor, these outlets can server the beverage parallely.

- `CoffeMachine.java` has two public method through which end user will interact
    1. > public void brewBeverage(int outlletId, BeverageType type);
    2. > public void refillIngredients(IngredientsType ingredientsType, int quantity);

**`Resource.java` is the ingredients that CoffeeMachine has.**

- `Resource.java` is a shared object which used by all the outlets parallely so methods are `synchronized` (thread safe).

## config (package)
- `BeverageIngredients` -> This is similar to a config file where we can set the composition of beverages.

- `Ingredients` -> This a config file which signifies the full capacity of ingredients that coffee_machine can hold.

- `IngredientsIndicatorThreshold` -> This config is used to set the threshold for ingredients so whenever the ingredients reach to this level system will display a alert corresponding to that resource.

**For functional demo please have a look `MainHandler.java`**


`MainHandler.java` : This is not a test class but it demonstrate the functionality of CoffeeMachine.
