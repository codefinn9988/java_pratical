//Write a java program that writes objects of Employee class in the file named emp.doc. 
//Create Employee class as of your interest.
//5 marks in model

import java.io.*;

// Employee class implements Serializable for object writing
// Serialization in Java is a mechanism of writing the state of an object into a byte-stream
class Employee implements Serializable {
  // Instance variables
  private int empId;
  private String name;
  private double salary;

  // Constructor
  public Employee(int empId, String name, double salary) {
    this.empId = empId;
    this.name = name;
    this.salary = salary;
  }

}

public class EmployeeFileWriter {
  public static void main(String[] args) {
    try {
      // Create file output stream(byte data)
      FileOutputStream fileOut = new FileOutputStream("emp.doc");
      ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

      // Create Employee objects
      Employee emp1 = new Employee(101, "John Doe", 50000.00);
      Employee emp2 = new Employee(102, "Jane Smith", 60000.00);
      Employee emp3 = new Employee(103, "Mike Johnson", 55000.00);

      // Write objects to file
      objectOut.writeObject(emp1);
      objectOut.writeObject(emp2);
      objectOut.writeObject(emp3);

      // Close streams
      objectOut.close();
      fileOut.close();

      System.out.println("Employee objects written to emp.doc successfully!");

    } catch (IOException e) {
      System.out.println("Error writing to file: " + e.getMessage());
    }
  }
}
