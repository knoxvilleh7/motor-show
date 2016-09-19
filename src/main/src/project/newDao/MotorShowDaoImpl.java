package project.newDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import project.model.MotorShow;

import java.util.List;

@Repository
public class MotorShowDaoImpl extends NewDaoGenericsImpl<MotorShow> implements MotorShowDao {

    public MotorShowDaoImpl(Class aClass) {
        super(aClass);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<MotorShow> getAllMotorShowsForRegistration() {
        Session session = sessionFactory.getCurrentSession();
        List<MotorShow> objects = null;
        try {
            objects = (List<MotorShow>) session.createCriteria(aClass).list();
        } catch (RuntimeException ignored) {
        }
        return objects;
    }
}
