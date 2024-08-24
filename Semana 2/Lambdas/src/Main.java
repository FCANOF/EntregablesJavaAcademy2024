// Frida Cano 
// 09/29/2021
// Functional Interfaces in Java
import java.util.function.*;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Supplier Examples
        // Supplier is a functional interface that represents a supplier of results.
        Supplier<String> supplier1 = () -> "Hello from Supplier!";
        Supplier<Double> supplier2 = () -> Math.random();
        Supplier<Integer> supplier3 = () -> 42;
        Supplier<List<String>> supplier4 = () -> Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("Supplier 1: " + supplier1.get());
        System.out.println("Supplier 2: " + supplier2.get());
        System.out.println("Supplier 3: " + supplier3.get());
        System.out.println("Supplier 4: " + supplier4.get());

        // Consumer Examples
        // Consumer is a functional interface that represents an operation that accepts a single input argument and returns no result.
        Consumer<String> consumer1 = s -> System.out.println("Consumer 1: " + s);
        Consumer<Integer> consumer2 = i -> System.out.println("Consumer 2: " + (i * i));
        Consumer<List<String>> consumer3 = list -> list.forEach(System.out::println);
        Consumer<String> consumer4 = s -> System.out.println("Consumer 4: " + s.toUpperCase());
        consumer1.accept("Hello, Consumer!");
        consumer2.accept(5);
        consumer3.accept(Arrays.asList("Apple", "Banana", "Cherry"));
        consumer4.accept("lowercase string");

        // BiConsumer Examples
        // BiConsumer is a functional interface that represents an operation that accepts two input arguments and returns no result.
        BiConsumer<String, Integer> biConsumer1 = (s, i) -> System.out.println(s + " is " + i + " years old.");
        BiConsumer<Integer, Integer> biConsumer2 = (a, b) -> System.out.println("Sum: " + (a + b));
        BiConsumer<String, String> biConsumer3 = (s1, s2) -> System.out.println(s1 + " & " + s2);
        BiConsumer<String, List<String>> biConsumer4 = (s, list) -> list.forEach(item -> System.out.println(s + ": " + item));
        biConsumer1.accept("Alice", 25);
        biConsumer2.accept(10, 20);
        biConsumer3.accept("Java", "Python");
        biConsumer4.accept("Fruit", Arrays.asList("Apple", "Banana", "Cherry"));

        // Predicate Examples
        // Predicate is a functional interface that represents a predicate (boolean-valued function) of one argument.
        Predicate<Integer> predicate1 = i -> i > 10;
        Predicate<String> predicate2 = s -> s.startsWith("J");
        Predicate<List<String>> predicate3 = list -> !list.isEmpty();
        Predicate<String> predicate4 = s -> s.contains("Lambda");
        System.out.println("Predicate 1 (15 > 10): " + predicate1.test(15));
        System.out.println("Predicate 2 (Java starts with J): " + predicate2.test("Java"));
        System.out.println("Predicate 3 (List is not empty): " + predicate3.test(Arrays.asList("Apple")));
        System.out.println("Predicate 4 (Contains 'Lambda'): " + predicate4.test("Hello, Lambda!"));

        // BiPredicate Examples
        // BiPredicate is a functional interface that represents a predicate (boolean-valued function) of two arguments.
        BiPredicate<String, Integer> biPredicate1 = (s, i) -> s.length() == i;
        BiPredicate<Integer, Integer> biPredicate2 = (a, b) -> a > b;
        BiPredicate<String, String> biPredicate3 = (s1, s2) -> s1.equalsIgnoreCase(s2);
        BiPredicate<List<String>, String> biPredicate4 = (list, s) -> list.contains(s);
        System.out.println("BiPredicate 1 (Length equals 5): " + biPredicate1.test("Hello", 5));
        System.out.println("BiPredicate 2 (10 > 5): " + biPredicate2.test(10, 5));
        System.out.println("BiPredicate 3 (Java equals JAVA): " + biPredicate3.test("Java", "JAVA"));
        System.out.println("BiPredicate 4 (List contains 'Banana'): " + biPredicate4.test(Arrays.asList("Apple", "Banana"), "Banana"));

        // Function Examples
        // Function is a functional interface that represents a function that accepts one argument and produces a result.
        Function<String, Integer> function1 = String::length;
        Function<Integer, Integer> function2 = i -> i * i;
        Function<String, String> function3 = String::toUpperCase;
        Function<List<String>, Integer> function4 = List::size;
        System.out.println("Function 1 (Length of 'Lambda'): " + function1.apply("Lambda"));
        System.out.println("Function 2 (Square of 7): " + function2.apply(7));
        System.out.println("Function 3 (Uppercase 'hello'): " + function3.apply("hello"));
        System.out.println("Function 4 (Size of list): " + function4.apply(Arrays.asList("Apple", "Banana", "Cherry")));

        // BiFunction Examples
        // BiFunction is a functional interface that represents a function that accepts two arguments and produces a result.
        BiFunction<String, String, String> biFunction1 = (s1, s2) -> s1 + " " + s2;
        BiFunction<Integer, Integer, Integer> biFunction2 = Integer::sum;
        BiFunction<String, Integer, String> biFunction3 = (s, i) -> s + " has " + i + " characters.";
        BiFunction<Integer, Integer, Boolean> biFunction4 = (a, b) -> a > b;
        System.out.println("BiFunction 1 (Concatenate strings): " + biFunction1.apply("Hello", "World"));
        System.out.println("BiFunction 2 (Sum 5 and 10): " + biFunction2.apply(5, 10));
        System.out.println("BiFunction 3 (String length): " + biFunction3.apply("Lambda", 6));
        System.out.println("BiFunction 4 (Is 15 > 10?): " + biFunction4.apply(15, 10));

        // UnaryOperator Examples
        // UnaryOperator is a specialized Function interface that takes a single argument and returns a result of the same type.
        UnaryOperator<Integer> unaryOperator1 = i -> i * 2;
        UnaryOperator<String> unaryOperator2 = String::toUpperCase;
        UnaryOperator<Integer> unaryOperator3 = i -> i + 5;
        UnaryOperator<String> unaryOperator4 = s -> s + "!";
        System.out.println("UnaryOperator 1 (Double 4): " + unaryOperator1.apply(4));
        System.out.println("UnaryOperator 2 (Uppercase 'hello'): " + unaryOperator2.apply("hello"));
        System.out.println("UnaryOperator 3 (Add 5 to 10): " + unaryOperator3.apply(10));
        System.out.println("UnaryOperator 4 (Add exclamation to 'Wow'): " + unaryOperator4.apply("Wow"));

        // BinaryOperator Examples
        // BinaryOperator is a specialized BiFunction interface that takes two arguments of the same type and returns a result of the same type.
        BinaryOperator<Integer> binaryOperator1 = (a, b) -> a + b;
        BinaryOperator<String> binaryOperator2 = (s1, s2) -> s1 + " & " + s2;
        BinaryOperator<Integer> binaryOperator3 = (a, b) -> a * b;
        BinaryOperator<String> binaryOperator4 = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator 1 (Sum 3 and 7): " + binaryOperator1.apply(3, 7));
        System.out.println("BinaryOperator 2 (Combine strings): " + binaryOperator2.apply("Java", "Python"));
        System.out.println("BinaryOperator 3 (Multiply 4 by 5): " + binaryOperator3.apply(4, 5));
        System.out.println("BinaryOperator 4 (Concatenate 'Hello' and 'World'): " + binaryOperator4.apply("Hello", "World"));
    }
}
