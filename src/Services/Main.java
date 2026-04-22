package Service;

import ATM.Transaction;

public class Main {
    public static void main(String[] args) {
    	
        Transaction t=new Transaction(null, 0);
    	System.out.println(t.getDateCreated());
    	Bank bank = new Bank(); 
        ATM atm = new ATM(bank);
        atm.start();
        
    }
}
