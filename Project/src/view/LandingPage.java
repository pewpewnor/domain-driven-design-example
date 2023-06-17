package view;

import utils.Help;
import AccountManagement.repository.*;
import CourseManagement.repository.*;

public class LandingPage {

  public LandingPage() {
    while (true) {
      Help.cls();
      Help.border('=', 100);

      System.out.println("Welcome to the Online Course Application");
      Help.list("Login", "Register", "Exit");
      // System.out.println("1. Login");
      // System.out.println("2. Register");
      // System.out.println("3. Exit");
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
        System.exit(0);
      }
    }
  }

  public static void addPresetData() {
    StudentRepository.getInstance().deleteAll();
    TeacherRepository.getInstance().deleteAll();
    AssignmentRepository.getInstance().deleteAll();
    CourseRepository.getInstance().deleteAll();
    MaterialRepository.getInstance().deleteAll();
    SubmissionRepository.getInstance().deleteAll();

    StudentRepository.getInstance().insert("Raul", "a", "a");
    TeacherRepository.getInstance().insert("Juan Gauthama", "a@b.com", "a1234");
    CourseRepository.getInstance().insert("Math", "Math is for losers", 1);
  }

  public static void main(String[] args) {
    // addPresetData();
    new LandingPage();
  }
}
