🏧 ATM System (Java)

📌 Overview

This project is a simple ATM System implemented in Java using Object-Oriented Programming (OOP).
It simulates real ATM operations such as account creation, login, deposit, withdrawal, and PIN management.

The system also uses file handling to store and retrieve account data.

---

🚀 Features

- 🔐 Login with:
  
  - Account Number / Name
  - National ID
  - PIN (4 digits)

- 👤 Create New Account with validation:
  
  - Unique Account Number
  - Unique National ID
  - Valid PIN (4 digits)

- 💰 Banking Operations:
  
  - Deposit
  - Withdraw
  - Check Balance
  - Change PIN

- 🕒 Transaction timestamp (Date tracking)

- 💾 Data Persistence:
  
  - Accounts are saved in a file ("accounts.txt")
  - Automatically loaded on startup

- 🔒 Security:
  
  - Maximum 3 login attempts
  - System lock after failed attempts

---

🏗️ Project Structure

ATM-System/
│
├── Service/
│   ├── Main.java
│   ├── Bank.java
│   └── ATM.java
│
├── ATM/
│   ├── Account.java
│   ├── Customer.java
│   └── Transaction.java
│
└── accounts.txt

---

⚙️ How It Works

1. Start Program

ATM atm = new ATM(bank);
atm.start();

2. Main Menu

- Login
- Create Account
- Exit

3. After Login

- Deposit
- Withdraw
- Check Balance
- Change PIN
- Logout

---

💡 Key Concepts Used

- Object-Oriented Programming (OOP)
- Encapsulation
- File I/O (BufferedReader / BufferedWriter)
- ArrayList
- Exception Handling
- Date & Time ("java.util.Date")

---

📂 Data Format (accounts.txt)

Each account is stored as:

accountNumber,nationalId,pin,balance

Example:

12345,30123456789012,1234,5000.0

---

⚠️ Notes

- PIN must be exactly 4 digits
- Withdrawal only works if balance is sufficient
- Negative deposit values are rejected
- File is created automatically after the first account

👨‍💻 Author

Youssef Radwan
Backend Developer (Java)

---

❤️ Support

If you like this project:

- ⭐ Star the repository
- 🍴 Fork it
- 🛠️ Contribute

---

🧪 Example Run

____________ ATM SYSTEM ____________
1- Login
2- Create Account
3- Exit
Choice: 2

Account created successfully

---

📅 Transaction Example

Wed Apr 22 12:30:45 EET 2026

---

🔚 End

Simple and practical ATM simulation.
