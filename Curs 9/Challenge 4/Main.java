import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("john", "doe", "johndoe");
        User user2 = new User("jane", "smith", "janesmith");

        // Capitalize a single user
        Mono<User> capitalizedUserMono = UserOperations.capitalizeOne(Mono.just(user1));
        capitalizedUserMono.subscribe(System.out::println);

        // Capitalize multiple users
        Flux<User> usersFlux = Flux.just(user1, user2);
        Flux<User> capitalizedUsersFlux = UserOperations.capitalizeMany(usersFlux);
        capitalizedUsersFlux.subscribe(System.out::println);

        // Capitalize multiple users asynchronously
        Flux<User> asyncCapitalizedUsersFlux = UserOperations.asyncCapitalizeMany(usersFlux);
        asyncCapitalizedUsersFlux.subscribe(System.out::println);
    }
}

