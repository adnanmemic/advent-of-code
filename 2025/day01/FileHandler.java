import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String filePath;
    private List<String> rotations;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        rotations = new ArrayList<>();
    }

    public void readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String lineContent = null;
            while ((lineContent = reader.readLine()) != null) {
                this.rotations.add(lineContent);
            }
        }
    }

    public List<String> getRotations() {
        return this.rotations;
    }
}
