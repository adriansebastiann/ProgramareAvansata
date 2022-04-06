package compulsoryAndHomework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the elements from the bottom of the frame
 * Each button has his own functionality
 */


public class Bottom extends JPanel {
    private JButton loadButton;
    private JButton saveButton;
    private JButton resetButton;
    private JButton win;
    private JButton instructions;
    private JButton puzzle;

    public Bottom (FrameAlignedTitle frame) {
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        resetButton = new JButton("Reset");
        win = new JButton("First Who Clicks This Wins!!!");
        instructions = new JButton("Click to see the rules of the game");
        puzzle = new JButton("Play a puzzle instead!");

        //the reset button will create a new frame with all elements and close the old one
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getFrame().getContentPane().removeAll();
                frame.getFrame().repaint();
                frame.createAndShowGUI();
            }
        });

        //the win button will create a new window which displays a message to mark the winner player
        //this is my game logic, who presses on this button first will win
        win.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setLocationRelativeTo(null);
                frame.add(new JLabel(new ImageIcon("src/main/resources/img.png")));
                frame.setVisible(true);
            }
        });

        //when pressing the instructions button a new window which is displaying the instructions will appear
        instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setLocationRelativeTo(null);
                frame.add(new JLabel(new ImageIcon("src/main/resources/img_2.png")));
                frame.setVisible(true);
            }
        });

        //if you don't like what I created you can press the puzzle button and play a cute puzzle
        //the project is not mine I just stole it from the internet
        puzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        PuzzleEx puzzle = new PuzzleEx();
                        puzzle.setVisible(true);
                    }
                });
            }
        });

        //here I add the buttons from the frame
        this.add(loadButton);
        this.add(saveButton);
        this.add(resetButton);
        this.add(instructions);
        this.add(puzzle);
        this.add(win);
    }
}
