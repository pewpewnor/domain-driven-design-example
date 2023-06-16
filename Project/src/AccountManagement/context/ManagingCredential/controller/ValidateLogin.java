package AccountManagement.context.ManagingCredential.controller;

import AccountManagement.model.*;
import AccountManagement.repository.*;
import utils.*;

public class ValidateLogin {

  public static Student getStudent() {

    Student student = null;

    while (student == null) {
      String email = Help.strPrompt("Email: ", 1);
      String password = Help.strPrompt("Password: ", 1);

      student = StudentRepository.getInstance().findByCredential(email, password);
    }
    return student;
  }

  public static Teacher getTeacher() {
    Teacher teacher = null;
    while (teacher == null) {
      String email = Help.strPrompt("Email: ", 1);
      String password = Help.strPrompt("Password: ", 1);

      teacher = TeacherRepository.getInstance().findByCredential(email, password);
    }

    return teacher;
  }
}
