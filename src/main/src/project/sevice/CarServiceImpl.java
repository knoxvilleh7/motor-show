package project.sevice;

import project.dao.CarDao;
import project.dao.CarDaoImpl;
import project.exception.MyExcep;
import project.model.Car;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

/**
 * Created on 15.08.2016.
 */
public class CarServiceImpl implements CarService{
private CarDao carDao = new CarDaoImpl();
private ModelValidator mv = new ModelValidator();
    public void saveCar(Car car) throws MyExcep {
        Map<String, List<String>> err = mv.mValid(car);
        if (err.isEmpty()) {
            carDao.saveCar(car);
        }else {
            throw new MyExcep(err);
        }
    }

    public List<Car> getCarsByMSId(Integer msid) {
        return carDao.getCarsByMSId(msid);
    }

    public Car getCarById(Integer id) {
        return carDao.getCarById(id);
    }

    public void deleteCar(Integer id) {
        carDao.deleteCar(id);
    }
}
