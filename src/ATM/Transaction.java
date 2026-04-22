package ATM;

import java.util.Date;

public class Transaction {

	    private String type;   
	    private double amount;
	    private Date dateCreated;

	    
	    public Transaction(String type, double amount) {
	        this.type = type;
	        this.amount = amount;
	        this.dateCreated = new Date();
	    }
	    public Date getDateCreated() {
	        return dateCreated;
	    }
	    

	    public String getType() {
	        return type;
	    }

	    public double getAmount() {
	        return amount;
	    }
	}


