package CourseManagement.context.ManagingCourse.controller;

import java.util.ArrayList;
import CourseManagement.repository.MaterialRepository;
import CourseManagement.context.ManagingCourse.events.CreateMaterialEvent;
import CourseManagement.model.*;

public class MaterialController {
    public static ArrayList<Material> getAllMaterialsForCourse(int courseId) {
        return MaterialRepository.getInstance().findAllByCourseId(courseId);
    }

    public static void createMaterial(CreateMaterialEvent createMaterialEvent) {
        MaterialRepository.getInstance().insert(createMaterialEvent.getName(), createMaterialEvent.getContent(),
                createMaterialEvent.getCourseId());
    }
}
