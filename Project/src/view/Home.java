package view;

// import model.*;
import utils.Help;
import model.*;

public class Home {

  public void showStudentPage(Student user) {
    Help.list("Joined Course", "View all Courses", "View all Assignments", "View Scores", "Logout");
    int choice = Help.prompt(">> ", 1, 5);
    Help.cls();

    if (choice == 1) {
      new JoinedCourse(user);
    } else if (choice == 2) {
      new AllCourse(user);
    } else if (choice == 3) {
      new MyAssignment(user);
    } else if (choice == 4) {
      new MyScore(user);
    } else {
      new LandingPage();
    }
  }

  public void showTeacherPage(Teacher user) {
    Help.list("Teached Course", "View all Courses", "Create New Course", "Log out");
    int choice = Help.prompt(">> ", 1, 3);
    Help.cls();

    if (choice == 1) {
      new JoinedCourse(user);
    } else if (choice == 2) {
      new AllCourse(user);
    } else if (choice == 3) {
      new CreateCourse(user);
    } else {
      new LandingPage();
    }

  }

  public Home(User user) {
    Help.cls();
    Help.border('=', 100);
    System.out.println("Home");
    Help.border('=', 100);

    if (user instanceof Teacher) {
      showTeacherPage((Teacher) user);
    } else if (user instanceof Student) {
      showStudentPage((Student) user);
    }

  }

}
