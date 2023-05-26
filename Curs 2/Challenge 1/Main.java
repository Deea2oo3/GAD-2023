
public class Main {
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Fighter 1", 100, 10);
        Fighter fighter2 = new Fighter("Fighter 2", 120, 8);

        BoxingMatch match = new BoxingMatch(fighter1, fighter2);
        String winner = match.fight();

        System.out.println("The winner is: " + winner);
    }
}
