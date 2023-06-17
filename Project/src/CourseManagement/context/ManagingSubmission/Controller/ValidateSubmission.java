package CourseManagement.context.ManagingSubmission.Controller;

import java.util.ArrayList;

import AccountManagement.model.Student;
import AccountManagement.repository.StudentRepository;
import CourseManagement.model.Submission;
import CourseManagement.repository.SubmissionRepository;
import utils.Help;
import view.Home;

public class ValidateSubmission {
    public static void gradeSubmissionScore(Submission submission) {
        int score = Help.prompt("Score for Submission: ", 1, 100);

        SubmissionRepository.getInstance().update(submission.getAssignmentId(), submission.getStudentId(),
                submission.getAnswer(), score);
    }

    public static ArrayList<Submission> getAllSubmissionForAssignment(int assignmentId) {
        return SubmissionRepository.getInstance().findAllByAssignmentId(assignmentId);
    }

    // public static Submission getSubmissionForAssignmentAndStudent(int
    // assignmentId, int studentId) {
    // return
    // SubmissionRepository.getInstance().findByAssignmentAndStudentId(assignmentId,
    // studentId);
    // }

    public static void submitSubmission(int assignmentId) {
        String answer = Help.strPrompt("Enter your answer: ", 1);

        if (SubmissionRepository.getInstance().findByAssignmentAndStudentId(assignmentId,
                Home.getCurrentStudent().getId()) != null) {
            SubmissionRepository.getInstance().update(assignmentId, Home.getCurrentStudent().getId(), answer, -1);
        } else {
            SubmissionRepository.getInstance().insert(assignmentId, Home.getCurrentStudent().getId(), answer);
        }
    }

    public static ArrayList<Submission> getAllSubmissionByStudent(int studentId) {
        return SubmissionRepository.getInstance().findAllByStudentId(studentId);
    }

    public static Student getStudentFromSubmission(Submission submission) {
        return StudentRepository.getInstance().findById(submission.getStudentId());
    }
}
