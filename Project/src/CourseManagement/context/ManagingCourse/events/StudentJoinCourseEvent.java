package CourseManagement.context.ManagingCourse.events;

import AccountManagement.model.Student;
import view.Home;

public class StudentJoinCourseEvent {
    private Student student;
    private int courseId;

    public StudentJoinCourseEvent(int courseId) {
        this.student = Home.getCurrentStudent();
        this.courseId = courseId;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
