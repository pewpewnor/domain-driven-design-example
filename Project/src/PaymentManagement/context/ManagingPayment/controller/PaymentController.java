package PaymentManagement.context.ManagingPayment.controller;

import AccountManagement.model.Teacher;
import AccountManagement.repository.TeacherRepository;
import PaymentManagement.context.ManagingPayment.events.CheckoutEvent;
import PaymentManagement.context.ManagingPayment.events.SalaryIncreaseEvent;
import PaymentManagement.factory.PaymentFactory;
import PaymentManagement.model.Payment;

public class PaymentController {
        public static void checkoutSalary(CheckoutEvent checkoutEvent) {
                Teacher teacher = checkoutEvent.getTeacher();

                Payment emptySalary = PaymentFactory.createPayment("IDR", 0);
                TeacherRepository.getInstance().update(teacher.getId(), teacher.getName(), teacher.getEmail(),
                                teacher.getPassword(),
                                emptySalary);
        }

        public static void salaryIncrease(SalaryIncreaseEvent salaryIncreaseEvent) {
                Teacher teacher = salaryIncreaseEvent.getTeacher();

                Payment increasedSalary = PaymentFactory.createPayment(teacher.getSalary().getCurrency(),
                                teacher.getSalary().getBalance() + 100000.0);
                TeacherRepository.getInstance().update(teacher.getId(), teacher.getName(),
                                teacher.getEmail(),
                                teacher.getPassword(), increasedSalary);
        }
}
