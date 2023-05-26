
public class RabbitRunnable implements Runnable {
    private int nr;

    public RabbitRunnable(int nr) {
        this.nr = nr;
    }

    public void run() {
        System.out.println("Rabbit #" + nr + " is running");
    }
}
