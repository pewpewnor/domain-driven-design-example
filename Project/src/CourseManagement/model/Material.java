package CourseManagement.model;

public class Material {
    private int id;
    private String name;
    private String content;
    int courseId;

    public Material(int id, String name, String content, int courseId) {
        this.id = id;
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}