package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Generate {
    public static int generateLatestId(File file) {
        int highest = 0;

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                int id = Integer.parseInt(scan.nextLine().split("#")[0]);
                if (id > highest) {
                    highest = id;
                }
            }

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return highest + 1;
    }
}