import java.util.*;
public class Iterable2 {
    public static void main(String[] args) {
List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iteratorObj =  list.iterator();
        while(iteratorObj.hasNext()){
            int val = iteratorObj.next();
            System.out.println(val);
            if(val==3){
                iteratorObj.remove();
            }
        

        }
        System.out.println(list.size());
        ////////////////////
        for(int it: list){
            System.out.println(it);
        }
        /// ////////////////

       
    }

}
/*
after traversing using iteratorObj one traversed if we want to traverse again do we need to create new iteratorobj
Yes — you must create a new iterator if you want to traverse the collection again.
✅ Why?

In Java, an Iterator is one-time use.
Once it reaches the end of the collection, it cannot be reset or reused.

Example:

Iterator<Integer> it = list.iterator();

while (it.hasNext()) {
    System.out.println(it.next());
}

// Now it has no more elements → can't use again


If you try again:

while (it.hasNext()) { ... }   // ❌ won't run (iterator already exhausted)

✅ Correct way: Create a new iterator
Iterator<Integer> it1 = list.iterator();  // first traversal
while (it1.hasNext()) {
    System.out.println(it1.next());
}

Iterator<Integer> it2 = list.iterator();  // second traversal
while (it2.hasNext()) {
    System.out.println(it2.next());
}


Each list.iterator() call returns a fresh iterator starting at the beginning.

🧠 Why Java designed it this way?

Because:

Iterators are lightweight cursor objects

They maintain internal state (current position)

Resetting them would require extra complexity

So Java simply lets you ask the collection for a new iterator.

✔ Final Answer

Yes, you must create a new iterator object to traverse the collection again.

If you want, I can also explain how ListIterator works (it supports backward traversal too). 
 */