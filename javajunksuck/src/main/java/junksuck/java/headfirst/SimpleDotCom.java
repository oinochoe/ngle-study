package junksuck.java.headfirst;

import java.util.ArrayList;

public class SimpleDotCom {

    static int[] locationCells;
    static int numOfHits= 0;

    public static void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public static String checkYourself(String stringGuess) {
        // Converts an int to a String
        int guess = Integer.parseInt(stringGuess);
        String result = "You're shit! Miss!";

        // Repeat for each location cell populated
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "Hit";
                numOfHits++; // Increase numOfHits by 1
                break; // Gets you out of the loop
            }
        }
        // Does numOfHits = the number of cells taken up by the target
        if (numOfHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}
