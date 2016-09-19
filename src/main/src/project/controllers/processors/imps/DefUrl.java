package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 15.08.2016.
 */
public class DefUrl implements RequestInterface {

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameterMap().isEmpty()) {
            request.getRequestDispatcher("pages/index.jsp").forward(request, response);
        }
    }
}
