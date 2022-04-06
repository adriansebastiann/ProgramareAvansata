package compulsoryAndHomework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

/**
 * this Circle Button class extends the classic JButton class
 * I created a button that is circular
 */
public class CircleButton extends JButton {
    private boolean mouseOver = false;
    private boolean mousePressed = false;
    private int turn = 0;

    public CircleButton(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);

        MouseAdapter mouseListener = new MouseAdapter() {

            /**
             * I override the methods for basic mouse action
             * This way I managed to change the color of the button when the click is pressed
             */
            @Override
            public void mousePressed(MouseEvent me) {
                if (contains(me.getX(), me.getY())) {
                    turn = (turn + 1) % 2;
                    mousePressed = true;
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                mouseOver = contains(me.getX(), me.getY());
                repaint();
            }
        };

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }

    //math stuff
    private int getDiameter() {
        int diameter = Math.min(getWidth(), getHeight());
        return diameter;
    }

    //another math stuff
    @Override
    public Dimension getPreferredSize() {
        FontMetrics metrics = getGraphics().getFontMetrics(getFont());
        int minDiameter = 10 + Math.max(metrics.stringWidth(getText()), metrics.getHeight());
        return new Dimension(minDiameter, minDiameter);
    }

    //more math stuff
    @Override
    public boolean contains(int x, int y) {
        int radius = getDiameter() / 2;
        return Point2D.distance(x, y, getWidth() / 2, getHeight() / 2) < radius;
    }

    @Override
    public void paintComponent(Graphics g) {

        int diameter = getDiameter();
        int radius = diameter / 2;

        //here I verify the actions and change the colors
        if (mousePressed && turn == 0) {
            g.setColor(Color.RED);
            turn = 1;
        } else if (mousePressed && turn == 1) {
            g.setColor(Color.BLUE);
            turn = 0;
        } else {
            g.setColor(Color.WHITE);
        }

        g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);

        if (mouseOver) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);

        g.setColor(Color.BLACK);
        g.setFont(getFont());
        FontMetrics metrics = g.getFontMetrics(getFont());
        int stringWidth = metrics.stringWidth(getText());
        int stringHeight = metrics.getHeight();
        g.drawString(getText(), getWidth() / 2 - stringWidth / 2, getHeight() / 2 + stringHeight / 4);
    }
}

