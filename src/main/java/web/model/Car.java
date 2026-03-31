package web.model;

import java.util.Objects;

public class Car {
    private String model;
    private int mileage;
    private int price;
    public Car() {

    }

    public Car(String model, int mileage, int price) {
        this.model = model;
        this.mileage = mileage;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage && price == car.price && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, mileage, price);
    }
}
