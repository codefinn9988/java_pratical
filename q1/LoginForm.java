
// Write a java program to create login form with user id, password, ok button,
// and cancel button. Handle key events such that pressing ‘l’ performs login
// and pressing ‘c’ clears text boxes and puts focus on user id text box. Assume
// user table having fields Uid and Password in the database named account.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame {
  private JTextField userIdField;
  private JPasswordField passwordField;

  public LoginForm() {
    setTitle("Login Form");
    setSize(250, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // Simple panel with FlowLayout
    JPanel panel = new JPanel(new FlowLayout());

    panel.add(new JLabel("User ID:"));
    userIdField = new JTextField(15);
    panel.add(userIdField);

    panel.add(new JLabel("Password:"));
    passwordField = new JPasswordField(15);
    panel.add(passwordField);

    JButton loginButton = new JButton("Login");
    JButton cancelButton = new JButton("Cancel");
    panel.add(loginButton);
    panel.add(cancelButton);

    // Add key listener using KeyAdapter
    KeyAdapter keyHandler = new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'l' || e.getKeyChar() == 'L') {
          performLogin();
        } else if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
          clearFields();
        }
      }
    };

    userIdField.addKeyListener(keyHandler);
    passwordField.addKeyListener(keyHandler);

    loginButton.addActionListener(e -> performLogin());
    cancelButton.addActionListener(e -> clearFields());

    add(panel);
  }

  private void performLogin() {
    try {
      Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/account",
          "root",
          "password");

      String query = "SELECT * FROM user WHERE Uid=? AND Password=?";
      PreparedStatement pstmt = conn.prepareStatement(query);
      pstmt.setString(1, userIdField.getText());
      pstmt.setString(2, new String(passwordField.getPassword()));

      if (pstmt.executeQuery().next()) {
        JOptionPane.showMessageDialog(this, "Login Successful!");
      } else {
        JOptionPane.showMessageDialog(this, "Invalid credentials!");
      }
      conn.close();

    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
    }
  }

  private void clearFields() {
    userIdField.setText("");
    passwordField.setText("");
    userIdField.requestFocus();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
  }
}
