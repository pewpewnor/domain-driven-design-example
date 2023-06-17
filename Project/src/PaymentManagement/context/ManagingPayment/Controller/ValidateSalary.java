package PaymentManagement.context.ManagingPayment.Controller;

import AccountManagement.model.Teacher;
import AccountManagement.repository.TeacherRepository;
import PaymentManagement.factory.PaymentFactory;
import PaymentManagement.model.Payment;
import view.Home;

public class ValidateSalary {
    public static void checkoutSalary() {
        Teacher teacher = Home.getCurrentTeacher();
        Payment salary = PaymentFactory.createPayment("IDR", 0);
        TeacherRepository.getInstance().update(teacher.getId(), teacher.getName(), teacher.getEmail(),
                teacher.getPassword(),
                salary);
    }
}
