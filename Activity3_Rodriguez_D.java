public class Activity3_Rodriguez_D {
    public static void main(String[] args) {


        // Task 2: Logical AND Operator (&&)
        int age = 20;
        boolean hasValidID = true;

        boolean isAllowedToEnter = (age >= 18) && hasValidID;

        System.out.println("=== TASK 2: Event Entry Check ===");
        System.out.println("Age: " + age);
        System.out.println("Has Valid ID: " + hasValidID);
        System.out.println("Allowed to Enter: " + isAllowedToEnter);
        System.out.println();


        // Task 3: Logical OR Operator (||)
        boolean isWeekend = false;
        boolean isHoliday = true;

        boolean noClassesToday = isWeekend || isHoliday;

        System.out.println("=== TASK 3: No Classes Check ===");
        System.out.println("Is Weekend: " + isWeekend);
        System.out.println("Is Holiday: " + isHoliday);
        System.out.println("No Classes Today: " + noClassesToday);
        System.out.println();

        // Task 4: Ternary Operator (? :)
        int score = 82;

        String gradeResult = (score >= 75) ? "Passed" : "Failed";

        System.out.println("=== TASK 4: Grade Status ===");
        System.out.println("Score: " + score);
        System.out.println("Status: " + gradeResult);
        System.out.println();

        // ==========================================
        // Task 5: Ternary Operator (? :)
        // Larger Number Determination
        // ==========================================
        int num = 45;
        int num2 = 78;

        int largerNumber = (num > num2) ? num : num2;

        System.out.println("=== TASK 5: Larger Number Check ===");
        System.out.println("Number 1: " + num);
        System.out.println("Number 2: " + num2);
        System.out.println("Larger Number: " + largerNumber);
    }
}