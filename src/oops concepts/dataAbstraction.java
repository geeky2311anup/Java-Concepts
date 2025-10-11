abstract class Shape{
    public abstract double area();
    public void displayArea(){
        System.out.println("Area is :"+ area());
    }
}

class Circle extends Shape{
private double radius;

public Circle(double radius){
this.radius = radius;
}

public double area(){
return Math.PI*radius*radius;
}
}

class rectangle extends Shape{
    double length;
    double breath;
    public rectangle(double length,double breath){
        this.length = length;
        this.breath = breath;
    }
    private double area(){
        return length*breath;
    }

    }


public class DataAbstraction{
    public static void main(String[] args){
        Circle objCircle = new Circle(6);
         objCircle.displayArea();
         rectangle objRectangle = new rectangle(4, 5);
         objRectangle.displayArea();

    }
}


