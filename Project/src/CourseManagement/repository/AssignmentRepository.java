package CourseManagement.repository;

import java.io.*;
import java.util.*;
import CourseManagement.factory.AssignmentFactory;
import CourseManagement.model.Assignment;
import base.Repository;
import utils.*;

public class AssignmentRepository extends Repository {
    private static AssignmentRepository instance = null;

    private AssignmentRepository() {
        super("assignment");
    }

    public static AssignmentRepository getInstance() {
        return instance == null ? new AssignmentRepository() : instance;
    }

    private Assignment parseAssignment(String[] items) {
        int id = Integer.parseInt(items[0]);
        String name = items[1];
        String description = items[2];
        int courseId = Integer.parseInt(items[3]);

        return AssignmentFactory.createAssignment(id, name, description, courseId);
    }

    public Assignment findById(int id) {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Assignment assignment = parseAssignment(reader.nextLine().split("#"));
                if (assignment.getId() == id) {
                    reader.close();
                    return assignment;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Assignment> findAllByCourseId(int courseId) {
        ArrayList<Assignment> assignments = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Assignment assignment = parseAssignment(reader.nextLine().split("#"));
                if (assignment.getCourseId() == courseId) {
                    assignments.add(assignment);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return assignments;
    }

    public ArrayList<Assignment> getAll() {
        ArrayList<Assignment> assignments = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Assignment assignment = parseAssignment(reader.nextLine().split("#"));
                assignments.add(assignment);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return assignments;
    }

    public void insert(String name, String description, int courseId) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(Generate.generateLatestId(file)).add(name).add(description)
                    .add(courseId)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String name, String description, int courseId) {
        delete(id);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(id).add(name).add(description).add(courseId)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Assignment delete(int id) {
        Assignment deleted = null;
        String tempContent = "";

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                Assignment assignment = parseAssignment(line.split("#"));

                if (assignment.getId() == id) {
                    deleted = assignment;
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