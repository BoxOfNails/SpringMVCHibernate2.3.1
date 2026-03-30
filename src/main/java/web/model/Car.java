package web.model;

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
}
