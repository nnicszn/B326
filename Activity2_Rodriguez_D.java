public class Activity2_Rodriguez_D {
    public static void main(String[] args) {
        double income = 50000;
        double foodAllowance = 15000;
        double transportation = 2500;
        double rent = 4500;
        double utilityBill = 3500;

        double totalExpenses = foodAllowance + transportation + rent + utilityBill;
        double remainingBalance = income - totalExpenses;

        double foodPercent = (foodAllowance / income) * 100;
        double transPercent = (transportation / income) * 100;
        double rentPercent = (rent / income) * 100;
        double utilityPercent = (utilityBill / income) * 100;

        System.out.println("=== EXPENSE BREAKDOWN ===");
        System.out.printf("Food Allowance Percentage:   %.1f %%\n", foodPercent);
        System.out.printf("Transportation Percentage:   %.1f %%\n", transPercent);
        System.out.printf("Rent Percentage:             %.1f %%\n", rentPercent);
        System.out.printf("Utility Bill Percentage:     %.1f %%\n", utilityPercent);
        System.out.println("-------------------------");
        System.out.printf("Total Income:               ₱%.2f\n", income);
        System.out.printf("Total Expenses:             ₱%.2f\n", totalExpenses);
        System.out.printf("Remaining Balance:          ₱%.2f\n", remainingBalance);
    }
}