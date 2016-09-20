package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Page;
import project.service.CarService;
import project.service.MotorShowService;
import project.service.PageService;

import static project.constants.AttributeConst.PAGE_SIZE_FOR_SEARCH;
import static project.constants.PagesConst.*;

@Service
@Transactional
public class PageServiceImpl implements PageService {

    private final MotorShowService motorShowService;
    private final CarService carService;

    @Autowired
    public PageServiceImpl(CarService carService, MotorShowService motorShowService) {
        this.carService = carService;
        this.motorShowService = motorShowService;
    }

    public Page getPageForAllCars(Integer pageSize, Integer pageNumber) {
        Page page;
        page = pageProcessing(pageSize, pageNumber);
        Long count = carService.getCarCount();
        page.setPageCount(getNumberOfPages(count, page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForSearchCars(Integer pageSize, Integer pageNumber, Object searchValue, String searchCategory) {
        Page page;
        page = pageProcessing(PAGE_SIZE_FOR_SEARCH, pageNumber);
        page.setPageCount(getNumberOfPages(carService.getCarForSearchCount(searchValue, searchCategory), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForCarsInMotorShow(Integer pageSize, Integer pageNumber, Integer motorShowId) {
        Page page;
        page = pageProcessing(pageSize, pageNumber);
        page.setPageCount(getNumberOfPages(carService.getCarOfShowCount(motorShowId), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForSearchCarsInMotorShow(Integer pageSize, Integer pageNumber, Object searchValue, String searchCategory, Integer motorShowId) {
        Page page;
        page = pageProcessing(PAGE_SIZE_FOR_SEARCH, pageNumber);
        page.setPageCount(getNumberOfPages(carService.getCarForSearchCountInMotorShow(searchValue, searchCategory, motorShowId), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForAllMotorShows(Integer pageSize, Integer pageNumber) {
        Page page;
        page = pageProcessing(pageSize, pageNumber);
        page.setPageCount(getNumberOfPages(this.motorShowService.getMotorShowCount(), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForSearchMotorShows(Integer pageSize, Integer pageNumber, Object searchValue, String searchCategory) {
        Page page;
        page = pageProcessing(PAGE_SIZE_FOR_SEARCH, pageNumber);
        page.setPageCount(getNumberOfPages(this.motorShowService.getMotorShowForSearchCount(searchValue, searchCategory), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    private Page pageProcessing(Integer pageSize, Integer pageNumber) {
        Page page = new Page();
        Integer size = (pageSize == null) ? DEFAULT_PAGE_SIZE : pageSize;
        Integer number = (pageNumber == null) ? DEFAULT_PAGE_NUMBER : pageNumber;
        page.setPageSize(size);
        page.setPageNumber(number);
        return page;
    }

    private Page getButtonsStatement(Page page) {
        page.setToNext(page.getPageNumber() < page.getPageCount());
        page.setToPrev(page.getPageNumber() > 1);
        return page;
    }

    public Long getNumberOfPages(Long objects, Integer pageSize) {
        if (objects == 0) {
            return NULL_OBJECTS_PAGE;
        }
        Long l = (objects / pageSize);
        if (objects % pageSize != 0) {
            l++;
        }
        return l;
    }
}
