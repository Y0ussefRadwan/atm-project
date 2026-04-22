package Service;

import ATM.Account;
import java.io.*;
import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();
    private final String FILE_PATH = "accounts.txt";

    public Bank() {
        loadAccountsFromFile();
    }
//load
    private void loadAccountsFromFile() {
        accounts.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                accounts.add(new Account(
                        d[0],                  
                        d[1],                  
                        Integer.parseInt(d[2]),
                        Double.parseDouble(d[3]) 
                ));
            }
        } catch (IOException e) {
            System.out.println("📁 No accounts file yet");
        }
    }
////////////////////////////////////////////////////////////////////    
//Save
    private void saveAccountsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Account a : accounts) {
                bw.write(a.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(" ❌ Error saving file ");
        }
    }

/////////////////////////////////////////////////////////////////////////

    /*         Check Information           */
    public boolean createAccount(String acc, String id, int pin, double balance) {

        for (Account a : accounts) {
            if (a.getAccountNumber().equals(acc)) {
                System.out.println(" ❌ Account already exists ");
                return false;
            }
        }

        for (Account a : accounts) {
            if (a.getNationalId().equals(id)) {
                System.out.println(" ❌ National ID already exists ");
                return false;
            }
        }

        if (String.valueOf(pin).length() != 4) {
            System.out.println(" ❌ PIN must be exactly 4 digits but not (1000:9999) ");
            return false;
        }

        accounts.add(new Account(acc, id, pin, balance));
        saveAccountsToFile();
        return true;
    }
    
//////////////////////////////////////////////////////////////////////
    public Account authenticate(String acc, String id, int pin) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(acc)
                    && a.getNationalId().equals(id)
                    && a.getPin() == pin)
                return a;
        }
        return null;
    }

    public void updateAccounts() {
        saveAccountsToFile();
    }
}
