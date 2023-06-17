package view;

// import model.*;
import utils.Help;
import AccountManagement.model.Student;
import AccountManagement.model.Teacher;
import AccountManagement.model.User;

public class Home {
  public static boolean currentUserIsStudent;
  public static Teacher currentTeacher = null;
  public static Student currentStudent = null;

  // student
  public void showStudentPage(Student student) {
    int choice = 0;

    while (true) {
      printBanner();
      Help.list("Joined Course", "View all Courses", "View Scores", "Logout");
      choice = Help.prompt(">> ", 1, 5);
      Help.cls();

      if (choice == 1) {
        new JoinedCourse();
      } else if (choice == 2) {
        new AllCourse();
      } else if (choice == 3) {
        new MyScore();
      } else if (choice == 4) {
        break;
      }

      Help.pause();
      Help.cls();
    }
    new LandingPage();
  }

  // teacher
  public void showTeacherPage(Teacher teacher) {
    int choice = 0;

    while (true) {
      printBanner();
      Help.list("Teached Course", "View all Courses", "Create New Course", "Log out");
      choice = Help.prompt(">> ", 1, 3);
      Help.cls();

      if (choice == 1) {
        new JoinedCourse();
      } else if (choice == 2) {
        new AllCourse();
      } else if (choice == 3) {
        new CreateCourse();
      } else if (choice == 4) {
        break;
      }

      Help.pause();
      Help.cls();
    }
    new LandingPage();
  }

  public void printBanner() {
    Help.border('=', 100);
    System.out.println(currentUserIsStudent ? "Student Home Page, welcome " + currentStudent.getName() + "!"
        : "Teacher Home Page, welcome " + currentTeacher.getName() + "!");
    Help.border('=', 100);
  }

  public Home(User user) {

    Help.cls();

    if (user instanceof Teacher) {
      currentTeacher = ((Teacher) user);
      currentUserIsStudent = false;
      showTeacherPage((Teacher) user);
    } else if (user instanceof Student) {
      currentStudent = ((Student) user);
      currentUserIsStudent = true;
      showStudentPage((Student) user);
    }
  }
}
