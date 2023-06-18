package view;

import AccountManagement.context.ManagingCredential.controller.LoginController;
import AccountManagement.model.Student;
import AccountManagement.model.Teacher;
import utils.Help;

public class Login {

  Login() {
    Help.border('=', 100);
    System.out.println("Login As");
    Help.border('=', 100);

    Help.list("Student", "Teacher", "Back");

    int choice = Help.prompt("choice >> ", 1, 3);

    if (choice == 1) {
      String email = Help.strPrompt("Email: ", 1);
      String password = Help.strPrompt("Password: ", 1);

      Student student = LoginController.getStudent(email, password);

      if (student == null) {
        System.out.println("Login credential is incorrect!");
        Help.pause();
      }

      new Home(student);

    } else if (choice == 2) {
      String email = Help.strPrompt("Email: ", 1);
      String password = Help.strPrompt("Password: ", 1);

      Teacher teacher = LoginController.getTeacher(email, password);

      if (teacher == null) {
        System.out.println("Login credential is incorrect!");
        Help.pause();
      }
      new Home(teacher);

    } else if (choice == 3) {
      new LandingPage();
    }
  }

}
