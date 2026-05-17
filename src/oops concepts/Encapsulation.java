// File name: Main.java

class Employee {

    // Private data members
    private int empId;
    private String empName;

    // Setter methods
    public void setEmpId(int id) {
        empId = id;
    }

    public void setEmpName(String name) {
        empName = name;
    }

    // Getter methods
    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e = new Employee();

        e.setEmpId(101);
        e.setEmpName("Rahul");

        System.out.println("Employee ID: " + e.getEmpId());
        System.out.println("Employee Name: " + e.getEmpName());
    }
}
