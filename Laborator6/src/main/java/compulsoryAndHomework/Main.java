package compulsoryAndHomework;

import java.awt.*;

/**
 * Here it is just created and show the main frame, nothing more to see
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FrameAlignedTitle().createAndShowGUI();
        });
    }
}
