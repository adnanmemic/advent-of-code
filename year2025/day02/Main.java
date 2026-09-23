package day02;

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

        String path = "resources/input.txt";
        FileHandler file = new FileHandler(path);
        try {
            String[] idRanges = file.readFile();

            Id id = new Id(idRanges);

            List<String> invalidIds = id.invalidIds(mode);
            long sum = id.sumOfInvalidIds(invalidIds);

            System.out.println("Sum of all invalid IDs: " + sum);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
