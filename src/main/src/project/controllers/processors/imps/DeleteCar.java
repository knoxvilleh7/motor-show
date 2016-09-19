package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.model.Car;
import project.sevice.CarService;
import project.sevice.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 16.08.2016.
 */
public class DeleteCar implements RequestInterface {
    private Car car = new Car();
    private CarService carService = new CarServiceImpl();
    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String i = request.getParameter("car");
        int id = Integer.parseInt(i);
        car = carService.getCarById(id);
        int mid = car.getMotorShowId();
        carService.deleteCar(id);
        response.sendRedirect("/mscars?MS="+mid);
    }
}
