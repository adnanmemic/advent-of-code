import java.util.ArrayList;
import java.util.List;

public class Id {

    public String[][] idList;

    public Id(String[] idRanges) {
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

            for (long j = begin; j < end + 1; j++) {
                String id = String.valueOf(j);

                // Add if id has a repeated sequence
                int idLength = id.length();
                String substring1 = id.substring(0, idLength / 2);
                String substring2 = id.substring(idLength / 2, idLength);
                if (substring1.equals(substring2)) {
                    invalidIds.add(id);
                }
            }
        }
        return invalidIds;
    }

    public long sumOfInvalidIds(List<String> invalidIds) {
        long sum = 0;
        for (String invalidId : invalidIds) {
            long invalidIdAsInt = Long.parseLong(invalidId);
            sum += invalidIdAsInt;
        }
        return sum;
    }
}
