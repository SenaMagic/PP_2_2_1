package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.CarDaoImpl;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;
    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByCar(String model, int series) {
        return carDao.getUserByCar(model, series);
    }
}
