package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.dao.MotorShowDao;
import project.dao.MotorShowDaoImpl;
import project.model.MotorShow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16.08.2016.
 */
public class CreateCar implements RequestInterface {
    private List<MotorShow> mShows = new ArrayList<MotorShow>();
    private MotorShowDao motorShowDao = new MotorShowDaoImpl();
    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameterMap().isEmpty()) {
            mShows = motorShowDao.getMotorShows();
            request.setAttribute("shows", mShows);
            request.getRequestDispatcher("pages/createcar.jsp").forward(request, response);
        }
    }
}
