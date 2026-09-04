import java.util.Scanner;

public class capstone1_Rodriguez_D {

    private static double accountBalance = 500.00;
    private static String mobileNumber = "";
    private static String networkCarrier = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=================================================");
        System.out.println("       WELCOME TO E-LOAD & PROMO REGISTRATION     ");
        System.out.println("=================================================");

        registerMobileNumber(scanner);

        while (running) {
            System.out.println("\n-------------------------------------------------");
            System.out.println("MOBILE NUMBER : " + mobileNumber + " (" + networkCarrier + ")");
            System.out.printf("WALLET BALANCE: PHP %.2f%n", accountBalance);
            System.out.println("-------------------------------------------------");
            System.out.println("1. Buy Regular Load");
            System.out.println("2. Register to Promos");
            System.out.println("3. Cash-In (Add Wallet Funds)");
            System.out.println("4. Change Mobile Number");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    buyRegularLoad(scanner);
                    break;
                case 2:
                    registerPromoMenu(scanner);
                    break;
                case 3:
                    cashInWallet(scanner);
                    break;
                case 4:
                    registerMobileNumber(scanner);
                    break;
                case 5:
                    System.out.println("\nThank you for using E-Load Registration! Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice. Please select between 1 and 5.");
            }
        }

        scanner.close();
    }

    private static void registerMobileNumber(Scanner scanner) {
        boolean valid = false;

        while (!valid) {
            System.out.print("\nEnter 11-digit Mobile Number (e.g., 09171234567): ");
            String input = scanner.nextLine().trim();

            if (input.length() == 11 && input.startsWith("09")) {
                mobileNumber = input;
                networkCarrier = detectCarrier(input.substring(0, 4));
                valid = true;
                System.out.println("[SUCCESS] Mobile number registered under " + networkCarrier);
            } else {
                System.out.println("[ERROR] Invalid number! Must be 11 digits starting with '09'.");
            }
        }
    }

    private static String detectCarrier(String prefix) {
        if (prefix.equals("0917") || prefix.equals("0927") || prefix.equals("0916")) {
            return "GLOBE/TM";
        } else if (prefix.equals("0918") || prefix.equals("0919") || prefix.equals("0920")) {
            return "SMART/TNT";
        } else if (prefix.equals("0991") || prefix.equals("0992")) {
            return "DITO";
        }
        return "GENERAL NETWORK";
    }

    private static void buyRegularLoad(Scanner scanner) {
        System.out.println("\n--- BUY REGULAR LOAD ---");
        System.out.print("Enter amount to load (PHP 10 - 1000): ");
        double amount = scanner.nextDouble();

        if (amount < 10 || amount > 1000) {
            System.out.println("[ERROR] Invalid load amount. Must be between 10 and 1000.");
        } else if (amount > accountBalance) {
            System.out.println("[ERROR] Insufficient wallet balance!");
        } else {
            accountBalance -= amount;
            printReceipt("Regular Load (" + (int)amount + ")", amount);
        }
    }

    private static void registerPromoMenu(Scanner scanner) {
        System.out.println("\n--- AVAILABLE PROMOS ---");
        System.out.println("1. UNLI_TXT15   - Unli AllNet Texts for 1 Day        (PHP 15.00)");
        System.out.println("2. DATA_SURF50  - 5GB Data + Unli Texts for 3 Days   (PHP 50.00)");
        System.out.println("3. MEGA_COMBO99 - 10GB Data + Unli Calls/Texts 7 Days(PHP 99.00)");
        System.out.println("4. Back to Main Menu");
        System.out.print("Select promo (1-4): ");

        int choice = scanner.nextInt();
        String promoName = "";
        double price = 0.0;

        switch (choice) {
            case 1:
                promoName = "UNLI_TXT15";
                price = 15.00;
                break;
            case 2:
                promoName = "DATA_SURF50";
                price = 50.00;
                break;
            case 3:
                promoName = "MEGA_COMBO99";
                price = 99.00;
                break;
            case 4:
                return;
            default:
                System.out.println("[ERROR] Invalid promo option.");
                return;
        }

        if (price > accountBalance) {
            System.out.println("[ERROR] Insufficient wallet balance for this promo!");
        } else {
            accountBalance -= price;
            printReceipt(promoName, price);
        }
    }

    private static void cashInWallet(Scanner scanner) {
        System.out.println("\n--- CASH-IN WALLET ---");
        System.out.print("Enter amount to add: PHP ");
        double addAmount = scanner.nextDouble();

        if (addAmount <= 0) {
            System.out.println("[ERROR] Amount must be greater than 0.");
        } else {
            accountBalance += addAmount;
            System.out.printf("[SUCCESS] Cash-in successful! New Balance: PHP %.2f%n", accountBalance);
        }
    }

    private static void printReceipt(String item, double price) {
        System.out.println("\n=================================================");
        System.out.println("              TRANSACTION RECEIPT                ");
        System.out.println("=================================================");
        System.out.println("Target Number : " + mobileNumber);
        System.out.println("Network       : " + networkCarrier);
        System.out.println("Item Purchased: " + item);
        System.out.printf("Amount Paid   : PHP %.2f%n", price);
        System.out.printf("Remaining Bal : PHP %.2f%n", accountBalance);
        System.out.println("Status        : SUCCESSFUL / REGISTERED");
        System.out.println("=================================================");
    }
}