package ru.cr1phy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String[] HANGMAN = {"""
     +---+
     |   |
     |  \s
     |  \s
     |  \s
    _|_
    \s""", """
     +---+
     |   |
     |   O
     |  \s
     |  \s
    _|_
    \s""", """
     +---+
     |   |
     |   O
     |   |
     |  \s
    _|_
    \s""", """
     +---+
     |   |
     |   O
     |  /|
     |  \s
    _|_
    \s""", """
     +---+
     |   |
     |   O
     |  /|\\
     |  \s
    _|_
    \s""", """
     +---+
     |   |
     |   O
     |  /|\\
     |  /\s
    _|_
    \s""", """
     +---+
     |   |
     |   O
     |  /|\\
     |  / \\
    _|_
    """};
    static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    static final Scanner SCANNER = new Scanner(System.in);
    static final WordDatabase db = new WordDatabase();

    static void inGame() {
        Word word = db.getRandomWord();
        WordDisplay display = new WordDisplay(word.letters().length);
        ArrayList<Character> usedLetters = new ArrayList<>();
        int state = 0;

        while (state < 6) {
            if (display.isSolved()) break;

            System.out.printf("%s\n\n[ %s ]\nDescription: %s\n>>> ", HANGMAN[state], display.show(), word.description());

            String input = SCANNER.nextLine().trim().toLowerCase();
            if (input.equals("exit")) {
                break;
            }

            char letter = input.charAt(0);
            if (input.length() != 1 || ALPHABET.indexOf(letter) == -1) {
                System.out.println("Invalid input. Only one letter from russian alphabet are allowed.");
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
            state++;
        }
    }

    public static void main(String[] args) {
        boolean isExit = false;

        while (!isExit) {
            System.out.print("Hello! This is a hangman, the game for guessing words.\n1 - Play and generate session\n0 - Exit\n>>> ");
            String input = SCANNER.nextLine();
            try {
                int option = Integer.parseInt(input.trim());
                switch (option) {
                    case 1:
                        inGame();
                        break;
                    case 0:
                        isExit = true;
                        SCANNER.close();
                        break;
                    default:
                        throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.printf("Please enter a valid option: %s\n", e);
            }
        }
    }
}
