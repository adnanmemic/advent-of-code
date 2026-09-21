import java.util.ArrayList;
import java.util.List;

public class Id {

    private String[][] idList;

    public Id(String[] idRanges) {
        if (idRanges == null || idRanges.length == 0)
            throw new IllegalArgumentException("idRanges cannot be null or empty.");

        this.idList = new String[idRanges.length][2];

        for (int i = 0; i < idRanges.length; i++) {
            this.idList[i] = idRanges[i].strip().split("-");
        }
    }

    public List<String> invalidIds(String mode) {
        List<String> invalidIds = new ArrayList<>();

        for (int i = 0; i < this.idList.length; i++) {
            long begin = Long.parseLong(idList[i][0]); // id range begin
            long end = Long.parseLong(idList[i][1]); // id range end

            for (long j = begin; j <= end; j++) {
                String id = String.valueOf(j);
                boolean valid = false;

                // Add if id has a repeated sequence
                if (mode.equals("part1")) { // Part 1
                    valid = this.isValid(id);
                } else if (mode.equals("part2")) { // Part 2
                    valid = this.isValidP2(id);
                }

                if (!valid)
                    invalidIds.add(id);
            }
        }
        return invalidIds;
    }

    public long sumOfInvalidIds(List<String> invalidIds) {
        if (invalidIds == null)
            throw new IllegalArgumentException("invalidIds cannot be null.");

        long sum = 0;
        for (String invalidId : invalidIds) {
            long invalidIdAsLong = Long.parseLong(invalidId);
            sum += invalidIdAsLong;
        }
        return sum;
    }

    public boolean isValid(String id) {
        boolean valid = true;
        int idLength = id.length();
        String substring1 = id.substring(0, idLength / 2);
        String substring2 = id.substring(idLength / 2);

        if (substring1.equals(substring2)) {
            valid = false;
        }

        return valid;
    }

    public boolean isValidP2(String id) {
        boolean valid = true;
        int idLength = id.length();

        // begin with 2 because with one there is no substring
        for (int i = 2; i <= idLength; i++) {
            if (idLength % i != 0)
                continue;

            int piece = idLength / i;
            int previous = piece;
            int counter = 0;
            String substring1 = id.substring(0, piece);

            while (previous + piece <= idLength) {
                String substring2 = id.substring(previous, previous + piece);
                if (substring1.equals(substring2))
                    counter++;
                previous += piece;
            }

            // i - 1 because the first substring doesn't count
            if (counter == i - 1) {
                valid = false;
                break;
            } else {
                valid = true;
            }
        }
        return valid;
    }
}
