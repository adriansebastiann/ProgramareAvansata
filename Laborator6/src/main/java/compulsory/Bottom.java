package compulsory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bottom extends JPanel {
    private JButton loadButton;
    private JButton saveButton;
    private JButton resetButton;

    public Bottom (FrameAlignedTitle frame) {
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        resetButton = new JButton("Reset");

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getFrame().getContentPane().removeAll();
                frame.getFrame().repaint();
                frame.createAndShowGUI();
            }
        });
        this.add(loadButton);
        this.add(saveButton);
        this.add(resetButton);
    }
}
