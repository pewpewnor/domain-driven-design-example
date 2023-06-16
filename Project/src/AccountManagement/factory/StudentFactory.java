package AccountManagement.factory;

import AccountManagement.model.Student;
import base.Factory;

public class StudentFactory extends Factory {

	public static Student createStudent(int id, String name, String email, String password, int courseId) {
		return new Student(id, name, email, password, courseId);
	}

}
