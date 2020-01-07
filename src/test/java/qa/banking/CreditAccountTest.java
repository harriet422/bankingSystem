package qa.banking;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {
    public void test_going_overdrawn_on_credit_account() {
        double openingBalance = 234.01;
        double amountToDebit = 44.00;
        Account acc = new CreditAccount(1, "Bob", openingBalance, InterestRate.HOME_LOAN);

        //act
        acc.debit(amountToDebit);

        //assert
        assertEquals(amountToDebit, acc.availableBalance());
        assertEquals(amountToDebit, acc.currentBalance());
    }
}