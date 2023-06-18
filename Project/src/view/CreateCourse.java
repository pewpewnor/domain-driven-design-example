package view;

import CourseManagement.context.ManagingCourse.controller.CourseController;
import CourseManagement.context.ManagingCourse.events.CreateCourseEvent;
import utils.Help;

public class CreateCourse {
    public CreateCourse() {
        Help.border('=', 100);
        System.out.println("Create New Course");
        Help.border('=', 100);

        String name = Help.strPrompt("Name [1-20 char]: ", 1, 20);
        String description = Help.strPrompt("Description [1-100 char]: ", 1, 100);

        CourseController.createCourse(new CreateCourseEvent(name, description));
    }
}