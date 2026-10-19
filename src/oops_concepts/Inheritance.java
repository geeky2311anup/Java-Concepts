class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void makeSound() {
        System.out.println(name + " makes a sound");
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
        System.out.println("Dog constructor called");
    }

    public void bark() {
        System.out.println(getName() + " is barking");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching the ball");
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Woof!");
    }
}

class Puppy extends Dog {
    private int age;

    public Puppy(String name, String breed, int age) {
        super(name, breed);
        this.age = age;
        System.out.println("Puppy constructor called");
    }

    public void play() {
        System.out.println(getName() + " is playing");
    }

    public void showAge() {
        System.out.println(getName() + " is " + age + " months old");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Woof Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void scratch() {
        System.out.println(getName() + " is scratching");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Meow!");
    }
}

public class Inheritance {
    public static void main(String[] args) {

        System.out.println("===== Animal Object =====");
        Animal a = new Animal("Animal");
        a.eat();
        a.sleep();
        a.makeSound();

        System.out.println("\n===== Dog Object =====");
        Dog d = new Dog("Jack", "Labrador");
        d.eat();
        d.bark();
        d.fetch();
        d.makeSound();
        System.out.println("Breed: " + d.getBreed());

        System.out.println("\n===== Puppy Object =====");
        Puppy p = new Puppy("Tommy", "Beagle", 4);
        p.eat();
        p.bark();
        p.play();
        p.showAge();
        p.makeSound();

        System.out.println("\n===== Cat Object =====");
        Cat c = new Cat("Kitty");
        c.eat();
        c.sleep();
        c.scratch();
        c.makeSound();

        System.out.println("\n===== Runtime Polymorphism =====");
        Animal obj1 = new Dog("Rocky", "German Shepherd");
        Animal obj2 = new Cat("Luna");

        obj1.makeSound();
        obj2.makeSound();

        System.out.println("\n===== Upcasting =====");
        Animal obj3 = new Dog("Bruno", "Pug");
        obj3.eat();
        obj3.makeSound();
        System.out.println("Name: " + obj3.getName());

        // obj3.bark(); // Compilation error:
        // Animal reference cannot directly access Dog-specific methods.
    }
}
