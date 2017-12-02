package BackAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();

        // Read a CSV file then create new accounts based on that data
        String file = "C:\\Users\\DanBr\\eclipse-workspace\\BankApplication\\src\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);

        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String SSN = accountHolder[1];
            String accountType = accountHolder[2];
            double deposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Chequing")) {
                accounts.add(new Chequing(name, SSN, deposit));
            } else if (accountType.equals(("Savings"))){
                accounts.add(new Savings(name, SSN, deposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc : accounts) {
            acc.showInfo();
            System.out.println();
        }

    }
}
