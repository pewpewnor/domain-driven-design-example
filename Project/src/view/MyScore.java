package view;

import utils.Help;
import java.util.*;
import AccountManagement.model.*;
import CourseManagement.model.Submission;

public class MyScore {
    Student student;

    public void printSubmission(Submission submission) {
        System.out.println("Assignment Name: ");
        System.out.println("Assignment Description: ");
        System.out.println("Score: " + submission.getScore());

    }

    public MyScore() {
        student = Home.currentStudent;

        Help.border('=', 100);
        System.out.println("My Score");
        Help.border('=', 100);

        ArrayList<Submission> submission = null;
        if (submission == null || submission.size() == 0) {
            System.out.println("No Submission found");
            Help.prompt("Press enter to continue");
            Help.cls();
            return;
        }

        printSubmission(submission.get(0));

    }
}