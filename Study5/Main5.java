import java.util.List;
import java.util.function.Consumer;

public class Main5 {
    public static void main(String[] args){

        //ПЕРВОЕ УПРАЖНЕНИЕ
        List<String> fruits = List.of("яблоко", "банан", "вишня");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        Consumer<String> f = System.out::println;
        fruits.forEach(f);

    }
}
