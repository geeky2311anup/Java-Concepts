//there are basically 4 types of functional interfaces in java

//1. Consumer Functional Interface
//in this type of functional interface, the abstract method takes input but does not return any output
interface ConsumerFunctionalInterface<T>{
    public void accept(T t);
}

//2. Supplier Functional Interface
//in this type of functional interface, the abstract method does not take any input but returns output
interface SupplierFunctionalInterface<R>{
    public R giveOutput();
}

//3. Function functional Interface
//in this type of functional interface, the abstract method takes input and returns output
interface FunctionFunctionalInterface<R,T>{
    public R outputfun(T t);
}

//4. Predicate Functional Interface
//in this type of functional interface, the abstract method takes input and returns boolean output
interface PredicateFunctionalInterface<T>{
    public boolean test(T t);
}
class Types_of_functional_interface{
    public static void main(String [] args){
        //1. Consumer Functional Interface
        
        ConsumerFunctionalInterface<String> consumerObj = (t)->{
            System.out.println("the input provided is: "+ t );
        };
        consumerObj.accept("Hello Consumer");

        //2. Supplier Functional Interface
        SupplierFunctionalInterface<Double> supplierObj = ()->{
            return 1.234;
        };
        System.out.println(supplierObj.giveOutput()); 
        //3. Function functional Interface
        FunctionFunctionalInterface<Integer,String> FunctionObj = (s)->{
            return s.length();

        };
        Integer a=FunctionObj.outputfun("hello java");
        System.out.println("length of input string is "+a);

        //4. Predicate Functional Interface
        PredicateFunctionalInterface<Integer> predicateObj = (it)->{
            return it%1 == 0;
        };
        Boolean it = predicateObj.test(12345);
        System.out.println("the input integer is " +it);


}
}