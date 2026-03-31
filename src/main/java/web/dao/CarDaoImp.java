package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{
    List<Car> cars;
    public CarDaoImp() {
        cars = new ArrayList<>();
        cars.add(new Car("car1", 1,2));
        cars.add(new Car("car2", 3,4));
        cars.add(new Car("car3", 5,6));
        cars.add(new Car("car4", 7,8));
        cars.add(new Car("car5", 9,10));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
    public List<Car> getSomeCars(int number) {
        return cars.subList(0, number);
    }
}
