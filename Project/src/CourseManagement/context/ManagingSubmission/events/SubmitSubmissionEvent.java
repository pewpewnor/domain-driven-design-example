package CourseManagement.context.ManagingSubmission.events;

import view.Home;

public class SubmitSubmissionEvent {
    private int assignmentId;
    private int studentId;
    private String answer;

    public SubmitSubmissionEvent(int assignmentId, String answer) {
        this.assignmentId = assignmentId;
        this.studentId = Home.getCurrentStudent().getId();
        this.answer = answer;
    }

    public int getAssignmentId() {
        return this.assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
