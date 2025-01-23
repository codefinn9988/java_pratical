//Write a TCP client - server system in which the client program
//sends two integers to a server program which returns the greatest among them.
//5 marks 2080

import java.io.*;
import java.net.*;

public class GreatestClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 5000);

      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      DataInputStream in = new DataInputStream(socket.getInputStream());

      // Send two integers to the server
      int num1 = 10; // Example integer 1
      int num2 = 20; // Example integer 2
      out.writeInt(num1);
      out.writeInt(num2);

      // Receive the greatest number from the server
      int greatest = in.readInt();
      System.out.println("The greatest number is: " + greatest);

      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
