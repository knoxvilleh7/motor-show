package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import project.controllers.processors.RequestInterface;
import project.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class MainProcessor implements HttpRequestHandler {

    private Map map;

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().replace(req.getContextPath(),"");
        System.out.println(url);
        RequestInterface requestInterface = (RequestInterface) map.get(url);
        if (requestInterface != null) {
            try {
                requestInterface.method(req, resp);
            } catch (DaoException | ExceptionInInitializerError e) {
                e.printStackTrace();
            }
        }
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
