package project.newDao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
class NewDaoGenericsImpl<T> implements NewDaoGenerics<T> {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Class aClass;

    NewDaoGenericsImpl(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public void saveOrUpdate(T obj) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        T obj = null;
        try {
            obj = (T) session.get(aClass, id);
        } catch (RuntimeException ignored) {
        }
        return obj;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll(Integer pageNumber, Integer pageSize) {

        Session session = sessionFactory.getCurrentSession();
        List<T> objects = null;
        try {
            Criteria criteria = session.createCriteria(aClass);
            criteria.setFirstResult((pageNumber - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            objects = (List<T>) criteria.list();
        } catch (RuntimeException ignored) {
        }
        return objects;
    }

    @Override
    public void deleteById(T obj) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(obj);
        } catch (RuntimeException ignored) {
        }
    }

    public Long getCount(String table, Integer id) {
        Query query;
        Long count = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            if (Objects.equals(table, "car")) {
                if (id == null) {
                    query = session.createQuery(HQL_CAR_COUNT);
                } else {
                    query = session.createQuery(HQL_CAR_COUNT_OF_MOTOR_SHOW);
                    query.setParameter("id", id);
                }
            } else {
                query = session.createQuery(HQL_MOTOR_SHOW_COUNT);
            }
            count = (Long) query.uniqueResult();
        } catch (RuntimeException ignored) {
        }
        return count;
    }

    public Long getCountForSearch(Object searchValue, String searchCategory, Integer id) {
        Long count = null;
        Criteria criteria;
        Session session = sessionFactory.getCurrentSession();
        try {
            criteria = session.createCriteria(aClass);
            if (id != null) {
                criteria.add(Restrictions.like("motorShowId", id));
            }
            criteria.add(Restrictions.like(searchCategory, searchValue));
            criteria.setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
        } catch (RuntimeException ignored) {
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public List<T> getObjectsForSearch(Integer id, Object searchValue, String searchCategory, Integer pageNumber, Integer pageSize) {
        List<T> objects = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            Criteria criteria = session.createCriteria(aClass).add(Restrictions.like(searchCategory, searchValue));
            if (id != null) {
                criteria.add(Restrictions.like("motorShowId", id));
            }
            criteria.setFirstResult((pageNumber - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            objects = criteria.list();
        } catch (RuntimeException ignored) {
        }
        return objects;
    }
}

