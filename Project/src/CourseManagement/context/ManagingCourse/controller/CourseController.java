package CourseManagement.context.ManagingCourse.controller;

import CourseManagement.repository.CourseRepository;
import PaymentManagement.context.ManagingPayment.controller.PaymentController;
import PaymentManagement.context.ManagingPayment.events.SalaryIncreaseEvent;
import AccountManagement.model.Student;
import AccountManagement.repository.StudentRepository;
import view.Home;
import java.util.*;
import CourseManagement.context.ManagingCourse.events.*;
import CourseManagement.model.*;

public class CourseController {

    public static void createCourse(CreateCourseEvent createCourseEvent) {
        CourseRepository.getInstance().insert(createCourseEvent.getName(), createCourseEvent.getDescription(),
                createCourseEvent.getTeacherId());
    }

    public static ArrayList<Course> viewAllCourses() {
        return CourseRepository.getInstance().getAll();
    }

    public static Course viewStudentCurrentCourses() {
        int studentId = Home.getCurrentStudent().getCourseId();
        return CourseRepository.getInstance().findById(studentId);
    }

    public static ArrayList<Course> viewTeacherCurrentCourses() {
        int teacherId = Home.getCurrentTeacher().getId();
        return CourseRepository.getInstance().findAllByTeacherId(teacherId);
    }

    public static Course getCourseById(int courseId) {
        return CourseRepository.getInstance().findById(courseId);
    }

    public static void addStudentToCourse(StudentJoinCourseEvent studentJoinCourseEvent) {
        Student student = studentJoinCourseEvent.getStudent();

        PaymentController.salaryIncrease(new SalaryIncreaseEvent(studentJoinCourseEvent.getCourseId()));
        StudentRepository.getInstance().update(student.getId(), student.getName(),
                student.getEmail(), student.getPassword(),
                studentJoinCourseEvent.getCourseId());
    }

}