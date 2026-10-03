package io.github.adnanmemic.day04;

import io.github.adnanmemic.util.FileHandler;

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

        String path = "src/main/resources/day04/input.txt";
        FileHandler file = new FileHandler(path);
        List<char[]> content = null;

        try {
            content = file.readFileAsCharArray();
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        Grid grid = new Grid(content);
        int count = 0;

        switch (mode) {
            case "part1":
                for (int row = 0; row < content.size(); row++)
                    for (int column = 0; column < content.get(row).length; column++)
                        if (content.get(row)[column] == '@'
                                && grid.adjacentRollPapers(row, column) < 4) count++;

                System.out.println("Total roll papers: " + count);

                break;

            case "part2":
                int removed;

                while ((removed = grid.removeRollPapers()) != 0) {
                    count += removed;
                }

                System.out.println("Total removed: " + count);

                break;
        }
    }
}
