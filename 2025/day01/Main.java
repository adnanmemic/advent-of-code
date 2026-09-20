import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String filePath = "resources/input.txt";
		List<String> rotations;
		FileHandling file = new FileHandling(filePath);

		try {
			file.readFile();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		rotations = file.getRotations();
		// int lineCounter = 0;
		// for (String rotation : rotations) {
		// 	lineCounter++;
		// 	System.out.println(lineCounter + ": " + rotation);
		// }
	}
}
