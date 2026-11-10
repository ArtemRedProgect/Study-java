import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
    }
}
