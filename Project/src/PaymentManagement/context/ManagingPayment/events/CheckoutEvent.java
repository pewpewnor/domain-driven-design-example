package PaymentManagement.context.ManagingPayment.events;

import AccountManagement.model.Teacher;
import view.Home;

public class CheckoutEvent {
    private Teacher teacher;

    public CheckoutEvent() {
        this.teacher = Home.getCurrentTeacher();
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
