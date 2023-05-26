interface Pizza {
    String getDescription();
    double getCost();
}

class MargheritaPizza implements Pizza {
    public String getDescription() {
        return "Margherita Pizza";
    }

    public double getCost() {
        return 8.99;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    public double getCost() {
        return decoratedPizza.getCost();
    }
}

class ExtraCheeseDecorator extends PizzaDecorator {
    public ExtraCheeseDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    public String getDescription() {
        return super.getDescription() + ", Extra Cheese";
    }

    public double getCost() {
        return super.getCost() + 1.50;
    }
}

class BaconDecorator extends PizzaDecorator {
    public BaconDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    public String getDescription() {
        return super.getDescription() + ", Bacon";
    }

    public double getCost() {
        return super.getCost() + 2.00;
    }
}
