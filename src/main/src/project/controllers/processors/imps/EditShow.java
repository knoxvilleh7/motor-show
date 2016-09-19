package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.model.MotorShow;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 16.08.2016.
 */
public class EditShow implements RequestInterface {
    private MotorShow motorShow = new MotorShow();
    private MShowService mShowService = new MShowServiceImpl();
    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String i = request.getParameter("MS");
        int mid = Integer.parseInt(i);
        motorShow = mShowService.getMShowById(mid);
        request.setAttribute("show", motorShow);
        request.getRequestDispatcher("/pages/editshow.jsp").forward(request, response);
    }
}
