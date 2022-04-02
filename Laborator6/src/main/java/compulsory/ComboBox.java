package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JPanel {

    private int rows;
    private int columns;
    private boolean pressed = false;
    private int[] values = {4, 5, 6, 7, 8};
    private JTextField heading1 = new JTextField("Choose the number of rows ");
    private JTextField heading2 = new JTextField("Choose the number of columns ");
    private JTextField selectedRows = new JTextField(10);
    private JTextField selectedColumns = new JTextField(10);
    private JComboBox boxOfValue1 = new JComboBox();
    private JComboBox boxOfValue2 = new JComboBox();
    private JButton createButton = new JButton("Create");
    private JButton[][] btn;

    public ComboBox() {
        for (int i = 0; i < values.length; i++) {
            boxOfValue1.addItem(values[i]);
            boxOfValue2.addItem(values[i]);
        }

        heading1.setEditable(false);
        heading2.setEditable(false);

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
