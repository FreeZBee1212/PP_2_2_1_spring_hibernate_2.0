package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      Car car1 = new Car("GTR", 600);
//      Car car2 = new Car("BMW", 3);
//      Car car3 = new Car("Lada", 1);
//
//      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
//      User user2 = new User("User1", "Lastname1", "user1@mail.ru");
//      User user3 = new User("User1", "Lastname1", "user1@mail.ru");
//
//      user1.setCar(car1);
//      userService.add(user1);
//
//      user2.setCar(car2);
//      userService.add(user2);
//
//      user3.setCar(car3);
//      userService.add(user3);

      UserDaoImp us0 = new UserDaoImp();
      UserServiceImp us = new UserServiceImp();
      us0.getUserByCarModelAndSeries("GTR", "600");



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
