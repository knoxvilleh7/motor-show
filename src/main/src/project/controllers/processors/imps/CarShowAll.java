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
import static project.constants.PagesConst.CARSALL;

public class CarShowAll implements RequestInterface {

    private CarService carService;
    private PageService pageService;

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

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
            page = pageService.getPageForAllCars(request);
            cars = carService.getCars(page.getPageNumber(), page.getPageSize());
        }else {
            page = pageService.getPageForSearchCars(request, searchValue, searchCategory);
            cars = carService.getCarsBySearch(searchValue, searchCategory, page.getPageNumber(), page.getPageSize());
        }
        request.setAttribute(CARS, cars);
        request.setAttribute(PAGE, page);
        request.getRequestDispatcher(CARSALL).forward(request, response);
    }


}

