package ru.cr1phy;

import java.util.ArrayList;

public record Word(char[] letters, String description) {
    public ArrayList<Integer> indexesFromLetter(char letter) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == letter) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}

