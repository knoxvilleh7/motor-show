package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project.exception.ValidException;
import project.model.Car;
import project.model.MotorShow;
import project.model.Page;
import project.service.CarService;
import project.service.MotorShowService;
import project.service.PageService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static project.constants.AttributeConst.*;
import static project.constants.CarConst.*;
import static project.constants.PagesConst.*;


@Controller
public class CarController {

    private final CarService carService;
    private final PageService pageService;
    private final MotorShowService motorShowService;

    @Autowired
    public CarController(MotorShowService motorShowService, PageService pageService, CarService carService) {
        this.motorShowService = motorShowService;
        this.pageService = pageService;
        this.carService = carService;
    }

    @RequestMapping("/car/list")
    public String carShowAll(Model model, Integer pageNumber, Integer pageSize, String searchValue, String searchCategory) {
        Object parsedSearchValue;
        if (Objects.equals(searchCategory, PRICE) || Objects.equals(searchCategory, EVOL)) {
            parsedSearchValue = Double.parseDouble(searchValue);
        } else {
            parsedSearchValue = searchValue;
        }
        List<Car> cars;
        Page page;
        if (searchValue == null && searchCategory == null) {
            page = pageService.getPageForAllCars(pageSize, pageNumber);
            cars = carService.getCars(page.getPageNumber(), page.getPageSize());
        } else {
            page = pageService.getPageForSearchCars(pageSize, pageNumber, parsedSearchValue, searchCategory);
            cars = carService.getCarsBySearch(parsedSearchValue, searchCategory, page.getPageNumber(), page.getPageSize());
            model.addAttribute(SEARCH_VALUE, parsedSearchValue);
        }
        model.addAttribute(CARS, cars);
        model.addAttribute(PAGE, page);
        return CARSALL;
    }

    @RequestMapping(value = "/car/edit/{id}", method = RequestMethod.GET)
    public String carEdit(@PathVariable(ID) Integer id, ModelMap model) {

        Car car = carService.getCarById(id);
        model.addAttribute(ID, id);
        model.addAttribute(CAR, car);
        return CAREDIT;
    }

    @RequestMapping(value = "/car/copy/{id}", method = RequestMethod.GET)
    public String carCopy(@PathVariable(ID) Integer id, ModelMap model) {
        Car car = carService.getCarById(id);
        car.setId(null);
        car.setMotorShow(null);
        car.setVinCode(null);
        List<MotorShow> mShows = motorShowService.getAllMotorShowsForRegistration();
        model.addAttribute(MOTOR_SHOWS, mShows);
        model.addAttribute(CAR, car);
        return CAREDIT;
    }

    @RequestMapping("/car/add")
    public String carAdd(Model model) {
        List<MotorShow> mShows = motorShowService.getAllMotorShowsForRegistration();
        model.addAttribute(MOTOR_SHOWS, mShows);
        model.addAttribute(CAR, new Car());
        return CAREDIT;
    }

    @RequestMapping(value = "/car/save", method = RequestMethod.POST)
    public String carSave(@ModelAttribute(CAR) Car car, Model model) {

        try {
            carService.saveCar(car);
            return CARSOFMS + car.getMotorShow().getId().toString();
        } catch (ValidException validException) {
            List<MotorShow> mShows = motorShowService.getAllMotorShowsForRegistration();
            model.addAttribute(MOTOR_SHOWS, mShows);
            model.addAttribute(ID, car.getId());
            model.addAttribute(CAR, car);
            model.addAttribute(ERRS, validException.getErrs());
            return CAREDIT;
        }
    }

    @RequestMapping(value = "/car/delete/{id}/{motorShowId}", method = RequestMethod.GET)
    public String carDelete(@PathVariable(ID) Integer id, @PathVariable(MSID) Integer motorShowId) {
        carService.deleteCar(id);
        return CARSOFMS + motorShowId.toString();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
