package project.controllers;

import project.controllers.processors.RequestInterface;
import project.controllers.processors.imps.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created on 15.08.2016.
 */
public class Controller extends HttpServlet {

    private static final HashMap<String, RequestInterface> PROCESSORS = new HashMap<String, RequestInterface>() {{
        put("/", new DefUrl());
        put("/motorshows", new AllShows());
        put("/createshow", new CreateShow());
        put("/editthisshow", new EditShow());
        put("/mssave", new SaveShow());
        put("/deleteshow", new DeleteShow());
        put("/mscars", new CarsOfShow());
        put("/createcar", new CreateCar());
        put("/carsave", new SaveCar());
        put("/editthiscar", new EditCar());
        put("/deletecar", new DeleteCar());
        put("/cars", new AllCars());
    }};

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        RequestInterface requestInterface = PROCESSORS.get(url);
        if (requestInterface != null) {
            requestInterface.method(req, resp);
        }
    }
}
