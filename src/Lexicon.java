import java.io.*;
import java.util.HashMap;

public class Lexicon {
    public static void main(String[] args) {
        StringBuilder readed = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) readed.append(line).append(" ");
        } catch (IOException e) {
            System.err.println(e);
        }

        String cleaned = readed.toString().replaceAll("[^a-zA-Z ]", "").trim();
        String[] splitted = cleaned.split(" ");
        HashMap<String, Integer> occurs = new HashMap<>();
        for (String word : splitted) {
            Integer count = occurs.get(word.toLowerCase());
            if (count == null) count = 0;
            occurs.put(word.toLowerCase(), count+1);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lexicon.txt"))){
            occurs.keySet().stream().sorted((String::compareTo)).forEach(s -> {
                try {
                    writer.write(s + " - " + occurs.get(s) + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}