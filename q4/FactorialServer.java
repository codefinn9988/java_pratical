//Write a java program using TCP such that client
//sends number to server and displays its factorial.
//The server computes factorial of the number received from client.
//model 5 marks

import java.io.*;
import java.net.*;

public class FactorialServer {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(5000);
      System.out.println("Server is waiting for a client...");
      Socket socket = serverSocket.accept();

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      int number = in.readInt();
      int factorial = 1;
      for (int i = 1; i <= number; i++) {
        factorial *= i;
      }
      out.writeInt(factorial);

      socket.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
