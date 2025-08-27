package ru.cr1phy;

import java.util.List;

public class WordDisplay {
    private String display;

    WordDisplay(int length) {
        this.display = "*".repeat(length);
    }

    public String show() {
        return this.display;
    }

    public boolean isSolved() {
        for (char c : this.display.toCharArray()) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }

    public void acceptLetter(List<Integer> indexes, char letter) {
        char[] d = this.display.toCharArray();
        for (Integer index : indexes) {
            d[index] = letter;
        }
        this.display = String.valueOf(d);
    }
}
