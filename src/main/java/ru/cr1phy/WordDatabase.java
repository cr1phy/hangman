package ru.cr1phy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordDatabase {
    private final ArrayList<Word> words = new ArrayList<>();
    private final Random random = new Random();

    public WordDatabase() {
        Path file = Path.of("words.txt");
        try {
            List<String> content = Files.readAllLines(file);
            for (String line : content) {
                String[] word = line.split("//");
                this.words.add(new Word(word[0].toCharArray(), word[1]));
            }
        } catch (IOException _) {
            System.out.println("I didn't find `words.txt`!");
            System.exit(1);
        }
    }

    public Word getRandomWord() {
        return this.words.get(this.random.nextInt(words.size()));
    }
}
