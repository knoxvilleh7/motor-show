package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.dao.MotorShowDao;
import project.dao.MotorShowDaoImpl;
import project.exception.MyExcep;
import project.model.Car;
import project.model.MotorShow;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;
import project.transformer.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16.08.2016.
 */
public class SaveCar implements RequestInterface {
    private CarService carService = new CarServiceImpl();
    private MotorShowDao motorShowDao = new MotorShowDaoImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Car car = Transformer.getCarParam(request);
        String msname = request.getParameter("motorShow");

        MotorShow motorShow = motorShowDao.getMotorShowByName(msname);
                car.setMotorShowId(motorShow.getId());
        try {
            carService.saveCar(car);
            Integer i = motorShow.getId();
            response.sendRedirect("/mscars?MS=" + i);
        } catch (MyExcep myExcep) {
            List<MotorShow> mShows = motorShowDao.getMotorShows();
            request.setAttribute("shows", mShows);
            request.setAttribute("errs", myExcep.getErrs());
            request.getRequestDispatcher("pages/createcar.jsp").forward(request, response);
        }

    }
}
