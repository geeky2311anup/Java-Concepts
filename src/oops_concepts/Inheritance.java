class Fish extends Animal {
    public Fish(String name) {
        super(name);
        System.out.println("Fish constructor called");
    }

    public void swim() {
        System.out.println(getName() + " is swimming");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes bubbles");
    }

    @Override
    public String toString() {
        return "Fish[" + getName() + "]";
    }
}

class Horse extends Animal {
    public Horse(String name) {
        super(name);
        System.out.println("Horse constructor called");
    }

    public void run() {
        System.out.println(getName() + " is running");
    }

    public void run(int km) {
        System.out.println(getName() + " is running " + km + " km");
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println(getName() + " says Neigh!");
    }
}

class GuideDog extends Dog {
    private String trainer;

    public GuideDog(String name, String breed, String trainer) {
        super(name, breed);
        this.trainer = trainer;
        System.out.println("GuideDog constructor called");
    }

    public void guide() {
        System.out.println(getName() + " is guiding " + trainer);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Trainer: " + trainer);
    }
}
