import org.example.exceptionHandler.BalanceInquiryException;
import org.example.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BalanceInquiryTest {
    // balance test after doing operations

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account(123, 456, "Ali", 0.0);
    }

    @Test
    void shouldReturnInitialBalanceAfterAccountCreation() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void shouldReturnCorrectBalanceAfterTransactions() {
        account.deposit(1000.0);
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenAccountNotFound() {
        account = null;
        assertThrows(NullPointerException.class, () -> {
            account.getBalance();
        });
    }
}
