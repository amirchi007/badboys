import org.example.exceptionHandler.BankServiceException;
import org.example.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DepositWithdrawTest {
    /*
     Deposit and Withdraw correctly
     not mines balance
     decrease money correctly
    */
    private Account account;

    @BeforeEach
    void setUp() {
         account = new Account(123, 456,"Ali", 1000.0);
    }

    @Test
    void shouldIncreaseBalanceWhenDepositIsValid() {
        account.deposit(200.0);
        assertEquals(1200.0, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenDepositAmountIsNegative() {
        assertThrows(BankServiceException.class, () -> {
            account.deposit(-50.0);
        });
    }

    @Test
    void shouldDecreaseBalanceWhenWithdrawingIsValidAmount() {
        account.withdraw(200.0);
        assertEquals(800.0, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenWithDrawingIsMoreThanBalance() {
        assertThrows(BankServiceException.class, () -> {
            account.withdraw(2000);
        });
    }

    @Test
    void shouldShowCorrectBalanceAfterAnyOperation() {
        account.deposit(500.0);
        account.withdraw(300.0);
        assertEquals(1200.0, account.getBalance());
    }
}
