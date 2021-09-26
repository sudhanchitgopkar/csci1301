/*
* RockPaperScissors.java
* Author: Sudhan Chitgopkar
* Submission Date: Sept. 24, 2019
*
* Purpose: This program plays the game "Rock, Paper, Scissors" with the computer. Firstly, the user inputs a value with respect to the amount
* of rounds-won required to end the game. Following this, they will enter either "Rock", "Paper", or "Scissors" into the program in order to 
* play a round or they will be prompted to enter one of the aforementioned options until they do. After user input, the computer randomly plays 
* either "Rock," "Paper," or "Scissors." The program then decides who has won the round per the rules of "Rock, Paper, Scissors" and increments the 
* points of either the computer or the user up one accordingly. This score is show to the user after each round ends. The game ends once either the
* computer or user reaches the score limit put in by the user in the beginning of the program. The program then presents a message to the user 
* indicating whether they have won or lost the game.
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
public class RockPaperScissors {

	public static void main(String[] args) {

		//variable declaration, instantiation for computerScore and userScore
		int pointsToWin;
		int computerScore=0;
		int userScore=0;
		String userMove;


		//Setting up the scanner for keyboard input
		Scanner keyboard= new Scanner (System.in);

		// Asking the user for pointsToWin input
		System.out.print("Points to win: ");
		pointsToWin= keyboard.nextInt();

		keyboard.nextLine();
		
		//Sets up a while loop that will keep the game going until either the computer or the user meet the score limit.
		while (computerScore<pointsToWin && userScore<pointsToWin) {
			
			//asks the user for their move
			System.out.print("Rock, paper, or scissors? ");
			userMove=keyboard.nextLine();

			//reports invalid input to user, asks user for valid input
			while (!((userMove.equalsIgnoreCase("rock") || (userMove.equalsIgnoreCase("paper") || (userMove.equalsIgnoreCase("scissors")))))){
				System.out.println("This is an invalid input. Please enter \"Rock,\" \"Paper,\" or \"Scissors.\"");
				userMove=keyboard.nextLine();
			}
			
			//finds computer move from ComputerOpponent program
			String computerMove=ComputerOpponent.getMove();

			//checks for tie, outputs non-incremented score
			if (computerMove.equalsIgnoreCase(userMove)) {
				System.out.println("The computer chose " + computerMove + ", so it's a tie." + "(" + userScore + "-" + computerScore + ")");
			}
			//checks if computer played rock and user played paper, gives user one point
			else if (computerMove.equalsIgnoreCase("rock") && userMove.equalsIgnoreCase("paper")) {
				userScore++;
				System.out.println ("The computer chose rock, so you win!" + "(" + userScore + "-" + computerScore + ")");
			}
			//checks if computer played rock and user played scissors, gives computer one point
			else if (computerMove.equalsIgnoreCase("rock") && userMove.equalsIgnoreCase("scissors")) {
				computerScore++;
				System.out.println ("The computer chose rock, so you lose." + "(" + userScore + "-" + computerScore + ")");
			}
			//checks if computer played paper and user played rock, gives computer one point
			else if (computerMove.equalsIgnoreCase("paper") && userMove.equalsIgnoreCase("rock")) {
				computerScore++;
				System.out.println ("The computer chose paper, so you lose." + "(" + userScore + "-" + computerScore + ")");
			}
			//checks if computer played paper and user played scissors, gives user one point
			else if (computerMove.equalsIgnoreCase("paper") && userMove.equalsIgnoreCase("scissors")) {
				userScore++;
				System.out.println ("The computer chose paper, so you win!" + "(" + userScore + "-" + computerScore + ")");
			}
			//checks if computer played scissors and user played rock, gives user one point
			else if (computerMove.equalsIgnoreCase("scissors") && userMove.equalsIgnoreCase("rock")) {
				userScore++;
				System.out.println ("The computer chose scissors, so you win!" + "(" + userScore + "-" + computerScore + ")");
			}
			//checks if computer played scissors and user played paper, gives computer one point
			else if (computerMove.equalsIgnoreCase("scissors") && userMove.equalsIgnoreCase("paper")) {
				computerScore++;
				System.out.println ("The computer chose scissors, so you lose." + "(" + userScore + "-" + computerScore + ")");
			}
		}
		//after game over, checks if computer won.
		//if computer won, outputs lose statement to user
		if (computerScore==pointsToWin) {
			System.out.println("Sorry, you lost. Better luck next time!");
		}
		//if computer lost, outputs win statement to user
		else {
			System.out.println("Congratulations! You won!");
		}
		//fin.
	}

}
