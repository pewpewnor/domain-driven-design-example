package model;

import java.util.*;

public class Course {
    private int id;
    private int score;
    private String name;
    private String description;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Assignment> assignments;

    public Course(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }
}