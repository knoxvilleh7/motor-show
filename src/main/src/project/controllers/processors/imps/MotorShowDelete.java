package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.service.MotorShowService;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static project.constants.AttributeConst.MSID;
import static project.constants.PagesConst.MSALLCONT;

public class MotorShowDelete implements RequestInterface {

    private MotorShowService motorShowService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        this.motorShowService.delete(Util.getInteger(request, MSID));
        response.sendRedirect(MSALLCONT);
    }
}
