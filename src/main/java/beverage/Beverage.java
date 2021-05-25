package beverage;

import ingredients.Resource;

public abstract class Beverage {
    protected Resource resource;
    public Beverage(Resource resource) {
        this.resource = resource;
    }
    public abstract boolean make();
}
