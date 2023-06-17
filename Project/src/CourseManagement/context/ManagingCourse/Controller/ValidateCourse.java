package CourseManagement.context.ManagingCourse.Controller;

import CourseManagement.repository.CourseRepository;
import PaymentManagement.factory.PaymentFactory;
import PaymentManagement.model.Payment;
import AccountManagement.model.Teacher;
// import AccountManagement.model.Student;
import AccountManagement.repository.StudentRepository;
import AccountManagement.repository.TeacherRepository;
import utils.Help;
import view.Home;
import java.util.*;
import CourseManagement.model.*;

public class ValidateCourse {

    public static void createCourse() {
        String name = "";
        String description = "";
        int teacherId = Home.getCurrentTeacher().getId();

        name = Help.strPrompt("Name [1-20 char]: ", 1, 20);
        description = Help.strPrompt("Description [1-100 char]: ", 1, 100);

        CourseRepository.getInstance().insert(name, description, teacherId);
    }

    public static ArrayList<Course> viewAllCourse() {
        return CourseRepository.getInstance().getAll();
    }

    public static Course viewStudentCurrentCourse() {
        int studentCourseId = Home.getCurrentStudent().getCourseId();
        return CourseRepository.getInstance().findById(studentCourseId);
    }

    public static ArrayList<Course> viewTeacherCurrentCourse() {
        int teacherCourse = Home.getCurrentTeacher().getId();
        return CourseRepository.getInstance().findAllByTeacherId(teacherCourse);
    }

    public static Course courseNotNull(int courseId) {
        if (CourseRepository.getInstance().findById(courseId) != null) {
            return CourseRepository.getInstance().findById(courseId);
        }
        return null;
    }

    public static void addStudentToCourse(int courseId) {
        // Domain event
        int courseTeacherId = CourseRepository.getInstance().findById(courseId).getTeacherId();
        Teacher courseTeacher = TeacherRepository.getInstance()
                .findById(courseTeacherId);

        Payment salary = PaymentFactory.createPayment(courseTeacher.getSalary().getCurrency(),
                courseTeacher.getSalary().getBalance() + 100000.0);

        TeacherRepository.getInstance().update(courseTeacher.getId(), courseTeacher.getName(), courseTeacher.getEmail(),
                courseTeacher.getPassword(), salary);

        StudentRepository.getInstance().update(Home.getCurrentStudent().getId(), Home.getCurrentStudent().getName(),
                Home.getCurrentStudent().getEmail(), Home.getCurrentStudent().getPassword(), courseId);
    }

    // public static int calculateStudentsInCourse(int courseId){
    // // need repository
    // }

    // public static int calculateTotalStudentsTeached() {
    // ArrayList<Course> courses = viewTeacherCurrentCourse();
    // int totalStudents = 0;
    // for (Course course : courses) {
    // totalStudents += calculateStudentsInCourse(course.getId());
    // }
    // return totalStudents;

    // }

}