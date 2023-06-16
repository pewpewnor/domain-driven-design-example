package view;

import java.util.ArrayList;

import AccountManagement.model.Student;
import CourseManagement.model.Assignment;
import utils.Help;

public class MyAssignment {
    Student student = Home.currentStudent;

    public void printAssignment(Assignment assignment){
        System.out.println("Assignment ID: " + assignment.getId());
        System.out.println("Assignment Name: " + assignment.getName());
        System.out.println("Assignment Description: ");
        System.out.println(assignment.getDescription());
    }

    public MyAssignment() {
        Help.border('=', 100);
        System.out.println("My Assignment");
        Help.border('=', 100);

        ArrayList<Assignment> assignments = null;
        if(assignments == null || assignments.size() == 0) {
            System.out.println("No Assignment found");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        printAssignment(assignments.get(0));


    }
}