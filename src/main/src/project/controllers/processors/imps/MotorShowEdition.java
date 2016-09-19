package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.service.MotorShowService;
import project.service.MotorShowServiceImpl;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static project.constants.AttributeConst.*;
import static project.constants.PagesConst.MSEDIT;

public class MotorShowEdition implements RequestInterface {

    private MotorShowService motorShowService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        Integer motorShowId = Util.getInteger(request, MSID);
        if (motorShowId != null) {
            request.setAttribute(MOTORSHOW, motorShowService.getMShowById(motorShowId));
        }
        request.setAttribute(ERRS, Collections.EMPTY_MAP);
        request.getRequestDispatcher(MSEDIT).forward(request, response);

    }
}
