/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds_day01carssorted;

import java.util.Comparator;

/**
 *
 * @author mysel
 */
public class Car implements Comparable<Car> {
    private String makeModel;
    private double engineSizeL;
    private int prodYear;

    public Car(String makeModel, double engineSizeL, int prodYear) {
        this.makeModel = makeModel;
        this.engineSizeL = engineSizeL;
        this.prodYear = prodYear;
    }

    
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public double getEngineSizeL() {
        return engineSizeL;
    }

    public void setEngineSizeL(double engineSizeL) {
        this.engineSizeL = engineSizeL;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    @Override
    public String toString() {
        return "Car{" + "makeModel=" + makeModel + ", engineSizeL=" + engineSizeL + ", prodYear=" + prodYear + '}';
    }
    
    @Override
    public int compareTo(Car o) {
        return makeModel.compareTo(o.makeModel);
    }
    
    
}


 