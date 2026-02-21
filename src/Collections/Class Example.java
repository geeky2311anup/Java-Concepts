📦 Java Collections Framework (JCF)
The Java Collections Framework is a set of classes and interfaces in Java used to store and manipulate groups of objects.
It is in the package:
Java
Copy code
java.util
🧩 Main Interfaces
The framework is mainly divided into:
Copy code

Iterable
   └── Collection
         ├── List
         ├── Set
         └── Queue
   └── Map   (separate, not part of Collection)
1️⃣ List (Ordered, Allows Duplicates)
Maintains insertion order
Allows duplicate elements
Index-based access
Common Classes:
Class
Features
ArrayList
Fast access, dynamic array
LinkedList
Fast insertion/deletion
Vector
Thread-safe (old class)
Stack
LIFO (Last In First Out)
Example:
Java
Copy code
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
2️⃣ Set (No Duplicates)
Does NOT allow duplicate elements
No guaranteed order (except some implementations)
Common Classes:
Class
Features
HashSet
No order, fastest
LinkedHashSet
Maintains insertion order
TreeSet
Sorted order
Example:
Java
Copy code
Set<Integer> set = new HashSet<>();
set.add(10);
set.add(10); // duplicate ignored
3️⃣ Queue (FIFO – First In First Out)
Used for processing elements in order
Common Classes:
Class
Features
PriorityQueue
Sorted based on priority
LinkedList
Can act as Queue
Example:
Java
Copy code
Queue<Integer> q = new LinkedList<>();
q.add(1);
q.poll();
4️⃣ Map (Key-Value Pair)
⚠️ Map is NOT part of Collection interface.
Stores data as key-value pairs
Keys must be unique
Common Classes:
Class
Features
HashMap
Fastest, no order
LinkedHashMap
Maintains insertion order
TreeMap
Sorted by key
Hashtable
Thread-safe (old class)
