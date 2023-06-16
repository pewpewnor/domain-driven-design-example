package AccountManagement.context.ManagingCredential.controller;

import AccountManagement.repository.*;
import utils.*;

public class ValidateRegister {
    private static String name = "";
    private static String email = "";
    private static String password = "";
    private static String confirmPassword = "";

    public static void getData() {
        name = Help.strPrompt("Name [5-20 word]: ", 5, 20);

        do {
            email = Help.strPrompt("Email [must be valid format]: ", 5, 20);
        } while (!Help.isValidEmail(email));

        do {
            password = Help.strPrompt("Password [must be alphanumeric & lowercase]: ", 1, 20);
        } while (!Help.isAlphaNumeric(password) && !Help.hasUpperCase(password));

        do {
            confirmPassword = Help.strPrompt("Confirm Password [must be alphanumeric & lowercase & same as password]: ",
                    1, 20);
        } while (password == confirmPassword);
    }

    public static void createStudentAccount() {
        getData();
        StudentRepository.getInstance().insert(name, email, password);
    }

    public static void createTeacherAccount() {
        getData();
        TeacherRepository.getInstance().insert(name, email, password);
    }
}
