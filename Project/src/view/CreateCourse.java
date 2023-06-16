package view;

// import model.*;
import utils.Help;
import CourseManagement.ManagingCourse.Controller.ValidateCourse;

public class CreateCourse {
    public CreateCourse() {
        Help.border('=', 100);
        System.out.println("Create New Course");
        Help.border('=', 100);

        ValidateCourse.createCourse();
    }
}