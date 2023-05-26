public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();

        Animal dog = dogFactory.createAnimal();
        dog.makeSound();

        Animal cat = catFactory.createAnimal();
        cat.makeSound();
    }
}