package model;

public class Student extends User {
	int courseId;

	public Student(int id, String name, String email, String password, int courseId) {
		super(id, name, email, password);
		this.courseId = courseId;
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
