import java.util.*;
public class CollectionVsCollections4{
    public static void main(String[] args){
        List<Integer> listObj = new ArrayList<>();
        listObj.add(1);
        listObj.add(2);
        listObj.add(3);
        System.out.println("max value is "+Collections.max(listObj));
        System.out.println("max value is "+Collections.min(listObj));
        Collections.sort(listObj);
        listObj.forEach((Integer val)-> System.out.println(val));

        

    }
}
