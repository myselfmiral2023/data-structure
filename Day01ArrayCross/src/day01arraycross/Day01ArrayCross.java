/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day01arraycross;

/**
 *
 * @author mysel
 */
public class Day01ArrayCross {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] data = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}  
    };
    
    // Part A
    int minRow = 0;
    int minCol = 0;
    int minSum = Integer.MAX_VALUE;
    
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        int sum = sumOfCross(data, i, j);
        if (sum < minSum) {
          minSum = sum;
          minRow = i;
          minCol = j;
        }
      }
    }
    
    System.out.println("Min sum is: " + minSum + " at row: " + minRow + " col: " + minCol);

    // Part B
    int[][] data2Dsums = duplicateEmptyArray2D(data);
    
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        data2Dsums[i][j] = sumOfCross(data, i, j);
      }
    }
    
    print2D(data);
    print2D(data2Dsums);
        
        
    } //End of main method
    
    static int getIfExists(int[][] data, int row, int col) {
    if (row >= 0 && row < data.length && col >= 0 && col < data[row].length) {
      return data[row][col];
    } else {
      return 0;  
    }
  }

  static int sumOfCross(int[][] data, int row, int col) {
    return data[row][col] 
         + getIfExists(data, row-1, col)  
         + getIfExists(data, row+1, col)
         + getIfExists(data, row, col-1)
         + getIfExists(data, row, col+1);
  }
  
  static void print2D(int[][] data) {
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        System.out.print(data[i][j] + " ");
      }
      System.out.println();
    }
  }

  static int[][] duplicateEmptyArray2D(int[][] orig2d) {
    int[][] dup = new int[orig2d.length][];
    for (int i = 0; i < orig2d.length; i++) {
      dup[i] = new int[orig2d[i].length]; 
    }
    return dup;
  }
    
}
