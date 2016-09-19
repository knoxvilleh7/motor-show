package project.controllers.processors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 15.08.2016.
 */
public interface RequestInterface {

    void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
