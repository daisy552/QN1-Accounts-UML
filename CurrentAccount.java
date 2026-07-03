public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal denied: exceeds overdraft limit");
            return false;
        }
        balance -= amount;
        return true;
    }
}