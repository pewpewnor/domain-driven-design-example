package AccountManagement.context.ManagingCredential.controller;

import AccountManagement.model.*;
import AccountManagement.repository.*;
// import view.LandingPage;
import utils.*;

public class ValidateLogin {

  public static Student getStudent() {
    Student student = null;

    String email = Help.strPrompt("Email: ", 1);
    String password = Help.strPrompt("Password: ", 1);

    student = StudentRepository.getInstance().findByCredential(email, password);

    if (student == null) {
      System.out.println("Login credential is incorrect!");
      Help.pause();
    }

    return student;
  }

  public static Teacher getTeacher() {
    Teacher teacher = null;

    String email = Help.strPrompt("Email: ", 1);
    String password = Help.strPrompt("Password: ", 1);

    teacher = TeacherRepository.getInstance().findByCredential(email, password);

    if (teacher == null) {
      System.out.println("Login credential is incorrect!");
      Help.pause();
    }

    return teacher;
  }
}
