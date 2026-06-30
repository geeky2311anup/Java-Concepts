/*
===============================================================================
             ABSTRACT CLASS IMPLEMENTING AN INTERFACE
===============================================================================

Flow:

Interface
    ↓
Abstract Class
    ↓
Concrete Class
    ↓
Object

===============================================================================
Why use an Abstract Class between Interface and Concrete Class?

Suppose many classes implement the same interface.

Instead of writing the common implementation repeatedly,
we place it inside an abstract class.

This avoids code duplication.

Example:

Bird
  ↑
Parrot (common implementation)
  ↑
MyParrot
AfricanParrot
GreenParrot

All parrots can fly similarly,
but every parrot may sing differently.

===============================================================================
INTERFACE
===============================================================================

An interface specifies WHAT a class should do.

It contains only the contract.

Example:

Bird

↓

fly()

Every bird must provide fly().

===============================================================================
ABSTRACT CLASS
===============================================================================

An abstract class provides partial implementation.

It may contain

✔ implemented methods
✔ abstract methods
✔ constructors
✔ instance variables
✔ static methods

It cannot be instantiated.

Example

Bird

↓

Parrot

↓

MyParrot

===============================================================================
CONCRETE CLASS
===============================================================================

Concrete class provides implementation of all remaining abstract methods.

Objects can be created only from concrete classes.

===============================================================================
Variables inside Interface
===============================================================================

Every variable inside an interface is automatically

public
static
final

So these are identical:

String color = "Varied";

and

public static final String color = "Varied";

Meaning:

✔ One copy exists.

✔ Cannot change.

===============================================================================
Methods inside Interface
===============================================================================

By default

public abstract

Example

void fly();

is same as

public abstract void fly();

===============================================================================
Reference Types
===============================================================================

MyParrot obj = new MyParrot();

Can access

fly()
sing()
eat()

------------------------------------------------

Parrot obj = new MyParrot();

Can access

fly()
sing()

Cannot access

eat()

because compiler checks reference type.

------------------------------------------------

Bird obj = new MyParrot();

Can access only

fly()

because Bird interface declares only fly().

===============================================================================
Runtime Polymorphism
===============================================================================

Bird b = new MyParrot();

b.fly();

Compiler checks Bird.

JVM executes MyParrot's inherited implementation.

===============================================================================
Why abstract class doesn't need to override interface methods?

Because abstract class is incomplete.

It may leave some methods for subclasses.

Example

abstract class Parrot implements Bird{

}

Perfectly valid.

===============================================================================
When concrete class implements interface

Every abstract method MUST be implemented.

Otherwise compiler error.

===============================================================================
Can interface have constructor?

NO.

Reason:

Objects of interface cannot be created.

===============================================================================
Can abstract class have constructor?

YES.

Constructor executes whenever subclass object is created.

===============================================================================
Can interface have instance variables?

NO.

Only constants.

===============================================================================
Can abstract class have instance variables?

YES.

===============================================================================
Can abstract class have static methods?

YES.

===============================================================================
Can interface have static methods?

YES (Java 8+)

===============================================================================
Can interface have default methods?

YES (Java 8+)

Example

default void sleep(){

}

===============================================================================
Can abstract class have final methods?

YES.

final methods cannot be overridden.

===============================================================================
Can abstract class have private methods?

YES.

===============================================================================
Memory Representation

Bird Interface

          ↑

      Parrot

          ↑

     MyParrot Object

Reference

Bird b

↓

MyParrot Object

===============================================================================
Interview Questions

Q1 Why use interface?

To achieve abstraction and loose coupling.

------------------------------------------------

Q2 Why use abstract class?

To provide common implementation.

------------------------------------------------

Q3 Can abstract class implement interface?

YES.

------------------------------------------------

Q4 Must abstract class implement every interface method?

NO.

------------------------------------------------

Q5 Must concrete class implement remaining methods?

YES.

------------------------------------------------

Q6 Can we create object of abstract class?

NO.

------------------------------------------------

Q7 Can we create object of interface?

NO.

------------------------------------------------

Q8 Why reference type matters?

Compiler only allows methods declared in reference type.

Actual method executed depends upon object type.

(Runtime Polymorphism)

------------------------------------------------

Q9 Can interface extend another interface?

YES.

------------------------------------------------

Q10 Can abstract class extend another abstract class?

YES.

------------------------------------------------

Q11 Can abstract class implement multiple interfaces?

YES.

Example

abstract class Animal implements Bird, Runnable

------------------------------------------------

Q12 Can one class extend two abstract classes?

NO.

Java doesn't support multiple inheritance of classes.

------------------------------------------------

Q13 Difference between Interface and Abstract Class?

Interface

• Pure contract
• Multiple inheritance supported
• No constructors
• Variables are public static final

Abstract Class

• Partial implementation
• Constructors allowed
• Instance variables allowed
• Single inheritance

===============================================================================
*/
