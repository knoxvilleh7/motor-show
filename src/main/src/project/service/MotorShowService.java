package project.service;

import project.exception.ValidException;
import project.model.MotorShow;

import java.util.List;

public interface MotorShowService {

    void mShowSave(MotorShow motorShow) throws ValidException;

    MotorShow getMShowById(Integer id);

    void delete(Integer id);

    List<MotorShow> getAllMotorShows(Integer pageNumber, Integer pageSize);

    List<MotorShow> getAllMotorShowsForRegistration();

    Long getMotorShowCount();

    Long getMotorShowForSearchCount(Object  searchValue, String searchCategory);

    List<MotorShow> getMotorShowsBySearch(Object searchValue,String searchCategory,Integer PageNumber,Integer PageSize);



}
