package CourseManagement.context.ManagingCourse.Controller;

import CourseManagement.repository.CourseRepository;
import PaymentManagement.context.ManagingPayment.model.Payment;
// import AccountManagement.model.Student;
import AccountManagement.repository.StudentRepository;
import utils.Help;
import view.Home;
import java.util.*;
import CourseManagement.model.*;

public class ValidateCourse {

    public static void createCourse() {
        String name = "";
        String description = "";
        int teacherId = Home.currentTeacher.getId();

        name = Help.strPrompt("Name [1-20 char]: ", 1, 20);
        description = Help.strPrompt("Description [1-100 char]: ", 1, 100);

        CourseRepository.getInstance().insert(name, description, teacherId);
    }

    public static ArrayList<Course> viewAllCourse() {
        return CourseRepository.getInstance().getAll();
    }

    public static Course viewStudentCurrentCourse() {
        int studentCourse = Home.currentStudent.getCourseId();
        return CourseRepository.getInstance().findById(studentCourse);
    }

    public static ArrayList<Course> viewTeacherCurrentCourse() {
        int teacherCourse = Home.currentTeacher.getId();
        return CourseRepository.getInstance().findAllByTeacherId(teacherCourse);
    }

    public static boolean courseNotNull(int courseId) {
        if (CourseRepository.getInstance().findById(courseId) != null) {
            return true;
        }
        return false;
    }

    public static void addStudentToCourse(int courseId) {
        Payment salary = new Payment(Home.currentTeacher.getSalary().getCurrency() , calculateTotalStudentsTeached() * 100000.0);
        Home.currentTeacher.setSalary(salary);

        StudentRepository.getInstance().update(Home.currentStudent.getId(), Home.currentStudent.getName(),
                Home.currentStudent.getEmail(), Home.currentStudent.getPassword(), courseId);
    }

    public static int calculateStudentsInCourse(int courseId){
        // need repository
    }

    public static int calculateTotalStudentsTeached(){
        ArrayList<Course> courses = viewTeacherCurrentCourse();
        int totalStudents = 0;
        for (Course course : courses) {
            totalStudents += calculateStudentsInCourse(course.getId());
        }
       return totalStudents;

    }

}