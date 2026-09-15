import java.util.Scanner;

// ------------------- INTERFACES -------------------
interface Bonusable {
    double computeBonus();
    boolean isEligibleForBonus();
}

interface Auditable {
    String generateEmployeeId();
    void logSalaryComputation(String employeeId);
}

// ------------------- BASE CLASS -------------------
abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double computeSalary();
    public abstract double computeDeductions();
    public abstract String getEmployeeType();
}

// ------------------- SUBCLASSES -------------------

// 1. RegularEmployee
class RegularEmployee extends Employee implements Bonusable, Auditable {
    private static final double ATTENDANCE_BONUS = 1000;
    private static final double TAX_RATE = 0.10;

    public RegularEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double computeSalary() {
        return getBaseSalary() + ATTENDANCE_BONUS;
    }

    @Override
    public double computeDeductions() {
        return computeSalary() * TAX_RATE;
    }

    @Override
    public double computeBonus() {
        return getBaseSalary() * 0.05;
    }

    @Override
    public boolean isEligibleForBonus() {
        return true;
    }

    @Override
    public String getEmployeeType() {
        return "Regular";
    }

    @Override
    public String generateEmployeeId() {
        return "REG-" + getName().toUpperCase();
    }

    @Override
    public void logSalaryComputation(String employeeId) {
        System.out.println("Audit log: " + employeeId + " salary computed.");
    }
}

// 2. SalesEmployee
class SalesEmployee extends Employee implements Bonusable {
    private static final double TAX_RATE = 0.12;
    private double commission;

    public SalesEmployee(String name, double baseSalary, double commission) {
        super(name, baseSalary);
        this.commission = commission;
    }

    @Override
    public double computeSalary() {
        return getBaseSalary() + commission;
    }

    @Override
    public double computeDeductions() {
        return computeSalary() * TAX_RATE;
    }

    @Override
    public double computeBonus() {
        return commission * 0.10;
    }

    @Override
    public boolean isEligibleForBonus() {
        return commission > 0;
    }

    @Override
    public String getEmployeeType() {
        return "Sales";
    }

    public double getCommission() { return commission; }
    public void setCommission(double commission) { this.commission = commission; }
}

// 3. ContractualEmployee
class ContractualEmployee extends Employee implements Auditable {
    private static final double TAX_RATE = 0.05;
    private double hoursWorked;
    private double hourlyRate;

    public ContractualEmployee(String name, double hoursWorked, double hourlyRate) {
        super(name, hoursWorked * hourlyRate);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double computeSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public double computeDeductions() {
        return computeSalary() * TAX_RATE;
    }

    @Override
    public String getEmployeeType() {
        return "Contractual";
    }

    @Override
    public String generateEmployeeId() {
        return "CON-" + getName().toUpperCase();
    }

    @Override
    public void logSalaryComputation(String employeeId) {
        System.out.println("Audit log: " + employeeId + " salary computed.");
    }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
}

// ------------------- MAIN CLASS -------------------
public class Activity15_Rodriguez_D {
    public static void main(String[] args) {
        System.out.println("=== TESTING SUBCLASSES ===");

        // Test Regular
        RegularEmployee reg = new RegularEmployee("Juan Dela Cruz", 20000);
        String regId = reg.generateEmployeeId();
        System.out.println("\nType: " + reg.getEmployeeType());
        System.out.println("Name: " + reg.getName());
        System.out.println("Salary: " + reg.computeSalary());
        System.out.println("Deductions: " + reg.computeDeductions());
        System.out.println("Bonus: " + reg.computeBonus());
        reg.logSalaryComputation(regId);

        // Test Sales
        SalesEmployee sales = new SalesEmployee("Maria Clara", 15000, 5000);
        System.out.println("\nType: " + sales.getEmployeeType());
        System.out.println("Name: " + sales.getName());
        System.out.println("Salary: " + sales.computeSalary());
        System.out.println("Deductions: " + sales.computeDeductions());
        System.out.println("Bonus: " + sales.computeBonus());

        // Test Contractual
        ContractualEmployee con = new ContractualEmployee("Pedro Penduko", 160, 100);
        String conId = con.generateEmployeeId();
        System.out.println("\nType: " + con.getEmployeeType());
        System.out.println("Name: " + con.getName());
        System.out.println("Salary: " + con.computeSalary());
        System.out.println("Deductions: " + con.computeDeductions());
        con.logSalaryComputation(conId);
    }
}