import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static BankManager bankManager;

    public static void main(String[] args) {
        try {
            bankManager = new BankManager();

        } catch (RuntimeException e) {
            System.err.println(
                    "Unable to start the banking system: "
                            + e.getMessage());
            return;
        }

        System.out.println("==================================");
        System.out.println("    BANKING SIMULATION SYSTEM");
        System.out.println("==================================");

        boolean running = true;

        while (running) {
            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> viewAllAccounts();
                case 3 -> searchAccount();
                case 4 -> depositMoney();
                case 5 -> withdrawMoney();
                case 6 -> checkBalance();
                case 7 -> viewTransactionHistory();
                case 8 -> {
                    running = false;
                    System.out.println(
                            "Thank you for using our banking system.");
                }
                default -> System.out.println(
                        "Invalid choice. Please select 1-8.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n---------- MAIN MENU ----------");
        System.out.println("1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Search Account");
        System.out.println("4. Deposit Money");
        System.out.println("5. Withdraw Money");
        System.out.println("6. Check Balance");
        System.out.println("7. View Transaction History");
        System.out.println("8. Exit");
    }

    private static void createAccount() {
        System.out.println("\n--- Create Account ---");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();

        int age = readInt("Enter age: ");

        double initialDeposit =
                readDouble("Enter initial deposit: ");

        try {
            BankAccount account = bankManager.createAccount(
                    name,
                    age,
                    initialDeposit
            );

            System.out.println("\nAccount created successfully!");
            System.out.println(account);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllAccounts() {
        List<BankAccount> accounts =
                bankManager.getAllAccounts();

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n--- All Bank Accounts ---");

        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }

    private static void searchAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();

        BankAccount account =
                bankManager.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("\nAccount found:");
            System.out.println(account);
        }
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();

        double amount = readDouble("Enter deposit amount: ");

        try {
            if (bankManager.deposit(accountNumber, amount)) {
                System.out.println("Deposit successful!");

                BankAccount account =
                        bankManager.findAccount(accountNumber);

                System.out.printf(
                        "Updated balance: ₹%.2f%n",
                        account.getBalance()
                );

            } else {
                System.out.println(
                        "Deposit failed. Check the account and amount.");
            }

        } catch (RuntimeException e) {
            System.out.println(
                    "Unable to save the transaction: "
                            + e.getMessage());
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();

        double amount = readDouble("Enter withdrawal amount: ");

        try {
            if (bankManager.withdraw(accountNumber, amount)) {
                System.out.println("Withdrawal successful!");

                BankAccount account =
                        bankManager.findAccount(accountNumber);

                System.out.printf(
                        "Remaining balance: ₹%.2f%n",
                        account.getBalance()
                );

            } else {
                System.out.println(
                        "Withdrawal failed. Check the account, amount, "
                                + "and available balance.");
            }

        } catch (RuntimeException e) {
            System.out.println(
                    "Unable to save the transaction: "
                            + e.getMessage());
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();

        BankAccount account =
                bankManager.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.printf(
                    "Current balance: ₹%.2f%n",
                    account.getBalance()
            );
        }
    }

    private static void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine().trim();

        BankAccount account =
                bankManager.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        List<Transaction> transactions =
                bankManager.getTransactionHistory(accountNumber);

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n--- Transaction History ---");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a valid number.");
            }
        }
    }
}