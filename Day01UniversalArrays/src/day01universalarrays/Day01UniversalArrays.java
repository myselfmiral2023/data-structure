/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day01universalarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mysel
 */
public class Day01UniversalArrays {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] arr1 = new int[3];
    inputArray(arr1);
    printArray(arr1);

    int[][] arr2d = new int[3][];
    arr2d[0] = new int[1];
    arr2d[1] = new int[2]; 
    arr2d[2] = new int[4];
    inputArray(arr2d); 
    printArray(arr2d);
    
    System.out.println("Duplicate Array: " + Arrays.toString(findDuplicates(arr2d[1],arr2d[2])));
    
    
    
    } //End block of Main method
    
    public static void inputArray(int[] data) {
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < data.length; i++) {
      System.out.printf("Enter value for element %d: ", i);
      data[i] = scanner.nextInt(); 
    }
  }

  public static void inputArray(int[][] data2d) {
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < data2d.length; i++) {
      for (int j = 0; j < data2d[i].length; j++) {
        System.out.printf("Enter value row %d column %d: ", i+1, j+1);
        data2d[i][j] = scanner.nextInt();
      }
    }
  }

  public static void printArray(int[] data) {
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i]);
      if (i < data.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }

  public static void printArray(int[][] data2d) {
    int maxLength = 0;
    for (int[] row : data2d) {
      for (int value : row) {
        int length = String.valueOf(value).length();
        if (length > maxLength) {
          maxLength = length;
        }
      }
    }
    
    for (int[] row : data2d) {
      for (int value : row) {
        String formatted = String.format("%" + maxLength + "d", value);
        System.out.print(formatted);
        System.out.print(", ");
      }
      System.out.println();
    }
  }
  
  public static int[] findDuplicates(int[] a1, int[] a2) {
  
    int[] duplicates = new int[a1.length + a2.length];
    int numDuplicates = 0;

    outerLoop:
    for (int i = 0; i < a1.length; i++) {
      int value = a1[i];
      for (int j = 0; j < numDuplicates; j++) {
        if (duplicates[j] == value) {
          continue outerLoop;
        }
      }
      for (int k = 0; k < a2.length; k++) {
        if (value == a2[k]) {
          duplicates[numDuplicates++] = value;
          continue outerLoop;
        }
      }
    }

    int[] result = new int[numDuplicates];
    for (int i = 0; i < numDuplicates; i++) {
      result[i] = duplicates[i];
    }
    return result;

  }
  
  public static int[] findDuplicates(int[][] a1, int[][] a2) {

    int[] duplicates = new int[countElements(a1) + countElements(a2)];
    int numDuplicates = 0;

    outerLoop:
    for (int i = 0; i < a1.length; i++) {
      for (int j = 0; j < a1[i].length; j++) {
        int value = a1[i][j];
        for (int k = 0; k < numDuplicates; k++) {
          if (duplicates[k] == value) {
            continue outerLoop;
          }
        }
        for (int m = 0; m < a2.length; m++) {
          for (int n = 0; n < a2[m].length; n++) {
            if (value == a2[m][n]) {
              duplicates[numDuplicates++] = value;
              continue outerLoop;
            }
          }
        }
      }
    }

    int[] result = new int[numDuplicates];
    for (int i = 0; i < numDuplicates; i++) {
      result[i] = duplicates[i];
    }
    return result;

  }

  private static int countElements(int[][] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      count += arr[i].length;
    }
    return count;
  }
    
}
