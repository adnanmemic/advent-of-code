package io.github.adnanmemic.day03;

public class Bank {

    private int[] batteries;

    /**
     * Creates a new bank.
     *
     * @param bank the String containing numbers for each battery
     */
    public Bank(String bank) {
        String[] batteriesString = bank.split("");
        
            this.batteries = new int[batteriesString.length];
        for (int i = 0; i < batteriesString.length; i++) {
            this.batteries[i] = Integer.parseInt(batteriesString[i]);
        }
    }

    /**
     * Calculates the max joltage for one bank.
     *
     * @return the calculated max joltage
     */
    public long getMaxJoltage(int digits) {
        int prevIndex = 0;
        long maxJoltage = 0;

        for (int i = digits; i > 0; i--) {
            int max = 0;
            int maxIndex = prevIndex;

            for (int j = prevIndex; j < this.batteries.length - i + 1; j++) {

                if (this.batteries[j] > max) {
                    max = this.batteries[j];
                    maxIndex = j;
                }
            }

            prevIndex = maxIndex + 1;
            maxJoltage = maxJoltage * 10 + max;
        }

        return maxJoltage;
    }
}
