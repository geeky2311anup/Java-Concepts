class Animal {
    private String name;

    public Animal() {
        name = "Animal";
    }

    public Animal(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public String getName() {
        return name;
    }
}

class Cat extends Animal {

    public Cat() {
        super("Cat");
    }

    public void meow() {
        System.out.println("Cat meows");
    }

    @Override
    public void eat() {
        System.out.println("Cat drinks milk");
    }
}

class Dog extends Animal {

    public Dog() {
        super("Dog");
    }

    public void bark() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }
}

interface Pet {
    void play();
}

interface WildAnimal {
    void hunt();
}

class Horse extends Animal implements Pet {

    public Horse() {
        super("Horse");
    }

    public void graze() {
        System.out.println("Horse grazes");
    }

    @Override
    public void play() {
        System.out.println("Horse plays");
    }
}

class Lion extends Animal implements WildAnimal {

    public Lion() {
        super("Lion");
    }

    @Override
    public void hunt() {
        System.out.println("Lion hunts deer");
    }

    @Override
    public void eat() {
        System.out.println("Lion eats meat");
    }
}

public class IsARelationship {

    public static void main(String[] args) {

        // Inheritance
        Cat cat = new Cat();
        cat.sleep();
        cat.eat();
        cat.meow();

        System.out.println();

        Dog dog = new Dog();
        dog.sleep();
        dog.eat();
        dog.bark();

        System.out.println();

        // Interface
        Pet pet = new Horse();
        pet.play();

        Horse horse = new Horse();
        horse.sleep();
        horse.graze();

        System.out.println();

        // Another interface example
        WildAnimal wild = new Lion();
        wild.hunt();

        System.out.println();

        // Polymorphism
        Animal a1 = new Cat();
        Animal a2 = new Dog();
        Animal a3 = new Lion();

        a1.eat();
        a2.eat();
        a3.eat();
    }
}
