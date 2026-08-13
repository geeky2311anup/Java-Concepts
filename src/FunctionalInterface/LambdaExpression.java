System.out.println("\n===== Stream API with Lambda =====");

List<Integer> numbers = Arrays.asList(2, 5, 8, 11, 14, 17, 20);

System.out.print("Even Numbers: ");
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(n -> System.out.print(n + " "));

System.out.println();

int total = numbers.stream()
                   .reduce(0, Integer::sum);
System.out.println("Sum = " + total);

System.out.println("Squares: " +
        numbers.stream()
               .map(n -> n * n)
               .toList());

System.out.println("Count > 10 = " +
        numbers.stream()
               .filter(n -> n > 10)
               .count());

System.out.println("\n===== Optional Example =====");

Optional<String> optional = Optional.of("Java Lambda");
optional.ifPresent(s -> System.out.println("Value: " + s));

System.out.println(optional.orElse("Default Value"));

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

Consumer<String> printer = System.out::println;
printer.accept("Consumer using Method Reference");

System.out.println("\n===== Sorting Integers =====");

List<Integer> values = Arrays.asList(50, 10, 80, 30, 20);
values.sort(Integer::compareTo);
System.out.println(values);

values.sort((a, b) -> b - a);
System.out.println("Descending: " + values);

System.out.println("\n===== forEach with Lambda =====");

numbers.forEach(n -> System.out.print(n + " "));
System.out.println();

System.out.println("\n===== Distinct & Max =====");

System.out.println(
    Arrays.asList(1, 2, 2, 3, 4, 4, 5)
          .stream()
          .distinct()
          .toList()
);

System.out.println("Maximum = " +
        numbers.stream()
               .max(Integer::compareTo)
               .orElse(-1));
