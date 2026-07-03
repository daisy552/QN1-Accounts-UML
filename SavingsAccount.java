public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (balance - amount < 0) {
            System.out.println("Withdrawal denied: would take savings account below zero");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void addInterest() {
        balance += balance * (interestRate / 100);
    }
}