package CourseManagement.context.ManagingSubmission.Controller;

public class Material {
    private int id;
    private String name;
    private String description;
    private Integer CourseID;

    public Material(int id, String name, String description, Integer CourseID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.CourseID = CourseID;
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

    public Integer getCourseID() {
        return this.CourseID;
    }

    public void setCourseID(Integer CourseID) {
        this.CourseID = CourseID;
    }


}