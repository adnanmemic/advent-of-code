package io.github.adnanmemic.day03;

public class Bank {

    private String[] batteries;

    /**
     * Creates a new bank.
     *
     * @param bank the String containing numbers for each battery
     */
    public Bank(String bank) {
        this.batteries = bank.split("");
    }

    /**
     * Calculates the max joltage for one bank.
     *
     * @return the calculated max joltage
     */
    public int getMaxJoltage() {
        int maxJoltage = 0;

        for (int i = 0; i < this.batteries.length - 1; i++) {
            for (int j = i + 1; j < this.batteries.length; j++) {
                String joltString = "" + this.batteries[i] + this.batteries[j];
                int joltage = Integer.parseInt(joltString);
                maxJoltage = joltage > maxJoltage ? joltage : maxJoltage;
            }
        }

        return maxJoltage;
    }
}
