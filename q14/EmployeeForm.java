import javax.swing.*;
import java.awt.*;
import java.io.*;

public class EmployeeForm extends JFrame {
  private JTextField nameField, ageField, salaryField;
  private JComboBox<String> genderBox;

  public EmployeeForm() {
    setTitle("Employee Details");
    setLayout(new GridLayout(5, 2, 10, 10));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add form components
    add(new JLabel("Name:"));
    nameField = new JTextField();
    add(nameField);

    add(new JLabel("Age:"));
    ageField = new JTextField();
    add(ageField);

    add(new JLabel("Gender:"));
    genderBox = new JComboBox<>(new String[] { "Male", "Female", "Other" });
    add(genderBox);

    add(new JLabel("Salary:"));
    salaryField = new JTextField();
    add(salaryField);

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(e -> saveToFile());
    add(saveButton);

    setSize(300, 200);
    setLocationRelativeTo(null);
  }

  private void saveToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("employees.txt", true))) {
      writer.printf("Name: %s, Age: %s, Gender: %s, Salary: %s%n",
          nameField.getText(),
          ageField.getText(),
          genderBox.getSelectedItem(),
          salaryField.getText());
      JOptionPane.showMessageDialog(this, "Data saved successfully!");
      clearFields();
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
    }
  }

  private void clearFields() {
    nameField.setText("");
    ageField.setText("");
    genderBox.setSelectedIndex(0);
    salaryField.setText("");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new EmployeeForm().setVisible(true));
  }
}
