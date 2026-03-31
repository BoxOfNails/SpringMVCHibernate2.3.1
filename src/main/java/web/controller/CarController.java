package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    public CarController() {
    }
    @GetMapping
    public String getAllCars(Model theModel) {
        theModel.addAttribute("cars", carService.getCars());
        return "cars";
    }
    @GetMapping(params = "count")
    public String getSomeCars(@RequestParam(required = false) Integer count, Model theModel) {
        theModel.addAttribute("cars", carService.getSomeCars(count));
        return "cars";
    }
}
