/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day01cachingfibonacci;

/**
 *
 * @author mysel
 */
public class Day01CachingFibonacci {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fibonacci fib = new Fibonacci(true);
    System.out.println(fib.getNthFib(10));
    System.out.println(fib.getCountOfFibsComputed());
    System.out.println(fib);
    } // End of main method
    
    
    
}
