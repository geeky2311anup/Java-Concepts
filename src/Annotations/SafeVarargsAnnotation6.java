class Animal{
    public static void sound(List<Integer>... args){
        Object[] objectList = args;
        List<String> stringList = new ArrayList<>();
        stringList.add("Test");
        objectList[0] = stringList; //heap pollution
    }
}

public class SafeVarargsAnnotation6 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        Animal.sound(intList);
        System.out.println(intList.get(0)); //ClassCastException at runtime because of heap pollution
    }
}
