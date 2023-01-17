package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);


      User userOne = new User("User1", "Lastname1", "user1@mail.ru");
      userService.add(userOne);
      carService.addCar(new Car("Porsche", 911, userOne));
      User userTwo = new User("User2", "Lastname2", "user2@mail.ru");
      userService.add(userTwo);
      carService.addCar(new Car("Peugeot", 107, userTwo));
      User userThree = new User("User3", "Lastname3", "user3@mail.ru");
      userService.add(userThree);
      carService.addCar(new Car("Skoda", 1, userThree));
      User userFour = new User("User4", "Lastname4", "user4@mail.ru");
      userService.add(userFour);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
      }

      System.out.println(carService.getUserByCar("Porsche", 911));

      context.close();
   }
}
