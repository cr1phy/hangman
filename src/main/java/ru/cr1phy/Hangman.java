package ru.cr1phy;

public class Hangman {
    final String[] HANGMAN = {"""
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
    private int state = 0;

    public void add() {
        this.state++;
    }

    public String render() {
        return HANGMAN[this.state];
    }

    public boolean isHangedHimself() {
        return state == 6;
    }
}
