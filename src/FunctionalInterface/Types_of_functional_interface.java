//there are basically 4 types of functional interfaces in java

//1. Consumer Functional Interface
//takes input but returns nothing
interface ConsumerFunctionalInterface<T>{
    void accept(T t);
}

//2. Supplier Functional Interface
//takes no input but returns output
interface SupplierFunctionalInterface<R>{
    R giveOutput();
}

//3. Function Functional Interface
//takes input and returns output
interface FunctionFunctionalInterface<R,T>{
    R outputfun(T t);
}

//4. Predicate Functional Interface
//takes input and returns boolean
interface PredicateFunctionalInterface<T>{
    boolean test(T t);
}

class Types_of_functional_interface{
    public static void main(String[] args){

        //================ Consumer =================
        ConsumerFunctionalInterface<String> consumerObj = (t) -> {
            System.out.println("The input provided is: " + t);
        };
        consumerObj.accept("Hello Consumer");

        ConsumerFunctionalInterface<Integer> squarePrinter = (n) -> {
            System.out.println("Square = " + (n * n));
        };
        squarePrinter.accept(8);

        //================ Supplier =================
        SupplierFunctionalInterface<Double> supplierObj = () -> {
            return 1.234;
        };
        System.out.println("Supplier Output : " + supplierObj.giveOutput());

        SupplierFunctionalInterface<String> greetingSupplier = () -> {
            return "Welcome to Java Functional Interfaces";
        };
        System.out.println(greetingSupplier.giveOutput());

        //================ Function =================
        FunctionFunctionalInterface<Integer, String> functionObj = (s) -> {
            return s.length();
        };
        Integer len = functionObj.outputfun("hello java");
        System.out.println("Length of input string is " + len);

        FunctionFunctionalInterface<String, Integer> binaryConverter = (num) -> {
            return Integer.toBinaryString(num);
        };
        System.out.println("Binary of 25 = " + binaryConverter.outputfun(25));

        //================ Predicate =================
        PredicateFunctionalInterface<Integer> predicateObj = (num) -> {
            return num % 2 == 0;
        };
        Boolean result = predicateObj.test(12345);
        System.out.println("Is number even? " + result);

        PredicateFunctionalInterface<String> emptyCheck = (str) -> {
            return !str.isEmpty();
        };
        System.out.println("String is not empty: " + emptyCheck.test("Java"));
    }
}
