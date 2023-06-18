package PaymentManagement.context.ManagingPayment.events;

import AccountManagement.model.Teacher;
import AccountManagement.repository.TeacherRepository;
import CourseManagement.repository.CourseRepository;
import PaymentManagement.factory.PaymentFactory;
import PaymentManagement.model.Payment;

public class UpdatePayment {
    public static void updatePayment(int courseId) {
        int courseTeacherId = CourseRepository.getInstance().findById(courseId).getTeacherId();
        Teacher courseTeacher = TeacherRepository.getInstance()
                .findById(courseTeacherId);

        Payment salary = PaymentFactory.createPayment(courseTeacher.getSalary().getCurrency(),
                courseTeacher.getSalary().getBalance() + 100000.0);

        TeacherRepository.getInstance().update(courseTeacher.getId(), courseTeacher.getName(), courseTeacher.getEmail(),
                courseTeacher.getPassword(), salary);
    }
}
