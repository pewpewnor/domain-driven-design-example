package CourseManagement.context.ManagingCourse.Controller;

import java.util.ArrayList;

import CourseManagement.repository.MaterialRepository;
import CourseManagement.model.*;

public class ValidateMaterial {
    public static ArrayList<Material> getAllMaterialsForCourse(int courseId) {
        return MaterialRepository.getInstance().findAllByCourseId(courseId);
    }
}
