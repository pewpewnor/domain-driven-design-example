package AccountManagement.context.ManagingCredential.controller;

import AccountManagement.context.ManagingCredential.events.CreateAccountEvent;
import AccountManagement.repository.*;
import utils.*;

public class RegisterController {

    public static void createStudentAccount(CreateAccountEvent createAccountEvent) {
        StudentRepository.getInstance().insert(createAccountEvent.getName(), createAccountEvent.getEmail(),
                createAccountEvent.getPassword());
    }

    public static void createTeacherAccount(CreateAccountEvent createAccountEvent) {
        TeacherRepository.getInstance().insert(createAccountEvent.getName(), createAccountEvent.getEmail(),
                createAccountEvent.getPassword());
    }

    public static boolean isValidEmail(String email) {
        return Help.isValidEmail(email);
    }

    public static boolean isValidPassword(String password) {
        return Help.isAlphaNumeric(password) && Help.hasUpperCase(password);
    }

    public static boolean samePassword(String password1, String password2) {
        return password1.equals(password2);
    }

}