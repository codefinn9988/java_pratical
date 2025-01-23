//Write a simple GUI program that displays "Hello World" in a text field.
//The program should display output if user clicks a button.
//2079 4 marks

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorldApp {
  public static void main(String[] args) {
    // Create a JFrame
    JFrame frame = new JFrame("Hello World Application");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);

    // Create a JTextField
    JTextField textField = new JTextField(20);
    textField.setEditable(false); // Make it read-only

    // Create a JButton
    JButton button = new JButton("Click Me!");

    // Add ActionListener to the button
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textField.setText("Hello World");
      }
    });

    // Set layout manager
    frame.setLayout(new FlowLayout());

    // Add components to the frame
    frame.add(textField);
    frame.add(button);

    // Make the frame visible
    frame.setVisible(true);
  }
}
