package junksuck.java.headfirst;

import java.util.ArrayList;

public class SimpleDotComTestDrive {
    private static ArrayList<String> locations;

    public static void main (String[] args) {
        int numOfGuesses=0;
        GameHelper helper = new GameHelper();

        SimpleDotCom dot = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);

        dot.setLocationCells(locations);
        boolean isAlive = true;

        while(isAlive == true) {
            String guess = helper.getUserInput("enter a number");
            String result = dot.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println(numOfGuesses + " guesses");
            }
        }
        dot.setLocationCells(locations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
    }
}
