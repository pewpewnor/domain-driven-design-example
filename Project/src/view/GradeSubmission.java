package view;

import utils.Help;
import java.util.ArrayList;

import CourseManagement.context.ManagingSubmission.controller.*;
import CourseManagement.context.ManagingSubmission.events.GradeSubmissionEvent;
import CourseManagement.model.*;

public class GradeSubmission {

    public void printSubmission(int n, Submission submission) {
        System.out.println("Submssion Number " + n + " :");
        System.out.println("Submission Student ID: " + submission.getStudentId());
        System.out.println("Submission Student Name: " + SubmissionController.getStudentFromSubmission(submission));
        System.out.println("Submission Answer: " + submission.getAnswer());
        System.out.println("Score: " + (submission.getScore() == -1 ? "Not Graded Yet" : submission.getScore()));
        System.out.println();
    }

    public GradeSubmission(Assignment assignment) {
        Help.cls();
        Help.border('=', 100);
        System.out.println("Pick Submission to Grade");
        Help.border('=', 100);

        ArrayList<Submission> submissions = SubmissionController.getAllSubmissionForAssignment(assignment.getId());

        if (submissions.size() == 0) {
            System.out.println("No submissions by students yet!");
            return;
        }

        int i = 1;
        for (Submission submission : submissions) {
            printSubmission(i, submission);
            i++;
        }

        int index = Help.prompt(">> ", 1, submissions.size()) - 1;

        Submission selectedSubmission = submissions.get(index);

        int score = Help.prompt("Score for Submission: ", 1, 100);
        SubmissionController.gradeSubmissionScore(new GradeSubmissionEvent(selectedSubmission, score));

        System.out.println("Submission has been graded successfully!");
        Help.pause();
    }
}