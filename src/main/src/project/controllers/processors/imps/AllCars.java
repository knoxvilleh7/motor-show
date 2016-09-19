package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.dao.CarDao;
import project.dao.CarDaoImpl;
import project.model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 16.08.2016.
 */
public class AllCars implements RequestInterface {
    private CarDao carDao = new CarDaoImpl();
    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Car> cars = carDao.getCars();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/pages/cars.jsp").forward(request, response);
    }
}
