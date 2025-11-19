import java.util.*;

public class CollectionMethods3 {
   public static void main(String[] args){
        List<Integer> listObj = new ArrayList<>();
        listObj.add(10);
        listObj.add(20);
        listObj.add(30);
        listObj.add(40);
        //size
        System.out.println("size of listObj is : "+listObj.size());
        //contains
        System.out.println("listObj contains 20 : "+listObj.contains(20));
        //remove
        listObj.remove(3);
        System.out.println("size of listObj after removing element is : "+listObj.size());
        Stack<Integer> stackObj = new Stack<>();
        stackObj.add(100);
        stackObj.add(200);
        stackObj.add(300);
        listObj.addAll(stackObj);
        System.out.println(listObj.containsAll(stackObj));
        listObj.removeAll(stackObj);
        System.out.println("size of listObj after removing all stack elements is : "+listObj.size());   
        //clear
        listObj.clear();
        System.out.println("size of listObj after clearing all elements is : "+listObj.size());

   }   
}
