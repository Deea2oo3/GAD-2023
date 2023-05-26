public class Game {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        player1.start();
        player2.start();

        while (!player1.hasChosen() || !player2.hasChosen()) {
            try {
                Thread.sleep(100); // wait 100 milliseconds before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String choice1 = player1.getChoice();
        String choice2 = player2.getChoice();

        System.out.println(player1.getName() + " chose " + choice1);
        System.out.println(player2.getName() + " chose " + choice2);

        if (choice1.equals(choice2)) {
            System.out.println("It's a tie!");
        } else if (choice1.equals("rock") && choice2.equals("scissors") ||
                   choice1.equals("paper") && choice2.equals("rock") ||
                   choice1.equals("scissors") && choice2.equals("paper")) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }
    }
}
