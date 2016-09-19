package project.util;

import net.sf.oval.constraint.CheckWithCheck;
import project.model.Car;
import project.service.CarService;

public class VinCheck implements CheckWithCheck.SimpleCheck {

    private CarService dao = SpringUtils.getBean(CarService.class);

    public boolean isSatisfied(Object valObj, Object value) {
        if (valObj instanceof Car) {
            Car carFromBase = null;
            try {
                carFromBase = dao.getCarByVin(value.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return carFromBase == null || (carFromBase.getId().equals(((Car) valObj).getId()));
        }
        return false;
    }
}
