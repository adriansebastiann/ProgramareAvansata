package compulsoryAndHomework;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class is basically the board game
 */

public class PlayBoard extends JPanel {

    private JButton[][] buttons;
    private List<Connection> connections;
    private List<Connection> connections2;
    private boolean basicLine = true;

    public PlayBoard(int rows, int columns) {
        GridLayout layout = new GridLayout(rows, columns);
        layout.setHgap(60);
        layout.setVgap(60);
        setLayout(layout);

        //we create a matrix of buttons representing the board game
        buttons = new JButton[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                CircleButton button = new CircleButton("");
                buttons[r][c] = button;
                add(button);
            }
        }

        //here we create connections between buttons
        //the connections will be painted with default color and thickness
        connections = new ArrayList<>(100);
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < columns - 1; c++) {
                connections.add(new Connection(buttons[r][c], buttons[r][c + 1]));
                connections.add(new Connection(buttons[r][c], buttons[r + 1][c]));
            }
        }
        for (int i = 0; i < columns - 1; i++) {
            connections.add(new Connection(buttons[rows - 1][i], buttons[rows - 1][i + 1]));
        }
        for (int j = 0; j < rows - 1; j++) {
            connections.add(new Connection(buttons[j][columns - 1], buttons[j + 1][columns - 1]));
        }

        //here we add the random sticks to the board using a random boolean
        //we go throw all the buttons, and maybe we'll throw a stick there maybe not, who knows?
        Random random = new Random();
        connections2 = new ArrayList<>();
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < columns - 1; c++) {
                if (random.nextBoolean()) {
                    connections2.add(new Connection(buttons[r][c], buttons[r][c + 1]));
                }
                if (random.nextBoolean()) {
                    connections2.add(new Connection(buttons[r][c], buttons[r + 1][c]));
                }
            }
        }
    }

    //here the math and art are meeting together to paint the board game
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);
        for (Connection connection : connections) {
            JButton source = connection.getSource();
            JButton dest = connection.getDestination();

            if (source.getX() == dest.getX()) {
                // Same column...
                g2d.drawLine(source.getX() + source.getWidth() / 2, source.getY(),
                        dest.getX() + source.getWidth() / 2, dest.getY());
            } else if (source.getY() == dest.getY()) {
                // Same row...
                g2d.drawLine(source.getX(), source.getY() + source.getHeight() / 2,
                        dest.getX(), dest.getY() + dest.getHeight() / 2);
            }
        }
        g2d.setColor(Color.BLACK);
        float[] fa = {10, 10, 10};
        BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, fa, 10);
        g2d.setStroke(bs);
        for (Connection connection : connections2) {
            JButton source = connection.getSource();
            JButton dest = connection.getDestination();

            if (source.getX() == dest.getX()) {
                // Same column...
                g2d.drawLine(source.getX() + source.getWidth() / 2, source.getY(),
                        dest.getX() + source.getWidth() / 2, dest.getY());
            } else if (source.getY() == dest.getY()) {
                // Same row...
                g2d.drawLine(source.getX(), source.getY() + source.getHeight() / 2,
                        dest.getX(), dest.getY() + dest.getHeight() / 2);
            }
        }
        g2d.dispose();
    }

    protected double horizontalCenter(JComponent bounds) {
        return bounds.getX() + bounds.getWidth() / 2d;

    }

    protected double verticalCenter(JComponent bounds) {
        return bounds.getY() + bounds.getHeight() / 2d;

    }

    protected boolean hasIntersection(Line2D line, JComponent... exclude) {
        List<JComponent> toExclude = Arrays.asList(exclude);
        boolean intersects = false;
        for (Component comp : getComponents()) {
            if (!toExclude.contains(comp)) {
                if (line.intersects(comp.getBounds())) {
                    System.out.println(line.getP1() + "-" + line.getP2() + " intersets with " + ((JButton) comp).getText() + "; " + comp.getBounds());
                    intersects = true;
                    break;
                }
            }
        }
        return intersects;
    }

    /**
     * this is the connection between the buttons
     */
    public class Connection {

        private final JButton source;

        private final JButton destination;

        public Connection(JButton source, JButton destination) {
            this.source = source;
            this.destination = destination;
        }

        public JButton getSource() {
            return source;
        }

        public JButton getDestination() {
            return destination;
        }

    }
}

