package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.dao.MotorShowDao;
import project.dao.MotorShowDaoImpl;
import project.model.MotorShow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 15.08.2016.
 */
public class AllShows implements RequestInterface {
    private MotorShowDao motorShowDao = new MotorShowDaoImpl();


    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MotorShow> mShow = motorShowDao.getMotorShows();
        request.setAttribute("show", mShow);
        request.getRequestDispatcher("/pages/motorshows.jsp").forward(request, response);
    }
}
