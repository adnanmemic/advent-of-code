import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Arguments: "part1" to run part 1 and "part2" to run part 2
        if (args.length < 1) {
            System.err.println("Error: expected at least one argument: 'part1' or 'part2'");
            return;
        }

        if (!args[0].equals("part1") && !args[0].equals("part2")) {
            System.err.println("Error: expected 'part1' or 'part2', but got '" + args[0] + "'");
            return;
        }

        String mode = args[0];

		String filePath = "src/main/resources/input.txt";
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
		int password = 0;

		switch (mode) {
			case "part1":
				password = dial.getPassword(rotations);
				break;
			case "part2":
				password = dial.getPasswordP2(rotations);
				break;
		}

		System.out.println("Password: " + password);
	}
}
