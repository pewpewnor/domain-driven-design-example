package CourseManagement.context.ManagingAssignment.Controller;

import java.util.ArrayList;
import CourseManagement.model.*;
import CourseManagement.model.Assignment;
import CourseManagement.repository.AssignmentRepository;
import utils.Help;
import view.Home;
import CourseManagement.repository.CourseRepository;

public abstract class ValidateAssignment {
    public static void createAssignment() {
        int teacherId = Home.currentTeacher.getId();

        ArrayList<Course> course = CourseRepository.getInstance().findAllByTeacherId(teacherId);

        String name = Help.strPrompt("name: ", 1);
        String description = Help.strPrompt("description: ", 1);
        int courseId = Help.prompt("course ID: ", 1, course.size());

        AssignmentRepository.getInstance().insert(name, description, courseId);
    }

    public static ArrayList<Assignment> getAllAssignmentsForCourse(int courseId) {
        return AssignmentRepository.getInstance().findAllByCourseId(courseId);
    }

}