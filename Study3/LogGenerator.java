import java.io.*;
import java.util.*;

public class LogGenerator {
    public static void main(String[] args) throws IOException {
        String[] words = {"Spring", "Java", "C++", "Docker", "C#", "Python", "Tests", "Fullbody"};
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt"))) {

            for(int j = 0; j < 100000; j ++) {
                StringBuilder sb = new StringBuilder();
                int len = rand.nextInt(3, 8);
                for (int i = 0; i < len; i++) {
                    sb.append(words[rand.nextInt(words.length)]);
                    sb.append(" ");
                }
                String result = sb.toString().trim();
                writer.write(result);
                writer.newLine();
            }
        }
    }
}
