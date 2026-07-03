import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Account> accounts;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public double totalWorth() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public static void main(String[] args) {
        Customer daisy = new Customer("C001", "Daisy Eleanor");
        SavingsAccount sav = new SavingsAccount("SA-100", 200000, 5);
        CurrentAccount cur = new CurrentAccount("CA-200", 50000, 100000);
        daisy.addAccount(sav);
        daisy.addAccount(cur);

        sav.addInterest();
        cur.withdraw(120000);

        System.out.println(sav.generateStatement());
        System.out.println(cur.generateStatement());
        System.out.println("Customer total worth: UGX " + daisy.totalWorth());
    }
}