
// Write a GUI program using components to find sum and 
// difference of two numbers. Use two text fields for
// giving input and a label for output. The program should display sum
// if user presses mouse and difference if user release mouse.
//8 2078

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumDifferenceCalculator extends JFrame {
  private JTextField num1Field;
  private JTextField num2Field;
  private JLabel resultLabel;

  public SumDifferenceCalculator() {
    setTitle("Sum and Difference Calculator");
    setLayout(new FlowLayout());

    // Create text fields for input
    num1Field = new JTextField(10);
    num2Field = new JTextField(10);

    // Create label for output
    resultLabel = new JLabel("Result: ");

    // Add components to frame
    add(new JLabel("Number 1:"));
    add(num1Field);
    add(new JLabel("Number 2:"));
    add(num2Field);
    add(resultLabel);

    // Mouse listener to handle press and release events
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        calculateSum();
      }

      public void mouseReleased(MouseEvent e) {
        calculateDifference();
      }
    });

    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void calculateSum() {
    int num1 = Integer.parseInt(num1Field.getText());
    int num2 = Integer.parseInt(num2Field.getText());
    int sum = num1 + num2;
    resultLabel.setText("Result: Sum = " + sum);
  }

  private void calculateDifference() {
    int num1 = Integer.parseInt(num1Field.getText());
    int num2 = Integer.parseInt(num2Field.getText());
    int difference = num1 - num2;
    resultLabel.setText("Result: Difference = " + difference);
  }

  public static void main(String[] args) {
    new SumDifferenceCalculator();
  }
}
