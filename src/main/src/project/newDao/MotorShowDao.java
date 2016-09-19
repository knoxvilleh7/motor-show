package project.newDao;

import project.model.MotorShow;

import java.util.List;

public interface MotorShowDao extends NewDaoGenerics<MotorShow>{

    List<MotorShow> getAllMotorShowsForRegistration();

}
