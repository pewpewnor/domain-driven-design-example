package CourseManagement.context.ManagingCourse.Controller;

import java.util.ArrayList;

import CourseManagement.repository.MaterialRepository;
import CourseManagement.model.*;
import utils.Help;

public class ValidateMaterial {
    private static String name;
    private static String content;
    private static int courseId;

    public static void printMaterial(Material material) {
        System.out.println("> Material ID: " + material.getId());
        System.out.println("> Material Name: " + material.getName());
        System.out.println("> Material Content: ");
        System.out.println(material.getContent());
        System.out.println("> Material Course ID: " + material.getCourseId());
    }

    public static void printAllMaterial(ArrayList<Material> materials) {
        for (Material material : materials) {
            printMaterial(material);
            System.out.println();
        }
    }

    public static ArrayList<Material> getAllMaterialsForCourse(int courseId) {
        return MaterialRepository.getInstance().findAllByCourseId(courseId);
    }

    public static void createMaterial(int CourseId) {
        printAllMaterial(getAllMaterialsForCourse(CourseId));
        name = Help.strPrompt("Enter material name: ", "Name cannot be empty", 1);
        content = Help.strPrompt("Enter material content: ", "Content cannot be empty", 1);
        courseId = CourseId;

        MaterialRepository.getInstance().insert(name, content, courseId);
    }
}
