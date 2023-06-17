package PaymentManagement.context.ManagingPayment.Controller;

import AccountManagement.model.Teacher;
import PaymentManagement.context.ManagingPayment.model.Payment;

public class ValidateSalary {
    public static Payment getSalary(Teacher teacher) {
        // Should return totalStudentsCourse * 100000.0 if IDR
       return new Payment("IDR", 4000.0);
    }
}
