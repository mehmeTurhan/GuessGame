/**
 * An implementation of a Guess a Number game
 *
 * @author Ewa Syta
 * @author Mehmet Turhan
 *
 *@version 2.0 2/25/2021
 */

/**pseudocode
* GENERATE a random Number
* numbertries=1;
*GUESS a number between the upperBound and 0
*while actualTries <= numOfTries or guess != GENERATEDnum
*numbertries++;
*IF guess < numToGuess THEN
*print 'Too low'
*ELSE
*print 'Toohigh'
*ENDIF
*IF numbertries = maxtries - 1 THEN
*print there is only 1 try left
*ENDIF
*GUESS a number between the upperBound and 0
ENDWHILE

*IF GUESS = GENEREATEDnum THEN
*print congrats message, number of guesses it took
*ELSE
*print the right number was, GNERATEDnum
*ENDIF
*/

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    // Instance variables:
    private int upperBound; //max number to guess
    private int numToGuess; //randomly generated number to guess between 0 and upperBound
    private int numOfTries; //max number of tries
    private int actualTries; //actual number of tries during a game
    private boolean result; //game outcome, true if player won and false if player lost

//Constructors:

  /**
   * Constructs a new game instance
   *
   * @param upperBound upper bound for selecting numToGuess
   * @param numOfTries max number of tries
   */
    public GuessGame(int upperBound, int numOfTries) {
        //Add your code here
        this.upperBound = upperBound;
        this.numOfTries = numOfTries;
    }

//Methods

    /**
     * Sets up a new game by randomly generating a new number to guess and printing welcome info
     *
     * @random creates a random integer
     */
    private void setUpGame() {
        //Add your code here
        Random rand = new Random();
        numToGuess = rand.nextInt(upperBound+1);
        System.out.println("In this game, you will have maximum of " + numOfTries + " tries to guess the randomly generated number. For every guess, if it's not correct, the computer will tell you Too high or Too low.");
        System.out.println("You will continue to guess until you guess the correct number or exceed the allowed number of tries. You will also be warned when there is only 1 try left");
    }

    /**
     * Gets guesses from a player until correct number is guessed or max number of tries is exceeded
     *
     * @scanner scans the input
     */
    private void processGuesses() {
        //Add your code here
       actualTries=1;
       Scanner firstGuess = new Scanner(System.in);
       System.out.println("Guess a number between 0 and "+upperBound+":");
       int guess = firstGuess.nextInt();
       while (actualTries < numOfTries && guess != numToGuess) {
       actualTries++;
          if ( guess < numToGuess){
            System.out.println("Too low");}
         else{
            System.out.println("Too high");
          }
          if (actualTries == (numOfTries)) {
            System.out.println("there is only 1 try left");
          }
          Scanner newGuesses = new Scanner(System.in);
          System.out.println("Guess a number between 0 and "+upperBound+":");
          guess = newGuesses.nextInt();
      }
        if ( guess == numToGuess){
          result = true;
        }
      }

    /**
     * Displays a game summary based on the game outcome
     */
    private void finishGame() {
        //Add your code here
        if (result) {
          System.out.println("Congratulations, you guessed the right number in "+actualTries+" tries.");
        }
        else {
          System.out.println("Sorry you could not guess the right number in "+numOfTries+" tries, the correct number was: "+numToGuess);
        }
    }

    /*
     * Runs the three steps of a game: setting up a game, processing guesses, and finishing the game
     */
    public void play() {
        setUpGame();
        processGuesses();
        finishGame();
    }


    public static void main(String args[]) {

        if (args.length != 2){
          System.out.println("Sorry, invalid number of arguments");
          return;
        }

        if (Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0) {
          System.out.println("Sorry, invalid number of arguments");
          return;
        }

        GuessGame game = new GuessGame(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        game.play();
    }

}
