package service.factory;

import java.io.*;
import model.Student;

public class StudentFactory extends Factory {

	public static Student createStudent(int id, String name, String email, String password) {
		return new Student(id, name, email, password);
	}
	
}
