import java.util.*;

public class CollectionVsCollections4 {
    public static void main(String[] args) {

        List<Integer> listObj = new ArrayList<>();

        listObj.add(1);
        listObj.add(2);
        listObj.add(3);
        listObj.add(2);
        listObj.add(5);

        // Max and Min
        System.out.println("Max value is: " + Collections.max(listObj));
        System.out.println("Min value is: " + Collections.min(listObj));

        // Sort
        Collections.sort(listObj);
        System.out.println("\nAfter Sorting:");
        listObj.forEach(val -> System.out.print(val + " "));

        // Reverse
        Collections.reverse(listObj);
        System.out.println("\n\nAfter Reversing:");
        listObj.forEach(val -> System.out.print(val + " "));

        // Shuffle
        Collections.shuffle(listObj);
        System.out.println("\n\nAfter Shuffling:");
        listObj.forEach(val -> System.out.print(val + " "));

        // Binary Search (list must be sorted)
        Collections.sort(listObj);
        int index = Collections.binarySearch(listObj, 3);
        System.out.println("\n\nIndex of 3: " + index);

        // Frequency
        int freq = Collections.frequency(listObj, 2);
        System.out.println("Frequency of 2: " + freq);

        // Swap
        Collections.swap(listObj, 0, listObj.size() - 1);
        System.out.println("\nAfter Swapping first and last element:");
        listObj.forEach(val -> System.out.print(val + " "));

        // Copy example
        List<Integer> destList =
                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        Collections.copy(destList, listObj);

        System.out.println("\n\nCopied List:");
        destList.forEach(val -> System.out.print(val + " "));

        // Fill
        Collections.fill(destList, 100);
        System.out.println("\n\nAfter Fill:");
        destList.forEach(val -> System.out.print(val + " "));

        // Unmodifiable List
        List<Integer> readOnlyList =
                Collections.unmodifiableList(listObj);

        System.out.println("\n\nRead Only List:");
        readOnlyList.forEach(val -> System.out.print(val + " "));
    }
}
