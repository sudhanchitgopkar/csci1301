/*
 * Bagels.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 10/17/19
 *
 * Purpose: This program contains methods for the bagels class which will be used in conjunction with both the
 * Player and Engine class in order to complete the game "Pico, Fermi, Bagels" - specifically, this class 
 * contains the main method which calls functions from the two aforementioned classes in order to run the actual game.
 * The game begins with a welcome message and takes input from the user regarding the amount of preferred digits
 * in the secret number as well as the name of the user. The program then completes one match of "Pico, Fermi, Bagels"
 * and then displays a congratulations message to the user alongside user statistics. The user is then given the option 
 * to play again, reset the game and play again, or to quit the game entirely. 
 *   
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.
 */

//imports scanner class for user input
import java.util.Scanner;
public class Bagels {

	public static void main(String[] args) {

		//variable declaration, instantiation
		String name="";
		String guess="";
		String userCommand="p";
		int numDigits=0;
		int numMoves=0;
		int gamesCompleted=0;
		int fastestWin= Integer.MAX_VALUE;
		int [] secretNumber;
		int [] guessArray;
		boolean correctGuess=false;

		//sets up scanner for keyboard input
		Scanner keyboard=new Scanner (System.in);

		//creates player and engine objects so that their methods may be used
		Player player = new Player();
		Engine engine = new Engine();

		//initial welcome statement
		System.out.println("Welcome!");

		//uses user input to determine amount of digits in the secret number
		engine.getNumDigits();
		numDigits=keyboard.nextInt();
		engine.setNumDigits(numDigits);

		//gets, sets player name
		name=player.getName();
		player.setName(name);

		// continually runs pico, fermi, bagel, while player wants to play again based on user command
		while (userCommand.equalsIgnoreCase("p")) {

			System.out.println();

			//outputs current game number to user
			System.out.println("Starting game #" + (gamesCompleted+1) + ".");

			//generates new secret number using engine class per numDigits specified by user
			engine.generateNewSecret();
			secretNumber=engine.getSecretNumber();
			guess="";

			//continually runs validator and takes user input for guesses while guess != secret number
			while (correctGuess==false) {
				//asks user for their guess
				guess=player.askForGuess();
				//increments number of moves taken for each guess
				numMoves++;
				//converts user guess from string to integer array
				guessArray=engine.convertNumToDigitArray(guess);
				//validates user guess per the secret number
				Validator.validateGuess(secretNumber, guessArray, numDigits);
				//if guess=secret number, changes boolean correctGuess to exit while loop
				correctGuess=true;
				for (int i=0;i<numDigits;i++) {
					if(guessArray[i]!=secretNumber[i]) {
						correctGuess=false;
					}
				}
			}

			//resets correctGuess to false for future games
			correctGuess=false;

			//increments games completed by 1
			gamesCompleted+=1;

			//checks if number of moves in last game is lower than past number of moves
			//if so, sets fastest win to current game number of moves
			if(numMoves<fastestWin) {
				fastestWin=numMoves;
			}

			//prints congratulations statement for winning the round
			System.out.println("Congratulations! You won in " + numMoves + " moves.");

			//prints user statistics
			System.out.println();
			System.out.println("Statistics for " + name + ":" );
			System.out.println("Games completed: " + gamesCompleted);
			System.out.println("Number of Digits: " + numDigits);
			System.out.println("Fastest Win: " + fastestWin + " moves." );

			//resets number of moves to 0 for future games
			numMoves=0;

			//outputs user command options
			System.out.println("p- Play again");
			System.out.println("r- Reset game");
			System.out.println("q- Quit");

			//asks for user command
			System.out.print("What would you like to do?");
			userCommand=keyboard.next();

			//prints error message if user command length > one character
			while (userCommand.length()>1) {
				System.out.println("Please enter only one character");
				userCommand=keyboard.next();
			}

			//prints error message if user command is not a valid input
			while (!(userCommand.equalsIgnoreCase("p") ||  userCommand.equalsIgnoreCase("r") || userCommand.equalsIgnoreCase("q"))) {
				System.out.println("This is an invalid input.");
				System.out.println("p- Play again");
				System.out.println("r- Reset game");
				System.out.println("q- Quit");
				System.out.println();


				System.out.print("What would you like to do? ");
				userCommand=keyboard.next();
				System.out.println();

			}

			//if user wants to quit the program, outputs goodbye statement, exits.
			if (userCommand.equalsIgnoreCase("q")) {
				System.out.println();
				System.out.println("Goodbye!");
				System.exit(0);
			}

			//if user wants to reset the program, resets number of digits in secret number
			//resets player name, resets games completed, resets fastest win, replays game
			else if (userCommand.equalsIgnoreCase("r")) {

				engine.getNumDigits();
				numDigits=keyboard.nextInt();
				engine.setNumDigits(numDigits);

				name=player.getName();
				player.setName(name);

				gamesCompleted=0;
				fastestWin=Integer.MAX_VALUE;

				userCommand="p";

			}
		}

		//fin.
		//written by sudhan.chitgopkar.
	}
}
