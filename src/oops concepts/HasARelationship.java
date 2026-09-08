```java
// Has-A Relationship Example

class Address {
    private String city;
    private String state;
    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}

class Employee {
    private int empId;
    private String empName;
    private String department;
    private Address address; // Employee Has-A Address

    public Employee(int empId, String empName, String department, Address address) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDepartment() {
        return department;
    }

    public Address getAddress() {
        return address;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("City: " + address.getCity());
        System.out.println("State: " + address.getState());
        System.out.println("Country: " + address.getCountry());
    }
}

public class Main {
    public static void main(String[] args) {

        Address addr = new Address("New York", "NY", "USA");

        Employee emp = new Employee(
            101,
            "John Doe",
            "Software Development",
            addr
        );

        emp.displayDetails();
    }
}
```
