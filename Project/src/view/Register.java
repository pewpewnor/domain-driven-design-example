package view;

import utils.Help;

public class Register {
    public Register(){
        Help.border('=', 100);
        System.out.println("Register");
        Help.border('=', 100);

        String name = Help.strPrompt("Name: ", 1);
        String email = Help.strPrompt("Email: ", 1);
        String password = Help.strPrompt("Password: ", 1);
        String confirmPassword = Help.strPrompt("Confirm Password: ", 1);
    }
}
