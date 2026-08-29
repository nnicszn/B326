import java.util.Scanner;

public class Activity8_Rodriguez_D{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];
        int sum = 0;

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int highest = numbers[0];
        int lowest = numbers[0];

        System.out.println("\n--- Results ---");
        System.out.print("Numbers entered: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i < numbers.length - 1 ? ", " : ""));

            sum += numbers[i];

            if (numbers[i] > highest) {
                highest = numbers[i];
            }
            if (numbers[i] < lowest) {
                lowest = numbers[i];
            }
        }

        double average = (double) sum / numbers.length;

        System.out.println("\nSum: " + sum);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Highest Number: " + highest);
        System.out.println("Lowest Number: " + lowest);

        scanner.close();
    }
}