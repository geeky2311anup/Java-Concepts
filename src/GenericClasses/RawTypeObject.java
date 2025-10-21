class Animal<T>{
    T type;
    public void setType(T type){
        this.type = type;
    }
}

public class RawTypeObject{
    public static void main(String[] args){
        Animal<String> dog = new Animal<>();//generic object
        dog.setType("lebrador");
        System.out.println(dog.type);
        Animal BigCat = new Animal();//its raw type object because we have not specified any data type
        BigCat.setType("Tiger");
        System.out.println(BigCat.type);
    }
}