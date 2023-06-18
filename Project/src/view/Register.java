package view;

import utils.Help;
import AccountManagement.context.ManagingCredential.controller.RegisterController;
import AccountManagement.context.ManagingCredential.events.CreateAccountEvent;

public class Register {
    private CreateAccountEvent getEventFromData() {
        String name, email, password, confirmPassword;

        name = Help.strPrompt("Name [5-20 word]: ", 5, 20);

        do {
            email = Help.strPrompt("Email [must be valid format]: ", 5, 20);
        } while (!RegisterController.isValidEmail(email));

        do {
            password = Help.strPrompt("Password [must be alphanumeric & must have uppercase]: ", 1, 20);
        } while (!RegisterController.isValidPassword(password));

        do {
            confirmPassword = Help.strPrompt("Confirm Password [must be same as password]: ",
                    1, 20);
        } while (!RegisterController.samePassword(password, confirmPassword));

        return new CreateAccountEvent(name, email, password);
    }

    public Register() {
        Help.border('=', 100);
        System.out.println("Register as");
        Help.border('=', 100);

        Help.list("Student", "Teacher", "Back");
        int choice = Help.prompt("choice >> ", 1, 3);

        if (choice == 1) {
            RegisterController.createStudentAccount(getEventFromData());
            System.out.println("Register Successfully");
            Help.pause();
            new Login();

        } else if (choice == 2) {
            RegisterController.createTeacherAccount(getEventFromData());
            System.out.println("Register Successfully");
            Help.pause();
            new Login();
        }
    }
}
