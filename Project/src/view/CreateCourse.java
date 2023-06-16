package view;

import CourseManagement.context.ManagingCourse.Controller.ValidateCourse;
// import model.*;
import utils.Help;

public class CreateCourse {
    public CreateCourse() {
        Help.border('=', 100);
        System.out.println("Create New Course");
        Help.border('=', 100);

        ValidateCourse.createCourse();
    }
}