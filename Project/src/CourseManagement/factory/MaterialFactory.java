package CourseManagement.factory;

import CourseManagement.model.Material;

public class MaterialFactory {
    public static Material createMaterial(int id, String name, String content, int courseId) {
        return new Material(id, name, content, courseId);
    }
}
