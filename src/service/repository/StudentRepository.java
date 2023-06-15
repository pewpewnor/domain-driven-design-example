package service.repository;

import java.io.*;
import java.util.*;
import model.*;
import service.factory.StudentFactory;
import service.utils.*;

public class StudentRepository extends Repository {
	private static StudentRepository instance = null;

	private StudentRepository() {
		super("student");
	}
	
	public static StudentRepository getInstance() {
		return instance == null ? new StudentRepository() : instance;
	}

	public void insert(String name, String email, String password) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.append(new WriteDataBuilder().add(GenerateID.generateLatestId(file)).add(name).add(email).add(password).getResult());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Model find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Student> getAll() {
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				String[] items = reader.nextLine().split("#");
				
				int id = Integer.parseInt(items[0]);
				String name = items[1];
				String email = items[2];
				String password = items[3];
				
				students.add(StudentFactory.createStudent(id, name, email, password));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	
}
