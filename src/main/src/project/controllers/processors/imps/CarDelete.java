package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.service.CarService;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.CAR;
import static project.constants.AttributeConst.MSID;
import static project.constants.PagesConst.CARSOFMS;

public class CarDelete implements RequestInterface {

    private CarService carService;

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        this.carService.deleteCar(Util.getInteger(request, CAR));
        response.sendRedirect(CARSOFMS + Util.getInteger(request, MSID));
    }

}

