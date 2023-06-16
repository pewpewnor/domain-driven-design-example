package CourseManagement.factory;

import CourseManagement.model.Assignment;
import base.Factory;

public class AssignmentFactory extends Factory {
    public static Assignment createAssignment(int id, String name, String description, int courseId) {
        return new Assignment(id, name, description, courseId);
    }
}
