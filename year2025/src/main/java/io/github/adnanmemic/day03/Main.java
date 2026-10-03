package io.github.adnanmemic.day03;

import io.github.adnanmemic.util.FileHandler;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("Error: expected at least one argument: 'part1' or 'part2'");
            return;
        }

        if (!args[0].equals("part1") && !args[0].equals("part2")) {
            System.err.println("Error: expected 'part1' or 'part2', but got '" + args[0] + "'");
            return;
        }

        String mode = args[0];

        String path = "src/main/resources/day03/input.txt";
        FileHandler file = new FileHandler(path);
        List<String> banks = null;

        try {
            banks = file.readFile();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        long maxElevatorJoltage = 0;

        for (String bank : banks) {
            Bank b = new Bank(bank);

            switch (mode) {
                case "part1":
                    maxElevatorJoltage += b.getMaxJoltage(2);
                    break;

                case "part2":
                    maxElevatorJoltage += b.getMaxJoltage(12);
                    break;
            }
        }

        System.out.println("Max joltage: " + maxElevatorJoltage);
    }
}
