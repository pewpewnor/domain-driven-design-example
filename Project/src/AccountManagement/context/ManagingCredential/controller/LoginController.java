package AccountManagement.context.ManagingCredential.controller;

import AccountManagement.model.*;
import AccountManagement.repository.*;

public class LoginController {

  public static Student getStudent(String email, String password) {
    return StudentRepository.getInstance().findByCredential(email, password);
  }

  public static Teacher getTeacher(String email, String password) {
    return TeacherRepository.getInstance().findByCredential(email, password);
  }
}
