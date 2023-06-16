package view;

import model.*;
import utils.Help;
import java.util.ArrayList;

public class JoinedCourse {

    public void JoinedCourseStudent(Student user) {
        Course course = null;
        System.out.println("Course ID: " + course.getId());
        System.out.println("Course Name: " + course.getName());
        System.out.println("Course Teacher: " + course.getTeachers().getName());
        System.out.println("Course Description: ");
        System.out.println(course.getDescription());

        System.out.println();
        for (Assignment assignment : course.getAssignments()) {

        }

    }

    public void JoinedCourseTeacher(Teacher user) {
        ArrayList<Course> course = null;

    }

    public JoinedCourse(User user) {
        Help.border('=', 100);
        System.out.println("Joined Course");
        Help.border('=', 100);

        if (user instanceof Student) {
            JoinedCourseStudent((Student) user);
        } else if (user instanceof Teacher) {
            JoinedCourseTeacher((Teacher) user);
        }
    }
}