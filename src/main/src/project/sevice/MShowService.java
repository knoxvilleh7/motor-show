package project.sevice;

import project.exception.MyExcep;
import project.model.MotorShow;

/**
 * Created on 15.08.2016.
 */
public interface MShowService {

    void mShowSave(MotorShow motorShow) throws MyExcep;

    MotorShow getMShowById(Integer id);

    void deleteMShow(Integer id);
}
