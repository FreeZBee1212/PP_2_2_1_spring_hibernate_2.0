package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(Car car);
   void add(User user);
   List<User> listUsers();
   public User getUserByCarModelAndSeries(String model, int series);
}
