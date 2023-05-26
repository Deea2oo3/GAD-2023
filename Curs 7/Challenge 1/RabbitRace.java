
public class RabbitRace {
    public static void main(String[] args) {
        Thread[] rabbits = new Thread[10];

        for (int i = 0; i < rabbits.length; i++) {
            if (i % 2 == 0) {
                rabbits[i] = new RabbitThread(i/2+1);
            } else {
                rabbits[i] = new Thread(new RabbitRunnable(i/2+1));
            }
        }

        System.out.println("Ready... Set... Go!");
        for (Thread rabbit : rabbits) {
            rabbit.start();
        }
    }
}
