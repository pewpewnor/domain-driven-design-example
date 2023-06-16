package CourseManagement.context.ManagingCourse.Controller;

import CourseManagement.repository.CourseRepository;
import utils.Help;
import view.Home;
import java.util.*;
import CourseManagement.model.*;

public class ValidateCourse {

    public static void createCourse() {
        String name = "";
        String description = "";
        int teacherId = Home.currentTeacher.getId();

        name = Help.strPrompt("Name [1-20 char]: ", 1, 20);
        description = Help.strPrompt("Description [1-100 char]: ", 1, 100);

        CourseRepository.getInstance().insert(name, description, teacherId);
    }

    public static ArrayList<Course> viewAllCourse() {
        return CourseRepository.getInstance().getAll();
    }

    public static Course viewStudentCurrentCourse() {
        int studentCourse = Home.currentStudent.getCourseId();
        return CourseRepository.getInstance().findById(studentCourse);
    }

    public static ArrayList<Course> viewTeacherCurrentCourse() {
        int teacherCourse = Home.currentTeacher.getId();
        return CourseRepository.getInstance().findAllByTeacherId(teacherCourse);
    }
}