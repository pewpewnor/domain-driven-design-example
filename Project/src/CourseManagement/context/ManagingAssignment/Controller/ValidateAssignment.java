package CourseManagement.context.ManagingAssignment.Controller;

import java.util.ArrayList;
import CourseManagement.model.Assignment;
import CourseManagement.repository.AssignmentRepository;
import utils.Help;

public abstract class ValidateAssignment {
    public static void createAssignment() {
        String name = Help.strPrompt("name: ", 1);
        String description = Help.strPrompt("description: ", 1);
        int course = Help.prompt("course id: ", 1, 10);

        AssignmentRepository.getInstance().insert(name, description, course);
    }

    public void gradeAssignment() {

    }

    public static ArrayList<Assignment> getAllAssignmentsForCourse(int courseId) {
        return AssignmentRepository.getInstance().findAllByCourseId(courseId);
    }

}
