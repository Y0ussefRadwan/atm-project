package ATM;

import java.util.ArrayList;

public class Customer {

	private String Name;
	private String ID_National;
	private String Phone ;
	private ArrayList<Account> accounts;
	 
	 public Customer(String nationalId, String name, String phone) {
        this.ID_National = nationalId;
        this.Name = name;
        this.Phone = phone;
        this.accounts = new ArrayList<>();
    }

    public String getNationalId() {
        return ID_National;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}

