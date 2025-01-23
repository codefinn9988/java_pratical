//Suppose that 9 integers are written in a file named"magic.txt"in the
//arrangement of 3*3 separated by space in.Write a program,whether the integers in all rows,
//all columns and boot diagonals sum to the same constant or not.[5]

import java.io.File;
import java.util.Scanner;

public class MagicSquare {
  public static void main(String[] args) {
    try {
      int[][] grid = new int[3][3];
      Scanner sc = new Scanner(new File("magic.txt"));

      // Read grid
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          grid[i][j] = sc.nextInt();
        }
      }
      sc.close();

      int target = grid[0][0] + grid[0][1] + grid[0][2];
      boolean isMagic = true;

      // Check rows
      for (int i = 0; i < 3; i++) {
        if (grid[i][0] + grid[i][1] + grid[i][2] != target)
          isMagic = false;
      }

      // Check columns
      for (int j = 0; j < 3; j++) {
        if (grid[0][j] + grid[1][j] + grid[2][j] != target)
          isMagic = false;
      }

      // Check diagonals
      if (grid[0][0] + grid[1][1] + grid[2][2] != target)
        isMagic = false;
      if (grid[0][2] + grid[1][1] + grid[2][0] != target)
        isMagic = false;

      System.out.println(isMagic ? "Magic square" : "Not a magic square");

    } catch (Exception e) {
      System.out.println("Error reading file");
    }
  }
}
