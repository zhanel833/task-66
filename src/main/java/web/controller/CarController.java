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
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showCars(@RequestParam(value = "count",required = false) Integer count, Model model) {
        if (count == null||count>= carService.getAllCars().size()) {
            model.addAttribute("cars", carService.getAllCars());
        }
        else {
            model.addAttribute("cars", carService.getCars(count));
        }
        return "cars";
    }
}
