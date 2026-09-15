public class Activity14_Rodriguez_D {
    public static void main(String[] args) {
        Employee[] employees = {
                new RegularEmployee("syclla", 15000),
                new SalesEmployee("urban", 12000, 5000),
                new ContractualEmployee("manta", 160, 75)
        };

        for (Employee e : employees) {
            e.printPayslip();
        }
    }
}

class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double computeSalary() {
        return baseSalary;
    }

    public void printPayslip() {
        System.out.println(name + "'s salary: " + computeSalary());
    }
}

class RegularEmployee extends Employee {
    public RegularEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double computeSalary() {
        return baseSalary + 1000;
    }
}

class SalesEmployee extends Employee {
    private double commission;

    public SalesEmployee(String name, double baseSalary, double commission) {
        super(name, baseSalary);
        this.commission = commission;
    }

    @Override
    public double computeSalary() {
        return baseSalary + commission;
    }
}

class ContractualEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public ContractualEmployee(String name, double hoursWorked, double hourlyRate) {
        super(name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double computeSalary() {
        return hoursWorked * hourlyRate;
    }
}