class Person{
    private String name;
    private int age;
     public Person(String name, int age){
         this.name = name;
         if(age>0){
            this.age = age;
         }
         else{
            System.out.println("age is not valid");
         }
     }
     public void getinfo(){
        System.out.println("name is "+ name + " age is "+ age);
     }
     public void setinfo(String name, int age){
        this.name = name;
        if(age>0){
            this.age = age;
         }
         else{
            System.out.println("age is not valid");
         }
     }
}

class Encapsulation{
    public static void main(String[] args){
        Person obj = new Person("anup",23);
        obj.getinfo();
        obj.setinfo("abhinash",-11);
        obj.setinfo("abhinash",21);
        obj.getinfo();


    }
}