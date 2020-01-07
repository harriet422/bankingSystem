package qa.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    public TransactionTest(){}

    @Test
    public void transaction_created_balance_is_equal_to_deposit(){
        //arrange
        double initAmount = 67.77;
        double expectedResult = 67.77;
        Transaction t1 = new Transaction(initAmount);
        //act
        double actualResult = t1.getAmount();
        //assert
        assertEquals(expectedResult, actualResult);
    }
}