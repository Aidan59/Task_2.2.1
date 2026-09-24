package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      /*User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");

      user1.setCar(new Car(user1, "car1", 111));
      user2.setCar(new Car(user2, "car2", 222));
      user3.setCar(new Car(user3, "car3", 333));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);*/

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println();
      System.out.println(userService.getUserByCar(new Car(null, "car1", 111)));
      System.out.println();
      System.out.println(userService.getUserByCar(new Car(null, "car2", 222)));
      System.out.println();
      System.out.println(userService.getUserByCar(new Car(null, "car3", 333)));

      context.close();
   }
}
