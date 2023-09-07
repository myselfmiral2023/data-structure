/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ds_day01carssorted;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mysel
 */
public class DS_Day01CarsSorted {
static ArrayList<Car> parking = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int date = 0;
        int date1 = 0;
        
        readDataFromFile();

        System.out.println("Part 1: Cars List");
        printCars();

        System.out.println("\nPart 2: Sorting by Make/Model");
        Collections.sort(parking);
        printCars();

        System.out.println("\nPart 2: Sorting by Engine Size");
        Comparator<Car> engineSizeComparator = (car1, car2) -> Double.compare(car1.getEngineSizeL(), car2.getEngineSizeL());
        parking.sort(engineSizeComparator);
        printCars();

        System.out.println("\nPart 2: Sorting by Production Year");
        parking.sort((car1, car2) -> Integer.compare(car1.getProdYear(), car2.getProdYear()));
        printCars();

        System.out.println("\nPart 2: Sorting by Production Year then Make/Model");
        parking.sort(Comparator.comparingInt(Car::getProdYear).thenComparing(Car::getMakeModel));
        printCars();
        
    }
    
    static void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(";");
                if (carData.length == 3) {
                    String makeModel = carData[0];
                    double engineSizeL = Double.parseDouble(carData[1]);
                    int prodYear = Integer.parseInt(carData[2]);
                    parking.add(new Car(makeModel, engineSizeL, prodYear));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing data from file: " + e.getMessage());
        }
    }

    static void printCars() {
        for (Car car : parking) {
            System.out.println(car);
        }
    }
    
}
