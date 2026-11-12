import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main6 {

    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }

    static class Reader {
        private String name;
        private int age;
        private List<Book> borrowedBooks;

        public Reader(String name, int age, List<Book> borrowedBooks) {
            this.name = name;
            this.age = age;
            this.borrowedBooks = borrowedBooks;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }
    }

    public static Optional<String> findMostPopularAuthor(List<Reader> readers) {
        return readers.stream()
                .flatMap(reader -> reader.getBorrowedBooks().stream())
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public static OptionalDouble averageReaderAge(List<Reader> readers) {
        return readers.stream()
                .mapToInt(Reader::getAge)
                .average();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        numbers = numbers.stream().map(number -> number * 2).collect(Collectors.toList());
        System.out.println(numbers);

        List<String> words = List.of("кот", "дом", "слон", "еж", "кит", "жираф");
        Map<Integer, Long> wordLengthCounts = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(wordLengthCounts);

        List<Book> books1 = new ArrayList<>(List.of(
                new Book("Война и мир", "Толстой"),
                new Book("Анна Каренина", "Толстой"),
                new Book("Преступление и наказание", "Достоевский")
        ));

        List<Book> books2 = new ArrayList<>(List.of(
                new Book("Идиот", "Достоевский"),
                new Book("Братья Карамазовы", "Достоевский")
        ));

        List<Book> books3 = new ArrayList<>();

        List<Reader> readers = List.of(
                new Reader("Иван", 25, books1),
                new Reader("Мария", 30, books2),
                new Reader("Пётр", 40, books3)
        );

        Optional<String> mostPopularAuthor = findMostPopularAuthor(readers);
        System.out.println(mostPopularAuthor.orElse("нет данных"));

        OptionalDouble averageAge = averageReaderAge(readers);
        System.out.println(averageAge.isPresent() ? averageAge.getAsDouble() : "нет данных");
    }
}