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

    public List<String> invalidIds() {
        List<String> invalidIds = new ArrayList<>();

        for (int i = 0; i < this.idList.length; i++) {
            long begin = Long.parseLong(idList[i][0]);
            long end = Long.parseLong(idList[i][1]);

            for (long j = begin; j <= end; j++) {
                String id = String.valueOf(j);

                int idLength = id.length();
                if (idLength % 2 != 0) {
                    continue;
                }
                // Add if id has a repeated sequence
                if (!this.isValid(id)) {
                    invalidIds.add(id);
                }
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
}
