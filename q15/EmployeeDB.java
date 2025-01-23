import java.sql.*;

public class EmployeeDB {
  // JDBC URL, username, and password
  static final String DB_URL = "jdbc:mysql://localhost:3306/practical";
  static final String USER = "root";
  static final String PASS = "root";

  public static void main(String[] args) {
    try {
      // Register JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // Open a connection
      System.out.println("Connecting to database...");
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // Create table
      String createTable = "CREATE TABLE IF NOT EXISTS employee " +
          "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
          " name VARCHAR(50), " +
          " age INTEGER, " +
          " salary DOUBLE)";

      Statement stmt = conn.createStatement();
      stmt.execute(createTable);
      System.out.println("Table created successfully");

      // Insert data
      String insertData = "INSERT INTO employee (name, age, salary) VALUES (?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(insertData);
      pstmt.setString(1, "John Doe");
      pstmt.setInt(2, 30);
      pstmt.setDouble(3, 50000.0);
      pstmt.executeUpdate();
      System.out.println("Employee data inserted");

      // Retrieve data
      ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
      while (rs.next()) {
        System.out.printf("ID: %d, Name: %s, Age: %d, Salary: %.2f%n",
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("age"),
            rs.getDouble("salary"));
      }

      // Close resources
      rs.close();
      stmt.close();
      pstmt.close();
      conn.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
