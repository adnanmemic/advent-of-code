import java.util.List;

public class Dial {
    private int initialPosition;
    private int range;
    private List<String> rotations;

    public Dial(List<String> rotations, int initialPosition, int range) {
        this.rotations = rotations;
        this.initialPosition = initialPosition;
        this.range = range;
    }

    public int getPassword() {
        int currentPosition = this.initialPosition;
        int countZeros = 0;

        for (String rotation : this.rotations) {
            char direction = rotation.charAt(0);
            int distance = Integer.parseInt(rotation.substring(1));

            if (direction == 'R') {
                currentPosition = (currentPosition + distance) % range;
            } else if (direction == 'L') {
                currentPosition = (((currentPosition - distance) % range) + range) % range;
            }

            if (currentPosition == 0)
                countZeros++;
        }

        return countZeros;
    }
}
