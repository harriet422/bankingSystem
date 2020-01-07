package qa.banking;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    public void test_balance_is_correct() {
        double openingBalance = 44.00;
        Account acc = new Account(1, "Bob", openingBalance);

        //assert
        assertEquals(openingBalance, acc.availableBalance());
        assertEquals(acc.availableBalance(), acc.currentBalance());
    }

    public void test_does_balance_match_after_debit_and_credit(){
        //arrange
        double openingBalance = 234.01;
        double amountToDebit = 44.00;
        double amountToCredit = 13.00;
        double firstAmount = openingBalance - amountToDebit + amountToCredit;
        double secondAmount = openingBalance - amountToDebit + amountToCredit;
        Account acc = new CreditAccount(1, "Bob", openingBalance, InterestRate.HOME_LOAN);

        //act
        acc.debit(amountToDebit);

        //assert
        assertEquals(firstAmount ,acc.availableBalance());
        assertEquals(secondAmount ,acc.currentBalance());
        amountToDebit += amountToDebit * InterestRate.HOME_LOAN.rate() / 100;
    }


}