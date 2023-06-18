package view;

import AccountManagement.model.Teacher;
import PaymentManagement.context.ManagingPayment.controller.PaymentController;
import PaymentManagement.context.ManagingPayment.events.CheckoutEvent;
import utils.Help;

public class SalaryPage {

    private void printBanner() {
        Help.border('=', 100);
        System.out.println("Salary Page");
        Help.border('=', 100);
        System.out.println();
    }

    private void printTeacherInformation() {
        Teacher currentTeacher = Home.getCurrentTeacher();
        System.out.println("> Teacher ID: " + currentTeacher.getId());
        System.out.println("> Teacher Name: " + currentTeacher.getName());
        System.out.println("Your salary is: " + currentTeacher.getSalary().getCurrency() + " "
                + currentTeacher.getSalary().getBalance());
        System.out.println();
    }

    public SalaryPage() {
        do {
            Help.cls();
            printBanner();
            printTeacherInformation();

            Help.list("Checkout Salary", "Back");
            int choice = Help.prompt(">> ", 1, 2);

            if (choice == 1) {
                PaymentController.checkoutSalary(new CheckoutEvent());
            } else if (choice == 2) {
                return;
            }
        } while (true);

    }
}
