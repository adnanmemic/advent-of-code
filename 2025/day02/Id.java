import java.util.ArrayList;
import java.util.List;

public class Id {

    private String[][] idList;

    /**
     * Creates a new ID object.
     * 
     * @param idRanges the array of all ID ranges.
     * @throws IllegalArgumentException if idRanges is null or empty
     */
    public Id(String[] idRanges) {
        if (idRanges == null || idRanges.length == 0)
            throw new IllegalArgumentException("idRanges cannot be null or empty.");

        this.idList = new String[idRanges.length][2];

        for (int i = 0; i < idRanges.length; i++) {
            this.idList[i] = idRanges[i].strip().split("-");
        }
    }

    /**
     * Creates a list of all IDs that are invalid.
     * 
     * @param mode the mode that specifies when an ID is invalid
     * @return a list of all invalid IDs
     */
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

    /**
     * Calculates the sum of all invalid IDs.
     * 
     * @param invalidIds the list of all invalid IDs
     * @return the sum of all invalid IDs
     */
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

    /**
     * Checks if an ID is valid. An ID is invalid if it consists of a sequence 
     * of digits repeated twice, i.e. 121 occurs twice in 121121.
     * 
     * @param id the ID to be checked
     * @return true if the ID is valid, false otherwise
     */
    public boolean isValid(String id) {
        boolean valid = true;
        int idLength = id.length();

        // A repeated sequence is only possible if the ID length is divisible by 2
        if (idLength % 2 != 0)
            return true;

        String substring1 = id.substring(0, idLength / 2);
        String substring2 = id.substring(idLength / 2);
        if (substring1.equals(substring2)) {
            valid = false;
        }

        return valid;
    }

    /**
     * Part2: Checks if an ID is valid. An ID is invalid if it consists of a
     * sequence of digits repeated at least twice, i.e. 121 occurs twice in
     * 121121, 34 occurs three times in 343434 etc.
     * 
     * @param id the ID to be checked
     * @return true if the ID is valid, false otherwise
     */
    public boolean isValidP2(String id) {
        boolean valid = true;
        int idLength = id.length();

        // begin with 2 because a sequence must be repeated at least twice
        for (int i = 2; i <= idLength; i++) {
            if (idLength % i != 0)
                continue;

            int piece = idLength / i;
            int previous = piece;
            int counter = 0; // counts the matches between substring1 and substring2

            String substring1 = id.substring(0, piece);

            while (previous + piece <= idLength) {
                String substring2 = id.substring(previous, previous + piece);
                if (substring1.equals(substring2))
                    counter++;
                previous += piece;
            }

            // i - 1 because the first substring is not compared
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
