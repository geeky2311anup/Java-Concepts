/*
 * ============================
 * 10. Why is <T> written before void?
 * ============================
 *
 * The correct syntax of a generic method is:
 *
 * public <T> void display(T value)
 *        ^^^
 *
 * <T> must be written BEFORE the return type.
 *
 * Here:
 *
 * public     -> access modifier
 * <T>        -> declares the type parameter
 * void       -> return type
 * display    -> method name
 * T value    -> parameter
 *
 *
 * Compare:
 *
 * public void display(T value)      // WRONG
 *
 * public <T> void display(T value)  // CORRECT
 *
 *
 * ============================
 * 11. Generic method can also RETURN T
 * ============================
 *
 * A generic method does not have to return void.
 *
 * Example:
 *
 * public <T> T getValue(T value) {
 *     return value;
 * }
 *
 * Usage:
 *
 * Integer x = getValue(10);
 * String s = getValue("Hello");
 * Animal a = getValue(obj);
 *
 * Java determines T from the argument.
 *
 * For:
 *
 * getValue(10)
 *
 * T = Integer
 *
 * For:
 *
 * getValue("Hello")
 *
 * T = String
 *
 *
 * ============================
 * 12. Generic method with TWO types
 * ============================
 *
 * A method can have more than one type parameter.
 *
 * Example:
 *
 * public <T, U> void printBoth(T first, U second) {
 *     System.out.println(first);
 *     System.out.println(second);
 * }
 *
 * Calling:
 *
 * printBoth(10, "Java");
 *
 * means:
 *
 * T = Integer
 * U = String
 *
 * Another call:
 *
 * printBoth("Age", 25);
 *
 * means:
 *
 * T = String
 * U = Integer
 *
 *
 * ============================
 * 13. T can be used only inside
 *     the method where it is declared
 * ============================
 *
 * Example:
 *
 * public <T> void display(T value) {
 *     System.out.println(value);
 * }
 *
 * Here T belongs to this method.
 *
 * Another method can independently declare its own T:
 *
 * public <T> T getValue(T value) {
 *     return value;
 * }
 *
 * These T's do NOT have to represent the same type.
 *
 * T is simply a conventional name.
 *
 *
 * ============================
 * 14. T is only a convention
 * ============================
 *
 * We normally use:
 *
 * T -> Type
 * E -> Element
 * K -> Key
 * V -> Value
 * N -> Number
 *
 * But Java does not force us to use T.
 *
 * These are also valid:
 *
 * public <ABC> void display(ABC value)
 *
 * public <MyType> void display(MyType value)
 *
 * However, T is preferred because it is standard and readable.
 *
 *
 * ============================
 * 15. Generic method vs normal Object method
 * ============================
 *
 * We could also write:
 *
 * public void display(Object value) {
 *     System.out.println(value);
 * }
 *
 * This can also accept:
 *
 * Integer
 * String
 * Animal
 * Double
 *
 * because every class ultimately inherits from Object.
 *
 * So why use generics?
 *
 * Generics provide TYPE SAFETY.
 *
 *
 * Example:
 *
 * public <T> T getValue(T value) {
 *     return value;
 * }
 *
 * Integer x = getValue(100);
 *
 * Java knows that x is Integer.
 *
 * With Object:
 *
 * public Object getValue(Object value) {
 *     return value;
 * }
 *
 * Integer x = (Integer) getValue(100);
 *
 * We need casting.
 *
 * Generics can avoid unnecessary casting.
 *
 *
 * ============================
 * 16. Generic method is checked at COMPILE TIME
 * ============================
 *
 * Java determines the appropriate type during compilation.
 *
 * Example:
 *
 * public <T> T identity(T value) {
 *     return value;
 * }
 *
 * Integer number = identity(10);
 *
 * Java understands:
 *
 * T = Integer
 *
 * Therefore the returned value is treated as Integer.
 *
 *
 * ============================
 * 17. Explicitly specifying T
 * ============================
 *
 * Usually Java automatically determines T.
 *
 * Example:
 *
 * demo.display(100);
 *
 * Java determines:
 *
 * T = Integer
 *
 *
 * But we can also explicitly specify the type.
 *
 * Example:
 *
 * demo.<Integer>display(100);
 *
 * Here we explicitly tell Java:
 *
 * T = Integer
 *
 * Usually this is unnecessary because Java can infer it.
 *
 *
 * ============================
 * 18. Generic method inside a
 *     non-generic class
 * ============================
 *
 * IMPORTANT:
 *
 * A class does NOT have to be generic
 * for its method to be generic.
 *
 * Example:
 *
 * class Demo {
 *
 *     public <T> void print(T value) {
 *         System.out.println(value);
 *     }
 * }
 *
 * Demo obj = new Demo();
 *
 * obj.print(10);
 * obj.print("Hello");
 * obj.print(5.5);
 *
 * The class Demo is NOT generic.
 *
 * Only the method is generic.
 *
 *
 * ============================
 * 19. Generic class vs generic method
 * ============================
 *
 * Generic CLASS:
 *
 * class Box<T> {
 *     T value;
 * }
 *
 * Here T belongs to the CLASS.
 *
 *
 * Generic METHOD:
 *
 * class Demo {
 *
 *     public <T> void print(T value) {
 *         System.out.println(value);
 *     }
 * }
 *
 * Here T belongs only to the METHOD.
 *
 *
 * ============================
 * 20. Generic class + generic method
 * ============================
 *
 * Both can exist together.
 *
 * Example:
 *
 * class Box<T> {
 *
 *     T value;
 *
 *     public <U> void show(U data) {
 *         System.out.println(value);
 *         System.out.println(data);
 *     }
 * }
 *
 * Here:
 *
 * T -> belongs to the class
 * U -> belongs to the method
 *
 *
 * ============================
 * 21. Bounded type parameter
 * ============================
 *
 * Sometimes we don't want T to accept EVERY type.
 *
 * We can put a restriction on T.
 *
 * Example:
 *
 * public <T extends Number> void print(T value) {
 *     System.out.println(value);
 * }
 *
 * Now T must be Number or a subclass of Number.
 *
 * Valid:
 *
 * print(10);       // Integer
 * print(10.5);     // Double
 * print(100L);     // Long
 *
 * Invalid:
 *
 * print("Hello");  // String
 *
 *
 * Why?
 *
 * Integer extends Number
 * Double extends Number
 * Long extends Number
 *
 * But String does not extend Number.
 *
 *
 * ============================
 * 22. Why use bounded generics?
 * ============================
 *
 * Suppose we want to perform a Number-specific operation.
 *
 * Example:
 *
 * public <T extends Number> double square(T value) {
 *     double x = value.doubleValue();
 *     return x * x;
 * }
 *
 * Now:
 *
 * square(5);
 * square(5.5);
 *
 * are valid.
 *
 * But:
 *
 * square("Hello");
 *
 * is not allowed.
 *
 *
 * ============================
 * 23. Multiple bounds
 * ============================
 *
 * A type parameter can have multiple bounds.
 *
 * Example:
 *
 * <T extends Number & Comparable<T>>
 *
 * This means T must:
 *
 * 1. Extend Number
 * 2. Implement Comparable<T>
 *
 * Syntax:
 *
 * <T extends ClassName & Interface1 & Interface2>
 *
 * IMPORTANT:
 *
 * If a class is present, it must come first.
 *
 *
 * ============================
 * 24. Generic method with ArrayList
 * ============================
 *
 * Generics are heavily used with collections.
 *
 * Example:
 *
 * public <T> void printList(List<T> list) {
 *
 *     for (T item : list) {
 *         System.out.println(item);
 *     }
 * }
 *
 * Now the same method can work with:
 *
 * List<Integer>
 * List<String>
 * List<Animal>
 *
 *
 * ============================
 * 25. Wildcards are different from
 *     generic type parameters
 * ============================
 *
 * Generic type parameter:
 *
 * <T>
 *
 * Wildcard:
 *
 * ?
 *
 * Example:
 *
 * public void printList(List<?> list) {
 *     for (Object item : list) {
 *         System.out.println(item);
 *     }
 * }
 *
 * ? means:
 *
 * "Some unknown type."
 *
 *
 * ============================
 * 26. T vs ?
 * ============================
 *
 * T:
 *
 * public <T> void display(T value)
 *
 * We are introducing a type parameter
 * and giving it a name: T.
 *
 *
 * ?:
 *
 * List<?> list
 *
 * We don't care about the exact type.
 *
 *
 * Simple way to remember:
 *
 * T = "I want to USE the type."
 *
 * ? = "I don't care what the type is."
 *
 *
 * ============================
 * 27. Generic methods and primitive types
 * ============================
 *
 * Generics work with OBJECTS, not primitive types.
 *
 * This is NOT allowed:
 *
 * display(int);
 *
 * But this works:
 *
 * display(Integer.valueOf(10));
 *
 * Normally Java automatically performs
 * autoboxing:
 *
 * display(10);
 *
 * 10 (int)
 *   ↓
 * Integer
 *
 * Therefore:
 *
 * display(10);
 *
 * results in:
 *
 * T = Integer
 *
 *
 * ============================
 * 28. Common generic type wrappers
 * ============================
 *
 * int     -> Integer
 * double  -> Double
 * float   -> Float
 * long    -> Long
 * char    -> Character
 * boolean -> Boolean
 * short   -> Short
 * byte    -> Byte
 *
 *
 * ============================
 * 29. Generic methods don't create
 *     a separate method for every type
 * ============================
 *
 * This:
 *
 * public <T> void display(T value)
 *
 * does NOT mean Java creates:
 *
 * display(Integer)
 * display(String)
 * display(Double)
 * display(Animal)
 *
 * as separate source-level methods.
 *
 * Generics provide compile-time type abstraction.
 *
 *
 * ============================
 * 30. VERY IMPORTANT INTERVIEW POINT
 * ============================
 *
 * Generic methods and method overloading
 * are NOT the same.
 *
 * Generic method:
 *
 * public <T> void display(T value)
 *
 * One method can work with different types.
 *
 *
 * Method overloading:
 *
 * void display(int x)
 * void display(String x)
 *
 * Multiple methods have the same name
 * but different parameter lists.
 *
 *
 * ============================
 * 31. Your complete example
 * ============================
 *
 * Animal obj = new Animal("carnivore");
 *
 * GenericMethodDemo demo = new GenericMethodDemo();
 *
 * demo.display(obj);
 *
 * Step 1:
 *
 * obj is of type Animal.
 *
 * Step 2:
 *
 * Java infers:
 *
 * T = Animal
 *
 * Step 3:
 *
 * Method receives:
 *
 * Animal value = obj;
 *
 * Step 4:
 *
 * System.out.println(value);
 *
 * approximately calls:
 *
 * value.toString();
 *
 * Step 5:
 *
 * Animal doesn't override toString().
 *
 * Therefore Object.toString() is used.
 *
 * Output looks like:
 *
 * Animal@6d06d69c
 *
 *
 * ============================
 * 32. If Animal overrides toString()
 * ============================
 *
 * Example:
 *
 * @Override
 * public String toString() {
 *     return "Type: " + type;
 * }
 *
 * Now:
 *
 * demo.display(obj);
 *
 * Output:
 *
 * Type: carnivore
 *
 *
 * ============================
 * 33. The most important idea
 * ============================
 *
 * Generic method:
 *
 * public <T> void display(T value)
 *
 * can be understood as:
 *
 * "Create a method that can accept a value
 * of any reference type, and call that type T."
 *
 *
 * When we call:
 *
 * display(10);
 *
 * T becomes Integer.
 *
 * When we call:
 *
 * display("Hello");
 *
 * T becomes String.
 *
 * When we call:
 *
 * display(obj);
 *
 * T becomes Animal.
 *
 *
 * ============================
 * QUICK REVISION
 * ============================
 *
 * <T>       -> declares a type parameter
 *
 * T         -> represents that type
 *
 * Generic method
 *             -> method that works with different types
 *
 * Type inference
 *             -> Java automatically determines T
 *
 * <T, U>    -> multiple type parameters
 *
 * T extends Number
 *             -> restricts T to Number/subclasses
 *
 * ?         -> wildcard / unknown type
 *
 * Object    -> accepts objects but may require casting
 *
 * Generics  -> provide compile-time type safety
 *
 * toString()
 *             -> provides String representation of an object
 *
 * Object.toString()
 *             -> default representation such as
 *                ClassName@hexadecimalHash
 *
 *
 * ============================
 * ONE-LINE INTERVIEW ANSWER
 * ============================
 *
 * A generic method is a method that declares its own
 * type parameter using <T>, allowing the same method
 * to work with different types while maintaining
 * compile-time type safety.
 *
 */
