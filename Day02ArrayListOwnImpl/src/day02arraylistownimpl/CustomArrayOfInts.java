/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day02arraylistownimpl;

/**
 *
 * @author mysel
 */
public class CustomArrayOfInts {

    private int[] data;
    private int size;

    public CustomArrayOfInts() {
        data = new int[2];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size == data.length) {
            expandArray();
        }
        data[size++] = value;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public boolean deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                deleteByIndex(i);
                return true;
            }
        }
        return false;
    }

    public void insertValueAtIndex(int value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == data.length) {
            expandArray();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public void clear() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    public int[] getSlice(int startIdx, int length) {
        if (startIdx < 0 || startIdx >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (i + startIdx >= size) {
                break;
            }
            result[i] = data[startIdx + i];
        }
        return result;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i] + ", ");
        }
        sb.append(data[size - 1] + "]");
        return sb.toString();
    }

    private void expandArray() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
