package service.repository;

import java.io.*;

public abstract class Repository {
	protected File file;
	
	public Repository(String fileName) {
		final String filePath = "./database/";
		
		this.file = new File(filePath + fileName + ".txt");
	}
	
}
