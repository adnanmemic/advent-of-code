import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {
    private String filePath;
    private String[] rotations;

    public FileHandling(String filePath) {
        this.filePath = filePath;
        this.rotations = null;
    }

    public void readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String lineContent = null;
            int counter = 0;
            while ((lineContent = reader.readLine()) != null) {
                this.rotations[counter] = lineContent;
                counter++;
            }
        }
    }
}
