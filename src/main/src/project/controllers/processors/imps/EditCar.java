package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.dao.MotorShowDao;
import project.dao.MotorShowDaoImpl;
import project.model.Car;
import project.model.MotorShow;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16.08.2016.
 */
public class EditCar implements RequestInterface {
    private Car car = new Car();
    private CarService carService = new CarServiceImpl();
    private List<MotorShow> mShows = new ArrayList<MotorShow>();
    private MotorShowDao motorShowDao = new MotorShowDaoImpl();
    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String i = request.getParameter("car");
        int id = Integer.parseInt(i);
        car = carService.getCarById(id);
        mShows = motorShowDao.getMotorShows();
        request.setAttribute("car", car);
        request.setAttribute("shows", mShows);
        request.getRequestDispatcher("/pages/editcar.jsp").forward(request, response);
    }
}
