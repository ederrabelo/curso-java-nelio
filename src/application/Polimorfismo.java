package application;

import model.entities.Account;
import model.entities.SavingsAccount;

public class Polimorfismo {
    public static void main(String[] args) {
        Account x = new Account(1020, "Alex", 1000.0);
        Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);

        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println(x);
        System.out.println(y);
    }
}
