package Service;

import ATM.Account;
import ATM.Transaction;

import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner input = new Scanner(System.in);

    public ATM(Bank bank) {
        this.bank = bank;
    }
    
////////////////////////////////////////////////////////////////////////////   

//Start fuction
    public void start() {

        while (true) {
            System.out.println("\n____________ ATM SYSTEM ____________");
            System.out.println("1- Login");
            System.out.println("2- Create Account");
            System.out.println("3- Exit");
            System.out.print("Choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> login();
                case 2 -> createAccount();
                case 3 -> {
                	
                	System.out.println("  👋 Goodbye  " );
                	
                	System.exit(0);
                    return;
                }
                
                default -> System.out.println("Invalid choice");
            }
        }
    }
////////////////////////////////////////////////////////////////////////////

 //Login
    private void login() {

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Account Number OR Account Name : ");
            String acc = input.nextLine();

            System.out.print("National ID : ");
            String id = input.nextLine();

            System.out.print("PIN : ");
            int pin = input.nextInt();
            input.nextLine();

            Account account = bank.authenticate(acc, id, pin);

            if (account != null) {
                System.out.print("✅ Login successful  "+new java.util.Date());
                userMenu(account);
                return;
            }
//////////////////////////////////////////////////////////////////////////           

  //check your own account
            attempts--;
            System.out.println("❌ Wrong data | Attempts left: " + attempts  );

   
        }
    

        System.out.println("  🚫 System locked |  Please call Customer Service ");
        System.exit(0);
    }
//////////////////////////////////////////////////////////////////////////////

 //Menu
    private void userMenu(Account account) {

        int choice;
        do {
            System.out.println("\n1- Deposit");
            System.out.println("2- Withdraw");
            System.out.println("3- Balance");
            System.out.println("4- Change PIN ");
            System.out.println("5- Logout");
            System.out.print("Choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Amount : ");
                    account.deposit(input.nextDouble());
                    bank.updateAccounts();
                }
                case 2 -> {
                    System.out.print("Amount : ");
                    account.withdraw(input.nextDouble());
                    bank.updateAccounts();
                }
                case 3 -> System.out.println("Balance = " + account.getBalance());
                case 4 -> {
                	 int newPin;
                	    while (true) {
                	        System.out.print("Enter new PIN (1000 : 9999): ");
                	        newPin = input.nextInt();
                	        input.nextLine(); 

                	        if (newPin >= 1000 && newPin <= 9999) { 
                	            break; 
                	        } else {
                	            System.out.println("Invalid PIN! It must be 4 digits.");
                	        }
                	    }

                	    account.setPin(newPin);   
                	    bank.updateAccounts();     
                	    System.out.println("PIN changed successfully!");
                }

                case 5 -> {System.out.println("  _________   Logged out _________  " + new java.util.Date());
                start();
                
                }

                default -> System.out.println(" _________  Invalid choice _________  ");
            }

            Transaction t=new Transaction(null, 0);
        	System.out.println(t.getDateCreated());
        } while (choice != 4);
    }
//////////////////////////////////////////////////////////////////////////////

 //Accoount
    private void createAccount() {

        System.out.print("Account Number OR Account Name  : ");
        String acc = input.nextLine();

        System.out.print("National ID : ");
        String id = input.nextLine();

        System.out.print("PIN (4 digits) : ");
        int pin = input.nextInt();

        System.out.print("Initial Balance : ");
        double balance = input.nextDouble();
        input.nextLine();

        if (bank.createAccount(acc, id, pin, balance))
            System.out.println("✅ Account created successfully");
        Transaction t=new Transaction(null, 0);
    	System.out.println(t.getDateCreated());
    	
    }
}
