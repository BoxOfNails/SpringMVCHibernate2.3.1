package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    List<Car> cars;
    @Autowired
    CarService carService;
    public CarController() {
        cars = new ArrayList<>();
        cars.add(new Car("car1", 1,2));
        cars.add(new Car("car2", 3,4));
        cars.add(new Car("car3", 5,6));
        cars.add(new Car("car4", 7,8));
        cars.add(new Car("car5", 9,10));
    }
    @GetMapping()
    public String getAllCars(@RequestParam(required = false) Integer count, Model theModel) {
        if(count!=null && count <= 5) {
            theModel.addAttribute("cars", carService.getNumberOfCars(cars, count));
        } else {
            theModel.addAttribute("cars", cars);
        }
        return "cars";
    }
    @GetMapping("/{carId}")
    public String getSomeCars(@PathVariable int carId, Model theModel) {
        theModel.addAttribute("cars", carService.getNumberOfCars(cars, carId));
        return "cars";
    }
}
