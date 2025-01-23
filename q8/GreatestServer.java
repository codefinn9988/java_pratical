//Write a TCP client - server system in which the client program
//sends two integers to a server program which returns the greatest among them.
//5 marks 2080

import java.io.*;
import java.net.*;

public class GreatestServer {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(5000);
      System.out.println("Server is waiting for a client...");
      Socket socket = serverSocket.accept();

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      // Receive two integers from the client
      int num1 = in.readInt();
      int num2 = in.readInt();

      // Find the greatest number
      int greatest = (num1 > num2) ? num1 : num2;

      // Send the result back to the client
      out.writeInt(greatest);

      socket.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

