package CourseManagement.context.ManagingSubmission.events;

import CourseManagement.model.Submission;

public class GradeSubmissionEvent {
    private Submission submission;
    private int score;

    public GradeSubmissionEvent(Submission submission, int score) {
        this.submission = submission;
        this.score = score;
    }

    public Submission getSubmission() {
        return this.submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
