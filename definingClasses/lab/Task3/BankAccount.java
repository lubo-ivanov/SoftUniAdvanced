package javaAdvanced.definingClasses.lab.Task3;

public class BankAccount {
    private int id;
    private double balance;

    private static double interestRate = 0.02;
    private static int bankAccountNum = 1;

    public static int getBankAccountNum() {
        return bankAccountNum;
    }

    public int getId() {
        return id;
    }

    BankAccount() {
        this.id = bankAccountNum++;
    }
    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
    public void deposit (double amount) {
        this.balance += amount;
    }
    public String getInterest (int years) {
        return String.format("%.2f",BankAccount.interestRate * years * this.balance);
    }
}
