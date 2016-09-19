package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.Car;
import project.model.MotorShow;
import project.service.CarService;
import project.service.MotorShowService;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.PagesConst.CAREDIT;

public class CarEdition implements RequestInterface {

    private MotorShowService motorShowService;
    private CarService carService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {
        Integer motorShowId = Util.getInteger(request, MSID);
        Integer id = Util.getInteger(request, CAR);
        Integer nullId = 0;
        if (motorShowId != null) {
            request.setAttribute(MSID, motorShowId);
            request.setAttribute(ID, null);
            request.setAttribute(MSHOWS, Collections.EMPTY_LIST);
        }
        if (id != null) {
            Car car = this.carService.getCarById(id);
            request.setAttribute(ID, id);
            request.setAttribute(CAR, car);
            request.setAttribute(MSID, car.getMotorShowId());
            request.setAttribute(MSHOWS, Collections.EMPTY_LIST);
        } else {
            List<MotorShow> mShows = this.motorShowService.getAllMotorShowsForRegistration();
            request.setAttribute(MSHOWS, mShows);
            request.setAttribute(ID, nullId);
            request.setAttribute(MSID, nullId);
        }
        request.setAttribute(ERRS, Collections.EMPTY_MAP);
        request.getRequestDispatcher(CAREDIT).forward(request, response);
    }
}




