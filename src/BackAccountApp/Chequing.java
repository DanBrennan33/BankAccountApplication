package BackAccountApp;

public class Chequing extends Account {
    // List properties specific to a Chequing Account
    private int debitCardNumber;
    private int debitCardPin;

    // Constructor to initialize Chequing Account properties
    public Chequing(String name, String SSN, double deposit) {
        super(name, SSN, deposit);
        accountNumber = "2" + accountNumber;

        setDebitCard();
    }

    @Override
    public void setBaseRate() {
        rate = getBaseRate() * .15;
    }


    // List any methods specific to the Chequing Account
    private void setDebitCard() {
        debitCardNumber = (int)(Math.random()*Math.pow(10, 12));
        debitCardPin = (int)(Math.random()*Math.pow(10, 4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Chequing Account Features: " +
                "\nDebit Card Number: " + String.format("%012d", debitCardNumber) +
                "\nDebit Card PIN:    " + String.format("%04d", debitCardPin)
        );

    }
}
