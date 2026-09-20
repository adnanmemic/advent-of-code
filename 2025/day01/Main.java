import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String filePath = "resources/input.txt";
		List<String> rotations;
		FileHandler file = new FileHandler(filePath);

		try {
			file.readFile();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		rotations = file.getRotations();

		Dial dial = new Dial(50, 100);
		int password = dial.getPassword(rotations);

		System.out.println("Password: " + password);
	}
}
