package project.newDao;

import project.model.Car;

import java.util.List;

public interface CarDao extends NewDaoGenerics<Car>{

    List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize);

    Car getByVin(String VinCode);
}
