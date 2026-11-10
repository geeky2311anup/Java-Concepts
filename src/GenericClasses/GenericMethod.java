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
