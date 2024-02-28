import javax.swing.SwingUtilities;

public class RubricaApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableFrame();
        });
    }

}
