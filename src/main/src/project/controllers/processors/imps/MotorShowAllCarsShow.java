package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.Car;
import project.model.Page;
import project.service.CarService;
import project.service.PageService;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static project.constants.AttributeConst.*;
import static project.constants.CarConst.EVOL;
import static project.constants.CarConst.PRICE;
import static project.constants.PagesConst.MSALLCARS;

public class MotorShowAllCarsShow implements RequestInterface {

    private CarService carService;
    private PageService pageService;

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        Integer motorShowId = Util.getInteger(request, MSID);
        String searchCategory = Util.getString(request, SEARCH_BY);
        Object searchValue;
        if(Objects.equals(searchCategory, PRICE) || Objects.equals(searchCategory, EVOL)){
            searchValue = Util.getDouble(request, SEARCH);
        }else{
            searchValue = Util.getString(request, SEARCH);
        }
        List<Car> cars;
        Page page;
        if (searchValue == null && searchCategory == null) {
            page = this.pageService.getPageForCarsInMotorShow(request, motorShowId);
            cars = this.carService.getCarsByMSId(motorShowId, page.getPageNumber(), page.getPageSize());
        }else {
            page = this.pageService.getPageForSearchCarsInMotorShow(request, searchValue, searchCategory, motorShowId);
            cars = this.carService.getCarsBySearchInMotorShow(motorShowId, searchValue, searchCategory, page.getPageNumber(), page.getPageSize());
        }
        request.setAttribute(CARS, cars);
        request.setAttribute(PAGE, page);
        request.setAttribute(MSID, motorShowId);
        request.getRequestDispatcher(MSALLCARS).forward(request, response);
    }
}

