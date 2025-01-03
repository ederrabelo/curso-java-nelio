package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class ExcecoesPersonalizadasExercicio {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data: ");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println(account);

            System.out.println();
            System.out.print("Enter amount to withdraw: ");
            double withdraw = sc.nextDouble();
            account.withdraw(withdraw);
            System.out.print("New balance: " + account.getBalance());
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
