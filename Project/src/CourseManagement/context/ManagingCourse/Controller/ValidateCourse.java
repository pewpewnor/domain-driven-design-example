package CourseManagement.context.ManagingCourse.Controller;

import CourseManagement.repository.CourseRepository;
import utils.Help;
import view.Home;

public class ValidateCourse {
    private static String name = "";
    private static String description = "";
    private static int teacherId = Home.currentTeacher.getId();

    public static void createCourse() {
        name = Help.strPrompt("Name [1-20 word]: ", 1, 20);
        description = Help.strPrompt("Description [1-100 word]", 1, 100);

        CourseRepository.getInstance().insert(name, description, teacherId);
    }
}