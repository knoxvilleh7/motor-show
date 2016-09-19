package project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.exception.ValidException;
import project.model.MotorShow;
import project.newDao.MotorShowDao;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

import static project.constants.AttributeConst.MOTORSHOW;

@Service
@Transactional
public class MotorShowServiceImpl implements MotorShowService {

    private MotorShowDao motorShowDao;

    public void setMotorShowDao(MotorShowDao motorShowDao) {
        this.motorShowDao = motorShowDao;
    }

    private ModelValidator mv = new ModelValidator();

    public void mShowSave(MotorShow motorShow) throws ValidException{
        Map<String, List<String>> errs = mv.mValid(motorShow);
        if (errs.isEmpty()) {
            this.motorShowDao.saveOrUpdate(motorShow);
        } else {
            throw new ValidException(errs);
        }
    }

    public MotorShow getMShowById(Integer id){
        return this.motorShowDao.getById(id);
    }

    public void delete(Integer id){
        this.motorShowDao.deleteById(this.motorShowDao.getById(id));
    }

    public List<MotorShow> getAllMotorShows(Integer pageNumber, Integer pageSize){
        return motorShowDao.getAll(pageNumber, pageSize);
    }

    public List<MotorShow> getAllMotorShowsForRegistration() {return this.motorShowDao.getAllMotorShowsForRegistration();
    }

    public Long getMotorShowCount() {
        return this.motorShowDao.getCount(MOTORSHOW, null);
    }

    public Long getMotorShowForSearchCount(Object searchValue, String searchCategory) {
        return this.motorShowDao.getCountForSearch(searchValue,searchCategory, null);
    }

    public List<MotorShow> getMotorShowsBySearch(Object searchValue, String searchCategory, Integer PageNumber, Integer PageSize) {
        return this.motorShowDao.getObjectsForSearch(null, searchValue, searchCategory, PageNumber, PageSize);
    }

}
