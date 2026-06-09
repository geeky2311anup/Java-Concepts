//hasArelationship
class Address {
    private String city;
    private String state;

    // Constructor
    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Getter methods
    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}

class Employee {
    private int empId;
    private String empName;
    private Address address; // Has-A relationship

    // Constructor
    public Employee(int empId, String empName, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
    }

    // Getter methods
    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Address getAddress() {
        return address;
    }
}

public class Main {
    public static void main(String[] args) {
        Address addr = new Address("New York", "NY");
        Employee emp = new Employee(101, "John Doe", addr);

        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getEmpName());
        System.out.println("Employee City: " + emp.getAddress().getCity());
        System.out.println("Employee State: " + emp.getAddress().getState());
    }
}