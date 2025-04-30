import org.example.AmountException;
import org.example.BankServices;
import org.example.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransferMoneyTest {
    /*
     Transfer between two accounts
     raise and decrease correctly
     exception for wrong account
    */

    @Test
    void shouldTransferMoneySuccessfullyBetweenAccounts() {
        Account sender = new Account(123, "amir", 100);
        Account receiver = new Account(456, "ali", 50);

        sender.transferMoney(sender, receiver, 40);

        assertEquals(60, sender.getBalance(), "sender balance decrease 40 from last balance");
        assertEquals(90, receiver.getBalance(), "receiver balance raise to 40 from last balance");
    }

    @Test
    void shouldThrowErrorWhenReceiverAccountDoesNotExist() {
        Account sender = new Account(123, "amir", 100);
        Account receiver = null;

        assertThrows(AmountException.class, () -> {
            sender.transferMoney(sender, receiver, 100);
        });
    }

    @Test
    void shouldThrowErrorWhenInsufficientBalanceForTransfer() {
        Account sender = new Account(123, "amir", 100);
        Account receiver = new Account(456, "ali", 50);


        assertThrows(IllegalArgumentException.class, () -> {
            sender.transferMoney(sender, receiver, 200);
        });
    }

    @Test
    void shouldNotAllowTransferToItsAccount() {
        Account sender = new Account(123, "amir", 100);

        assertThrows(IllegalArgumentException.class, () -> {
            sender.transferMoney(sender, sender, 50);
        });
    }

}
