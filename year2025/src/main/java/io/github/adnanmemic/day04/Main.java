package io.github.adnanmemic.day04;

import java.util.List;
import java.io.IOException;

import io.github.adnanmemic.util.FileHandler;

public class Main {

    public static void main(String[] args) {

        String path = "src/main/resources/day04/input.txt";
        FileHandler file = new FileHandler(path);
        List<String> content = null;

        try{
            content = file.readFile();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // TODO: implement main logic
        System.out.println(content); // only for testing
    }
}
