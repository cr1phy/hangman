package ru.cr1phy;

import java.util.ArrayList;

public class Game {
    private final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final ArrayList<Character> usedLetters = new ArrayList<>();
    private final Word word;
    private final Hangman hm;
    private final WordDisplay display;

    public Game(Word word) {
        this.word = word;
        this.hm = new Hangman();
        this.display = new WordDisplay(word.letters().length);
    }

    public void start() {
        while (!this.hm.isHangedHimself()) {
            if (display.isSolved()) {
                System.out.println("Holy shit! You won!");
                return;
            }

            System.out.printf("%s\n\n[ %s ]\nDescription: %s\nUsed letters: %s\n>>> ", this.hm.render(), display.show(), word.description(), usedLetters);

            String input = Main.SCANNER.nextLine().trim().toLowerCase();
            if (input.equals("exit")) {
                return;
            }
            if (input.length() != 1) {
                System.out.println("Are you kidding me? Only *ONE* letter, plz.");
                continue;
            }

            char letter = input.charAt(0);
            if (ALPHABET.indexOf(letter) == -1) {
                System.out.println("Invalid input. Choose only letter from russian alphabet. Not numbers or different things.");
                continue;
            }
            if (usedLetters.contains(letter)) {
                System.out.println("Already used.");
                continue;
            }

            ArrayList<Integer> indexes = word.indexesFromLetter(letter);
            usedLetters.add(letter);
            if (!indexes.isEmpty()) {
                display.acceptLetter(indexes, letter);
                System.out.println("YES! You found it!");
                continue;
            }

            System.out.println("Oh... that isn't correct. Try again.");
            this.hm.add();
        }
        System.out.printf("Maybe, it was hard for you.\n\n%s\n", this.hm.render());
    }
}
