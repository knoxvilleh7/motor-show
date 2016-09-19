package project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.exception.ValidException;
import project.model.Car;
import project.newDao.CarDao;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

import static project.constants.AttributeConst.CAR;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    private ModelValidator mv = new ModelValidator();

    @Transactional
    public void saveCar(Car car) throws ValidException{
        Map<String, List<String>> err = mv.mValid(car);
        if (err.isEmpty()) {
            carDao.saveOrUpdate(car);
        } else {
            throw new ValidException(err);
        }
    }

    public List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize) {
        return this.carDao.getCarsByMSId(MotorShowId, pageNumber, pageSize);
    }

    public Car getCarById(Integer id) {
        return carDao.getById(id);
    }

    @Override
    public Car getCarByVin(String VinCode) {
        return carDao.getByVin(VinCode);
    }

    public List<Car> getCars(Integer pageNumber, Integer pageSize) {
        return carDao.getAll(pageNumber, pageSize);
    }

    public Long getCarCount(){
       return carDao.getCount(CAR, null);
    }

    public Long getCarForSearchCount(Object  searchValue,String searchCategory) {
        return this.carDao.getCountForSearch(searchValue,searchCategory, null);
    }

    public Long getCarForSearchCountInMotorShow(Object searchValue, String searchCategory, Integer motorShowId) {
        return this.carDao.getCountForSearch(searchValue,searchCategory, motorShowId);
    }

    public Long getCarOfShowCount(Integer motorShowId) {
        return carDao.getCount(CAR, motorShowId );
    }

    public List<Car> getCarsBySearch(Object searchValue, String searchCategory, Integer PageNumber, Integer PageSize) {
        return this.carDao.getObjectsForSearch(null, searchValue, searchCategory, PageNumber, PageSize);
    }

    public List<Car> getCarsBySearchInMotorShow(Integer motorShowId, Object searchValue, String searchCategory, Integer PageNumber, Integer PageSize) {
        return this.carDao.getObjectsForSearch(motorShowId, searchValue, searchCategory, PageNumber, PageSize);
    }

    public void deleteCar(Integer id) {
        carDao.deleteById(carDao.getById(id));
    }

}
