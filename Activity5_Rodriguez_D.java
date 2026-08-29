import java.util.Scanner;

public class Activity5_Rodriguez_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Required variables
        double balance = 5000.00;
        int choice;
        double depositAmount;
        double withdrawAmount;

        // Display Menu
        System.out.println("=== SIMPLE ATM MENU ===");
        System.out.println("1 - Check Balance");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Exit");
        System.out.print("Enter your choice (1-4): ");

        choice = scanner.nextInt();

        // Process Choice using Switch Statement
        switch (choice) {
            case 1:
                // Check Balance
                System.out.printf("Your current balance is: $%.2f%n", balance);
                break;

            case 2:
                // Deposit
                System.out.print("Enter deposit amount: ");
                depositAmount = scanner.nextDouble();

                // Nested if for validation
                if (depositAmount > 0) {
                    balance += depositAmount;
                    System.out.printf("Successfully deposited $%.2f. New balance: $%.2f%n", depositAmount, balance);
                } else {
                    System.out.println("Error: Deposit amount must be greater than zero.");
                }
                break;

            case 3:
                // Withdraw
                System.out.print("Enter withdrawal amount: ");
                withdrawAmount = scanner.nextDouble();

                // Nested if statements for validation
                if (withdrawAmount > 0) {
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f%n", withdrawAmount, balance);
                    } else {
                        System.out.println("Error: Insufficient balance.");
                    }
                } else {
                    System.out.println("Error: Withdrawal amount must be greater than zero.");
                }
                break;

            case 4:
                // Exit
                System.out.println("Thank you for using the Simple ATM. Goodbye!");
                break;

            default:
                // Invalid Choice
                System.out.println("Error: Invalid choice! Please select an option between 1 and 4.");
                break;
        }

        scanner.close();
    }
}
