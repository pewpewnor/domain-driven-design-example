package view;

import model.*;
import utils.Help;

public class Home{
    // Help help = new Help();

    public Home(){
        // User user = 
        // int flag = 0;

        // while(!flag){
        //     // system.out
        // }
        
        // Help.pause();

        // Help.cls();

        // System.out.println("1. asasas\n2. asdsdf");
        // int choice = Help.prompt("choice >>", 1, 2);

        String[] options = {"opsi 1", "opsi2"};
        int choice = Help.comboList(options, "choice >> ", 1, 2);

        String name;
        do {
            name = Help.strPrompt("Name: ", 1, 20);
        } while (Help.hasLowerCase(name));

        Help.isNumeric("aaa");
        Help.isAlphaNumeric("asa");
        
        Help.strToInt("123");
        Help.intToStr(1233);

        Help.border('#', 100);
    }

    public static void main(String[] args) {
		new Home();
	}
}