package qa.banking;
import java.util.AbstractList;
import java.util.ArrayList;

public class Account {
    private int id;
    private String name;
    private double balance;
    private AbstractList<Transaction> transactions = new ArrayList<>();

    public Account(int id, String name, double amt) {
        this.id = id;
        this.name = name;
        credit(amt);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double availableBalance(){
        return balance;
    }

    public double currentBalance(){
        double balance = 0;
        for (Transaction txn : transactions)
            balance += txn.getAmount();
        return balance;
    }

    public double credit (double amt){
        balance += amt;
        transactions.add(new Transaction(amt));
        return balance;
    }

    public double debit (double amt){
        balance += amt * -1;
        transactions.add(new Transaction(amt * -1));
        return balance;
    }
}