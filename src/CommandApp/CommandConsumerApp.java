package CommandApp;

public class CommandConsumerApp implements WordTransformer {

    private String initialValue;
    private Command lastCommand;

    CommandConsumerApp(String initialValue) {
        this.initialValue = initialValue;
        this.lastCommand = new Command();
    }

    @Override
    public void add(int charIndex, char character) {
        if (charIndex > initialValue.length() || charIndex < 0) {
            throw new IllegalArgumentException(String.format("%s, Wrong command: %s, %d, %c", initialValue, "add", charIndex, character));
        }
        lastCommand = new Command("add", charIndex);
        if (charIndex == initialValue.length()) {
            initialValue = initialValue + character;
        } else {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < initialValue.length() + 1; i++) {
                if (i < charIndex) {
                    string.append(initialValue.charAt(i));
                } else if (i == charIndex) {
                    string.append(character);
                } else {
                    string.append(initialValue.charAt(i - 1));
                }

            }
            initialValue = string.toString();
        }
    }

    @Override
    public void replace(int charIndex, char character) {
        char[] chars = initialValue.toCharArray();
        if (charIndex > initialValue.length() - 1 || charIndex < 0) {
            throw new IllegalArgumentException(String.format("%s, Wrong command: %s, %d, %c", initialValue, "replace", charIndex, character));
        }
        lastCommand = new Command("replace", charIndex, character, chars[charIndex]);
        chars[charIndex] = character;
        StringBuilder newWord = new StringBuilder();
        for (char element : chars) {
            newWord.append(element);
        }
        initialValue = newWord.toString();
    }

    @Override
    public void remove(int charIndex) {
        if (charIndex > initialValue.length() - 1|| charIndex < 0) {
            throw new IllegalArgumentException(String.format("%s, Wrong command: %s, %d", initialValue, lastCommand.getName(), lastCommand.getCharIndex()));
        }
        lastCommand = new Command("remove", charIndex, initialValue.charAt(charIndex));
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < initialValue.length(); i++) {
            if (i != charIndex) {
                string.append(initialValue.charAt(i));
            }
        }
        initialValue = string.toString();
    }

    @Override
    public void upper(int charIndex) {
        lastCommand = new Command("upper", charIndex);
        if (charIndex > initialValue.length() - 1 || charIndex < 0) {
            throw new IllegalArgumentException(String.format("%s, Wrong command: %s, %d", initialValue, lastCommand.getName(), lastCommand.getCharIndex()));
        }
        char[] chars = initialValue.toCharArray();
        chars[charIndex] = Character.toUpperCase(chars[charIndex]);
        StringBuilder newWord = new StringBuilder();
        for (char element : chars) {
            newWord.append(element);
        }
        initialValue = newWord.toString();
    }

    @Override
    public void lower(int charIndex) {
        lastCommand = new Command("lower", charIndex);
        if (charIndex > initialValue.length() - 1 || charIndex < 0) {
            throw new IllegalArgumentException(String.format("%s, Wrong command: %s, %d", initialValue, lastCommand.getName(), lastCommand.getCharIndex()));
        }
        char[] chars = initialValue.toCharArray();
        chars[charIndex] = Character.toLowerCase(chars[charIndex]);
        StringBuilder newWord = new StringBuilder();
        for (char element : chars) {
            newWord.append(element);
        }
        initialValue = newWord.toString();
    }


    @Override
    public void undo() {
        switch (lastCommand.getName()) {
            case "add":
                remove(lastCommand.getCharIndex());
                break;
            case "remove":
                add(lastCommand.getCharIndex(), lastCommand.getCharacter());
                break;
            case "replace":
                replace(lastCommand.getCharIndex(), lastCommand.getReplacedCharacter());
                break;
            case "upper":
                lower(lastCommand.getCharIndex());
                break;
            case "lower":
                upper(lastCommand.getCharIndex());
                break;
        }
    }

    public String getInitialValue() {
        return initialValue;
    }
}
