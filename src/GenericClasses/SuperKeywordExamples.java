/*
 * 6. super() cannot be used inside a normal method.
 *
 *    super() is a constructor call, so it can ONLY be used inside
 *    a constructor.
 *
 *    Example:
 *
 *    class Child extends Parent {
 *
 *        Child() {
 *            super();      // ✅ Valid
 *        }
 *
 *        void display() {
 *            super();      // ❌ Compilation Error
 *        }
 *    }
 *
 *
 * 7. super can also be used WITHOUT parentheses.
 *
 *    super and super() are different.
 *
 *    super.variable
 *        → Accesses a variable of the parent class.
 *
 *    super.method()
 *        → Calls a method of the parent class.
 *
 *    super()
 *        → Calls the constructor of the parent class.
 *
 *
 *    Example:
 *
 *    class Parent {
 *        int x = 10;
 *
 *        void show() {
 *            System.out.println("Parent");
 *        }
 *    }
 *
 *    class Child extends Parent {
 *        int x = 20;
 *
 *        Child() {
 *            super();
 *        }
 *
 *        void display() {
 *            System.out.println(x);        // 20
 *            System.out.println(super.x);  // 10
 *
 *            show();        // Child's version if overridden
 *            super.show();  // Parent's version
 *        }
 *    }
 *
 *
 * 8. super() calls the immediate parent constructor only.
 *
 *    class A {
 *        A() {
 *            System.out.println("A");
 *        }
 *    }
 *
 *    class B extends A {
 *        B() {
 *            super();
 *            System.out.println("B");
 *        }
 *    }
 *
 *    class C extends B {
 *        C() {
 *            super();
 *            System.out.println("C");
 *        }
 *    }
 *
 *    new C();
 *
 *    Output:
 *
 *    A
 *    B
 *    C
 *
 *    C calls B's constructor.
 *    B calls A's constructor.
 *
 *
 * 9. Constructor chaining continues until Object.
 *
 *    Every Java class ultimately extends java.lang.Object
 *    either directly or indirectly.
 *
 *
 *    class A {
 *        A() {
 *            System.out.println("A");
 *        }
 *    }
 *
 *    class B extends A {
 *        B() {
 *            System.out.println("B");
 *        }
 *    }
 *
 *    class C extends B {
 *        C() {
 *            System.out.println("C");
 *        }
 *    }
 *
 *
 *    new C();
 *
 *    Internally:
 *
 *    C()
 *      ↓
 *    B()
 *      ↓
 *    A()
 *      ↓
 *    Object()
 *
 *
 * 10. If the parent has no default constructor, child must explicitly
 *     call an available parent constructor.
 *
 *    class Parent {
 *        Parent(int x) {
 *            System.out.println(x);
 *        }
 *    }
 *
 *    class Child extends Parent {
 *
 *        Child() {
 *            super(10);      // ✅ Required
 *        }
 *    }
 *
 *    If we write:
 *
 *    Child() {
 *        // Compiler tries to insert super();
 *    }
 *
 *    Compilation Error occurs because Parent does not have Parent().
 *
 *
 * 11. A constructor is NOT inherited by the child class.
 *
 *    class Parent {
 *        Parent(int x) {
 *        }
 *    }
 *
 *    class Child extends Parent {
 *    }
 *
 *    Child does NOT automatically inherit Parent(int).
 *
 *    The child must define a constructor and call:
 *
 *    Child() {
 *        super(10);
 *    }
 *
 *
 * 12. super() cannot be called twice in the same constructor.
 *
 *    Child() {
 *        super();
 *        super();       // ❌ Compilation Error
 *    }
 *
 *    Only one constructor call can appear as the first statement.
 *
 *
 * 13. this() and super() cannot be used together in the same constructor.
 *
 *    Child() {
 *        this(10);
 *        super();       // ❌ Compilation Error
 *    }
 *
 *    Both must be the first statement, so they cannot both be used.
 *
 *
 * 14. this() is used for constructor chaining within the same class.
 *
 *    class Student {
 *
 *        Student() {
 *            this(100);
 *        }
 *
 *        Student(int marks) {
 *            System.out.println(marks);
 *        }
 *    }
 *
 *    new Student();
 *
 *    Flow:
 *
 *    Student()
 *       ↓
 *    this(100)
 *       ↓
 *    Student(int)
 *
 *
 * 15. this() can eventually lead to super().
 *
 *    Example:
 *
 *    class Student {
 *
 *        Student() {
 *            this(100);
 *        }
 *
 *        Student(int marks) {
 *            System.out.println(marks);
 *        }
 *    }
 *
 *    The constructor Student(int) does not explicitly use super().
 *
 *    Therefore Java automatically inserts:
 *
 *    super();
 *
 *
 *    Flow:
 *
 *    Student()
 *       ↓
 *    this(100)
 *       ↓
 *    Student(int)
 *       ↓
 *    super()
 *       ↓
 *    Object()
 *
 *
 * 16. Constructor chaining must eventually reach Object().
 *
 *    There cannot be an infinite constructor chain.
 *
 *    Invalid:
 *
 *    Student() {
 *        this(10);
 *    }
 *
 *    Student(int x) {
 *        this();
 *    }
 *
 *    ❌ Compilation Error
 *
 *    Because the constructors call each other indefinitely.
 *
 *
 * 17. super can access parent members even when they are hidden/overridden.
 *
 *    class Parent {
 *        int value = 10;
 *
 *        void show() {
 *            System.out.println("Parent");
 *        }
 *    }
 *
 *    class Child extends Parent {
 *        int value = 20;
 *
 *        @Override
 *        void show() {
 *            System.out.println("Child");
 *        }
 *
 *        void display() {
 *            System.out.println(value);
 *            System.out.println(super.value);
 *
 *            show();
 *            super.show();
 *        }
 *    }
 *
 *    Output:
 *
 *    20
 *    10
 *    Child
 *    Parent
 *
 *
 * 18. super() can pass values to the parent constructor.
 *
 *    class Vehicle {
 *        String brand;
 *
 *        Vehicle(String brand) {
 *            this.brand = brand;
 *        }
 *    }
 *
 *    class Car extends Vehicle {
 *
 *        Car(String brand) {
 *            super(brand);
 *        }
 *    }
 *
 *    Here:
 *
 *    super(brand)
 *        → passes the value to Vehicle(String brand)
 *
 *
 * 19. Parent constructor executes before child constructor body.
 *
 *    class Parent {
 *        Parent() {
 *            System.out.println("Parent constructor");
 *        }
 *    }
 *
 *    class Child extends Parent {
 *        Child() {
 *            super();
 *            System.out.println("Child constructor");
 *        }
 *    }
 *
 *    new Child();
 *
 *    Output:
 *
 *    Parent constructor
 *    Child constructor
 *
 *
 * 20. Constructor execution order is always from parent to child.
 *
 *    For:
 *
 *    class A
 *       ↓
 *    class B extends A
 *       ↓
 *    class C extends B
 *
 *    new C();
 *
 *    Execution order:
 *
 *    A constructor
 *    ↓
 *    B constructor
 *    ↓
 *    C constructor
 *
 *
 * 21. super() is related to inheritance.
 *
 *    super()
 *        → Parent constructor
 *
 *    super.variable
 *        → Parent variable
 *
 *    super.method()
 *        → Parent method
 *
 *
 * 22. this is related to the current class/object.
 *
 *    this()
 *        → Another constructor of the same class
 *
 *    this.variable
 *        → Current class variable
 *
 *    this.method()
 *        → Current class method
 *
 *
 * 23. Quick Difference:
 *
 *    ---------------------------------------------------------
 *    this()             | super()
 *    ---------------------------------------------------------
 *    Same class         | Parent class
 *    Calls constructor  | Calls constructor
 *    Must be first      | Must be first
 *    One per constructor| One per constructor
 *    ---------------------------------------------------------
 *
 *
 * 24. Quick Difference between super and super()
 *
 *    super
 *       → Parent class reference
 *
 *    super()
 *       → Parent class constructor call
 *
 *    Example:
 *
 *    super.name;
 *       → Access parent variable
 *
 *    super.display();
 *       → Call parent method
 *
 *    super();
 *       → Call parent constructor
 *
 *
 * 25. Important Interview Question:
 *
 *    Q: Why does Java execute the parent constructor first?
 *
 *    A:
 *    Because the child object contains the inherited state of the
 *    parent class. The parent portion must be initialized before the
 *    child constructor starts initializing the child-specific state.
 *
 *
 * 26. Important Interview Question:
 *
 *    Q: Can we use this() and super() in the same constructor?
 *
 *    A:
 *    No.
 *
 *    Both must be the first statement of the constructor, so only one
 *    can be used directly.
 *
 *    However, this() can call another constructor, and that constructor
 *    can eventually call super().
 *
 *
 * 27. Important Interview Question:
 *
 *    Q: Can super() be used in a static method?
 *
 *    A:
 *    No.
 *
 *    Constructors are associated with object creation, while static
 *    methods belong to the class rather than a particular object.
 *
 *
 * 28. Important Interview Question:
 *
 *    Q: Can we call a private parent constructor using super()?
 *
 *    A:
 *    No.
 *
 *    A private constructor is accessible only inside its own class.
 *
 *
 * 29. Important Interview Question:
 *
 *    Q: What happens if the parent constructor throws an exception?
 *
 *    A:
 *    The child constructor cannot complete normally because the parent
 *    constructor must execute before the child constructor body.
 *
 *
 * 30. Golden Rule:
 *
 *    Object creation:
 *
 *        new Child()
 *             ↓
 *        Child constructor
 *             ↓
 *        super()
 *             ↓
 *        Parent constructor
 *             ↓
 *        Object constructor
 *             ↓
 *        Parent initialization
 *             ↓
 *        Child initialization
 *
 *
 * FINAL MEMORY TRICK:
 *
 *    this()
 *       → Same class constructor
 *
 *    super()
 *       → Parent class constructor
 *
 *    this.variable
 *       → Current class variable
 *
 *    super.variable
 *       → Parent class variable
 *
 *    this.method()
 *       → Current class method
 *
 *    super.method()
 *       → Parent class method
 *
 *
 * Remember:
 *
 *    this  = current object
 *    super = parent-class part/reference
 *
 *    this()  = constructor of current class
 *    super() = constructor of parent class
 */
