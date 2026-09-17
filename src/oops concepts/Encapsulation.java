class Employee {

    private int empId;
    private String empName;

    Employee(int id, String name) {
        setEmpId(id);
        setEmpName(name);
    }

    public void setEmpId(int id) {
        if (id > 0) {
            empId = id;
        }
    }

    public void setEmpName(String name) {
        empName = name;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e = new Employee(101, "Rahul");

        System.out.println("Employee ID: " + e.getEmpId());
        System.out.println("Employee Name: " + e.getEmpName());

        e.setEmpName("Amit");

        System.out.println("Updated Name: " + e.getEmpName());
    }
}
