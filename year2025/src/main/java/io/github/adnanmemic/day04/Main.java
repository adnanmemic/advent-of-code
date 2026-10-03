package io.github.adnanmemic.day04;

import java.util.List;
import java.io.IOException;

import io.github.adnanmemic.util.FileHandler;

public class Main {

    public static void main(String[] args) {

        String path = "src/main/resources/day04/input.txt";
        FileHandler file = new FileHandler(path);
        List<String> content = null;

        try{
            content = file.readFile();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Grid pd = new Grid(content);
        int count = 0;

        for (int row = 0; row < content.size(); row++)
            for (int column = 0; column < content.get(row).length(); column++)
                if (content.get(row).charAt(column) == '@' 
                        && pd.adjacentRollPapers(row, column) < 4)
                    count++;

        System.out.println("Total roll papers: " + count);

    }
}
