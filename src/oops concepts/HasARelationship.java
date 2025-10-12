class Address{
    
    public String city;
    public String state;
    public Address(String city, String state){
        this.city = city;
        this.state = state;
    }
}

class person{
    private String name;
    private int age;
    private Address address;
    public person(String name, int age, Address address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayInfo(){
        System.out.println("name is "+ name + " age is "+ age);
        System.out.println("city is "+address.city +" state is "+address.state);
    }
}
 public class HasARelationship{
    public static void main(String[] args){
        Address addr = new Address("Lucknow","UP");
        person obj = new person("anup",23,addr);
        obj.displayInfo();
    }
 }
