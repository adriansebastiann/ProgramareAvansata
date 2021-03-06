package compulsoryAndHomework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is for the upper part of the frame
 * I know it's chaotic and OOP principles are not respected, but I don't Think I have ever copied so much code
 * from the internet for a single project in my life :))))
 */
public class ComboBox extends JPanel {

    private int rows;
    private int columns;
    private boolean pressed;
    private int[] values;
    private JTextField heading1;
    private JTextField heading2;
    private JTextField selectedRows;
    private JTextField selectedColumns;
    private JComboBox boxOfValue1;
    private JComboBox boxOfValue2;
    private JButton createButton;
    private JButton[][] btn;

    public ComboBox() {
        pressed = false;
        values = new int[]{4, 5, 6, 7, 8};
        heading1 = new JTextField("Choose the number of rows ");
        heading2 = new JTextField("Choose the number of columns ");
        selectedRows = new JTextField(10);
        selectedColumns = new JTextField(10);
        boxOfValue1 = new JComboBox();
        boxOfValue2 = new JComboBox();
        createButton = new JButton("Create");

        for (int i = 0; i < values.length; i++) {
            boxOfValue1.addItem(values[i]);
            boxOfValue2.addItem(values[i]);
        }

        heading1.setEditable(false);
        heading2.setEditable(false);

        //the box of values are used to take the dimensions for the board game
        boxOfValue1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRows.setText("You selected -> " + ((JComboBox) e.getSource()).getSelectedItem());
                rows = (Integer) (((JComboBox) e.getSource()).getSelectedItem());
                System.out.println(rows);
            }
        });

        boxOfValue2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedColumns.setText("You selected -> " + ((JComboBox) e.getSource()).getSelectedItem());
                columns = rows = (Integer) (((JComboBox) e.getSource()).getSelectedItem());
                System.out.println(columns);
            }
        });

        createButton.addActionListener(e->{
            this.add(new PlayBoard(rows, columns));
            this.revalidate();
        });

        this.setLayout(new FlowLayout());
        this.add(heading1);
        this.add(selectedRows);
        this.add(boxOfValue1);
        this.add(heading2);
        this.add(selectedColumns);
        this.add(boxOfValue2);
        this.add(createButton);
    }

}
