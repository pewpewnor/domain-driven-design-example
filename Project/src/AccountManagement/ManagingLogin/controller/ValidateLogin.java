package AccountManagement.ManagingCredential.controller;

import model.*;
import service.repository.StudentRepository;
import utils.Help;

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

    }

    return teacher;
  }
}
