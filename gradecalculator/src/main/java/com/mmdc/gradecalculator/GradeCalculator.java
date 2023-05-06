/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mmdc.gradecalculator;

/**
 *
 * @author roque
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculator extends JFrame {
    private JLabel m1Label, m2Label, taLabel, resultLabel;
    private JTextField m1Field, m2Field, taField, resultField;
    private JButton calculateButton;

    public GradeCalculator() {
        setTitle("Grade Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        m1Label = new JLabel("Milestone 1:");
        m2Label = new JLabel("Milestone 2:");
        taLabel = new JLabel("Terminal Assessment:");
        resultLabel = new JLabel("Result:");
        m1Field = new JTextField(10);
        m2Field = new JTextField(10);
        taField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        calculateButton = new JButton("Calculate");

        // Add components to content pane
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panel.add(m1Label, c);
        c.gridx = 1;
        panel.add(m1Field, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(m2Label, c);
        c.gridx = 1;
        panel.add(m2Field, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(taLabel, c);
        c.gridx = 1;
        panel.add(taField, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(resultLabel, c);
        c.gridx = 1;
        panel.add(resultField, c);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        panel.add(calculateButton, c);

        // Add action listener to calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get milestone 1 points and check for exceptions
                    int m1 = Integer.parseInt(m1Field.getText());
                    if (m1 < 0 || m1 > 25) {
                        throw new IllegalArgumentException("Invalid Milestone 1 points");
                    }

                    // Get milestone 2 points and check for exceptions
                    int m2 = Integer.parseInt(m2Field.getText());
                    if (m2 < 0 || m2 > 40) {
                        throw new IllegalArgumentException("Invalid Milestone 2 points");
                    }

                    // Get terminal assessment points and check for exceptions
                    int ta = Integer.parseInt(taField.getText());
                    if (ta < 0 || ta > 35) {
                        throw new IllegalArgumentException("Invalid Terminal Assessment points");
                    }

                    // Calculate total points and display result
                    int total = m1 + m2 + ta;
                    resultField.setText(Integer.toString(total));
                } catch (NumberFormatException ex) {
                    // Handle invalid number format
                    JOptionPane.showMessageDialog(panel, "Invalid input format");
                } catch (IllegalArgumentException ex) {
                    // Handle invalid points range
                    JOptionPane.showMessageDialog(panel, ex.getMessage());
                }
            }
        });

        // Add panel to content pane
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();
        calculator.setVisible(true);
    }
}