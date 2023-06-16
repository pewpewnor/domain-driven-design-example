package CourseManagement.model;

public class Submission {
    private int assignmentId;
    private int studentId;
    private String answer;
    private int score;

    public Submission(int assignmentId, int studentId, String answer, int score) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.answer = answer;
        this.score = score;
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

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}