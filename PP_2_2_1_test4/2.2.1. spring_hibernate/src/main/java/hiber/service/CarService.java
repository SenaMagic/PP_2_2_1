package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {

    void addCar(Car car);

    User getUserByCar(String model, int series);
}
