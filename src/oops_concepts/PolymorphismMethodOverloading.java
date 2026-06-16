class Calculate {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public String add(String a, String b) {
        return a + b;
    }
}

class BankAccount {
    public void deposit(double amount) {
        System.out.println("Deposited ₹" + amount);
    }

    public void deposit(double amount, String mode) {
        System.out.println("Deposited ₹" + amount + " via " + mode);
    }

    public void deposit(double amount, String mode, String refId) {
        System.out.println(
            "Deposited ₹" + amount + " via " + mode + " Ref: " + refId
        );
    }
}

class SalaryCalculator {
    public double calculateSalary(double basic) {
        return basic;
    }

    public double calculateSalary(double basic, double bonus) {
        return basic + bonus;
    }

    public double calculateSalary(double basic,
                                  double bonus,
                                  double allowance) {
        return basic + bonus + allowance;
    }
}

class Phone {
    public void call(String number) {
        System.out.println("Calling " + number);
    }

    public void call(String number, boolean videoCall) {
        if (videoCall) {
            System.out.println("Video Calling " + number);
        } else {
            System.out.println("Voice Calling " + number);
        }
    }

    public void call(String number, boolean videoCall, String app) {
        System.out.println(
            (videoCall ? "Video" : "Voice")
            + " Calling " + number
            + " using " + app
        );
    }
}

public class PolymorphismMethodOverloading {
    public static void main(String[] args) {

        System.out.println("=== Calculator Example ===");
        Calculate calc = new Calculate();
        System.out.println(calc.add(5, 10));
        System.out.println(calc.add(5, 10, 15));
        System.out.println(calc.add("Hello, ", "World!"));

        System.out.println("\n=== Bank Account Example ===");
        BankAccount account = new BankAccount();
        account.deposit(5000);
        account.deposit(3000, "UPI");
        account.deposit(10000, "NEFT", "TXN12345");

        System.out.println("\n=== Salary Calculator Example ===");
        SalaryCalculator salary = new SalaryCalculator();
        System.out.println("Basic Salary: " +
                           salary.calculateSalary(30000));
        System.out.println("Salary + Bonus: " +
                           salary.calculateSalary(30000, 5000));
        System.out.println("Salary + Bonus + Allowance: " +
                           salary.calculateSalary(30000, 5000, 2000));

        System.out.println("\n=== Phone Call Example ===");
        Phone phone = new Phone();
        phone.call("9876543210");
        phone.call("9876543210", true);
        phone.call("9876543210", true, "WhatsApp");
    }
}
