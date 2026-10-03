package io.github.adnanmemic.day04;

import java.util.List;

public class Grid {

    private List<String> content;

    public Grid(List<String> grid) {
        this.content = grid;
    }

    public int adjacentRollPapers(int row, int column) {
        int count = 0;

        int minRow = row == 0 ? 0 : -1;
        int maxRow = row == this.content.size() - 1 ? 1 : 2;

        int minColumn = column == 0 ? 0 : -1;
        int maxColumn = column == this.content.get(row).length() - 1 ? 1 : 2;

        for(int i = minRow; i < maxRow; i++) {
            for(int j = minColumn; j < maxColumn; j++) {
                if (i != 0 || j != 0) {
                    if (this.content.get(row + i).charAt(column + j) == '@') {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
