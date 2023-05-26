import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        MonoExamples examples = new MonoExamples();

        // Example usage of the implemented methods
        examples.emptyMono().subscribe(System.out::println);
        examples.monoWithNoSignal().subscribe(System.out::println);
        examples.fooMono().subscribe(System.out::println);
        examples.errorMono().subscribe(System.out::println, System.err::println);
    }
}

