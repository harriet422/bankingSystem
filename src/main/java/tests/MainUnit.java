package tests;
import qa.banking.Account;
import qa.banking.CreditAccount;
import qa.banking.InterestRate;
import qa.banking.Transaction;

public class MainUnit {
    public static void main(String[] args) {
        test_Transaction();
        test_does_balance_match_after_debit_and_credit();
        test_going_overdrawn_on_credit_account();
        test_balance_is_correct();
    }

        /*Transaction t1 = new Transaction(87);
        System.out.println(t1.getAmount());
        System.out.println(t1.getWhen());

        double openingBalance = 234.01;
        Account acc = new Account(1, "Bob", openingBalance);

        if(openingBalance == acc.availableBalance() && openingBalance == acc.currentBalance()) System.out.println("work");
        else
            System.out.println("nope");*/

/*
        //arrange
        double openingBalance2 = 234.01;
        double amountToDeposit = 44.00;
        Account acc2 = new Account(1, "Bob", openingBalance2);

        //act
        acc2.credit(amountToDeposit);
        //assert
        if((openingBalance2 + amountToDeposit() == acc2.availableBalance()
                    && openingBalance2+amountToDeposit == acc2.currentBalance())) System.out.println("work");
        else
            System.out.println("nope");*/

        static void test_does_balance_match_after_debit_and_credit () {
            //arrange
            double openingBalance = 234.01;
            double amountToDebit = 44.00;
            double amountToCredit = 13.00;
            Account acc = new CreditAccount(1, "Bob", openingBalance, InterestRate.HOME_LOAN);

            //act
            acc.debit(amountToDebit);

            //assert
            amountToDebit += amountToDebit * InterestRate.HOME_LOAN.rate() / 100;
            if ((openingBalance - amountToDebit + amountToCredit) == acc.availableBalance() && (openingBalance - amountToDebit + amountToCredit) == acc.currentBalance())
                System.out.println("test_does_balance_match_after_debit_and_credit:PASSED");
            else
                System.out.println("test_does_balance_match_after_debit_and_credit:FAILED");
        }

        static void test_going_overdrawn_on_credit_account () {
            //arrange
            double openingBalance = 234.01;
            double amountToDebit = 44.00;
            Account acc = new CreditAccount(1, "Bob", openingBalance, InterestRate.HOME_LOAN);

            //act
            acc.debit(amountToDebit);

            //assert
            amountToDebit += amountToDebit * InterestRate.HOME_LOAN.rate() / 100;
            if ((openingBalance - amountToDebit) == acc.availableBalance() && (openingBalance - amountToDebit) == acc.currentBalance())
                System.out.println("test_going_overdrawn_on_credit_account:PASSED");
            else
                System.out.println("test_going_overdrawn_on_credit_account:FAILED");
        }


        //static void test_does_balance_match_After_debit_on_CreditAccount(){}

        static void test_Transaction() {
            Transaction t1 = new Transaction(67.77);
            System.out.println("Amount: " + t1.getAmount());
            System.out.println("When: " + t1.getWhen());
        }

        static void test_balance_is_correct(){
            double openingBalance = 44.00;
            double availableBalance = 44.00;
            double currentBalance = 44.00;
            Account acc = new Account(1, "Bob", openingBalance);

            //assert
            if ((openingBalance == acc.availableBalance()) && (openingBalance == acc.currentBalance()))
                System.out.println("test_balance:PASSED");
            else
                System.out.println("test_balance:FAILED");
        }
    }