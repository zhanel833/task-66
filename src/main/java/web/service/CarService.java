package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars;
    public CarService() {
        cars = new ArrayList<Car>();
        cars.add(new Car("Model 1","Brand 1",2021));
        cars.add(new Car("Model 2","Brand 2",2022));
        cars.add(new Car("Model 3","Brand 3",2023));
        cars.add(new Car("Model 4","Brand 4",2024));
        cars.add(new Car("Model 5","Brand 5",2025));
    }
    public List<Car> getCars(int count) {
        if (count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
        }
    public List<Car> getAllCars() {
        return cars;
    }
}
