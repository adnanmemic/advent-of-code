import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    private String path;
    private String[] idRanges;

    public FileHandler (String path) {
        this.path = path;
    }

    public String[] readFile () throws IOException{
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String content = file.readAllAsString();
            this.idRanges = content.split(",");
        }
        return this.idRanges;
    }
}
