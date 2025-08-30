package ru.cr1phy;

import java.util.Scanner;

public class Main {
    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        WordDatabase db = new WordDatabase();
        boolean isExit = false;

        while (!isExit) {
            System.out.print("Hello! This is a hangman, the game for guessing words.\n1 - Play and generate session\n0 - Exit\n>>> ");
            String input = SCANNER.nextLine().trim();
            switch (input) {
                case "1":
                    (new Game(db.getRandomWord())).start();
                    break;
                case "0":
                    SCANNER.close();
                    isExit = true;
                default:
                    break;
            }
        }
    }
}
