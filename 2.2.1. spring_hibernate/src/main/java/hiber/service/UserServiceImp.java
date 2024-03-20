package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.TypedQuery;
import java.util.List;

/* Как я понял про @Transactional: В итоге лучше ставить аннотацию перед классом, чтобы определять уже в методах
   чтение || чтение & запись, автоматом ставится readOnly = false, поэтому у метода ListUsers readOnly = true,
   ну и соответственно можно перед классом прописывать @Transactional (readOnly=true) и определять нужные методы false,
   но больше методов записей, чем чтения, поэтому преимущество отдаётся стандартному значению readOnly
   А главная суть @Transactional - замена классических транзакций хибернейта, но это не точно. Про уровни изоляции
   пока не разбирался
*/
@Service
@Transactional
public class UserServiceImp implements UserService {


   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public void add(User user) {
      userDao.add(user);
   }



   @Override
   public void add(Car car) { userDao.add(car);}

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }


   @Override
   public User getUserByCarModelAndSeries(String model, int series){
     return userDao.getUserByCarModelAndSeries(model, series);
   }

}

