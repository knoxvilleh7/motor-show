package project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Page;
import project.transformer.Transformer;

import javax.servlet.http.HttpServletRequest;

import static project.constants.PagesConst.DEFAULT_PAGE_NUMBER;
import static project.constants.PagesConst.DEFAULT_PAGE_SIZE;
import static project.constants.PagesConst.NULL_OBJECTS_PAGE;

@Service
@Transactional
public class PageServiceImpl implements PageService {

    private MotorShowService motorShowService;
    private CarService carService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public Page getPageForAllCars(HttpServletRequest request){
        Page page;
        page = pageProcessing(request);
        Long count = carService.getCarCount();
        page.setPageCount(getNumberOfPages(count, page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForSearchCars(HttpServletRequest request, Object searchValue, String searchCategory){
        Page page;
        page = pageProcessing(request);
        page.setPageCount(getNumberOfPages(this.carService.getCarForSearchCount(searchValue, searchCategory), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForCarsInMotorShow(HttpServletRequest request, Integer motorShowId){
        Page page;
        page = pageProcessing(request);
        page.setPageCount(getNumberOfPages(this.carService.getCarOfShowCount(motorShowId), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForSearchCarsInMotorShow(HttpServletRequest request, Object searchValue, String searchCategory, Integer motorShowId){
        Page page;
        page = pageProcessing(request);
        page.setPageCount(getNumberOfPages(this.carService.getCarForSearchCountInMotorShow(searchValue, searchCategory, motorShowId), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForAllMotorShows(HttpServletRequest request){
        Page page;
        page = pageProcessing(request);
        page.setPageCount(getNumberOfPages(this.motorShowService.getMotorShowCount(), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    public Page getPageForSearchMotorShows(HttpServletRequest request, Object searchValue, String searchCategory){
        Page page;
        page = pageProcessing(request);
        page.setPageCount(getNumberOfPages(this.motorShowService.getMotorShowForSearchCount(searchValue, searchCategory), page.getPageSize()));
        getButtonsStatement(page);
        return page;
    }

    private Page pageProcessing(HttpServletRequest request) {

        Page page = Transformer.getPageParam(request);
        if (page.getPageSize() == null) {
            page.setPageSize(DEFAULT_PAGE_SIZE);
        }
        if (page.getPageNumber() == null) {
            page.setPageNumber(DEFAULT_PAGE_NUMBER);
        }
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
