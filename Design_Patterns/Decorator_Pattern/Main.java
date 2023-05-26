public class Main {
    public static void main(String[] args) {
        Pizza margherita = new MargheritaPizza();
        System.out.println("Description: " + margherita.getDescription());
        System.out.println("Cost: $" + margherita.getCost());

        Pizza margheritaWithExtraCheese = new ExtraCheeseDecorator(margherita);
        System.out.println("Description: " + margheritaWithExtraCheese.getDescription());
        System.out.println("Cost: $" + margheritaWithExtraCheese.getCost());

        Pizza margheritaWithExtraCheeseAndBacon = new BaconDecorator(margheritaWithExtraCheese);
        System.out.println("Description: " + margheritaWithExtraCheeseAndBacon.getDescription());
        System.out.println("Cost: $" + margheritaWithExtraCheeseAndBacon.getCost());
    }
}