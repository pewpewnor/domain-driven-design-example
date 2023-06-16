package CourseManagement.factory;

import CourseManagement.model.Course;
import base.Factory;

public class CourseFactory extends Factory {
    public static Course createCourse(int id, String name, String description, int teacherId) {
        return new Course(id, name, description, teacherId);
    }
}
