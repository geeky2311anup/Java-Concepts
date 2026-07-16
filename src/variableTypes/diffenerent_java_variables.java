   /* ===========================
       WRAPPER CLASS VARIABLES
       =========================== */

    public void wrapperExample() {

        Integer number = 50;
        Double price = 99.99;
        Character grade = 'A';

        System.out.println(number);
        System.out.println(price);
        System.out.println(grade);
    }

    /* ===========================
       ARRAY VARIABLE
       =========================== */

    public void arrayExample() {

        String[] cities = {"Delhi", "Mumbai", "Pune"};

        for (String city : cities) {
            System.out.println(city);
        }
    }

    /* ===========================
       TYPE CASTING VARIABLES
       =========================== */

    public void typeCastingExample() {

        double marks = 95.75;
        int roundedMarks = (int) marks;

        System.out.println(marks);
        System.out.println(roundedMarks);
    }

    /* ===========================
       CONSTANT USING FINAL
       =========================== */

    public void constantExample() {

        final int DAYS_IN_WEEK = 7;

        System.out.println(DAYS_IN_WEEK);
    }

    /* ===========================
       STATIC LOCAL OBJECT
       =========================== */

    public void objectVariableExample() {

        Student student = new Student("Anup", 21);

        System.out.println(student);
    }

Then call them in main():

        alpha.wrapperExample();

        alpha.arrayExample();

        alpha.typeCastingExample();

        alpha.constantExample();

        alpha.objectVariableExample();

Finally, add this class at the end of the same file (after Child):

/* ===========================================
   STUDENT CLASS
   =========================================== */

class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}
