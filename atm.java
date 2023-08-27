import java.util.Scanner;
import java.util.Date;

public class atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        System.out.print("Enter your username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter your pin: ");
        String pin = scanner.nextLine();
        System.out.println("Login successful. Welcome, " + inputUsername + "!");

        double balance = 10000.0; // Initial balance
        double transfer = 0;
        final int MAX_TRANSACTIONS = 10;
        String[] transactionHistory = new String[MAX_TRANSACTIONS];
        int transactionCount = 0;

        while (true) {
            System.out.println("........ATM.........");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Amount");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    recordTransaction(transactionHistory, transactionCount, "Deposit", depositAmount);
                    transactionCount++;
                    System.out.println("Deposited " + depositAmount + " successfully.");
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        recordTransaction(transactionHistory, transactionCount, "Withdrawal", withdrawAmount);
                        transactionCount++;
                        System.out.println("Withdrawn " + withdrawAmount + " successfully.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account no. :");
                    Long accountnum = scanner.nextLong(15);
                    System.out.print("Enter Amount you want to transfer -");
                    double amt = scanner.nextDouble();
                    transfer += amt;
                    System.out.println(transfer + " transferred successfully...");
                    balance -= amt;
                    System.out.println("Now your balance is-> " + balance);
                    recordTransaction(transactionHistory, transactionCount, "transferred", amt);
                    transactionCount++;
                    break;

                case 5:
                    System.out.println("Transaction History:");
                    if (transactionCount == 0) {
                        System.out.println("No transaction history available.");
                    } else {
                        for (int i = 0; i < transactionCount; i++) {
                            System.out.println(transactionHistory[i]);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            System.out.println(); // Add a line for separation
        }
    }

    private static void recordTransaction(String[] history, int index, String type, double amount) {
        Date timestamp = new Date();
        history[index] = timestamp.toString() + " - " + type + " " + amount;
    }
}

