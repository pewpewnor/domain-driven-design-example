package CourseManagement.context.ManagingCourse.events;

import view.Home;

public class CreateCourseEvent {
    private int teacherId;
    private String name;
    private String description;

    public CreateCourseEvent(String name, String description) {
        this.teacherId = Home.getCurrentTeacher().getId();
        this.name = name;
        this.description = description;
    }

    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

}
