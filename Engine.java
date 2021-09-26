/*
 * Engine.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 10/17/19
 *
 * Purpose: This program contains methods for the Engine class which will be used in conjunction with both the
 * Player and Bagels class in order to complete the game "Pico, Fermi, Bagels" - specifically, this class gets 
 * the amount of digits the user wants in the secret number, generates and sets the secret number randomly, and
 * converts the user's guess of the secret number from a string to a set of individual integer digits which
 * are then put in their corresponding locations in an array of the user's guess.
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

//imports Random library for random number generation
import java.util.Random;

public class Engine {

	//declares private instance variables per UML diagram.
	private int numDigits;
	private int [] secretNumber;
	private Random randomNumberGenerator=new Random();

	//converts user guess from a string into an integer array
	public int [] convertNumToDigitArray(String number) {
		int [] guessArray= new int [number.length()];
		int parsedDigit;
		String digit;
		for (int i=0;i<number.length();i++) {
			//converts each digit from the string to a character
			digit=number.substring(i, i+1);
			//converts character to an integer
			parsedDigit=Integer.parseInt(digit);
			//assigns parsed integer value to its correct place in the guess array
			guessArray[i]=parsedDigit;
		}
		return guessArray;

	}
	public int getNumDigits() {
		//asks for numDigits, returns number of digits within secret number
		System.out.print ("Enter the number of digits to use: ");
		return numDigits;

	}

	public int [] getSecretNumber() {
		//returns previously generated secret number
		return secretNumber;
	}

	public void generateNewSecret() {
		//generates new secret number array of size numDigits
		secretNumber= new int [numDigits];
		//sets first array value to a random number between 1-9
		secretNumber[0]=randomNumberGenerator.nextInt(8)+1;
		//sets all array values except the first to a random number between 0-9
		for (int i=1;i<numDigits;i++) {
			secretNumber[i]=randomNumberGenerator.nextInt(9);
		}


	}
	public void setNumDigits(int numDigits) {
		this.numDigits=numDigits;

	}

	public void setSecretNumber (int[] secretNumber) {
		//sets each digit in the secret number to this.secretNumber integer array
		for (int i=0;i<numDigits;i++) {
			this.secretNumber[i]=secretNumber[i];
		}
	}
}
