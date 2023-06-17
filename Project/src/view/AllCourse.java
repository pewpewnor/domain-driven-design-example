package view;

import CourseManagement.context.ManagingCourse.Controller.*;
import CourseManagement.model.*;
import java.util.*;
// import model.*;
import utils.Help;

public class AllCourse {
    ArrayList<Course> courses;

    private void printCourseInformation(Course course) {
        System.out.println("> Course ID: " + course.getId());
        System.out.println("> Course Name: " + course.getName());
        System.out.println("> Course Description: ");
        System.out.println(course.getDescription());
        System.out.println();
    }

    // Student
    private void joinCourseMenu() {
        Help.cls();

        for (Course course : courses) {
            printCourseInformation(course);
        }

        while (true) {
            int courseId = Help.prompt("Enter courseId to Join: ", 1);
            Course selectourse = ValidateCourse.courseNotNull(courseId);
            if (selectourse != null) {
                System.out.println("Congrats! You have just joined a new course!");
                ValidateCourse.addStudentToCourse(courseId);
                break;
            } else {
                System.out.println("Course not found!");
            }
        }

    }

    public AllCourse() {
        Help.border('=', 100);
        System.out.println("All Course");
        Help.border('=', 100);

        courses = ValidateCourse.viewAllCourse();

        if (courses.size() == 0) {
            System.out.println("No courses found!");
            return;
        }

        for (Course course : courses) {
            printCourseInformation(course);
        }

        if (Home.currentUserIsStudent) {
            String choice = Help.choicePrompt("Do you want to join a course? [y / n]: ", "y", "n", "Y", "N");
            if (choice.equals("y") || choice.equals("Y")) {
                joinCourseMenu();
            }
        }
    }
}