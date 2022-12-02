package try_resource_usage;

import java.io.*;

public class Principal {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		String fileName = "myDocument.txt";
		
		try(FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(file)){
			System.out.println(buffer.readLine());
		}
	}
}
