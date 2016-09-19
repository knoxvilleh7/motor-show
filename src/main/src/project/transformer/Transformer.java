package project.transformer;

import project.model.Car;
import project.model.MotorShow;
import project.util.Util;

import javax.servlet.http.HttpServletRequest;

import static project.constants.CarConst.*;
import static project.constants.MotorShowConst.*;

/**
 * Created on 15.08.2016.
 */
public class Transformer {
    public static Car getCarParam(HttpServletRequest request) {
        Car car = new Car();
        car.setModel(Util.getString(request, MODEL));
        car.setManufacturerEmail(Util.getString(request, MEMAIL));
        car.setProductionDate(Util.getString(request, PD));
        car.setMotorShowId(Util.getInteger(request, MSID));
        car.setId(Util.getInteger(request, ID));
        car.setManufacturer(Util.getString(request, MANUFACTURER));
        car.setPrice(Util.getDouble(request, PRICE));
        car.setEngineVolume(Util.getDouble(request, EVOL));
        car.setVinCode(Util.getString(request, VIN));
        return car;
    }

    public static MotorShow getMotorShowParams(HttpServletRequest request) {
        MotorShow motorShow = new MotorShow();
        motorShow.setId(Util.getInteger(request, MID));
        motorShow.setName(Util.getString(request, NAME));
        motorShow.setAddress(Util.getString(request, ADDRESS));

        return motorShow;
    }
}
