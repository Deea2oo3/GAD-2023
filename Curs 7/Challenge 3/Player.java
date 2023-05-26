import java.util.Random;

public class Player extends Thread {
    private String name;
    private String choice;
    private boolean hasChosen;

    public Player(String name) {
        this.name = name;
        this.hasChosen = false;
    }

    public void run() {
        Random random = new Random();
        int choiceIndex = random.nextInt(3);
        if (choiceIndex == 0) {
            this.choice = "rock";
        } else if (choiceIndex == 1) {
            this.choice = "paper";
        } else {
            this.choice = "scissors";
        }
        this.hasChosen = true;
    }

    public boolean hasChosen() {
        return hasChosen;
    }

    public String getChoice() {
        return choice;
    }

    public String getName() {
        return name;
    }
}

