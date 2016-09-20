package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.exception.ValidException;
import project.model.Car;
import project.model.MotorShow;
import project.model.Page;
import project.service.CarService;
import project.service.MotorShowService;
import project.service.PageService;

import java.util.List;
import java.util.Objects;

import static project.constants.AttributeConst.*;
import static project.constants.CarConst.*;
import static project.constants.MotorShowConst.MID;
import static project.constants.PagesConst.*;

@Controller
public class MotorShowController {

    private final CarService carService;
    private final PageService pageService;
    private final MotorShowService motorShowService;

    @Autowired
    public MotorShowController(CarService carService, PageService pageService, MotorShowService motorShowService) {
        this.carService = carService;
        this.pageService = pageService;
        this.motorShowService = motorShowService;
    }

    @RequestMapping(value = "/motor_show/cars/{id}", method = RequestMethod.GET)
    public String motorShowAllCars(@PathVariable(ID) Integer motorShowId, Model model, Integer pageNumber, Integer pageSize, String searchValue, String searchCategory) {
        Object parsedSearchValue;
        if (Objects.equals(searchCategory, PRICE) || Objects.equals(searchCategory, EVOL)) {
            parsedSearchValue = Double.parseDouble(searchValue);
        } else {
            parsedSearchValue = searchValue;
        }
        List<Car> cars;
        Page page;
        if (searchValue == null && searchCategory == null) {
            page = pageService.getPageForCarsInMotorShow(pageSize, pageNumber, motorShowId);
            cars = carService.getCarsByMSId(motorShowId, page.getPageNumber(), page.getPageSize());
        } else {
            page = pageService.getPageForSearchCarsInMotorShow(pageSize, pageNumber, parsedSearchValue, searchCategory, motorShowId);
            cars = carService.getCarsBySearchInMotorShow(motorShowId, parsedSearchValue, searchCategory, page.getPageNumber(), page.getPageSize());
            model.addAttribute(SEARCH_VALUE, parsedSearchValue);
        }
        model.addAttribute(CARS, cars);
        model.addAttribute(PAGE, page);
        model.addAttribute(MOTOR_SHOW, motorShowService.getMShowById(motorShowId));
        return MSALLCARS;
    }

    @RequestMapping("/motor_show/list")
    public String motorShowAll(Model model, Integer pageNumber, Integer pageSize, String searchValue, String searchCategory) {

        List<MotorShow> motorShows;
        Page page;
        if (searchValue == null && searchCategory == null) {
            page = pageService.getPageForAllMotorShows(pageSize, pageNumber);
            motorShows = motorShowService.getAllMotorShows(page.getPageNumber(), page.getPageSize());
            model.addAttribute(SEARCH_VALUE, null);
        } else {
            page = pageService.getPageForSearchMotorShows(pageSize, pageNumber, searchValue, searchCategory);
            motorShows = motorShowService.getMotorShowsBySearch(searchValue, searchCategory, page.getPageNumber(), page.getPageSize());
            model.addAttribute(SEARCH_VALUE, searchValue);
        }
        model.addAttribute(MOTOR_SHOWS, motorShows);
        model.addAttribute(PAGE, page);
        return MSALL;
    }

    @RequestMapping(value = "/motor_show/edit/{id}", method = RequestMethod.GET)
    public String motorShowEdit(@PathVariable(ID) Integer id, Model model) {

        MotorShow motorShow = motorShowService.getMShowById(id);
        model.addAttribute(MID, id);
        model.addAttribute(MOTOR_SHOW, motorShow);
        return MSEDIT;
    }

    @RequestMapping("/motor_show/add")
    public String motorShowAdd(Model model) {

        model.addAttribute(MOTOR_SHOW, new MotorShow());
        return MSEDIT;
    }

    @RequestMapping(value = "/motor_show/save", method = RequestMethod.POST)
    public String motorShowSave(@ModelAttribute(MOTOR_SHOW) MotorShow motorShow, Model model) {

        try {
            motorShowService.mShowSave(motorShow);
            return MSALLCONT;
        } catch (ValidException validException) {
            model.addAttribute(MOTOR_SHOW, motorShow);
            model.addAttribute(ERRS, validException.getErrs());
            return MSEDIT;
        }
    }

    @RequestMapping(value = "/motor_show/delete/{id}", method = RequestMethod.GET)
    public String motorShowDelete(@PathVariable(ID) Integer id) {

        motorShowService.delete(id);
        return MSALLCONT;
    }
}
