import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main5 {
    public static void main(String[] args){

        //ПЕРВОЕ УПРАЖНЕНИЕ
        List<String> fruits = List.of("яблоко", "банан", "вишня");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        Consumer<String> f = System.out::println;
        fruits.forEach(f);

        //ВТОРОЕ УПРАЖНЕНИЕ
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int count = 0;
        for (int n : numbers) {
            if (n % 2 == 0) {
                count++;
            }
        }

        Predicate<Integer > g = x -> x % 2 == 0;
        long countL = numbers.stream().filter(g).count();
        System.out.println(countL);

        //3 ЗАДАНИЕ
        List<String> words = List.of("кот", "собака", "слон");
        List<Integer> lengths = new ArrayList<>();
        for (String word : words) {
            lengths.add(word.length());
        }

        Function<String, Integer> h = word -> word.length();
        List<Integer> result3 = words.stream().map(h).toList();
        System.out.println(result3);

        //УПРАЖНЕНИЕ 4
        String config = null;
        String result4;
        if (config != null) {
            result4 = config;
        } else {
            result4 = "значение по умолчанию";
        }
        Supplier<String> defaultValue = () -> "значение по умолчанию";
        String result2 = Optional.ofNullable(config).orElseGet(defaultValue);
        System.out.println(result2);

        //ПЯТОЕ УПРАЖНЕНИЕ
        List<String> names = List.of("Анна", "Борис", "Алиса", "Виктор");
        for (String name : names) {
            if (name.startsWith("А")) {
                System. out.println(name);
            }
        }
        Predicate<String> startsWithA = name -> name.startsWith("А");
        Consumer<String> printName = name -> System.out.println(name);
        names.stream().filter(startsWithA).forEach(printName);
    }
}
