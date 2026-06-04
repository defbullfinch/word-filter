import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<String> uniqueWords = new ArrayList<>();

        List<List<Character>> words = new ArrayList<>();

        Set<Character> bukva = new LinkedHashSet<>(List.of(
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        ));
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.length() == 5) {
                    String lower = line.toLowerCase();
                    boolean isUnique = true;
                    boolean[] seen = new boolean[26];
                    List<Character> uniqueLetters = new ArrayList<>(5);

                    for (int i = 0; i < 5; i++) {
                        char c = lower.charAt(i);
                        int idx = c - 'a';
                        if (idx < 0 || idx >= 26 || seen[idx]) {
                            isUnique = false;
                            break;
                        }
                        seen[idx] = true;
                        uniqueLetters.add(c);
                    }
                    if (isUnique){words.add(uniqueLetters);
                    }
                }
            }
        } catch (IOException e) {System.out.println(e.getMessage());}
        while(bukva.size() > 1){
            boolean anyChanged=false;
            for (List<Character> uniqueLetters:words) {
                if (bukva.containsAll(uniqueLetters)) {
                    bukva.removeAll(uniqueLetters);
                    uniqueWords.add(uniqueLetters.toString());
                    anyChanged = true;
                }
            }
            if (!anyChanged) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
        System.out.println(uniqueWords);
        System.out.println("Unused letters: " + bukva);

    }
}

