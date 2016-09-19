package project.util;

import net.sf.oval.constraint.CheckWithCheck;
import project.dao.CarDao;
import project.dao.CarDaoImpl;
import project.model.Car;

/**
 * Created on 16.08.2016.
 */
public class VinCheck implements CheckWithCheck.SimpleCheck {

    private CarDao carDao = new CarDaoImpl();
    public boolean isSatisfied(Object valObj, Object value) {

        String i = value.toString();
        int vin = Integer.parseInt(i);
        Car carFromBase = carDao.getCarByVin(vin);
        return carFromBase==null || (carFromBase.getId().equals(((Car)valObj).getId()));
        
    }
}
