package AccountManagement.factory;

import AccountManagement.model.Teacher;
import base.Factory;

public class TeacherFactory extends Factory {

	public static Teacher createTeacher(int id, String name, String email, String password) {
		return new Teacher(id, name, email, password);
	}

}