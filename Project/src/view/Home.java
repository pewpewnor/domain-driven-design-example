package view;

import utils.Help;
import AccountManagement.model.Student;
import AccountManagement.model.Teacher;
import AccountManagement.model.User;
import AccountManagement.repository.StudentRepository;
import AccountManagement.repository.TeacherRepository;

public class Home {
  public static boolean currentUserIsStudent;
  public static int currentTeacherId = 0;
  public static int currentStudentId = 0;

  public static Teacher getCurrentTeacher() {
    return TeacherRepository.getInstance().findById(currentTeacherId);
  }

  public static Student getCurrentStudent() {
    return StudentRepository.getInstance().findById(currentStudentId);
  }

  // student
  public void showStudentPage(Student student) {
    int choice = 0;

    while (true) {
      printBanner();
      Help.list("Joined Course", "View all Courses", "View Scores", "Logout");
      choice = Help.prompt(">> ", 1, 4);
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
      Help.list("Teached Course", "View all Courses", "Create New Course", "My Salary", "Log out");
      choice = Help.prompt(">> ", 1, 5);
      Help.cls();

      if (choice == 1) {
        new JoinedCourse();
      } else if (choice == 2) {
        new AllCourse();
      } else if (choice == 3) {
        new CreateCourse();
      } else if (choice == 4) {
        new SalaryPage();
      } else if (choice == 5) {
        break;
      }

      Help.pause();
      Help.cls();
    }
    new LandingPage();
  }

  public void printBanner() {
    Help.border('=', 100);
    System.out.println(currentUserIsStudent ? "Student Home Page, welcome " + getCurrentStudent().getName() + "!"
        : "Teacher Home Page, welcome " + getCurrentTeacher().getName() + "!");
    Help.border('=', 100);
  }

  public Home(User user) {

    Help.cls();

    if (user instanceof Teacher) {
      currentTeacherId = ((Teacher) user).getId();
      currentUserIsStudent = false;
      showTeacherPage((Teacher) user);
    } else if (user instanceof Student) {
      currentStudentId = ((Student) user).getId();
      currentUserIsStudent = true;
      showStudentPage((Student) user);
    }
  }
}
