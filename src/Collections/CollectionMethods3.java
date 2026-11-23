import java.util.*;

public class CollectionMethods3 {
    public static void main(String[] args) {

        List<Integer> listObj = new ArrayList<>();

        listObj.add(10);
        listObj.add(20);
        listObj.add(30);
        listObj.add(40);
        listObj.add(20);

        // size
        System.out.println("Size of listObj: " + listObj.size());

        // contains
        System.out.println("Contains 20: " + listObj.contains(20));

        // isEmpty
        System.out.println("Is list empty? " + listObj.isEmpty());

        // get
        System.out.println("Element at index 2: " + listObj.get(2));

        // indexOf
        System.out.println("First occurrence of 20: " + listObj.indexOf(20));

        // lastIndexOf
        System.out.println("Last occurrence of 20: " + listObj.lastIndexOf(20));

        // set
        listObj.set(1, 25);
        System.out.println("After set(): " + listObj);

        // remove by index
        listObj.remove(3);
        System.out.println("After remove(index): " + listObj);

        // addAll
        Stack<Integer> stackObj = new Stack<>();
        stackObj.add(100);
        stackObj.add(200);
        stackObj.add(300);

        listObj.addAll(stackObj);
        System.out.println("After addAll(): " + listObj);

        // containsAll
        System.out.println("Contains all stack elements: "
                + listObj.containsAll(stackObj));

        // retainAll
        List<Integer> temp = Arrays.asList(25, 100, 300);
        listObj.retainAll(temp);
        System.out.println("After retainAll(): " + listObj);

        // addAll again
        listObj.addAll(stackObj);

        // removeAll
        listObj.removeAll(stackObj);
        System.out.println("After removeAll(): " + listObj);

        // toArray
        Object[] arr = listObj.toArray();
        System.out.println("Array elements:");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        // --- Additional List & Collection methods ---

        // remove first matching Object (use Integer.valueOf so it doesn't treat as index)
        listObj.remove(Integer.valueOf(25));
        System.out.println("After remove(Integer.valueOf(25)): " + listObj);

        // add more elements, sort, and inspect a subList view
        listObj.addAll(Arrays.asList(15, 5, 50));
        Collections.sort(listObj);
        System.out.println("After sort(): " + listObj);

        List<Integer> view = listObj.subList(1, 3);
        System.out.println("SubList [1, 3): " + view);

        // typed toArray
        Integer[] typedArr = listObj.toArray(new Integer[0]);
        System.out.println("Typed array: " + Arrays.toString(typedArr));

        // safe removal while iterating using Iterator
        Iterator<Integer> it = listObj.iterator();
        while (it.hasNext()) {
            if (it.next() < 15) {
                it.remove();
            }
        }
        System.out.println("After removing elements < 15 via Iterator: " + listObj);

        // clear
        listObj.clear();
        System.out.println("Size after clear(): " + listObj.size());

        // isEmpty after clear
        System.out.println("Is list empty now? " + listObj.isEmpty());
    }
}
