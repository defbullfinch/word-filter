import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<String> uniqueWords = new ArrayList<>();

        List<String> words = new ArrayList<>();

        List<Character> bukva = new ArrayList<>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && line.matches("[a-zA-Z]+")) {
                    words.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        while (bukva.size() > 1) {
            for (String w : words) {
                String lower = w.toLowerCase();
                if (lower.length() != 5) continue;
                boolean isUnique = lower.chars()
                        .distinct()
                        .count() == lower.length();
// System.out.println(isUnique);
                if (!isUnique) continue;
                List<Character> uniqueLetters = lower.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList());

                if (bukva.containsAll(uniqueLetters)) {
                    bukva.removeAll(uniqueLetters);
                    uniqueWords.add(uniqueLetters.toString());
                }

            }
        }
        System.out.println(uniqueWords);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
        System.out.println("Unused letters: " + bukva);

    }
}

