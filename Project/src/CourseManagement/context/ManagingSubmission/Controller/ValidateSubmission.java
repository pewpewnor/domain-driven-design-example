package CourseManagement.context.ManagingSubmission.Controller;

import java.util.ArrayList;

import AccountManagement.model.Student;
import AccountManagement.repository.StudentRepository;
import CourseManagement.model.Submission;
import CourseManagement.repository.SubmissionRepository;
import utils.Help;

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

    public static ArrayList<Submission> getAllSubmissionByStudent(int studentId) {
        return SubmissionRepository.getInstance().findAllByStudentId(studentId);
    }

    public static Student getStudentFromSubmission(Submission submission) {
        return StudentRepository.getInstance().findById(submission.getStudentId());
    }
}
