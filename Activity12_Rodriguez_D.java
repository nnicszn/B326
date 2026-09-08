import java.util.Scanner;

public class Activity12_Rodriguez_D {

    public static void oddEven(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is EVEN.");
        } else {
            System.out.println(number + " is ODD.");
        }
    }


    public static void printName50Times() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + ". nica");
        }
    }


    public static void squareRoot(double number) {
        System.out.println("Square root: " + Math.sqrt(number));
    }


    public static void power(double base, double exponent) {
        System.out.println("Power: " + Math.pow(base, exponent));
    }


    public static void randomNumber() {
        int random = (int) (Math.random() * 100) + 1;
        System.out.println("Random number: " + random);
    }


    public static void circleArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle: " + area);
    }


    public static void voter(int age) {
        if (age >= 18) {
            System.out.println("The person is a VOTER.");
        } else {
            System.out.println("The person is NOT A VOTER.");
        }
    }


    public static void wordLength(String word) {
        System.out.println("Length of word: " + word.length());
    }


    public static void reverseWord(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println("Reversed word: " + reversed);
    }

    public static void nameAndAge() {
        System.out.println("Full Name: danica rodriguez");
        System.out.println("Age: 18");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== ACTIVITY 12 =====");

        System.out.print("\nEnter a number: ");
        int number = input.nextInt();
        oddEven(number);

        System.out.println("\nName 50 times:");
        printName50Times();

        System.out.print("\nEnter a number for square root: ");
        double sqrtNumber = input.nextDouble();
        squareRoot(sqrtNumber);

        System.out.print("\nEnter base: ");
        double base = input.nextDouble();

        System.out.print("Enter exponent: ");
        double exponent = input.nextDouble();

        power(base, exponent);

        System.out.println("\nRandom Number:");
        randomNumber();

        System.out.print("\nEnter radius: ");
        double radius = input.nextDouble();
        circleArea(radius);

        System.out.print("\nEnter age: ");
        int age = input.nextInt();
        voter(age);

        input.nextLine();
        System.out.print("\nEnter a word: ");
        String word = input.nextLine();
        wordLength(word);

        System.out.print("\nEnter a word to reverse: ");
        String reverse = input.nextLine();
        reverseWord(reverse);

        System.out.println("\nFull Name and Age:");
        nameAndAge();

        input.close();
    }
}