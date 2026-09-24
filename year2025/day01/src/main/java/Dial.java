import java.util.List;

public class Dial {
    private final int initialPosition;
    private final int range;

    /**
     * Creates a dial with a starting position and a specified range of numbers.
     * 
     * @param initialPosition the starting position of the dial
     * @param range           the range of the dial
     * @throws IllegalArgumentException if the initial position is negative or the
     *                                  range is not positive
     */
    public Dial(int initialPosition, int range) {
        if (initialPosition < 0)
            throw new IllegalArgumentException("initialPosition cannot be negative.");
        if (range <= 0)
            throw new IllegalArgumentException("range cannot be negative or zero.");

        this.initialPosition = initialPosition;
        this.range = range;
    }

    /**
     * Calculates the password from a sequence of rotations. The password is the
     * number of times the dial lands exactly on zero after a rotation.
     * 
     * @param rotations the list of rotations
     * @return the calculated password
     */
    public int getPassword(List<String> rotations) {
        int currentPosition = this.initialPosition;
        int countZeros = 0;

        for (String rotation : rotations) {
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

    /**
     * Part2: Calculates the password from a sequence of rotations. The password
     * is the number of times the dial passes through zero during a rotation
     * or if lands exactly on zero after a rotation.
     * 
     * @param rotations the list of rotations
     * @return the calculated password
     */
    public int getPasswordP2(List<String> rotations) {
        int currentPosition = this.initialPosition;
        int countZeros = 0;

        for (String rotation : rotations) {
            char direction = rotation.charAt(0);
            int distance = Integer.parseInt(rotation.substring(1));

            while (distance != 0) {

                switch (direction) {
                    case 'R':
                        currentPosition = (currentPosition + 1) % range;
                        break;
                    case 'L':
                        currentPosition = (((currentPosition - 1) % range) + range) % range;
                        break;
                }

                if (currentPosition == 0) {
                    countZeros++;
                }
                distance--;
            }
        }
        return countZeros;
    }
}
