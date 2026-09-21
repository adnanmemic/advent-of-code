import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path = "resources/input.txt";
        String[] idRanges = null; 

        FileHandler file = new FileHandler(path);
        try {
            idRanges = file.readFile();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Id id = new Id(idRanges);
        List<String> invalidIds = id.invalidIds();
        long sum = id.sumOfInvalidIds(invalidIds);

        System.out.println(sum);
    }
}
