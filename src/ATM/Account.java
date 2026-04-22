package ATM;

import java.util.ArrayList;

public class Account {

    private String accountNumber;
    private String nationalId;
    private int pin;
    private double balance;

    public Account(String accountNumber, String nationalId, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.nationalId = nationalId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getNationalId() {
        return nationalId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

	public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
        }
        else if(amount<0)
        {
        	System.out.println("Please,Enter postive value");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("❌ Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return accountNumber + "," + nationalId + "," + pin + "," + balance;
    }
    
    
        

}
