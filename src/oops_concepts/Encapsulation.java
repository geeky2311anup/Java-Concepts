class Person {
    private String name;
    private int age;
    private String city;
    private String job;

    public Person(String name, int age, String city, String job) {
        this.name = name;
        this.city = city;
        this.job = job;

        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("age is not valid");
        }
    }

    public void getinfo() {
        System.out.println("Name is " + name);
        System.out.println("Age is " + age);
        System.out.println("City is " + city);
        System.out.println("Job is " + job);
    }

    public void setinfo(String name, int age, String city, String job) {
        this.name = name;
        this.city = city;
        this.job = job;

        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("age is not valid");
        }
    }

    public void birthday() {
        age++;
        System.out.println("Happy Birthday " + name);
    }

    public void changeJob(String job) {
        this.job = job;
    }

    public void changeCity(String city) {
        this.city = city;
    }
}

class Encapsulation {
    public static void main(String[] args) {

        Person obj = new Person("Anup", 23, "Lucknow", "Developer");

        obj.getinfo();

        System.out.println();

        obj.birthday();

        System.out.println();

        obj.changeJob("Software Engineer");
        obj.changeCity("Delhi");

        obj.getinfo();

        System.out.println();

        obj.setinfo("Abhinash", -11, "Kanpur", "Tester");

        System.out.println();

        obj.setinfo("Abhinash", 21, "Kanpur", "Tester");

        obj.getinfo();
    }
}
