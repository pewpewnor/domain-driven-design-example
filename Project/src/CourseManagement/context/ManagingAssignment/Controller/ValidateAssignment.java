package CourseManagement.context.ManagingAssignment.Controller;

import java.util.ArrayList;
import CourseManagement.model.*;
import CourseManagement.model.Assignment;
import CourseManagement.repository.AssignmentRepository;
import utils.Help;
import view.Home;
import CourseManagement.repository.CourseRepository;

public abstract class ValidateAssignment {
    public static void createAssignment(Course selectedCourse) {
        int teacherId = Home.getCurrentTeacher().getId();

        String name = Help.strPrompt("Assignment name: ", 1);
        String description = Help.strPrompt("description: ", 1);

        AssignmentRepository.getInstance().insert(name, description, selectedCourse.getId());
    }

    public static ArrayList<Assignment> getAllAssignmentsForCourse(int courseId) {
        return AssignmentRepository.getInstance().findAllByCourseId(courseId);
    }

    public static Assignment assignmentNotNull(int assignmentID) {
        if (AssignmentRepository.getInstance().findById(assignmentID) != null) {
            return AssignmentRepository.getInstance().findById(assignmentID);
        }
        return null;
    }

}