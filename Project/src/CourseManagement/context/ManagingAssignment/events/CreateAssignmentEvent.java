package CourseManagement.context.ManagingAssignment.events;

public class CreateAssignmentEvent {
    private String name;
    private String description;
    private int courseId;

    public CreateAssignmentEvent(String name, String description, int courseId) {
        this.name = name;
        this.description = description;
        this.courseId = courseId;
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
