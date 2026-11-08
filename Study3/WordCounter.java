import java.io.*;
import java.util.*;

public class WordCounter {
    public static Map<String, Integer> countWords(String filename) throws IOException {
        Map<String, Integer> freq = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.split(" ");
                for (String word : wordsInLine) {
                    freq.put(word, freq.getOrDefault(word, 0) + 1);
                }
            }
        }

        return freq;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Integer> freq = countWords("logs.txt");

        int count = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
            if (count >= 10) break;
        }
    }
}