package project.sevice;

import project.exception.MyExcep;
import project.model.Car;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface CarService {

    void saveCar(Car car) throws MyExcep;

    List<Car> getCarsByMSId(Integer msid);

    Car getCarById(Integer id);

    void deleteCar(Integer id);
}
