package qa.banking;
import java.time.Instant;

public class Transaction {
    private double amount;
    private Instant when = Instant.now();

    public Transaction( double amt ) {
        amount = amt;
    }

    public double getAmount() {
        return amount;
    }

    public String getWhen() {
        return when.toString();
    }
}