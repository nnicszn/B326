import java.util.Scanner;
import java.util.regex.Pattern;

class UserAccount {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String email;
    private String password;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public UserAccount() {
    }

    public UserAccount(String firstName, String middleName, String lastName, String address, String email, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        setEmail(email);
        setPassword(password);
    }

    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }

        return hasUpper && hasLower && hasDigit;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        if (isValidPassword(password)) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Invalid password format.");
        }
    }

    public String getFullName() {
        if (middleName == null || middleName.trim().isEmpty()) {
            return firstName + " " + lastName;
        }
        return firstName + " " + middleName + " " + lastName;
    }
}

public class Activity13_Rodriguez_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== USER REGISTRATION ===");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Middle Name (Optional, press Enter to skip): ");
        String middleName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        String email;
        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (UserAccount.isValidEmail(email)) {
                break;
            } else {
                System.out.println("-> Invalid email format (e.g., user@example.com). Try again.");
            }
        }

        String password;
        while (true) {
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            if (UserAccount.isValidPassword(password)) {
                break;
            } else {
                System.out.println("-> Password must be at least 8 characters, with uppercase, lowercase, and digit. Try again.");
            }
        }

        UserAccount user = new UserAccount(firstName, middleName, lastName, address, email, password);

        System.out.println("\n=== ACCOUNT DETAILS CREATED ===");
        System.out.println("Full Name: " + user.getFullName());
        System.out.println("Email:     " + user.getEmail());
        System.out.println("Address:   " + user.getAddress());

        scanner.close();
    }
}