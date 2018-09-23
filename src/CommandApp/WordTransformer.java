package CommandApp;

public interface WordTransformer {

    void add(int charIndex, char character);

    void replace(int charIndex, char character);

    void remove(int charIndex);

    void upper(int charIndex);

    void lower(int charIndex);

    void undo();
}
