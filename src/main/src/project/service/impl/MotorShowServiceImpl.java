package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.exception.ValidException;
import project.model.MotorShow;
import project.newDao.MotorShowDao;
import project.service.MotorShowService;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

import static project.constants.AttributeConst.MOTOR_SHOW;

@Service
@Transactional
public class MotorShowServiceImpl implements MotorShowService {

    private final MotorShowDao motorShowDao;

    private ModelValidator mv = new ModelValidator();

    @Autowired
    public MotorShowServiceImpl(MotorShowDao motorShowDao) {
        this.motorShowDao = motorShowDao;
    }

    public void mShowSave(MotorShow motorShow) throws ValidException{
        Map<String, List<String>> errs = mv.mValid(motorShow);
        if (errs.isEmpty()) {
            this.motorShowDao.saveOrUpdate(motorShow);
        } else {
            throw new ValidException(errs);
        }
    }

    public MotorShow getMShowById(Integer id){
        return motorShowDao.getById(id);
    }

    public void delete(Integer id){
        motorShowDao.delete(motorShowDao.getById(id));
    }

    public List<MotorShow> getAllMotorShows(Integer pageNumber, Integer pageSize){
        return motorShowDao.getAll(pageNumber, pageSize);
    }

    public List<MotorShow> getAllMotorShowsForRegistration() {return motorShowDao.getAllMotorShowsForRegistration();
    }

    public Long getMotorShowCount() {
        return this.motorShowDao.getCount(MOTOR_SHOW, null);
    }

    public Long getMotorShowForSearchCount(Object searchValue, String searchCategory) {
        return motorShowDao.getCountForSearch(searchValue,searchCategory, null);
    }

    public List<MotorShow> getMotorShowsBySearch(Object searchValue, String searchCategory, Integer PageNumber, Integer PageSize) {
        return motorShowDao.getObjectsForSearch(null, searchValue, searchCategory, PageNumber, PageSize);
    }
}
