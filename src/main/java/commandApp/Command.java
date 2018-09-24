package commandApp;

public class Command {

    private String name;
    private int charIndex;
    private char character;
    private char replacedCharacter;

    Command(String name, int charIndex, char character, char replacedCharacter) {
        this.name = name;
        this.character = character;
        this.charIndex = charIndex;
        this.replacedCharacter = replacedCharacter;
    }

    Command(String name, int charIndex, char character) {
        this.name = name;
        this.character = character;
        this.charIndex = charIndex;
    }

    Command(String name, int charIndex) {
        this.name = name;
        this.charIndex = charIndex;
    }


    public String getName() {
        return name;
    }

    public int getCharIndex() {
        return charIndex;
    }

    public char getCharacter() {
        return character;
    }

    public char getReplacedCharacter() {
        return replacedCharacter;
    }
}

