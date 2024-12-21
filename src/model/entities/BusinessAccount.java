package model.entities;

public class BusinessAccount extends Account {
    private Double loanLimit;

    public BusinessAccount() {

    }

    public BusinessAccount(int number, String holder, double inicialDeposit, Double loanLimit) {
        super(number, holder, inicialDeposit);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {
            // deposit(amount);
            balance += amount - 10.0;
        }
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }

}
