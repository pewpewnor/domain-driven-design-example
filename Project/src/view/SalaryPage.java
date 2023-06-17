package view;

import AccountManagement.model.Teacher;
import PaymentManagement.context.ManagingPayment.Controller.ValidateSalary;
import PaymentManagement.context.ManagingPayment.model.Payment;
import CourseManagement.context.ManagingCourse.Controller.ValidateCourse;
import utils.Help;

public class SalaryPage {
    Teacher currentTeacher = Home.currentTeacher;
    private void printBanner(){
        Help.border('=', 100);
        System.out.println("Salary Page");
        Help.border('=', 100);
        System.out.println();
    }

    private void printTeacherInformation(){
        System.out.println("> Teacher ID: " + currentTeacher.getId());
        System.out.println("> Teacher Name: " + currentTeacher.getName());
        System.out.println("> Total Students Teached: " + ValidateCourse.calculateTotalStudentsTeached());        
        System.out.println("Your salary is: " + currentTeacher.getSalary().getCurrency() + " " + currentTeacher.getSalary().getBalance());
        System.out.println();
    }

    public SalaryPage(){
        Help.cls();
        printBanner();

        // Everytime a student join a course, update teacher salary.
        System.out.println();
        int choice;
        do{
            printTeacherInformation();
            Help.list("Checkout Salary", "Back");
            choice = Help.prompt(">> ", 1, 2);

            if(choice == 1){
                currentTeacher.setSalary(new Payment(currentTeacher.getSalary().getCurrency(), 0.0));
            }
            else if(choice == 2){
                return;
            }
            
        } while(true);


    }
}