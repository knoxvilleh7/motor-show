package project.controllers.processors;

import project.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface RequestInterface {

    void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException;
}
