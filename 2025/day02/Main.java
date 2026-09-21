import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path = "resources/input.txt";
        FileHandler file = new FileHandler(path);

        try {
            String[] idRanges = file.readFile();

            Id id = new Id(idRanges);
            List<String> invalidIds = id.invalidIds();
            long sum = id.sumOfInvalidIds(invalidIds);

            System.out.println(sum);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
