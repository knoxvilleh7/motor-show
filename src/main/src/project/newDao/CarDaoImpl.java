package project.newDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.model.Car;

import java.util.List;

@Component
@Transactional
public class CarDaoImpl extends NewDaoGenericsImpl<Car> implements CarDao {

    public CarDaoImpl() {
        super(Car.class);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize) {

        Session session = sessionFactory.openSession();
        List<Car> cars = null;
        try {

            Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("motorShow.id", MotorShowId));
            criteria.setFirstResult((pageNumber - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            cars = criteria.list();
        } catch (RuntimeException ignored) {
        }
        return cars;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Car getByVin(String vinCode) {
        Session session = sessionFactory.openSession();
        Car car = null;
        try {
            Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("vinCode", vinCode));
            List<Car> result = criteria.list();
            if (result != null && !result.isEmpty()) {
                car = result.get(0);
            }
        } catch (RuntimeException ignored) {
        }
        return car;
    }
}

