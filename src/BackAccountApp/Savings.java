package BackAccountApp;

public class Savings extends Account {
    // List properties specific to Savings Account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    // Constructor to initialize Savings Account properties
    public Savings(String name, String SSN, double deposit) {
        super(name, SSN, deposit);
        accountNumber = "1" + accountNumber;

        setSafetyDepositBox();
    }

    @Override
    public void setBaseRate() {
        rate = getBaseRate() - .25;
    }

    // List any methods specific to Savings Account
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int)(Math.random()*Math.pow(10, 3));
        safetyDepositBoxKey = (int)(Math.random()*Math.pow(10,4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(
                "SAVINGS ACCOUNT FEATURES: " +
                "\nSafety Deposit Box ID:  " + String.format("%03d", safetyDepositBoxID) +
                "\nSafety Deposit Box Key: " + String.format("%04d", safetyDepositBoxKey)
        );
    }
}
