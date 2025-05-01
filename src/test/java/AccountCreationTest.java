import org.example.exceptionHandler.AccountException;
import org.example.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountCreationTest {
    // create account
    // first define
    // validation

    Account account;
    Account account2;

    @BeforeEach
    void setUp() {
         account = new Account(123,456, "Ali", 0.0);
         account2 = new Account(456,789, "Sara", 0.0);
    }

    @Test
    void shouldCreateAccountWithValidName() {
        assertEquals("Ali", account.getName());
        assertEquals(123, account.getAccountId());
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void shouldGenerateUniqueAccountNumber() {
        assertNotEquals(account.getAccountId(), account2.getAccountId());
    }

    @Test
    void shouldInitializeBalanceToZero() {
        assertEquals(0.0, account.getBalance());
    }

}
