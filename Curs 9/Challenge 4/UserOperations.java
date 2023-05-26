import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserOperations {
    static Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(user ->
                new User(
                        capitalizeString(user.getFirstName()),
                        capitalizeString(user.getLastName()),
                        capitalizeString(user.getUsername())
                )
        );
    }

    static Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(user ->
                new User(
                        capitalizeString(user.getFirstName()),
                        capitalizeString(user.getLastName()),
                        capitalizeString(user.getUsername())
                )
        );
    }

    static Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap(UserOperations::asyncCapitalizeUser);
    }

    static Mono<User> asyncCapitalizeUser(User user) {
        return Mono.just(new User(
                capitalizeString(user.getFirstName()),
                capitalizeString(user.getLastName()),
                capitalizeString(user.getUsername())
        ));
    }

    private static String capitalizeString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

