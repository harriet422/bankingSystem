package qa.banking;

public class CreditAccount extends Account{
    InterestRate rate;
    public CreditAccount(int id, String name, double amt, InterestRate rate){
        super(id, name, amt);
        this.rate = rate;
    }

    @Override
    public double debit(double amt) {
        if(super.availableBalance() - amt < 0) {
            amt += rate.rate()/100 * amt;
        }
        super.debit(amt);
        return super.availableBalance();
    }
}
