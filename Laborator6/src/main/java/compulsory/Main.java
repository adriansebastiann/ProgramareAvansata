package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FrameAlignedTitle().createAndShowGUI();
        });
    }
}
