public class BankAccount {
    private String name;
    private int debit;

    public BankAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
    }

    public synchronized void withdraw(int amount) {
        longDatabaseCall();
        if (debit >= amount) {
            debit -= amount;
        } else {
            System.out.println("Not enough funds in " + name + " account to withdraw " + amount);
        }
    }

    public synchronized void deposit(int amount) {
        longDatabaseCall();
        debit += amount;
    }

    public int getDebit() {
        return debit;
    }

    private void longDatabaseCall() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

