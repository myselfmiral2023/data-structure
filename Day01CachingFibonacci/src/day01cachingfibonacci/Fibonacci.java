/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day01cachingfibonacci;

import java.util.HashMap;

/**
 *
 * @author mysel
 */
public class Fibonacci {
    private boolean isCacheOn;
  private HashMap<Integer,Long> fibsCached; 
  private int fibsCompCount;

  public Fibonacci(boolean cacheOn) {
    isCacheOn = cacheOn;
    fibsCached = new HashMap<>();
    fibsCached.put(0, 0L);
    fibsCached.put(1, 1L);
    fibsCompCount = 2; 
  }

  public long getNthFib(int n) {
    if (isCacheOn && fibsCached.containsKey(n)) {
      return fibsCached.get(n);
    }
    long fib = computeNthFib(n);
    if (isCacheOn) {
      fibsCached.put(n, fib);
    }
    return fib;
  }

  private long computeNthFib(int n) {
    fibsCompCount++;
    if (n <= 1) return n;
    return computeNthFib(n-1) + computeNthFib(n-2); 
  }

  public int getCountOfFibsComputed() {
    return fibsCompCount;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Integer key : fibsCached.keySet()) {
      if (sb.length() > 0) {
        sb.append(", ");
      }
      sb.append(fibsCached.get(key)); 
    }
    return sb.toString();
  }

      
}
