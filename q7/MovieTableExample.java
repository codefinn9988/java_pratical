// Assume a table MOVIE(id, title, genre). Now using JDBC, 
// perform the following queries. 
// a. Add any three records to the MOVIE table
// b. Using prepared statement, 
// update the genre to "Comedy" having title "Jatra"
// 2080 5 marks

import java.sql.*;

public class MovieTableExample {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/testdb"; // Replace with your database name
    String user = "root"; // Your database username
    String password = "password"; // Your database password

    try (Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement()) {

      // a. Add three records to the MOVIE table
      stmt.executeUpdate("INSERT INTO MOVIE (id, title, genre) VALUES (1, 'Jatra', 'Drama')");
      stmt.executeUpdate("INSERT INTO MOVIE (id, title, genre) VALUES (2, 'Drishyam', 'Thriller')");
      stmt.executeUpdate("INSERT INTO MOVIE (id, title, genre) VALUES (3, 'Inception', 'Sci-Fi')");

      System.out.println("Records inserted successfully.");

      // b. Update the genre to "Comedy" for the movie with title "Jatra"
      String updateQuery = "UPDATE MOVIE SET genre = ? WHERE title = ?";
      PreparedStatement pstmt = conn.prepareStatement(updateQuery);
      pstmt.setString(1, "Comedy"); // Set genre to Comedy
      pstmt.setString(2, "Jatra"); // Where title = "Jatra"
      // The method executeUpdate() returns an integer that indicates the number of
      // rows affected by the executed SQL statement
      int rowsUpdated = pstmt.executeUpdate();

      if (rowsUpdated > 0) {
        System.out.println("Genre updated successfully for movie 'Jatra'.");
      }

    } catch (SQLException e) {
      System.out.println("SQL Exception: " + e.getMessage());
    }
  }
}
