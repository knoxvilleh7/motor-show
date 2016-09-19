package project.sevice;

import project.dao.MotorShowDao;
import project.dao.MotorShowDaoImpl;
import project.exception.MyExcep;
import project.model.MotorShow;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

/**
 * Created on 15.08.2016.
 */
public class MShowServiceImpl implements MShowService {

    private MotorShowDao motorShowDao = new MotorShowDaoImpl();
    private ModelValidator mv = new ModelValidator();

    public void mShowSave(MotorShow motorShow) throws MyExcep {
        Map<String, List<String>> errs = mv.mValid(motorShow);
        if (errs.isEmpty()) {
            motorShowDao.saveMotorShow(motorShow);
        }else {
            throw new MyExcep(errs);
        }
    }

    public MotorShow getMShowById(Integer id) {
        MotorShow ms = motorShowDao.getMotorShowById(id);
        return ms;
    }

    public void deleteMShow(Integer id) {
        motorShowDao.deleteMotorShow(id);
    }
}
