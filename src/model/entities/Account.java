package model.entities;

import model.exceptions.DomainException;

public class Account {
    private int number;
    private String holder;
    protected double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public Account(int number, String holder, double inicialDeposit) {
        this.number = number;
        this.holder = holder;
        deposit(inicialDeposit);
    }

    public Account(int number, String holder, double inicialDeposit, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        deposit(inicialDeposit);
        this.withdrawLimit = withdrawLimit;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws DomainException {
        if (amount > withdrawLimit) throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
//        if (amount <= withdrawLimit && amount > balance) throw new DomainException("Withdraw error: Not enough balance");
        if (amount > balance) throw new DomainException("Withdraw error: Not enough balance");

        balance -= amount;// + 5.0;
    }

    public String toString() {
        return "Account " + number + ", Holder: " + holder + ", Balance: " + String.format("%.2f", balance) + ", Withdraw Limit: " + String.format("%.2f", withdrawLimit);
    }


}
