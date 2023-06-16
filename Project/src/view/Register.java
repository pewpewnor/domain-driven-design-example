package view;

import utils.Help;
import AccountManagement.context.ManagingCredential.controller.ValidateRegister;

public class Register {
    public Register() {
        Help.border('=', 100);
        System.out.println("Register as");
        Help.border('=', 100);

        Help.list("1. Student", "2. Teacher", "3. Back");
        int choice = Help.prompt("choice >> ", 1, 3);

        if (choice == 1) {
            ValidateRegister.createStudentAccount();
            System.out.println("Register Successfully");
            new Login();

        } else if (choice == 2) {
            ValidateRegister.createTeacherAccount();
            System.out.println("Register Successfully");
            new Login();
            
        } else if (choice == 3) {
            new LandingPage();
        }
    }
}
