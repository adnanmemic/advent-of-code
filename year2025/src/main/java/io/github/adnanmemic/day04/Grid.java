package io.github.adnanmemic.day04;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<char[]> content;

    /**
     * Creates a new grid.
     *
     * @param grid the grid containing the paper rolls
     */
    public Grid(List<char[]> grid) {
        this.content = grid;
    }

    /**
     * Gets the number of adjacent paper rolls.
     *
     * @param row the row of the paper roll
     * @param column the column of the paper roll
     * @return the number of adjacent paper rolls
     */
    public int adjacentRollPapers(int row, int column) {
        int count = 0; // counts adjacent paper rolls

        int minRow = row == 0 ? 0 : -1;
        int maxRow = row == this.content.size() - 1 ? 1 : 2;

        int minColumn = column == 0 ? 0 : -1;
        int maxColumn = column == this.content.get(row).length - 1 ? 1 : 2;

        for (int i = minRow; i < maxRow; i++) {
            for (int j = minColumn; j < maxColumn; j++) {
                if (i != 0 || j != 0) {
                    if (this.content.get(row + i)[column + j] == '@') {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Part2: Removes all removable paper rolls by replacing '@' with '.'.
     *
     * @return the number of removed paper rolls
     */
    public int removeRollPaper() {
        List<int[]> removable = new ArrayList<>();

        for (int row = 0; row < content.size(); row++)
            for (int column = 0; column < content.get(row).length; column++)
                if (content.get(row)[column] == '@' && this.adjacentRollPapers(row, column) < 4) {
                    removable.add(new int[] {row, column});
                }

        for (int[] coordinates : removable) {
            int row = coordinates[0];
            int column = coordinates[1];

            content.get(row)[column] = '.';
        }

        return removable.size();
    }
}
