package view;

import utils.Help;
import java.util.ArrayList;

import CourseManagement.context.ManagingSubmission.Controller.Material;
import CourseManagement.model.Assignment;
import CourseManagement.model.Course;
import CourseManagement.repository.CourseRepository;

public class JoinedCourse {

    public void PrintCourseInformation(Course course) {
        System.out.println("Course ID: " + course.getId());
        System.out.println("Course Name: " + course.getName());
        System.out.println("Course Description: ");
        System.out.println(course.getDescription());
    }

    public void PrintMaterialInformation(Material material) {
        System.out.println("Material ID: " + material.getId());
        System.out.println("Material Name: " + material.getName());
        System.out.println("Material Description: ");
        System.out.println(material.getDescription());
    }

    public void PrintAssignmentInformation(Assignment assignment) {
        System.out.println("Assignment ID: " + assignment.getId());
        System.out.println("Assignment Name: " + assignment.getName());
        System.out.println("Assignment Description: ");
        System.out.println(assignment.getDescription());
    }

    // all
    public void showCourseMaterials() {
        ArrayList<Material> materials = null;
        if (materials == null || materials.size() == 0) {
            System.out.println("No materials found");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        PrintMaterialInformation(materials.get(0));

    }

    // all
    public void showCourseAssignments() {
        ArrayList<Assignment> assignments = null;
        if (assignments == null || assignments.size() == 0) {
            System.out.println("No Assignment found");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        PrintAssignmentInformation(assignments.get(0));
    }

    // student
    public void JoinedCourseStudent() {
        Course course = CourseRepository.getInstance().findById(Home.currentStudent.getCourseId());
        if (course == null) {
            System.out.println("You haven't joined a course");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        PrintCourseInformation(course);
        System.out.println();

        Help.list("Materials", "Assignments", "Back");
        int choice = Help.prompt(">> ", 1, 3);
        Help.cls();

        PrintCourseInformation(course);
        if (choice == 1) {
            showCourseMaterials();
        } else if (choice == 2) {
            showCourseAssignments();
        } else if (choice == 3) {
            return;
        }
    }

    // teacher
    public void JoinedCourseTeacher() {
        ArrayList<Course> courses = CourseRepository.getInstance().findAllByTeacherId(Home.currentTeacher.getId());
        if (courses == null || courses.size() == 0) {
            System.out.println("No courses found");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        for(Course course: courses){
            PrintCourseInformation(course);
            System.out.println();
        }

        Help.list("Materials", "Assignments", "Back");
        int choice = Help.prompt(">> ", 1, 3);
        Help.cls();
    }

    public JoinedCourse() {
        Help.border('=', 100);
        System.out.println("Joined Course");
        Help.border('=', 100);

        if (Home.currentUserIsStudent) {
            JoinedCourseStudent();
        } else {
            JoinedCourseTeacher();
        }
    }
}