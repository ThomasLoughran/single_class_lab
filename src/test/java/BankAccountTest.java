import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    @Test
    void canGetFirstName(){
//        Given
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
//        When
        String result = bankAccount.getFirstName();
//        Then
        String expected = "Thomas";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canGetLastName(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        String result = bankAccount.getLastName();
        String expected = "Loughran";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canGetDob(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        String result = bankAccount.getDob();
        String expected = "June";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canGetAccountNumber(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        String result = bankAccount.getAccountNumber();
        String expected = "101";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canGetAccountType(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        String result = bankAccount.getAccountType();
        String expected = "default";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canGetOverdraft(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        int result = bankAccount.getOverdraft();
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canSetFirstName(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.setFirstName("Tom");
        String result = bankAccount.getFirstName();
        String expected = "Tom";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canSetLastName(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.setLastName("Smith");
        String result = bankAccount.getLastName();
        String expected = "Smith";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canSetDob(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.setDob("May");
        String result = bankAccount.getDob();
        String expected = "May";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canSetAccountNumber(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.setAccountNumber("102");
        String result = bankAccount.getAccountNumber();
        String expected = "102";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canSetAccountType(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.setAccountType("deluxe");
        String result = bankAccount.getAccountType();
        String expected = "deluxe";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canSetOverdraft(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.setOverdraft(500);
        int result = bankAccount.getOverdraft();
        int expected = 500;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void cannotOverdraw(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.setOverdraft(500);
        bankAccount.withdraw(800);
        int result = bankAccount.getBalance();
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canDeposit(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.deposit(50);
        int result = bankAccount.getBalance();
        int expected = 50;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void cannotDepositNegative(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.deposit(-50);
        int result = bankAccount.getBalance();
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canWithdraw(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.deposit(100);
        bankAccount.withdraw(60);
        int result = bankAccount.getBalance();
        int expected = 40;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void cannotWithdrawNegative(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.withdraw(-50);
        int result = bankAccount.getBalance();
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void canAddInterest(){
        BankAccount bankAccount = new BankAccount("Thomas", "Loughran", "June", "101");
        bankAccount.deposit(50);
        bankAccount.addInterest();
        int result = bankAccount.getBalance();
        int expected = 52;
        assertThat(result).isEqualTo(expected);
    }

}
