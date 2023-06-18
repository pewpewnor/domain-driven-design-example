package PaymentManagement.context.ManagingPayment.events;

import AccountManagement.model.Teacher;
import AccountManagement.repository.TeacherRepository;
import CourseManagement.repository.CourseRepository;

public class SalaryIncreaseEvent {
    private Teacher teacher;

    public SalaryIncreaseEvent(int courseId) {
        int teacherId = CourseRepository.getInstance().findById(courseId).getTeacherId();
        this.teacher = TeacherRepository.getInstance().findById(teacherId);
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
