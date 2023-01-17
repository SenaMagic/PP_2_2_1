package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {


    private SessionFactory sessionFactory;
    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User getUserByCar(String model, int series) throws NoResultException {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE id = (SELECT id FROM Car WHERE model = :model AND series = :series)");
        query.setParameter("model", model).setParameter("series", series);
        return query.setMaxResults(1).getSingleResult();
    }
}
