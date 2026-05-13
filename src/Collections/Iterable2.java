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


/*
After traversing using iteratorObj once,
if we want to traverse again, do we need to create a new iterator object?

✔ Yes — you must create a new iterator.

✅ Why?

In Java, an Iterator works like a cursor.
It keeps track of the current position while traversing the collection.

Once it reaches the end of the collection,
the iterator becomes exhausted and cannot restart automatically.

Example:

Iterator<Integer> it = list.iterator();

while (it.hasNext()) {
    System.out.println(it.next());
}

Now the iterator has already reached the end.

If you try:

while (it.hasNext()) {
    System.out.println(it.next());
}

nothing will print because hasNext() becomes false.

--------------------------------------------------

✅ Correct Way: Create a Fresh Iterator

Iterator<Integer> it1 = list.iterator();

while (it1.hasNext()) {
    System.out.println(it1.next());
}

Iterator<Integer> it2 = list.iterator(); // new iterator

while (it2.hasNext()) {
    System.out.println(it2.next());
}

Each call to list.iterator() creates a new iterator
starting from index 0.

--------------------------------------------------

✅ Important Point About remove()

iterator.remove() safely removes elements
during iteration.

If you directly use:

list.remove()

inside iterator traversal,
Java may throw:

ConcurrentModificationException

So while iterating,
always use iterator.remove() instead of list.remove().

--------------------------------------------------

✅ for-each Loop Internally Uses Iterator

This loop:

for(int x : list) {
    System.out.println(x);
}

internally works using an Iterator only.

Java automatically creates and manages the iterator behind the scenes.

--------------------------------------------------

✅ Difference Between Iterator and ListIterator

Iterator:
- Forward traversal only
- Can remove elements
- Works for all collections

ListIterator:
- Forward + backward traversal
- Can add, update, remove elements
- Works only with List implementations

--------------------------------------------------

🧠 Real-life Analogy

Iterator is like a video progress bar.

Once the video ends,
you cannot continue from the beginning automatically.

You must restart the video
(create a new iterator).

--------------------------------------------------

✔ Final Answer

Yes, after an iterator finishes traversal,
you must create a new iterator object
to traverse the collection again.
*/
