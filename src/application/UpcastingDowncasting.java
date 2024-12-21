package application;

import model.entities.Account;
import model.entities.BusinessAccount;
import model.entities.SavingsAccount;

public class UpcastingDowncasting {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Eder", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.00);

        // UPCASTING
        Account acc1 = bacc;
        acc1.getBalance();
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.00);
        Account acc3 = new SavingsAccount(1004, "Alex", 0.0, 0.01);

        // Downcasting
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(200.0);

        // BusinessAccount acc5 = (BusinessAccount) acc3;
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

    }
}
