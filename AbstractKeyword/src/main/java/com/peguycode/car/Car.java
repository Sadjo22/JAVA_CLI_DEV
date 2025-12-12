package com.peguycode.car;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
   private String regNumber;
   private BigDecimal rentalPricePerDay;
   private Brand brand;
   private Color color;
   private boolean isElectric;

    public Car(String regNumber, BigDecimal rentalPricePerDay, Brand brand, Color color, boolean isElectric) {
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.color = color;
        this.isElectric = isElectric;
    }


    public Car(String regNumber, BigDecimal rentalPricePerDay, Brand brand) {
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return isElectric == car.isElectric && Objects.equals(regNumber, car.regNumber) && Objects.equals(rentalPricePerDay, car.rentalPricePerDay) && brand == car.brand && color == car.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, rentalPricePerDay, brand, color, isElectric);
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", color=" + color +
                ", isElectric=" + isElectric +
                '}';
    }
}
