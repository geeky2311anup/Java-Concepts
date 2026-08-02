// ArrayList
System.out.println("\n30. ARRAYLIST");
System.out.println("-------------");
ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Orange");
fruits.add("Mango");
System.out.println("Fruits: " + fruits);
System.out.println("First Fruit: " + fruits.get(0));
fruits.remove("Banana");
System.out.println("After Removing Banana: " + fruits);
System.out.println("Size: " + fruits.size());

// HashMap
System.out.println("\n31. HASHMAP");
System.out.println("-----------");
HashMap<Integer, String> students = new HashMap<>();
students.put(1, "Rahul");
students.put(2, "Priya");
students.put(3, "Amit");
System.out.println("Student with ID 2: " + students.get(2));
System.out.println("Contains Key 1: " + students.containsKey(1));
System.out.println("All Students: " + students);

// Exception Handling
System.out.println("\n32. EXCEPTION HANDLING");
System.out.println("----------------------");
try {
    int result = 20 / 0;
    System.out.println(result);
} catch (ArithmeticException e) {
    System.out.println("Exception Caught: " + e.getMessage());
} finally {
    System.out.println("Finally block executed.");
}

// String Formatting
System.out.println("\n33. STRING FORMAT");
System.out.println("-----------------");
String name = "John";
int age = 21;
double marks = 92.5;
System.out.printf("Name: %s, Age: %d, Marks: %.1f%n", name, age, marks);

// Type Casting
System.out.println("\n34. TYPE CASTING");
System.out.println("----------------");
double value = 25.78;
int intValue = (int) value;
float floatValue = (float) value;
System.out.println("Double: " + value);
System.out.println("Integer: " + intValue);
System.out.println("Float: " + floatValue);

// Character Methods
System.out.println("\n35. CHARACTER METHODS");
System.out.println("---------------------");
char ch = 'A';
System.out.println("Is Letter: " + Character.isLetter(ch));
System.out.println("Is Uppercase: " + Character.isUpperCase(ch));
System.out.println("Lowercase: " + Character.toLowerCase(ch));
System.out.println("ASCII Value: " + (int) ch);
