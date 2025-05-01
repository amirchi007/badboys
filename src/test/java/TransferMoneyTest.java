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

        sender.transferMoney(sender, receiver, 40);

        assertEquals(60, sender.getBalance(), "sender balance decrease 40 from last balance");
        assertEquals(90, receiver.getBalance(), "receiver balance raise to 40 from last balance");
    }

    @Test
    void shouldThrowErrorWhenReceiverAccountDoesNotExist() {
        receiver = null;

        assertThrows(AmountException.class, () -> {
            sender.transferMoney(sender, receiver, 100);
        });
    }

    @Test
    void shouldThrowErrorWhenInsufficientBalanceForTransfer() {


        assertThrows(IllegalArgumentException.class, () -> {
            sender.transferMoney(sender, receiver, 200);
        });
    }

    @Test
    void shouldNotAllowTransferToItsAccount() {
        assertThrows(IllegalArgumentException.class, () -> {
            sender.transferMoney(sender, sender, 50);
        });
    }

}
