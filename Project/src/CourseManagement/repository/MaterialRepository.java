package CourseManagement.repository;

import java.io.*;
import java.util.*;
import CourseManagement.factory.MaterialFactory;
import CourseManagement.model.Material;
import base.Repository;
import utils.*;

public class MaterialRepository extends Repository {
    private static MaterialRepository instance = null;

    private MaterialRepository() {
        super("material");
    }

    public static MaterialRepository getInstance() {
        return instance == null ? new MaterialRepository() : instance;
    }

    private Material parseMaterial(String[] items) {
        int id = Integer.parseInt(items[0]);
        String name = items[1];
        String content = items[2];
        int courseId = Integer.parseInt(items[3]);

        return MaterialFactory.createMaterial(id, name, content, courseId);
    }

    public Material findById(int id) {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Material material = parseMaterial(reader.nextLine().split("#"));
                if (material.getId() == id) {
                    reader.close();
                    return material;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Material> findAllByCourseId(int courseId) {
        ArrayList<Material> materials = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Material material = parseMaterial(reader.nextLine().split("#"));
                if (material.getCourseId() == courseId) {
                    materials.add(material);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return materials;
    }

    public ArrayList<Material> getAll() {
        ArrayList<Material> materials = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                Material material = parseMaterial(reader.nextLine().split("#"));
                materials.add(material);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return materials;
    }

    public void insert(String name, String content, int courseId) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(Generate.generateLatestId(file)).add(name).add(content)
                    .add(courseId)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String name, String content, int courseId) {
        delete(id);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(new WriteDataBuilder().add(id).add(name).add(content).add(courseId)
                    .getResult());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Material delete(int id) {
        Material deleted = null;
        String tempContent = "";

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                Material material = parseMaterial(line.split("#"));

                if (material.getId() == id) {
                    deleted = material;
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