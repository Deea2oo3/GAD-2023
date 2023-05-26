import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class FluxOperations {
    private static List<String> words1 = Arrays.asList(
            "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

    private static List<String> words2 = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    static Flux<String> mergeFluxWithInterleave(Flux<String> flux1, Flux<String> flux2) {
        return Flux.merge(flux1, flux2);
    }

    static Flux<String> mergeFluxWithNoInterleave(Flux<String> flux1, Flux<String> flux2) {
        return Flux.concat(flux1, flux2);
    }

    static Flux<String> createFluxFromMultipleMono(Mono<String> mono1, Mono<String> mono2) {
        return Flux.concat(mono1, mono2);
    }

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.fromIterable(words1);
        Flux<String> flux2 = Flux.fromIterable(words2);
        Mono<String> mono1 = Mono.just("Mono 1");
        Mono<String> mono2 = Mono.just("Mono 2");

        // Merge flux1 and flux2 values with interleave
        Flux<String> mergedFluxWithInterleave = mergeFluxWithInterleave(flux1, flux2);
        mergedFluxWithInterleave.subscribe(System.out::println);

        System.out.println();

        // Merge flux1 and flux2 values with no interleave
        Flux<String> mergedFluxWithNoInterleave = mergeFluxWithNoInterleave(flux1, flux2);
        mergedFluxWithNoInterleave.subscribe(System.out::println);

        System.out.println();

        // Create a Flux containing the value of mono1 then the value of mono2
        Flux<String> fluxFromMultipleMono = createFluxFromMultipleMono(mono1, mono2);
        fluxFromMultipleMono.subscribe(System.out::println);
    }
}
