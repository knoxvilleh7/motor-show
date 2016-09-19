package project.controllers.processors.imps;

import project.controllers.processors.RequestInterface;
import project.exception.DaoException;
import project.model.MotorShow;
import project.model.Page;
import project.service.MotorShowService;
import project.service.PageService;
import project.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static project.constants.AttributeConst.*;
import static project.constants.PagesConst.MSALL;

public class MotorShowShowAll implements RequestInterface {


    private MotorShowService motorShowService;
    private PageService pageService;

    public void setMotorShowService(MotorShowService motorShowService) {
        this.motorShowService = motorShowService;
    }

    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    public void method(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, DaoException {

        String searchValue = Util.getString(request, SEARCH);
        String searchCategory = Util.getString(request, SEARCH_BY);
        List<MotorShow> motorShows;
        Page page;
        if (searchValue == null && searchCategory == null) {
            page = this.pageService.getPageForAllMotorShows(request);
            motorShows = motorShowService.getAllMotorShows(page.getPageNumber(), page.getPageSize());
        } else {
            page = this.pageService.getPageForSearchMotorShows(request, searchValue, searchCategory);
            motorShows = this.motorShowService.getMotorShowsBySearch(searchValue, searchCategory, page.getPageNumber(), page.getPageSize());
        }
        request.setAttribute(MOTORSHOW, motorShows);
        request.setAttribute(PAGE, page);
        request.getRequestDispatcher(MSALL).forward(request, response);
    }
}

