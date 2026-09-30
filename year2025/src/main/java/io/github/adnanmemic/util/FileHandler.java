package io.github.adnanmemic.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String path;

    /**
     * Creates a file handler for the specified file.
     * 
     * @param path the path to the file
     * @throws IllegalArgumentException if path is null or empty
     */
    public FileHandler(String path) {
        if (path == null || path.strip().equals(""))
            throw new IllegalArgumentException("path cannot be null or empty.");

        this.path = path;
    }

    /**
     * Loads the content from the file.
     * 
     * @throws IOException if an I/O error occurs while reading the file
     */
    public List<String> readFile() throws IOException {
        List<String> content = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            String lineContent;
            while ((lineContent = reader.readLine()) != null) {
                content.add(lineContent);
            }
        }

        return content;
    }
}
