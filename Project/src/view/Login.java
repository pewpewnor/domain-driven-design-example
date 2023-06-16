package view;

import AccountManagement.ManagingCredential.controller.ValidateLogin;
import model.*;
import utils.Help;

public class Login {

  Login() {
    Help.border('=', 100);
    System.out.println("Login As");
    Help.border('=', 100);

    Help.list("Student", "Teacher", "Back");

    int choice = Help.prompt("choice >> ", 1, 3);
    Help.cls();

    if (choice == 1) {
      Student student = ValidateLogin.getStudent();
      new Home(student);

    } else if (choice == 2) {
      Teacher teacher = ValidateLogin.getTeacher();
      new Home(teacher);

    } else if (choice == 3) {
      new LandingPage();
    }
  }

}
