package CommandApp;

public class TesterClass {

    public static void main(String[] args) {
        CommandConsumerApp app = new CommandConsumerApp("almafa");
        app.replace(0, 'k');
        System.out.println(app.getInitialValue());
        app.replace(1, 'o');
        System.out.println(app.getInitialValue());
        app.add(1, 'X');
        System.out.println(app.getInitialValue());
        app.undo();
        System.out.println(app.getInitialValue());
        app.add(2, 'r');
        System.out.println(app.getInitialValue());
        app.add(1, 'Y');
        System.out.println(app.getInitialValue());
        app.undo();
        System.out.println(app.getInitialValue());
        app.replace(3, 't');
        System.out.println(app.getInitialValue());
        app.replace(4, 'e');
        System.out.println(app.getInitialValue());
    }
}
