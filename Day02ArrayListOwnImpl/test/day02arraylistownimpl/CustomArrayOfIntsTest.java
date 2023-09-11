/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package day02arraylistownimpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mysel
 */
public class CustomArrayOfIntsTest {

    public CustomArrayOfIntsTest() {
    }

    private CustomArrayOfInts array;

    @BeforeEach
    void setup() {
        array = new CustomArrayOfInts();
    }

    @Test
    void testInitialSize() {
        assertEquals(0, array.size());
    }

    @Test
    void testAdd() {
        array.add(5);
        assertEquals(1, array.size());
        assertEquals(5, array.get(0));
    }

    @Test
    void testDeleteByIndex() {
        array.add(1);
        array.add(2);
        array.deleteByIndex(0);
        assertEquals(1, array.size());
        assertEquals(2, array.get(0));
    }

    @Test
    void testDeleteByValue() {
        array.add(1);
        array.add(2);
        assertTrue(array.deleteByValue(1));
        assertFalse(array.deleteByValue(1));
    }

    @Test
    void testInsertValueAtIndex() {
        array.insertValueAtIndex(10, 0);
        assertEquals(1, array.size());
        assertEquals(10, array.get(0));
    }

    @Test
    void testClear() {
        array.add(1);
        array.clear();
        assertEquals(0, array.size());
    }

    @Test
    void testGet() {
        array.add(5);
        assertEquals(5, array.get(0));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(0);
        });
    }

    @Test
    void testGetSlice() {
        array.add(1);
        array.add(2);
        array.add(3);
        int[] slice = array.getSlice(1, 2);
        assertArrayEquals(new int[]{2, 3}, slice);
    }

    @Test
    void testToString() {
        array.add(1);
        array.add(5);
        String expected = "[1, 5]";
        assertEquals(expected, array.toString());
    }

}
