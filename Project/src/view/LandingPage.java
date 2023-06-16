package view;

// import model.*;
import utils.Help;

public class LandingPage {

  // Help help = new Help();

  public void showHomePage() {
    Help.cls();
    Help.border('=', 100);

    System.out.println("Welcome to the Online Course Application");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Exit");
    Help.border('=', 100);

    int choice = Help.prompt("choice >> ", 1, 3);
    Help.cls();
    if (choice == 1) {
      new Login();
    } else if (choice == 2) {
      new Register();
    } else {
      Help.border('=', 100);
      System.out.println("Exits Program.. See you next time!");
      Help.border('=', 100);
    }
  }

  public LandingPage() {
    // User user =
    // int flag = 0;

    // while(!flag){
    // // system.out
    // }

    // Help.pause();

    // Help.cls();

    // System.out.println("1. asasas\n2. asdsdf");
    // int choice = Help.prompt("choice >>", 1, 2);

    // String[] options = {"opsi 1", "opsi2"};
    // int choice = Help.comboList(options, "choice >> ", 1, 2);

    // String name;
    // do {
    // name = Help.strPrompt("Name: ", 1, 20);
    // } while (Help.hasLowerCase(name));

    // Help.isNumeric("aaa");
    // Help.isAlphaNumeric("asa");

    // Help.strToInt("123");
    // Help.intToStr(1233);

    // Help.border('#', 100);
    showHomePage();
  }

  public static void main(String[] args) {
    new LandingPage();
  }
}
