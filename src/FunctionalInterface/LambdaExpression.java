System.out.println("\n===== Stream API with Lambda =====");

List<Integer> numbers = Arrays.asList(2, 5, 8, 11, 14, 17, 20);

System.out.print("Even Numbers: ");
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(n -> System.out.print(n + " "));

System.out.println();

int total = numbers.stream()
                   .reduce(0, (a, b) -> a + b);
System.out.println("Sum = " + total);

System.out.println("\n===== Optional Example =====");

Optional<String> optional = Optional.of("Java Lambda");
optional.ifPresent(s -> System.out.println("Value: " + s));

System.out.println("\n===== Constructor Reference =====");

Supplier<ArrayList<String>> listSupplier = ArrayList::new;
ArrayList<String> names = listSupplier.get();
names.add("Anup");
names.add("Rahul");
System.out.println("Names: " + names);

System.out.println("\n===== String Operations =====");

Function<String, String> upper = String::toUpperCase;
System.out.println(upper.apply("lambda expressions"));

Predicate<String> emptyCheck = String::isEmpty;
System.out.println("Is Empty: " + emptyCheck.test(""));

System.out.println("\n===== Sorting Integers =====");

List<Integer> values = Arrays.asList(50, 10, 80, 30, 20);
values.sort(Integer::compareTo);
System.out.println(values);
