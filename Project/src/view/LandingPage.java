package view;

// import model.*;
import utils.Help;
import AccountManagement.repository.StudentRepository;

public class LandingPage {

  public LandingPage() {
    while (true) {
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
        Help.pause();
        break;
      }
    }
  }

  public static void addPresetData() {
    StudentRepository.getInstance().deleteAll();

    StudentRepository.getInstance().insert("name", "email", "password");
    StudentRepository.getInstance().insert("fuck", "email", "password");
    StudentRepository.getInstance().insert("raul", "email", "password");
    StudentRepository.getInstance().insert("juan ga", "email@gmail", "12434");
  }

  public static void main(String[] args) {
    addPresetData();
    new LandingPage();
  }
}
