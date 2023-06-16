package CourseManagement.model;

public class Assignment {
    private int id;
    private String name;
    private String description;
    private int courseId;

    public Assignment(int id, String name, String description, int courseId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseId = courseId;
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

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
