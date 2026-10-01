package io.github.adnanmemic.day03;

import java.io.IOException;
import java.util.List;

import io.github.adnanmemic.util.FileHandler;


public class Main {

    public static void main(String[] args) {

        String path = "src/main/resources/day03/input.txt";
        FileHandler file = new FileHandler(path);
        List<String> banks;

        try {
            banks = file.readFile();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
