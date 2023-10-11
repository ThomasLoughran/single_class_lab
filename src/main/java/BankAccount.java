import java.util.ArrayList;
import java.util.Objects;

public class BankAccount {

    private String firstName;
    private String lastName;
    private String dob;
    private String accountNumber;
    private String accountType = "default";
    private ArrayList<String> accountTypes = new ArrayList<>();



    private int overdraft;
    private int balance = 0;

    public BankAccount(String inputFirstName, String inputLastName, String inputDob, String inputAccountNumber){
        this.firstName = inputFirstName;
        this.lastName = inputLastName;
        this.dob = inputDob;
        this.accountNumber = inputAccountNumber;
        this.overdraft = 0;

        this.accountTypes.add("default");
        this.accountTypes.add("premium");
        this.accountTypes.add("deluxe");
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getDob(){
        return this.dob;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public int getBalance(){
        return this.balance;
    }

    public String getAccountType(){
        return this.accountType;
    }

    public int getOverdraft(){
        return overdraft;
    }
    
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    public void setDob(String newDob){
        this.dob = newDob;
    }

    public void setAccountNumber(String newAccountNumber){
        this.accountNumber = newAccountNumber;
    }
    
    public void setAccountType(String newAccountType){
        for(String type:accountTypes) {
            if(type.equals(newAccountType)) {
                this.accountType = newAccountType;
            }
        }
    }

    public void setOverdraft(int newOverdraft){
        if(newOverdraft >= 0){
            this.overdraft = newOverdraft;
        }
    }

    public void deposit(int depositAmount){
        if(depositAmount > 0){
            balance += depositAmount;
        }
    }

    public void withdraw(int withdrawlAmount){
        if(withdrawlAmount > 0 && (balance - withdrawlAmount >= - overdraft)){
            balance -= withdrawlAmount;
        }
    }

    public void addInterest(){
        balance = (int) (balance * 1.05);
    }

}
