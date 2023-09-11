/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import day01cachingfibonacci.Fibonacci;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mysel Use @BeforeEach to initialize Fibonacci instance Test base
 * cases 0 and 1 Test some higher Fibonacci values Test caching works by calling
 * twice and checking count Test toString() outputs cache contents
 *
 */
public class FibonacciTest {

    public FibonacciTest() {
    }

    private Fibonacci fib;

    @BeforeEach
    void setup() {
        fib = new Fibonacci(true);
    }

    @Test
    void testFirstValues() {
        assertEquals(0, fib.getNthFib(0));
        assertEquals(1, fib.getNthFib(1));
    }

    @Test
    void testHigherValues() {
        assertEquals(55, fib.getNthFib(10));
        assertEquals(144, fib.getNthFib(12));
    }

    @Test
    void testCaching() {
        int countBefore = fib.getCountOfFibsComputed();
        fib.getNthFib(10);
        assertEquals(countBefore, fib.getCountOfFibsComputed());
    }

    @Test
    void testToString() {
        fib.getNthFib(5);
        String expected = "0, 1, 1, 2, 3, 5";
        assertEquals(expected, fib.toString());
    }
}
