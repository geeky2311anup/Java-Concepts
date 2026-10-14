```java
System.out.println("\n===== 1. Filter Numbers =====");

List<Integer> nums = Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24);

System.out.println("Numbers > 10: " +
        nums.stream()
            .filter(n -> n > 10)
            .toList());

System.out.println("Multiples of 3: " +
        nums.stream()
            .filter(n -> n % 3 == 0)
            .toList());


System.out.println("\n===== 2. Map Operations =====");

System.out.println("Doubled: " +
        nums.stream()
            .map(n -> n * 2)
            .toList());

System.out.println("String Values: " +
        nums.stream()
            .map(String::valueOf)
            .toList());

System.out.println("Incremented: " +
        nums.stream()
            .map(n -> n + 1)
            .toList());


System.out.println("\n===== 3. Limit and Skip =====");

System.out.println("First 3: " +
        nums.stream()
            .limit(3)
            .toList());

System.out.println("Skip First 3: " +
        nums.stream()
            .skip(3)
            .toList());


System.out.println("\n===== 4. Find First and Any =====");

System.out.println("First Even: " +
        nums.stream()
            .filter(n -> n % 2 == 0)
            .findFirst()
            .orElse(-1));

System.out.println("Any Number > 20: " +
        nums.stream()
            .filter(n -> n > 20)
            .findAny()
            .orElse(-1));


System.out.println("\n===== 5. AnyMatch, AllMatch, NoneMatch =====");

System.out.println("Any even? " +
        nums.stream().anyMatch(n -> n % 2 == 0));

System.out.println("All positive? " +
        nums.stream().allMatch(n -> n > 0));

System.out.println("No negative numbers? " +
        nums.stream().noneMatch(n -> n < 0));


System.out.println("\n===== 6. Min and Average =====");

System.out.println("Minimum = " +
        nums.stream()
            .min(Integer::compareTo)
            .orElse(-1));

System.out.println("Average = " +
        nums.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0));


System.out.println("\n===== 7. Summary Statistics =====");

IntSummaryStatistics stats =
        nums.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();

System.out.println("Count = " + stats.getCount());
System.out.println("Sum = " + stats.getSum());
System.out.println("Min = " + stats.getMin());
System.out.println("Max = " + stats.getMax());
System.out.println("Average = " + stats.getAverage());


System.out.println("\n===== 8. Collect to Set =====");

Set<Integer> uniqueNumbers =
        Arrays.asList(1, 2, 2, 3, 4, 4, 5)
              .stream()
              .collect(Collectors.toSet());

System.out.println("Unique Set: " + uniqueNumbers);


System.out.println("\n===== 9. Joining Strings =====");

List<String> languages =
        Arrays.asList("Java", "C++", "Python", "JavaScript");

String result = languages.stream()
        .collect(Collectors.joining(", "));

System.out.println("Languages: " + result);

String formatted = languages.stream()
        .collect(Collectors.joining(" | ", "[", "]"));

System.out.println(formatted);


System.out.println("\n===== 10. Grouping By =====");

List<String> words =
        Arrays.asList("apple", "ant", "banana",
                      "ball", "cat", "car");

Map<Integer, List<String>> groupedByLength =
        words.stream()
             .collect(Collectors.groupingBy(String::length));

System.out.println("Grouped by length: " + groupedByLength);


System.out.println("\n===== 11. Partitioning By =====");

Map<Boolean, List<Integer>> partitioned =
        nums.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));

System.out.println("Even: " + partitioned.get(true));
System.out.println("Odd: " + partitioned.get(false));


System.out.println("\n===== 12. Frequency of Elements =====");

List<String> fruits =
        Arrays.asList("apple", "banana", "apple",
                      "orange", "banana", "apple");

Map<String, Long> frequency =
        fruits.stream()
              .collect(Collectors.groupingBy(
                      Function.identity(),
                      Collectors.counting()));

System.out.println("Frequencies: " + frequency);


System.out.println("\n===== 13. FlatMap =====");

List<List<Integer>> nestedNumbers = Arrays.asList(
        Arrays.asList(1, 2, 3),
        Arrays.asList(4, 5),
        Arrays.asList(6, 7, 8)
);

List<Integer> flattened =
        nestedNumbers.stream()
                     .flatMap(List::stream)
                     .toList();

System.out.println("Flattened: " + flattened);


System.out.println("\n===== 14. Sorting Strings =====");

List<String> namesList =
        new ArrayList<>(Arrays.asList(
                "Rahul", "Anup", "Amit", "Zoya"));

namesList.sort(String::compareToIgnoreCase);
System.out.println("Ascending: " + namesList);

namesList.sort(Comparator.reverseOrder());
System.out.println("Descending: " + namesList);

namesList.sort(Comparator.comparingInt(String::length));
System.out.println("By Length: " + namesList);


System.out.println("\n===== 15. Custom Comparator =====");

List<Integer> sortNumbers =
        new ArrayList<>(Arrays.asList(15, 2, 100, 34, 7));

sortNumbers.sort(
        Comparator.comparingInt((Integer n) -> n % 10)
                  .thenComparingInt(n -> n)
);

System.out.println("Sorted by last digit, then value: "
        + sortNumbers);


System.out.println("\n===== 16. Reduce for Product =====");

int product = Arrays.asList(1, 2, 3, 4, 5)
        .stream()
        .reduce(1, (a, b) -> a * b);

System.out.println("Product = " + product);


System.out.println("\n===== 17. Reduce Without Initial Value =====");

Optional<Integer> sumOptional =
        Arrays.asList(10, 20, 30)
              .stream()
              .reduce(Integer::sum);

System.out.println("Sum = " + sumOptional.orElse(0));


System.out.println("\n===== 18. Optional Operations =====");

Optional<String> value = Optional.of("Java");

System.out.println("Length: " +
        value.map(String::length).orElse(0));

System.out.println("Filtered: " +
        value.filter(s -> s.startsWith("J")).orElse("Not Found"));

Optional<String> emptyValue = Optional.empty();

System.out.println("Empty fallback: " +
        emptyValue.orElseGet(() -> "Generated Default"));

System.out.println("Is Present: " + value.isPresent());


System.out.println("\n===== 19. ifPresentOrElse =====");

Optional<String> optionalName = Optional.of("Anup");

optionalName.ifPresentOrElse(
        name -> System.out.println("Hello, " + name),
        () -> System.out.println("Name is missing")
);


System.out.println("\n===== 20. Method References =====");

List<String> greetings =
        Arrays.asList("Hello", "Welcome", "Good Morning");

greetings.forEach(System.out::println);

Function<String, Integer> lengthFunction = String::length;
System.out.println("Length: " + lengthFunction.apply("Programming"));

BiFunction<Integer, Integer, Integer> addition = Integer::sum;
System.out.println("Addition: " + addition.apply(10, 20));


System.out.println("\n===== 21. Primitive Streams =====");

int primitiveSum = nums.stream()
        .mapToInt(Integer::intValue)
        .sum();

System.out.println("Primitive Sum = " + primitiveSum);

System.out.println("Even Count = " +
        nums.stream()
            .mapToInt(Integer::intValue)
            .filter(n -> n % 2 == 0)
            .count());


System.out.println("\n===== 22. Generate and Iterate =====");

System.out.println("Generated: " +
        Stream.generate(() -> "Java")
              .limit(3)
              .toList());

System.out.println("Iterated: " +
        Stream.iterate(1, n -> n + 1)
              .limit(5)
              .toList());


System.out.println("\n===== 23. Parallel Stream =====");

long parallelSum = nums.parallelStream()
        .mapToLong(Integer::longValue)
        .sum();

System.out.println("Parallel Sum = " + parallelSum);


System.out.println("\n===== 24. toMap =====");

Map<String, Integer> nameLengths =
        Arrays.asList("Anup", "Rahul", "Amit")
              .stream()
              .collect(Collectors.toMap(
                      Function.identity(),
                      String::length
              ));

System.out.println("Name Lengths: " + nameLengths);


System.out.println("\n===== 25. Remove Duplicates =====");

List<Integer> duplicateValues =
        Arrays.asList(5, 2, 5, 3, 2, 1, 3);

List<Integer> uniqueValues =
        duplicateValues.stream()
                       .distinct()
                       .toList();

System.out.println("Unique Values: " + uniqueValues);


System.out.println("\n===== 26. TakeWhile and DropWhile =====");

List<Integer> orderedNumbers =
        Arrays.asList(2, 4, 6, 7, 8, 10);

System.out.println("Take While Even: " +
        orderedNumbers.stream()
                      .takeWhile(n -> n % 2 == 0)
                      .toList());

System.out.println("Drop While Even: " +
        orderedNumbers.stream()
                      .dropWhile(n -> n % 2 == 0)
                      .toList());


System.out.println("\n===== 27. Map Multi-Operation Pipeline =====");

List<Integer> pipelineResult =
        nums.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .filter(n -> n > 100)
            .sorted()
            .toList();

System.out.println("Pipeline Result: " + pipelineResult);


System.out.println("\n===== 28. Count Words Starting With A =====");

long countA = words.stream()
        .filter(word -> word.startsWith("a"))
        .count();

System.out.println("Words starting with a = " + countA);


System.out.println("\n===== 29. Convert List to Map With Duplicate Keys =====");

Map<Integer, String> numberNames =
        Arrays.asList("one", "two", "three", "four")
              .stream()
              .collect(Collectors.toMap(
                      String::length,
                      Function.identity(),
                      (first, second) -> first + ", " + second
              ));

System.out.println("Length to Words: " + numberNames);


System.out.println("\n===== 30. Peek for Debugging =====");

List<Integer> debugResult =
        nums.stream()
            .filter(n -> n > 10)
            .peek(n -> System.out.println("After filter: " + n))
            .map(n -> n * 2)
            .peek(n -> System.out.println("After map: " + n))
            .toList();

System.out.println("Final Result: " + debugResult);
```
