package compulsoryAndHomework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * I used this class to collect all the created elements into a single frame
 * Basically, what this frame does, it tries to keep the title center aligned
 * And has a component used to take a screenshot
 */
import static compulsoryAndHomework.SayCheese.getScreenShot;

public class FrameAlignedTitle {
    private JFrame frame = new JFrame();

    public JFrame getFrame() {
        return frame;
    }

    public void createAndShowGUI() {
        frame.setPreferredSize(new Dimension(900, 800));
        frame.setTitle("Torture...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                titleAlign(frame);
            }

        });

        //this is the part with the screenshot
        //you press CTRL + 0 and BOOM, there's a screenshot saved into default location into the project
        JMenuItem screenshot =
                new JMenuItem("Screenshot");
        screenshot.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_0,
                        InputEvent.CTRL_DOWN_MASK
                ));
        screenshot.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        BufferedImage img = getScreenShot(
                                frame.getContentPane());
                        JOptionPane.showMessageDialog(
                                null,
                                new JLabel(
                                        new ImageIcon(
                                                img.getScaledInstance(
                                                        img.getWidth(null) / 2,
                                                        img.getHeight(null) / 2,
                                                        Image.SCALE_SMOOTH)
                                        )));
                        try {
                            // write the image as a PNG
                            ImageIO.write(
                                    img,
                                    "png",
                                    new File("screenshot.png"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        //here are added all the components of the app
        frame.add(screenshot);
        frame.add(new ComboBox());
        frame.add(new Bottom(this), BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    //this part keeps the title aligned
    private void titleAlign(JFrame frame) {
        Font font = frame.getFont();
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
    }

}
