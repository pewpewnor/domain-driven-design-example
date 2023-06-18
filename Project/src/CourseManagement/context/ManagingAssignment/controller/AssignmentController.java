package CourseManagement.context.ManagingAssignment.controller;

import java.util.ArrayList;
import CourseManagement.context.ManagingAssignment.events.CreateAssignmentEvent;
import CourseManagement.model.Assignment;
import CourseManagement.repository.AssignmentRepository;

public abstract class AssignmentController {
    public static void createAssignment(CreateAssignmentEvent createAssignmentEvent) {
        AssignmentRepository.getInstance().insert(createAssignmentEvent.getName(),
                createAssignmentEvent.getDescription(), createAssignmentEvent.getCourseId());
    }

    public static ArrayList<Assignment> getAllAssignmentsForCourse(int courseId) {
        return AssignmentRepository.getInstance().findAllByCourseId(courseId);
    }

    public static Assignment getAssignmentById(int assignmentID) {
        return AssignmentRepository.getInstance().findById(assignmentID);
    }

}