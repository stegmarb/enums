package commandApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandConsumerAppTest {

    private CommandConsumerApp app;

    @BeforeEach
    void setUp() {
        app = new CommandConsumerApp();
    }

    @Test
    void firstTestCase() {
        app.setInitialValue("almafa");
        app.replace(0, 'k');
        app.replace(1, 'o');
        app.add(1, 'X');
        app.undo();
        app.add(1, 'X');
        app.add(1, 'Y');
        app.undo();
        app.undo();
        app.replace(2, 'r');
        app.add(3, 't');
        app.replace(4, 'e');
        assertEquals("kortefa", app.getInitialValue());
    }

    @Test
    void secondTestCase() {
        app.setInitialValue("baba");
        app.replace(0, 'k');
        app.replace(1, 'o');
        app.add(1, 'X');
        app.undo();
        app.add(1, 'X');
        app.add(1, 'Y');
        app.upper(0);
        app.remove(5);
        assertEquals("KYXob", app.getInitialValue());

    }

    @Test
    void thirdTestCase() {
        app.setInitialValue("baba");
        app.replace(0, 'k');
        app.replace(1, 'o');
        app.add(1, 'X');
        app.undo();
        app.add(1, 'X');
        assertThrows(IllegalArgumentException.class, () ->
                app.add(-1, 'Y'), "kXoba. Wrong command: add, -1, Y");
        assertEquals("kXoba", app.getInitialValue());
        app.upper(0);
    }

    @Test
    void forthTestCase() {
        app.setInitialValue("bababa");
        app.replace(0, 'k');
        app.replace(1, 'o');
        app.add(1, 'X');
        app.undo();
        app.remove(1);
        app.remove(1);
        assertThrows(IllegalArgumentException.class, () ->
                app.upper(5), "kaba. Wrong command: upper,5");
        assertEquals("kaba", app.getInitialValue());
        app.upper(0);
    }
}