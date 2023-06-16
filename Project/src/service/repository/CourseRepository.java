package service.repository;

import java.io.*;
import java.util.*;
import model.Course;
import service.factory.CourseFactory;
import utils.*;

public class CourseRepository extends Repository {
    private static CourseRepository instance = null;

    private CourseRepository() {
        super("course");
    }

    public static CourseRepository getInstance() {
        return instance == null ? new CourseRepository() : instance;
    }

    private Course parseCourse(String[] items) {
        int id = Integer.parseInt(items[0]);
        String name = items[1];
        String description = items[2];
        int teacherId = Integer.parseInt(items[3]);

        return CourseFactory.createCourse(id, name, description, teacherId);
    }

    public Course findById(int id) {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Course course = parseCourse(reader.nextLine().split("#"));
                if (course.getId() == id) {
                    reader.close();
                    return course;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Course> findAllByTeacherId(int teacherId) {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Course course = parseCourse(reader.nextLine().split("#"));
                if (course.getTeacherId() == teacherId) {
                    courses.add(course);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public ArrayList<Course> getAll() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Course course = parseCourse(reader.nextLine().split("#"));
                courses.add(course);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public void insert(String name, String description, int teacherId) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(Generate.generateLatestId(file)).add(name).add(description)
                    .add(teacherId)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String name, String description, int teacherId) {
        delete(id);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(id).add(name).add(description).add(teacherId)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Course delete(int id) {
        Course deleted = null;
        String tempContent = "";

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                Course course = parseCourse(line.split("#"));

                if (course.getId() == id) {
                    deleted = course;
                } else {
                    tempContent += line + "\n";
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(file, false);
            writer.append(tempContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    public void deleteAll() {
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}