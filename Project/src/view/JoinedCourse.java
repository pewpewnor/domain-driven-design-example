package view;

import utils.Help;
import java.util.ArrayList;

import CourseManagement.model.*;
import CourseManagement.context.ManagingCourse.Controller.*;
import CourseManagement.context.ManagingAssignment.Controller.*;
import CourseManagement.context.ManagingSubmission.Controller.*;

public class JoinedCourse {
    Course selectedCourse = null;

    private void printCourseInformation(Course course) {
        System.out.println("> Course ID: " + course.getId());
        System.out.println("> Course Name: " + course.getName());
        System.out.println("> Course Description: ");
        System.out.println(course.getDescription());
        System.out.println();
    }

    private void printAssignmentInformation(Assignment assignment) {
        System.out.println("> Assignment ID: " + assignment.getId());
        System.out.println("> Assignment Name: " + assignment.getName());
        System.out.println("> Assignment Description: ");
        System.out.println(assignment.getDescription());
        System.out.println();
    }

    // student
    public void StudentMaterialMenu() {
        Help.cls();
        ArrayList<Material> materials = ValidateMaterial.getAllMaterialsForCourse(selectedCourse.getId());

        if (materials == null || materials.size() == 0) {
            System.out.println("No materials found");
            Help.pause();
            Help.cls();
            return;
        }

        ValidateMaterial.printAllMaterial(materials);

        Help.pause();
        Help.cls();
        return;
    }

    // student
    public int StudentAssignmentMenu() {
        do {
            Help.cls();
            ArrayList<Assignment> assignments = ValidateAssignment.getAllAssignmentsForCourse(selectedCourse.getId());

            if (assignments == null || assignments.size() == 0) {
                System.out.println("No Assignment found");
                Help.pause();
                Help.cls();
                return -1;
            }

            for (Assignment assignment : assignments) {
                printAssignmentInformation(assignment);
                System.out.println();
            }

            Help.list("Do Assignment", "Back");
            int input = Help.prompt(">> ", 1, 2);

            if (input == 1) {
                // Do Assignment

                int i = 1;
                for (Assignment assignment : assignments) {
                    System.out.println("Assignment Number " + i);
                    printAssignmentInformation(assignment);
                    System.out.println();
                    i++;
                }

                int index = Help.prompt("choose assignment: ", 1, assignments.size()) - 1;

                Assignment selectedAssignment = assignments.get(index);


                ValidateSubmission.submitSubmission(selectedAssignment.getId());
                System.out.println("assignment has been submited");
                Help.pause();
                Help.cls();
            } else if (input == 2) {
                break;
            }
        } while (true);

        return -1;
    }

    // teacher
    public void TeacherAssignmentMenu() {
        do {
            Help.cls();
            ArrayList<Assignment> assignments = ValidateAssignment.getAllAssignmentsForCourse(selectedCourse.getId());

            if (assignments == null || assignments.size() == 0) {
                System.out.println("No Assignment found");
                Help.pause();
                Help.cls();
            } else {
                for (Assignment assignment : assignments) {
                    printAssignmentInformation(assignment);
                    System.out.println();
                }
            }

            Help.list("Add Assignment", "Grade Assignment", "Back");
            int input = Help.prompt(">> ", 1, 4);
            Help.cls();

            if (input == 1) {
                ValidateAssignment.createAssignment(selectedCourse);
            } else if (input == 2) {
                GradeAssignmentMenu(assignments);
            } else if (input == 3) {
                break;
            }
        } while (true);
        return;
    }

    // teacher
    public int GradeAssignmentMenu(ArrayList<Assignment> assignments) {
        if (assignments == null || assignments.size() == 0) {
            System.out.println("No Assignment found");
            Help.pause();
            Help.cls();
            return -1;
        }

        do {
            Help.cls();
            for (Assignment assignment : assignments) {
                printAssignmentInformation(assignment);
                System.out.println();
            }

            int assignmentID = Help.prompt("Select Assigment ID to Grade (-1 to back):  ", -1);

            if (assignmentID == -1) {
                return -1;
            }

            Assignment selectedAssignment = ValidateAssignment.assignmentNotNull(assignmentID);
            if (selectedAssignment == null) {
                System.out.println("Invalid Assignment ID");
                Help.pause();
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
                Help.pause();
                Help.cls();
            } else {
                ValidateMaterial.printAllMaterial(materials);
            }

            Help.list("Add material", "Back");
            int input = Help.prompt(">> ", 1, 3);

            if (input == 1) {
                ValidateMaterial.createMaterial(selectedCourse.getId());
            } else if (input == 2) {
                break;
            }
        } while (true);
        return;
    }

    // student home
    public int JoinedCourseStudent() {
        selectedCourse = ValidateCourse.viewStudentCurrentCourse();
        if (selectedCourse == null) {
            System.out.println("You haven't joined a course");
            Help.pause();
            Help.cls();
            return -1;
        }

        do {
            printBanner();
            printCourseInformation(selectedCourse);
            System.out.println();

            Help.list("Materials", "Assignments", "Back");
            int choice = Help.prompt(">> ", 1, 3);
            Help.cls();

            if (choice == 1) {
                StudentMaterialMenu();
            } else if (choice == 2) {
                StudentAssignmentMenu();
            } else if (choice == 3) {
                return -1;
            }
        } while (true);
    }

    // teacher home
    public int JoinedCourseTeacher() {
        ArrayList<Course> courses = ValidateCourse.viewTeacherCurrentCourse();
        if (courses == null || courses.size() == 0) {
            System.out.println("No courses found");
            return -1;
        }

        int choice;
        do {
            Help.cls();
            printBanner();
            for (Course course : courses) {
                printCourseInformation(course);
                System.out.println();
            }

            choice = Help.prompt("Select course: (Input -1 to exit) >> ", -1);

            if (choice == -1) {
                Help.cls();
                return -1;
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

    private void printBanner() {
        Help.border('=', 100);
        System.out.println("Joined Course");
        Help.border('=', 100);
    }

    public JoinedCourse() {
        if (Home.currentUserIsStudent) {
            int returnValue = JoinedCourseStudent();
            if (returnValue == -1) {
                return;
            }
        } else {
            int returnValue = JoinedCourseTeacher();
            if (returnValue == -1) {
                return;
            }
        }
    }
}