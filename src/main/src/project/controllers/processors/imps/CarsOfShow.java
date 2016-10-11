package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.model.Car;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 16.08.2016.
 */
public class CarsOfShow implements RequestInterface {
    private final CarService carService = new CarServiceImpl();
    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String i = request.getParameter("MS");
        int msid = Integer.parseInt(i);
        List<Car> cars = carService.getCarsByMSId (msid);
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/pages/mscars.jsp").forward(request, response);
        request.getRequestDispatcher("/pages/mscars.jsp").include(request, response);
    }
}
