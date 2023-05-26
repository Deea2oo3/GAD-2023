
public class Main {
    public static void main(String[] args) {
        // Create a Person instance using the builder
        Person person = new Person.PersonBuilder("John")
                .setJob("Engineer")
                .setUniversity("MIT")
                .setDrivingLicense(true)
                .setMarried(false)
                .build();

        // Access the properties of the Person instance
        System.out.println("Name: " + person.getName());
        System.out.println("Job: " + person.getJob());
        System.out.println("University: " + person.getUniversity());
        System.out.println("Driving License: " + person.hasDrivingLicense());
        System.out.println("Married: " + person.isMarried());
    }
}