//Write a java program using TCP such that client
//sends number to server and displays its factorial.
//The server computes factorial of the number received from client.
//model 5 marks

import java.io.*;
import java.net.*;

public class FactorialClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 5000);

      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      DataInputStream in = new DataInputStream(socket.getInputStream());

      int number = 5; // You can change this number
      out.writeInt(number);

      int result = in.readInt();
      System.out.println("Factorial of " + number + " is: " + result);

      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
