import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FluxExamples examples = new FluxExamples();

        // Example usage of the implemented methods
        examples.emptyFlux().subscribe(System.out::println);
        examples.fooBarFluxFromValues().subscribe(System.out::println);
        examples.fooBarFluxFromList().subscribe(System.out::println);
        examples.errorFlux().subscribe(System.out::println, System.err::println);
        examples.counter().subscribe(System.out::println);

        // Wait for a while to observe the output
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

