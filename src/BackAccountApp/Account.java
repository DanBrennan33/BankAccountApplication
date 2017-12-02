package BackAccountApp;

public abstract class Account implements IBaseRate {
    // List common properties for savings and chequing accounts
    private String name;
    private String SSN;
    private double balance;

    private static int index = 00001;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String SSN, double deposit) {
        this.name = name;
        this.SSN = SSN;
        this.balance = deposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setBaseRate();
    }

    public abstract void setBaseRate();

    private String setAccountNumber() {
        String digitsFromSSN = SSN.substring(SSN.length() - 2, SSN.length());
        int uniqueID = index;
        int randomNum = (int)(Math.random()*Math.pow(10, 3));
        return String.format("%s%05d%03d", digitsFromSSN, uniqueID, randomNum);
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interest: $" + accruedInterest);
        balance += accruedInterest;
        printBalance();
    }

    // List common methods - transactions
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing:  $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing: $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        System.out.println("Transfer of: $" + amount + " to " + toWhere);
        balance -= amount;
        printBalance();
    }

    public void printBalance() {
        System.out.println("Balance: $" + balance);
    }

    public void showInfo() {
        System.out.println("Name: " + name +
               "\nAccount Number: " + accountNumber +
               "\nBalance:        " + balance +
               "\nBase Rate:      " + rate + "%"
        );
    }



}
