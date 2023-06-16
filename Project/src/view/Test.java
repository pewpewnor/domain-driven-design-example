package view;

import java.io.*;
import model.Student;
import service.repository.StudentRepository;

public class Test {

	private Test() {
		StudentRepository.getInstance().deleteAll();

		StudentRepository.getInstance().insert("name", "email", "password");
		StudentRepository.getInstance().insert("fuck", "email", "password");
		StudentRepository.getInstance().insert("raul", "email", "password");
		StudentRepository.getInstance().insert("juan ga", "email@gmail", "12434");

		System.out.println(StudentRepository.getInstance().getAll().get(3).getEmail());
	}

	public static void main(String[] args) {
		new Test();
	}
}
