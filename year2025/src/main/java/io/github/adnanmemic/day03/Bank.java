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
    public int getMaxJoltage() {
        int index1 = 0;
        int max = 0;
        for (int i = 0; i < this.batteries.length - 1; i++) {
            if (this.batteries[i] > max) {
                max = this.batteries[i];
                index1 = i;
            }
        }

        int index2 = 0;
        max = 0;
        for (int j = index1 + 1; j < this.batteries.length; j++) {
            if (this.batteries[j] > max) {
                max = this.batteries[j];
                index2 = j;
            }
        }

        return this.batteries[index1] * 10 + this.batteries[index2];
    }

    /**
     * Calculates the max joltage for one bank.
     *
     * @return the calculated max joltage
     */
    public long getMaxJoltagePart2() {
        int digits = 12;
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
