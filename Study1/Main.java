import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        List<Student> students= new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Сколько студентов вы желаете добавить?");
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Введите имя: ");
            String names = scan.nextLine();
            System.out.println("Введите средний балл: ");
            double year = scan.nextDouble();

            students.add(new Student(names,year));
        }
        System.out.println("Студенты: ");
        System.out.println(students);

        System.out.println("Сортировка по среднему баллу: ");
        students.sort(Comparator.comparingDouble(Student::get_ball));
        System.out.println(students);

        System.out.println("Сортировка по имени: ");
        students.sort(Comparator.comparing(Student::get_name));
        System.out.println(students);
    }
}