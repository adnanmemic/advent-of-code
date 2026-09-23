package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
     * Loads id ranges from the file.
     * 
     * @return array with id ranges
     * @throws IOException if an I/O error occurs while reading the file
     */
    public String[] readFile() throws IOException {
        String idRanges;
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            idRanges = file.readAllAsString();
        }
        return idRanges.split(",");
    }
}
