import java.util.Scanner;

public class Activity9_Rodriguez_D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get total number of students and subjects
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        // 2. Arrays to store subjects, student names, grades, and calculated averages
        String[] subjectNames = new String[numSubjects];
        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numSubjects];
        double[] averages = new double[numStudents];

        // 3. Prompt for subject names
        System.out.println("\n--- Subject Information ---");
        for (int j = 0; j < numSubjects; j++) {
            System.out.print("Enter name for Subject " + (j + 1) + ": ");
            subjectNames[j] = scanner.nextLine();
        }

        // 4. Prompt for student details and grades
        System.out.println("\n--- Student Details & Grades ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.print("Enter student name: ");
            studentNames[i] = scanner.nextLine();

            double sum = 0.0;
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter grade for " + subjectNames[j] + ": ");
                grades[i][j] = scanner.nextDouble();
                sum += grades[i][j];
            }
            scanner.nextLine(); // Clear buffer

            // Calculate average for current student
            averages[i] = sum / numSubjects;
        }

        // 5. Display the formatted Grades Report Table
        System.out.println("\n=======================================================");
        System.out.println("                     GRADES REPORT                     ");
        System.out.println("=======================================================");

        // Print header dynamically based on subject names
        System.out.printf("%-20s", "Student Name");
        for (int j = 0; j < numSubjects; j++) {
            System.out.printf("%-15s", subjectNames[j]);
        }
        System.out.printf("%-15s%n", "Average");
        System.out.println("-".repeat(35 + (numSubjects * 15)));

        // Print each student's record
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-20s", studentNames[i]);
            for (int j = 0; j < numSubjects; j++) {
                System.out.printf("%-15.2f", grades[i][j]);
            }
            System.out.printf("%-15.2f%n", averages[i]);
        }
        System.out.println("=======================================================");

        scanner.close();
    }
}