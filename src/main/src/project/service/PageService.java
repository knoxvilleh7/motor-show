package project.service;

import project.model.Page;

public interface PageService {

    Long getNumberOfPages(Long Cars, Integer NumberOfCars);

    Page getPageForAllCars(Integer pageSize, Integer pageNumber );

    Page getPageForSearchCars(Integer pageSize, Integer pageNumber , Object searchValue, String searchCategory);

    Page getPageForAllMotorShows(Integer pageSize, Integer pageNumber );

    Page getPageForSearchMotorShows(Integer pageSize, Integer pageNumber , Object searchValue, String searchCategory);

    Page getPageForCarsInMotorShow(Integer pageSize, Integer pageNumber , Integer motorShowId);

    Page getPageForSearchCarsInMotorShow(Integer pageSize, Integer pageNumber , Object searchValue, String searchCategory, Integer motorShowId);
}
