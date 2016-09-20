package project.service;

import project.exception.ValidException;
import project.model.Car;

import java.util.List;


public interface CarService {

    void saveCar(Car car) throws ValidException;

    List<Car> getCarsByMSId(Integer motorShowId, Integer pageNumber, Integer pageSize);

    Car getCarById(Integer id);

    Car getCarByVin(String VinCode);

    List<Car> getCars(Integer pageNumber, Integer pageSize);

    void deleteCar(Integer id);

    Long getCarCount();

    Long getCarForSearchCount(Object  searchValue,String searchCategory);

    Long getCarForSearchCountInMotorShow(Object  searchValue,String searchCategory,Integer motorShowId);

    Long getCarOfShowCount(Integer motorShowId);

    List<Car> getCarsBySearch(Object searchValue,String searchCategory,Integer PageNumber,Integer PageSize);

    List<Car> getCarsBySearchInMotorShow(Integer motorShowId, Object searchValue,String searchCategory,Integer PageNumber,Integer PageSize);


}
