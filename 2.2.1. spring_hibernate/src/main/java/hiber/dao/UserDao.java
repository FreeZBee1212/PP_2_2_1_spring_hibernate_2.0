package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(Car car);                  // mb delete
   void add(User user);
   List<User> listUsers();
}
