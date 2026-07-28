/*
 * Additional Important Points:
 *
 * 1. super() must ALWAYS be the first statement inside a child constructor.
 *
 *    Example:
 *    class Child extends Parent {
 *        Child() {
 *            super();      // ✅ First statement
 *            System.out.println("Child");
 *        }
 *    }
 *
 *    Wrong:
 *    Child() {
 *        System.out.println("Hello");
 *        super();          // ❌ Compilation Error
 *    }
 *
 *
 * 2. Java automatically inserts super() only if you don't write it.
 *
 *    Child() {
 *        // Compiler automatically adds:
 *        // super();
 *    }
 *
 *    This works only when the parent has a no-argument constructor.
 *
 *
 * 3. this.value and super() serve completely different purposes.
 *
 *    this.value = value1;
 *        → Assigns a value to a field.
 *
 *    super(value1);
 *        → Executes the parent constructor to initialize the parent part
 *          of the object.
 *
 *    So, assignment ≠ constructor call.
 *
 *
 * 4. Every child object contains a parent object internally.
 *
 *    Car Object
 *    ┌──────────────────────┐
 *    │ Vehicle Part         │ ← Initialized by super(...)
 *    │  brand               │
 *    │  year                │
 *    ├──────────────────────┤
 *    │ Car Part             │ ← Initialized by child constructor
 *    │  doors               │
 *    └──────────────────────┘
 *
 *    That's why the parent constructor must execute first.
 *
 *
 * 5. Constructor Call Chain
 *
 *    new Car(...)
 *          │
 *          ▼
 *    Car()
 *          │
 *          ▼
 *    super(...)
 *          │
 *          ▼
 *    Vehicle()
 *          │
 *          ▼
 *    Parent initialization complete
 *          │
 *          ▼
 *    Child initialization continues
 *
 *
 * Interview Tip:
 *
 * Q: Is super() mandatory?
 *
 * A:
 * - Yes, if the parent has only parameterized constructor(s).
 * - No, if the parent has a no-argument constructor (Java inserts super()
 *   automatically).
 *
 *
 * Remember:
 *
 * super  → Refers to the parent class.
 * this   → Refers to the current object.
 *
 * super() → Calls a parent constructor.
 * this()  → Calls another constructor in the same class.
 *
 * Both super() and this() must be the FIRST statement of a constructor,
 * and only one of them can be used in a constructor.
 */
