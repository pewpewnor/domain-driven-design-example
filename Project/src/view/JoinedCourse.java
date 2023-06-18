package view;

import utils.Help;
import java.util.ArrayList;

import CourseManagement.model.*;
import CourseManagement.repository.AssignmentRepository;
import CourseManagement.context.ManagingAssignment.controller.*;
import CourseManagement.context.ManagingAssignment.events.CreateAssignmentEvent;
import CourseManagement.context.ManagingCourse.controller.*;
import CourseManagement.context.ManagingCourse.events.CreateMaterialEvent;
import CourseManagement.context.ManagingSubmission.controller.*;
import CourseManagement.context.ManagingSubmission.events.SubmitSubmissionEvent;

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
        int score = SubmissionController.getSubmissionByAssignmentAndStudent(assignment.getId()).getScore();
        System.out.println(
                "> Submission score: " + (score == -1 ? "Not scored yet by Teacher" : score));
        System.out.println();
    }

    public static void printMaterial(Material material) {
        System.out.println("> Material ID: " + material.getId());
        System.out.println("> Material Name: " + material.getName());
        System.out.println("> Material Content: ");
        System.out.println(material.getContent());
    }

    public static void printAllMaterial(ArrayList<Material> materials) {
        for (Material material : materials) {
            printMaterial(material);
            System.out.println();
        }
    }

    // Student
    public void StudentMaterialMenu() {
        Help.cls();
        ArrayList<Material> materials = MaterialController.getAllMaterialsForCourse(selectedCourse.getId());

        if (materials == null || materials.size() == 0) {
            System.out.println("No materials found");
            Help.pause();
            Help.cls();
            return;
        }

        printAllMaterial(materials);

        Help.pause();
        Help.cls();
        return;
    }

    // Student
    public int StudentAssignmentMenu() {
        do {
            Help.cls();
            ArrayList<Assignment> assignments = AssignmentController.getAllAssignmentsForCourse(selectedCourse.getId());

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

                String answer = Help.strPrompt("Enter your answer: ", 1);
                SubmissionController.submitSubmission(new SubmitSubmissionEvent(selectedAssignment.getId(), answer));
                System.out.println("assignment has been submited");
                Help.pause();
                Help.cls();
            } else if (input == 2) {
                break;
            }
        } while (true);

        return -1;
    }

    // Teacher
    public void TeacherAssignmentMenu() {
        do {
            Help.cls();
            ArrayList<Assignment> assignments = AssignmentController.getAllAssignmentsForCourse(selectedCourse.getId());

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
                String name = Help.strPrompt("Assignment name: ", 1);
                String description = Help.strPrompt("description: ", 1);

                AssignmentController
                        .createAssignment(new CreateAssignmentEvent(name, description, selectedCourse.getId()));
            } else if (input == 2) {
                GradeAssignmentMenu(assignments);
            } else if (input == 3) {
                break;
            }
        } while (true);
        return;
    }

    // Teacher
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

            Assignment selectedAssignment = AssignmentController.getAssignmentById(assignmentID);
            if (selectedAssignment == null) {
                System.out.println("Invalid Assignment ID");
                Help.pause();
                continue;
            } else {
                new GradeSubmission(selectedAssignment);
            }

        } while (true);

    }

    // Teacher
    public void TeacherMaterialMenu() {
        do {
            Help.cls();
            ArrayList<Material> materials = MaterialController.getAllMaterialsForCourse(selectedCourse.getId());

            if (materials == null || materials.size() == 0) {
                System.out.println("No materials found");
                Help.pause();
                Help.cls();
            } else {
                printAllMaterial(materials);
            }

            Help.list("Add material", "Back");
            int input = Help.prompt(">> ", 1, 3);

            Help.cls();

            if (input == 1) {
                printAllMaterial(materials);
                String name = Help.strPrompt("Enter material name: ", "Name cannot be empty", 1);
                String content = Help.strPrompt("Enter material content: ", "Content cannot be empty", 1);

                MaterialController.createMaterial(new CreateMaterialEvent(name, content, selectedCourse.getId()));
            } else if (input == 2) {
                break;
            }
        } while (true);
    }

    // Student home
    public int JoinedCourseStudent() {
        selectedCourse = CourseController.viewStudentCurrentCourses();
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

    // Teacher home
    public int JoinedCourseTeacher() {
        ArrayList<Course> courses = CourseController.viewTeacherCurrentCourses();
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

            selectedCourse = CourseController.getCourseById(choice);
            if (selectedCourse == null) {
                System.out.println("Invalid course");
                continue;
            }
        } while (true);

    }

    // Teacher
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

    // All
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