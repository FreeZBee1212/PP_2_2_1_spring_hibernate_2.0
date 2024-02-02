package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.jvm.hotspot.debugger.Address;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void add(Car car) { userDao.add(car);}   // mb delete

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Autowired
   private SessionFactory sessionFactory;
   public User getUserByCarModelAndSeries(String carModel, String carSeries) {
      String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :carModel AND c.series = :carSeries";
      Session entityManager = null;
      TypedQuery<User> query = entityManager.createQuery(hql, User.class);
      query.setParameter("carModel", carModel);
      query.setParameter("carSeries", carSeries);
      return query.getSingleResult();
   }


}

