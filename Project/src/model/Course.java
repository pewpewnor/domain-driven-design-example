package model;

public class Course {
    private int id;
    private int score;
    private String name;
    private String description;
    private int teacherId;

    public Course(int id, int score, String name, String description, int teacherId) {
        this.id = id;
        this.score = score;
        this.name = name;
        this.description = description;
        this.teacherId = teacherId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

}