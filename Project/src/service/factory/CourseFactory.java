package service.factory;

import model.Course;

public class CourseFactory extends Factory {
    public static Course createCourse(int id, String name, String description, int teacherId) {
        return new Course(id, name, description, teacherId);
    }
}
