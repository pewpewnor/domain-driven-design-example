package CourseManagement.context.ManagingSubmission.controller;

import java.util.ArrayList;

import AccountManagement.model.Student;
import AccountManagement.repository.StudentRepository;
import CourseManagement.context.ManagingSubmission.events.GradeSubmissionEvent;
import CourseManagement.context.ManagingSubmission.events.SubmitSubmissionEvent;
import CourseManagement.model.Submission;
import CourseManagement.repository.SubmissionRepository;
// import utils.Help;
import view.Home;

public class SubmissionController {
    public static void gradeSubmissionScore(GradeSubmissionEvent gradeSubmissionEvent) {
        Submission submission = gradeSubmissionEvent.getSubmission();

        SubmissionRepository.getInstance().update(submission.getAssignmentId(), submission.getStudentId(),
                submission.getAnswer(), gradeSubmissionEvent.getScore());
    }

    public static ArrayList<Submission> getAllSubmissionForAssignment(int assignmentId) {
        return SubmissionRepository.getInstance().findAllByAssignmentId(assignmentId);
    }

    public static Submission getSubmissionByAssignmentAndStudent(int assignmentId) {
        return SubmissionRepository.getInstance().findByAssignmentAndStudentId(assignmentId,
                Home.getCurrentStudent().getId());
    }

    public static void submitSubmission(SubmitSubmissionEvent submitSubmissionEvent) {

        if (SubmissionRepository.getInstance().findByAssignmentAndStudentId(submitSubmissionEvent.getAssignmentId(),
                submitSubmissionEvent.getStudentId()) != null) {
            SubmissionRepository.getInstance().update(submitSubmissionEvent.getAssignmentId(),
                    submitSubmissionEvent.getStudentId(), submitSubmissionEvent.getAnswer(), -1);
        } else {
            SubmissionRepository.getInstance().insert(submitSubmissionEvent.getAssignmentId(),
                    submitSubmissionEvent.getStudentId(), submitSubmissionEvent.getAnswer());
        }
    }

    public static ArrayList<Submission> getAllSubmissionByStudent(int studentId) {
        return SubmissionRepository.getInstance().findAllByStudentId(studentId);
    }

    public static Student getStudentFromSubmission(Submission submission) {
        return StudentRepository.getInstance().findById(submission.getStudentId());
    }
}
