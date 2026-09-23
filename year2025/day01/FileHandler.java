package day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String path;
    private List<String> rotations;

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
        rotations = new ArrayList<>();
    }

    /**
     * Loads the rotations from the file.
     * 
     * @throws IOException if an I/O error occurs while reading the file
     */
    public void readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            String lineContent;
            while ((lineContent = reader.readLine()) != null) {
                this.rotations.add(lineContent);
            }
        }
    }

    /**
     * Returns the rotations.
     * 
     * @return the rotations
     */
    public List<String> getRotations() {
        return this.rotations;
    }
}
