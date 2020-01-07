package qa.banking;

public enum InterestRate {
    HOME_LOAN(5.67),
    BUSINESS_LOAN(2.34);

    private final double _rate;

    InterestRate(double rate){
        this._rate = rate;
    }

    public double rate(){
        return _rate;
    }
}

