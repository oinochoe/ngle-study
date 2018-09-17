package junksuck.java.headfirst;

import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<SimpleDotCom> dotComsList = new ArrayList<SimpleDotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        SimpleDotCom one = new SimpleDotCom();
        one.setName("Pets.com");
        SimpleDotCom two = new SimpleDotCom();
        two.setName("etoys.com");
        SimpleDotCom three = new SimpleDotCom();
        three.setName("go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("yout goal is to sink three dot coms");
        System.out.println("pets.com, etoys.com, go2.com");
        System.out.println("try sink");

        for (SimpleDotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while(!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;

        String result = "miss";

        for (SimpleDotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame() {
        System.out.println("All Dotcoms ARE DEAD");
        if (numOfGuesses <= 18) {
            System.out.println("it only took you" + numOfGuesses + "guesses");
            System.out.println("you got out before your options sank");
        } else {
            System.out.println("took you long enough" + numOfGuesses + "guesses");
            System.out.println("fish are dancing with your options");
        }
    }

    public static void main (String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
