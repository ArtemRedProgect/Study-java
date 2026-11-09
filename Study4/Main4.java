import java.util.List;

public class Main4 {
    public static void main(String[] args){
        Pair<String, Integer> adult = new Pair<>("Возраст", 18);
        String k = adult.getKey();
        Integer v = adult.getValue();
        System.out.println(k + ": " + v);
        System.out.println(max(List.of(3, 7, 2, 9, 5)));
        System.out.println(max(List.of(6.4, 7.8, 3.6, 12.6)));
    }

    public static <T extends Comparable<T>> T max(List<T> list){
        T result = list.get(0);

        for(T item : list){
            if(item.compareTo(result) > 0){
                result = item;
            }
        }
        return result;
    }
}
