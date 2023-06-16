package service.repository;

import java.io.*;
import java.util.*;
import model.*;
import service.factory.StudentFactory;
import utils.*;

public class StudentRepository extends Repository {
	private static StudentRepository instance = null;

	private StudentRepository() {
		super("student");
	}
	
	public static StudentRepository getInstance() {
		return instance == null ? new StudentRepository() : instance;
	}

	public Student parseStudent(String[] items) {
		int id = Integer.parseInt(items[0]);
		String name = items[1];
		String email = items[2];
		String password = items[3];

		return StudentFactory.createStudent(id, name, email, password);
	}
	
	public Student findById(int id) {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				Student student = parseStudent(reader.nextLine().split("#"));
				if (student.getId() == id) {
					reader.close();
					return student;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Student findByCredential(String email, String password) {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				Student student = parseStudent(reader.nextLine().split("#"));
				if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
					reader.close();
					return student;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Student> getAll() {
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				Student student = parseStudent(reader.nextLine().split("#"));
				students.add(student);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	public void insert(String name, String email, String password) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.append(new WriteDataBuilder().add(Generate.generateLatestId(file)).add(name).add(email).add(password).getResult());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, String name, String email, String password) {
		Student student = delete(id);
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.append(new WriteDataBuilder().add(student.getId()).add(name).add(email).add(password).getResult());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Student delete(int id) {
		Student deleted = null;
		String tempContent = "";

		try {
			Scanner reader = new Scanner(file);

			while (reader.hasNext()) {
				String line = reader.nextLine();
				Student student = parseStudent(line.split("#"));

				if (student.getId() == id) {
					deleted = student;
				}
				else {
					tempContent += line + "\n";
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			FileWriter writer = new FileWriter(file, false);
			writer.append(tempContent);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return deleted;
	}
	
	public void deleteAll() {
		try {
			FileWriter writer = new FileWriter(file, false);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}