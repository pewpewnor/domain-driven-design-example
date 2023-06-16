package service.factory;

import model.Teacher;

public class TeacherFactory extends Factory {

	public static Teacher createTeacher(int id, String name, String email, String password) {
		return new Teacher(id, name, email, password);
	}
	
}