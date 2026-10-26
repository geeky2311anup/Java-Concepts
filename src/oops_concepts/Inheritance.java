
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

    public void showInfo() {
        System.out.println("Animal name: " + name);
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

    public void guard() {
        System.out.println(getName() + " is guarding the house");
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Woof!");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Breed: " + breed);
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

    public void learn() {
        System.out.println(getName() + " is learning new tricks");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Woof Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
        System.out.println("Cat constructor called");
    }

    public void scratch() {
        System.out.println(getName() + " is scratching");
    }

    public void climb() {
        System.out.println(getName() + " is climbing a tree");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
        System.out.println("Bird constructor called");
    }

    public void fly() {
        System.out.println(getName() + " is flying");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Chirp!");
    }
}

public class Inheritance {

    public static void main(String[] args) {

        System.out.println("===== Animal Object =====");
        Animal a = new Animal("Animal");
        a.eat();
        a.sleep();
        a.makeSound();
        a.showInfo();

        System.out.println("\n===== Dog Object =====");
        Dog d = new Dog("Jack", "Labrador");
        d.eat();
        d.bark();
        d.fetch();
        d.guard();
        d.makeSound();
        System.out.println("Breed: " + d.getBreed());

        System.out.println("\n===== Puppy Object =====");
        Puppy p = new Puppy("Tommy", "Beagle", 4);
        p.eat();
        p.bark();
        p.fetch();
        p.play();
        p.showAge();
        p.learn();
        p.makeSound();

        System.out.println("\n===== Cat Object =====");
        Cat c = new Cat("Kitty");
        c.eat();
        c.sleep();
        c.scratch();
        c.climb();
        c.makeSound();

        System.out.println("\n===== Bird Object =====");
        Bird b = new Bird("Tweety");
        b.eat();
        b.fly();
        b.makeSound();

        System.out.println("\n===== Runtime Polymorphism =====");
        Animal obj1 = new Dog("Rocky", "German Shepherd");
        Animal obj2 = new Cat("Luna");
        Animal obj3 = new Bird("Rio");

        obj1.makeSound();
        obj2.makeSound();
        obj3.makeSound();

        System.out.println("\n===== Upcasting =====");
        Animal obj4 = new Dog("Bruno", "Pug");
        obj4.eat();
        obj4.makeSound();
        System.out.println("Name: " + obj4.getName());

        // obj4.bark(); // Compilation error:
        // Animal reference cannot access Dog-specific methods.

        System.out.println("\n===== Downcasting =====");
        if (obj4 instanceof Dog) {
            Dog dogRef = (Dog) obj4;
            dogRef.bark();
            System.out.println("Breed: " + dogRef.getBreed());
        }

        System.out.println("\n===== instanceof Operator =====");
        Animal[] animals = {
            new Dog("Max", "Husky"),
            new Cat("Misty"),
            new Bird("Sky"),
            new Puppy("Coco", "Poodle", 3)
        };

        for (Animal animal : animals) {
            System.out.println(animal.getName());

            if (animal instanceof Puppy) {
                System.out.println("This is a puppy");
            } else if (animal instanceof Dog) {
                System.out.println("This is a dog");
            } else if (animal instanceof Cat) {
                System.out.println("This is a cat");
            } else if (animal instanceof Bird) {
                System.out.println("This is a bird");
            }

            animal.makeSound();
        }

        System.out.println("\n===== Calling Parent Method with super =====");
        Dog specialDog = new Dog("Sheru", "German Shepherd");
        specialDog.showInfo();

        System.out.println("\n===== Inheritance Chain =====");
        Puppy littleDog = new Puppy("Buddy", "Golden Retriever", 6);

        littleDog.eat();       // Inherited from Animal
        littleDog.bark();      // Inherited from Dog
        littleDog.play();      // Defined in Puppy
        littleDog.makeSound(); // Overridden in Puppy

        System.out.println("\n===== Polymorphism with Arrays =====");
        Animal[] pets = {
            new Dog("Oscar", "Beagle"),
            new Cat("Milo"),
            new Bird("Pico")
        };

        for (Animal pet : pets) {
            pet.eat();
            pet.makeSound();
            System.out.println();
        }
    }
}
