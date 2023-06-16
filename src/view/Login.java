package view;
import utils.Help;

public class Login {
    public Login(){
        Help.border('=', 100);
        System.out.println("Login");
        Help.border('=', 100);

        String email = Help.strPrompt("Email: ", 1);
        String password = Help.strPrompt("Password: ", 1);
    }
}
