package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.MyExcep;
import project.model.MotorShow;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.transformer.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 16.08.2016.
 */
public class SaveShow implements RequestInterface {
    private MotorShow motorShow = new MotorShow();
    private MShowService mShowService = new MShowServiceImpl();

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        motorShow = Transformer.getMotorShowParams(request);
        try {
            mShowService.mShowSave(motorShow);
        } catch (MyExcep myExcep) {
            request.setAttribute("show", motorShow);
            request.setAttribute("errs", myExcep.getErrs());
            request.getRequestDispatcher("/pages/editshow.jsp").forward(request, response);

        }
        response.sendRedirect("/motorshows");
    }
}
