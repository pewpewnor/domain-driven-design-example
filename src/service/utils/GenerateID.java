package service.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerateID {
	public static int generateLatestId(File file) {
		String lastLine = null;
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNext()) {
				lastLine = scan.nextLine();
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastLine == null ? 0 : Integer.parseInt(lastLine.split("#")[0]) + 1;
	}
}
