package CourseManagement.factory;

import CourseManagement.model.*;

public class SubmissionFactory {
    public static Submission createSubmission(int assignmentId, int studentId, String answer, int score) {
        return new Submission(assignmentId, studentId, answer, score);
    }
}
