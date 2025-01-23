// Describe any two types of Layout manager. Using swing components, design a
// form with three buttons with captions “RED,” “BLUE,” and “GREEN,”
// respectively. Then write a program to handle the event such that when the
// user clicks the button, the color of that button will be the same as its
// caption

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonApp extends JFrame {
  public ColorButtonApp() {
    // Set up the frame
    setTitle("Color Buttons");
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a panel to hold buttons
    JPanel panel = new JPanel();

    // Create three buttons
    JButton redButton = new JButton("RED");
    JButton blueButton = new JButton("BLUE");
    JButton greenButton = new JButton("GREEN");

    // Add action listeners to change button colors
    redButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        redButton.setBackground(Color.RED);
      }
    });

    blueButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        blueButton.setBackground(Color.BLUE);
      }
    });

    greenButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        greenButton.setBackground(Color.GREEN);
      }
    });

    // Add buttons to the panel
    panel.add(redButton);
    panel.add(blueButton);
    panel.add(greenButton);

    // Add panel to the frame
    add(panel);
  }

  public static void main(String[] args) {
    // Create and show the frame
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ColorButtonApp().setVisible(true);
      }
    });
  }
}
