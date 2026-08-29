import java.util.Scanner;

public class Activity7_Rodriguez_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the number for the multiplication table: ");
        int number = scanner.nextInt();

        System.out.println("\n--- Multiplication Table of " + number + " ---");

        // Loop to multiply from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        scanner.close();
    }
}
