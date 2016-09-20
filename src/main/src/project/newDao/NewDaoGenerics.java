package project.newDao;

import java.util.List;


interface NewDaoGenerics<T> {

    String HQL_CAR_COUNT = "select count (*) from Car car";
    String HQL_CAR_COUNT_OF_MOTOR_SHOW = "select count (*) from Car car where car.motorShow.id=:id";
    String HQL_MOTOR_SHOW_COUNT = "select count (*) from MotorShow motorShow";

    void saveOrUpdate(T obj);

    T getById(Integer id);

    List<T> getAll(Integer pageNumber, Integer pageSize);

    void delete(T obj);

    Long getCount(String table, Integer id);

    Long getCountForSearch(Object  searchValue,String searchCategory, Integer id);

    List<T> getObjectsForSearch(Integer id, Object searchValue, String searchCategory, Integer pageNumber, Integer pageSize);
}
