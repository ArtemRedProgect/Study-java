import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Main5 {

    static class Person {
        String name;
        Person(String name) { this.name = name; }
    }

    public static void main(String[] args) {

        List<String> fruits = List.of("яблоко", "банан", "вишня");
        Consumer<String> f = System.out::println;
        fruits.forEach(f);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> g = x -> x % 2 == 0;
        long countL = numbers.stream().filter(g).count();
        System.out.println(countL);

        List<String> words = List.of("кот", "собака", "слон");
        Function<String, Integer> h = String::length;
        List<Integer> result3 = words.stream().map(h).toList();
        System.out.println(result3);

        String config = null;
        Supplier<String> defaultValue = () -> "значение по умолчанию";
        String result4 = Optional.ofNullable(config).orElseGet(defaultValue);
        System.out.println(result4);

        List<String> names = List.of("Анна", "Борис", "Алиса", "Виктор");
        Predicate<String> startsWithA = name -> name.startsWith("А");
        Consumer<String> printName = name -> System.out.println(name);
        names.stream().filter(startsWithA).forEach(printName);

        List<String> names6 = List.of("Иван", "Мария");
        Function<String, Person> createPersonRef = Person::new;
        List<Person> people = names6.stream().map(createPersonRef).toList();
        System.out.println(people.size());

        List<Integer> numbers7 = List.of(1, 2, 3, 4);
        Function<Integer, Integer> square = n -> n * n;
        int sumResult = numbers7.stream().map(square).reduce(0, Integer::sum);
        System.out.println(sumResult);

        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(4, 5, 6);
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        List<Integer> productsResult = IntStream.range(0, a.size())
                .mapToObj(i -> multiply.apply(a.get(i), b.get(i)))
                .toList();
        System.out.println(productsResult);

        List<Integer> numbers9 = List.of(4, 11, 12, 15, 20, 7);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThan10 = n -> n > 10;
        List<Integer> result9 = numbers9.stream()
                .filter(isEven.and(isGreaterThan10))
                .toList();
        System.out.println(result9);

        List<String> words10 = List.of("дом", "дерево", "кот", "машина", "сад");
        Predicate<String> isLong = word -> word.length() > 3;
        Function<String, String> toUpper = String::toUpperCase;
        Consumer<String> print = System.out::println;
        words10.stream()
                .filter(isLong)
                .map(toUpper)
                .forEach(print);
    }
}