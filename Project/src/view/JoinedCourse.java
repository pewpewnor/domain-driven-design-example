package view;

import utils.Help;
import java.util.ArrayList;

import CourseManagement.model.*;
import CourseManagement.context.ManagingCourse.Controller.*;
import CourseManagement.context.ManagingAssignment.Controller.*;

public class JoinedCourse {
    Course selectedCourse = null;

    private void printCourseInformation(Course course) {
        System.out.println("Course ID: " + course.getId());
        System.out.println("Course Name: " + course.getName());
        System.out.println("Course Description: ");
        System.out.println(course.getDescription());
        System.out.println();
    }

    private void printMaterialInformation(Material material) {
        System.out.println("Material ID: " + material.getId());
        System.out.println("Material Name: " + material.getName());
        System.out.println("Material Content: ");
        System.out.println(material.getContent());
        System.out.println();
    }

    private void printAssignmentInformation(Assignment assignment) {
        System.out.println("Assignment ID: " + assignment.getId());
        System.out.println("Assignment Name: " + assignment.getName());
        System.out.println("Assignment Description: ");
        System.out.println(assignment.getDescription());
        System.out.println();
    }

    // student
    public void StudentMaterialMenu() {
        Help.cls();
        ArrayList<Material> materials = ValidateMaterial.getAllMaterialsForCourse(selectedCourse.getId());

        if (materials == null || materials.size() == 0) {
            System.out.println("No materials found");
            return;
        }

        for (Material material : materials) {
            printMaterialInformation(material);
            System.out.println();
        }
        Help.prompt("Press enter to continue");
        Help.cls();
        return;
    }

    // student
    public void StudentAssignmentMenu() {
        do {
            Help.cls();
            ArrayList<Assignment> assignments = ValidateAssignment.getAllAssignmentsForCourse(selectedCourse.getId());

            if (assignments == null || assignments.size() == 0) {
                System.out.println("No Assignment found");
                Help.prompt("Press enter to continue");
                Help.cls();
                return;
            }

            for (Assignment assignment : assignments) {
                printAssignmentInformation(assignment);
                System.out.println();
            }

            Help.list("Do Assignment", "Back");
            int input = Help.prompt(">> ", 1, 2);

            if (input == 1) {
                // Do Assignment
            } else if (input == 2) {
                break;
            }
        } while (true);

        return;
    }

    // teacher
    public void TeacherAssignmentMenu() {
        do {
            Help.cls();
            ArrayList<Assignment> assignments = ValidateAssignment.getAllAssignmentsForCourse(selectedCourse.getId());

            if (assignments == null || assignments.size() == 0) {
                System.out.println("No Assignment found");
            } else {
                for (Assignment assignment : assignments) {
                    printAssignmentInformation(assignment);
                    System.out.println();
                }
            }

            Help.list("Add Assignment", "Grade Assignment", "Back");
            int input = Help.prompt(">> ", 1, 4);

            if (input == 1) {
                ValidateAssignment.createAssignment();
            } else if (input == 2) {
                GradeAssignmentMenu(assignments);
            } else if (input == 3) {
                break;
            }
        } while (true);
        return;
    }

    public void GradeAssignmentMenu(ArrayList<Assignment> assignments) {
        do {
            Help.cls();
            for (Assignment assignment : assignments) {
                printAssignmentInformation(assignment);
                System.out.println();
            }

            int assignmentID = Help.prompt("Select Assigment ID to Grade (-1 to back):  ", 1);

            if (assignmentID == -1) {
                return;
            }

            Assignment selectedAssignment = null;

            for (Assignment a : assignments) {
                if (a.getId() == assignmentID) {
                    selectedAssignment = a;
                    break;
                }
            }

            if (selectedAssignment == null) {
                System.out.println("Invalid Assignment ID");
                Help.prompt("Press enter to continue", 1);
                continue;
            } else {
                new GradeSubmission(selectedAssignment);
            }

        } while (true);

    }

    // teacher
    public void TeacherMaterialMenu() {
        do {
            Help.cls();
            ArrayList<Material> materials = ValidateMaterial.getAllMaterialsForCourse(selectedCourse.getId());

            if (materials == null || materials.size() == 0) {
                System.out.println("No materials found");
            } else {
                for (Material material : materials) {
                    printMaterialInformation(material);
                    System.out.println();
                }
            }

            Help.list("Add material", "Back");
            int input = Help.prompt(">> ", 1, 3);

            if (input == 1) {
                // Add Material
            } else if (input == 2) {
                break;
            }
        } while (true);
        return;
    }

    // student
    public void JoinedCourseStudent() {
        Course course = ValidateCourse.viewStudentCurrentCourse();
        if (course == null) {
            System.out.println("You haven't joined a course");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        do {
            printCourseInformation(course);
            System.out.println();

            Help.list("Materials", "Assignments", "Back");
            int choice = Help.prompt(">> ", 1, 3);
            Help.cls();

            printCourseInformation(course);
            if (choice == 1) {
                StudentMaterialMenu();
            } else if (choice == 2) {
                StudentAssignmentMenu();
            } else if (choice == 3) {
                break;
            }
        } while (true);

        return;
    }

    // teacher
    public void JoinedCourseTeacher() {
        ArrayList<Course> courses = ValidateCourse.viewTeacherCurrentCourse();
        if (courses == null || courses.size() == 0) {
            System.out.println("No courses found");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        int choice = 0;
        do {
            Help.cls();
            for (Course course : courses) {
                printCourseInformation(course);
                System.out.println();
            }

            choice = Help.prompt("Select course: (Input -1 to exit) >> ", 1);

            if (choice == -1) {
                Help.cls();
                break;
            }

            // Find course
            for (Course course : courses) {
                if (course.getId() == choice) {
                    selectedCourse = course;
                    showSelectedCourse();
                }
            }

            if (selectedCourse == null) {
                System.out.println("Invalid course");
                continue;
            }
        } while (true);
        return;

    }

    public void showSelectedCourse() {
        do {
            Help.cls();
            printCourseInformation(selectedCourse);
            System.out.println();

            Help.list("Materials", "Assignments", "Back");
            int choice = Help.prompt(">> ", 1, 3);
            if (choice == 1) {
                TeacherMaterialMenu();
            } else if (choice == 2) {
                TeacherAssignmentMenu();
            } else if (choice == 3) {
                break;
            }
        } while (true);

        return;

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