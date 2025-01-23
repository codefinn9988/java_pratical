import javax.swing.*;
import java.awt.*;

public class SimpleInterestCalculator extends JFrame {
  private JTextField principalField, rateField, yearsField, resultField;

  public SimpleInterestCalculator() {
    setTitle("Simple Interest Calculator");
    setLayout(new GridLayout(5, 2, 10, 10));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add components
    add(new JLabel("Principal:"));
    principalField = new JTextField();
    add(principalField);

    add(new JLabel("Rate (%):"));
    rateField = new JTextField();
    add(rateField);

    add(new JLabel("Years:"));
    yearsField = new JTextField();
    add(yearsField);

    JButton calculateButton = new JButton("FIND SI");
    add(calculateButton);

    resultField = new JTextField();
    resultField.setEditable(false);
    add(resultField);

    // Add button action
    calculateButton.addActionListener(e -> {
      try {
        double principal = Double.parseDouble(principalField.getText());
        double rate = Double.parseDouble(rateField.getText());
        double years = Double.parseDouble(yearsField.getText());
        double si = (principal * rate * years) / 100;
        resultField.setText(String.format("%.2f", si));
      } catch (NumberFormatException ex) {
        resultField.setText("Invalid input");
      }
    });

    // Set window properties
    setSize(300, 200);
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new SimpleInterestCalculator().setVisible(true);
    });
  }
}
