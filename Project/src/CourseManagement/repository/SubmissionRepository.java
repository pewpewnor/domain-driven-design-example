package CourseManagement.repository;

import java.io.*;
import java.util.*;
import CourseManagement.factory.SubmissionFactory;
import CourseManagement.model.Submission;
import base.Repository;
import utils.*;

public class SubmissionRepository extends Repository {
    private static SubmissionRepository instance = null;

    private SubmissionRepository() {
        super("submission");
    }

    public static SubmissionRepository getInstance() {
        return instance == null ? new SubmissionRepository() : instance;
    }

    private Submission parseSubmission(String[] items) {
        int assignmentId = Integer.parseInt(items[0]);
        int studentId = Integer.parseInt(items[1]);
        String answer = items[3];
        int score = Integer.parseInt(items[4]);

        return SubmissionFactory.createSubmission(assignmentId, studentId, answer, score);
    }

    // public Submission findByAssignmentAndStudentId(int assignmentId, int
    // studentId) {
    // try {
    // Scanner reader = new Scanner(file);
    // while (reader.hasNext()) {
    // Submission submission = parseSubmission(reader.nextLine().split("#"));
    // if (submission.getStudentId() == studentId && submission.getAssignmentId() ==
    // assignmentId) {
    // reader.close();
    // return submission;
    // }
    // }
    // reader.close();
    // } catch (FileNotFoundException e) {
    // e.printStackTrace();
    // }

    // return null;
    // }

    public ArrayList<Submission> findAllByAssignmentId(int assignmentId) {
        ArrayList<Submission> submissions = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Submission submission = parseSubmission(reader.nextLine().split("#"));
                if (submission.getAssignmentId() == assignmentId) {
                    submissions.add(submission);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return submissions;
    }

    public ArrayList<Submission> findAllByStudentId(int studentId) {
        ArrayList<Submission> submissions = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Submission submission = parseSubmission(reader.nextLine().split("#"));
                if (submission.getStudentId() == studentId) {
                    submissions.add(submission);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return submissions;
    }

    public ArrayList<Submission> getAll() {
        ArrayList<Submission> submissions = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Submission submission = parseSubmission(reader.nextLine().split("#"));
                submissions.add(submission);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return submissions;
    }

    public void insert(int assignmentId, int studentId, String answer, int score) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(assignmentId).add(studentId)
                    .add(answer)
                    .add(-1)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int assignmentId, int studentId, String answer, int score) {
        delete(assignmentId, studentId);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(assignmentId).add(studentId)
                    .add(answer)
                    .add(score)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Submission delete(int assignmentId, int studentId) {
        Submission deleted = null;
        String tempContent = "";

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                Submission submission = parseSubmission(line.split("#"));

                if (submission.getStudentId() == studentId && submission.getAssignmentId() == assignmentId) {
                    deleted = submission;
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