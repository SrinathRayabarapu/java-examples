package com.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * TODO: find the original problem from hackerrank and solve
 *
 * amazon coding problem
 *
 * @author Srinath.Rayabarapu
 */
public class SearchForestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("C:\\Work\\input3.txt");
        int tilesCountShouldBe = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            String[] split = scanner.nextLine().split(" ");

            /*
             * Forest Initialization with capacity and initial forest will be filled
             * with all 0's
             */
            SearchForest sf = new SearchForest(Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]));

            /*
             * Printing the forest
             */
            sf.showForest();

            tilesCountShouldBe = Integer.parseInt(scanner.nextLine());
            System.out.println("Tiles Count Should Be :" + tilesCountShouldBe);

            /*
             * Add the tiles to the forest. Added Tiles values will be set to 1
             */
            int count = 0;
            while (scanner.hasNext()) {
                split = scanner.nextLine().split(" ");
                System.out.println(split[0] + ":" + split[1]);
                sf.add(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                count++;
            }
            System.out.println(count + " values read from the file");

            /*
             * Printing the modified Forest
             */
            sf.showForest();

            int cabinets = sf.getNumberOfCabinets();
            System.out.println("Cabinets : " + cabinets);

            // sf.showForest();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

/**
 * amazon coding puzzle
 *
 * @author Srinath.Rayabarapu
 *
 */
class SearchForest {

    private final int[][] forest;
    private int actualX = 0;
    private int actualY = 0;

    public SearchForest(int x, int y) {

        this.actualX = x;
        this.actualY = y;
        this.forest = new int[x][y];

        for (int i = 0; i < this.forest.length; i++) {
            for (int j = 0; j < this.forest[i].length; j++) {
                this.forest[i][j] = 0;
            }
        }

        System.out.println("Forest initialized with " + x + ":" + y);
    }

    public void showForest() {
        System.out.println("Forest:-------------------");
        for (int i = 0; i < this.forest.length; i++) {
            for (int j = 0; j < this.forest[i].length; j++) {
                System.out.print(this.forest[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public void add(int x, int y) {
        if (x > 0 && y > 0 && x <= this.actualX && y <= this.actualY) {
            this.forest[x - 1][y - 1] = 1;
        }
    }

    public int getNumberOfCabinets() {
        int cabinets = 0;
        for (int i = 0; i < this.forest.length; i++) {
            for (int j = 0; j < this.forest[i].length; j++) {
                if (this.forest[i][j] == 1) {
                    if (!hasANeighbour(i, j)) {
                        cabinets++;
                    }
                }
            }
        }
        return cabinets;
    }

    private boolean hasANeighbour(int i, int j) {

        this.forest[i][j] = -1;

        boolean result = true;
        if (isValid(i, j - 1) && this.forest[i][j - 1] == 1) {
            return hasANeighbour(i, j - 1);
        } else if (isValid(i - 1, j) && this.forest[i - 1][j] == 1) {
            return hasANeighbour(i - 1, j);
        } else if (isValid(i, j + 1) && this.forest[i][j + 1] == 1) {
            return hasANeighbour(i, j + 1);
        } else if (isValid(i + 1, j) && this.forest[i + 1][j] == 1) {
            return hasANeighbour(i + 1, j);
        } else
            result = false;

        return result;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < this.actualX && j < this.actualY;
    }
}