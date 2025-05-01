import org.example.exceptionHandler.AmountException;
import org.example.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransferMoneyTest {
    /*
     Transfer between two accounts
     raise and decrease correctly
     exception for wrong account
    */

    Account sender;
    Account receiver;

    @BeforeEach
    void setUp() {
        sender = new Account(123, 456, "amir", 100);
        receiver = new Account(456, 789, "ali", 50);
    }

    @Test
    void shouldTransferMoneySuccessfullyBetweenAccounts() {
        sender.transferMoney(receiver, 40);
        assertEquals(60, sender.getBalance());
        assertEquals(90, receiver.getBalance());
    }

    @Test
    void shouldThrowErrorWhenReceiverAccountDoesNotExist() {
        receiver = null;
        assertThrows(AmountException.class, () -> sender.transferMoney(receiver, 100));
    }

    @Test
    void shouldThrowErrorWhenInsufficientBalanceForTransfer() {
        assertThrows(AmountException.class, () -> sender.transferMoney(receiver, 200));
    }

    @Test
    void shouldNotAllowTransferToItsAccount() {
        assertThrows(AmountException.class, () -> sender.transferMoney(sender, 50));
    }

}
