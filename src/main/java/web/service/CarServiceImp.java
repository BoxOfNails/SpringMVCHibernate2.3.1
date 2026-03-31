package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService{

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getSomeCars(int number) {
        if(number>=0 && number<=5) {
            return carDao.getSomeCars(number);
        } else {
            return carDao.getSomeCars(5);
        }
    }

    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }
}
