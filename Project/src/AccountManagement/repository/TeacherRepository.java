package AccountManagement.repository;

import java.io.*;
import java.util.*;
import AccountManagement.factory.*;
import AccountManagement.model.*;
import PaymentManagement.model.Payment;
import base.*;
import utils.*;

public class TeacherRepository extends Repository {
	private static TeacherRepository instance = null;

	private TeacherRepository() {
		super("teacher");
	}

	public static TeacherRepository getInstance() {
		return instance == null ? new TeacherRepository() : instance;
	}

	private Teacher parseTeacher(String[] items) {
		int id = Integer.parseInt(items[0]);
		String name = items[1];
		String email = items[2];
		String password = items[3];
		String currency = items[4];
		double balance = Double.parseDouble(items[5]);

		return TeacherFactory.createTeacher(id, name, email, password, currency, balance);
	}

	public Teacher findById(int id) {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				Teacher teacher = parseTeacher(reader.nextLine().split("#"));
				if (teacher.getId() == id) {
					reader.close();
					return teacher;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Teacher findByCredential(String email, String password) {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				Teacher teacher = parseTeacher(reader.nextLine().split("#"));
				if (teacher.getEmail().equals(email) && teacher.getPassword().equals(password)) {
					reader.close();
					return teacher;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Teacher> getAll() {
		ArrayList<Teacher> teachers = new ArrayList<>();

		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNext()) {
				Teacher teacher = parseTeacher(reader.nextLine().split("#"));
				teachers.add(teacher);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return teachers;
	}

	public void insert(String name, String email, String password) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.append(new WriteDataBuilder().add(Generate.generateLatestId(file)).add(name).add(email).add(password)
					.add("IDR").add(0.0)
					.getResult());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, String name, String email, String password, Payment payment) {
		delete(id);
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.append(new WriteDataBuilder().add(id).add(name).add(email).add(password)
					.add(payment.getCurrency()).add(payment.getBalance())
					.getResult());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Teacher delete(int id) {
		Teacher deleted = null;
		String tempContent = "";

		try {
			Scanner reader = new Scanner(file);

			while (reader.hasNext()) {
				String line = reader.nextLine();
				Teacher teacher = parseTeacher(line.split("#"));

				if (teacher.getId() == id) {
					deleted = teacher;
				} else {
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