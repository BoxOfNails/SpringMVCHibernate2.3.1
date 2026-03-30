package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService{

    @Override
    public List<Car> getNumberOfCars(List<Car> cars, int number) {
        return cars.subList(0, number);
    }
}
