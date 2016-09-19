package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.model.MotorShow;
import project.sevice.MShowService;
import project.sevice.MShowServiceImpl;
import project.transformer.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 15.08.2016.
 */
public class CreateShow implements RequestInterface {

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameterMap().isEmpty()) {
            request.getRequestDispatcher("pages/createshow.jsp").forward(request, response);
        }
//        else {
//            MotorShow motorShow = Transformer.getMotorShowParams(request);
//            mShowService.mShowSave(motorShow);
//
//        }
    }
}