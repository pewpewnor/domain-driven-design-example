package view;

import utils.Help;
import java.util.*;
import AccountManagement.model.*;
import CourseManagement.model.Submission;
import CourseManagement.context.ManagingSubmission.Controller.*;

public class MyScore {
    Student student;

    public void printSubmission(int n, Submission submission) {
        System.out.println("Submssion Number " + n + ":");
        System.out.println("Submission Student ID: " + submission.getStudentId());
        System.out.println("Submission Student Name: " + ValidateSubmission.getStudentFromSubmission(submission));
        System.out.println("Submission Answer: " + submission.getAnswer());
        System.out.println("Score: " + (submission.getScore() == -1 ? "Not Graded Yet" : submission.getScore()));
    }

    public MyScore() {
        student = Home.currentStudent;

        Help.border('=', 100);
        System.out.println("My Score");
        Help.border('=', 100);

        ArrayList<Submission> submissions = ValidateSubmission.getAllSubmissionByStudent(student.getId());
        if (submissions == null || submissions.size() == 0) {
            System.out.println("No Submission found");
            return;
        }

        int i = 1;
        for (Submission submission : submissions) {
            printSubmission(i, submission);
            i++;
        }

    }
}