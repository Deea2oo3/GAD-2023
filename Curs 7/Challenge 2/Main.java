public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Account 1", 1000);
        BankAccount account2 = new BankAccount("Account 2", 500);

        TransactionThread thread1 = new TransactionThread("Thread 1", account1, account2, 200);
        TransactionThread thread2 = new TransactionThread("Thread 2", account2, account1, 300);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance of " + account1 + ": " + account1.getDebit());
        System.out.println("Final balance of " + account2 + ": " + account2.getDebit());
    }
}

