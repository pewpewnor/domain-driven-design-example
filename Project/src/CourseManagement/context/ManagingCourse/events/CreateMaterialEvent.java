package CourseManagement.context.ManagingCourse.events;

public class CreateMaterialEvent {
    private String name;
    private String content;
    private int courseId;

    public CreateMaterialEvent(String name, String content, int courseId) {
        this.name = name;
        this.content = content;
        this.courseId = courseId;
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
