/*
 * StringFun.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 10/03/19
 *
 * Purpose: This program takes a user string and manipulates that string per 5 user functions 
 * and then outputs the manipulated string allowing for user re-manipulation till they decide to invoke the sixth, 
 * non-manipulation string function: quitting out of the program. The 5 user functions are as follows: reverse (which reverses
 * the most recent string,) replace first (which replaces the first instance of a user input character,) replace last (which replaces 
 * the last instance of a character input by the user,) remove (which removes a particular character at a particular user-defined location,)
 * and remove all (which removes all instances of a particular user-defined character)/
 * 
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

//importing scanner class for user input
import java.util.Scanner;
public class StringFun {

	public static void main(String[] args) {

		// Variable Declarations, Instantiations
		String userString="";
		String toReplaceString="";
		String replacementString="";;
		String toRemoveString="";
		String userCommand;
		String userStringReverse="";
		int userStringLength=0;
		int toRemoveLocation=0;
		int currentLocation=1;
		char toReplaceChar;
		char replacementChar;
		char toRemoveChar;
		boolean replacementTF=false;
		boolean removeTF=false;
		boolean charFound=false;
		boolean lengthChange=false;




		//Setting up keyboard for user input
		Scanner keyboard=new Scanner (System.in);

		System.out.println("Enter the string to be manipulated");
		userString=keyboard.nextLine();
		userStringLength=userString.length();
		System.out.println("Enter your command (reverse, replace first, replace last, remove all, remove, quit)");
		userCommand=keyboard.nextLine();




		//keeps the program running continuously while user command is not to quit
		while (!(userCommand.equalsIgnoreCase("quit"))) {
			//checks if user wants to reverse string
			if (userCommand.equalsIgnoreCase("reverse")) {
				for (int i=userStringLength-1;i>=0;i--) {
					userStringReverse = userStringReverse + userString.charAt(i);
				}
				//sets userString to userStringReverse for use of correct manipulated user String in the future
				userString=userStringReverse;
				System.out.println(userString);
			}


			else if (userCommand.equalsIgnoreCase("replace first")) { 
				//checks if user wants to replace first instance of a character
				// creating replaceFirst functionality
				System.out.println("Enter the character you want to replace:");
				toReplaceString=keyboard.nextLine();
				//continually prompts user for single character input while input is not single character
				while (toReplaceString.length()>1) {
					System.out.println("You have entered more than one character. Please only enter one character to replace: ");
					toReplaceString=keyboard.nextLine();
				}
				toReplaceChar=toReplaceString.charAt(0);
				System.out.println("Enter the replacement character");
				replacementString=keyboard.nextLine();
				//continually prompts user for single character input while input is not single character
				while (replacementString.length()>1) {
					System.out.println("You have entered more than one character. Please only enter one replacement character: ");
					replacementString=keyboard.nextLine();
				}
				replacementChar=replacementString.charAt(0);
				for (int i=0;i<userStringLength;i++) {
					if (userString.charAt(i)==toReplaceChar) {
						//sets boolean to true to confirm that needed character was found
						charFound=true;
					}	
				}
				for (int i=0; i<userStringLength;i++) {		
					if(userString.charAt(i)==toReplaceChar && replacementTF==false){
						//sets userString equal to itself with the toReplace removed and the replacement in
						userString=userString.substring(0,i)+replacementChar+userString.substring(i+1, userStringLength);
						replacementTF=true;
					}

				}
				//if letter wasn't found, provides output to user
				if (charFound==false) {
					System.out.println("The letter was not found in the word");
				}
				else {
					//if letter was found and input was correct, performs output
					System.out.println(userString);
					// end of replaceFirst functionality
				}
				//sets boolean to false for future use
				replacementTF=false;
			}


			else if (userCommand.equalsIgnoreCase("replace last")) {
				//creating replaceLast functionality
				charFound=false;
				System.out.println("Enter the character you want to replace:");
				toReplaceString=keyboard.nextLine();
				//continually prompts user for single character input while input is not single character
				while (toReplaceString.length()>1) {
					System.out.println("You have entered more than one character. Please only enter one character to replace: ");
					toReplaceString=keyboard.nextLine();
				}
				toReplaceChar=toReplaceString.charAt(0);
				System.out.println("Enter the replacement character");
				replacementString=keyboard.next();
				//continually prompts user for single character input while input is not single character
				while (replacementString.length()>1) {
					System.out.println("You have entered more than one character. Please only enter one replacement character: ");
					replacementString=keyboard.nextLine();
				}
				replacementChar=replacementString.charAt(0);
				for (int i=0;i<userStringLength;i++) {
					if (userString.charAt(i)==toReplaceChar) {
						//sets boolean to true to confirm that needed character was found
						charFound=true;
					}	
				}
				//Sets up decrementing check to see the first replaceable letter from the back, thus replacing the last letter
				for (int i=userStringLength-1; i>=0;i--) {
					if(userString.charAt(i)==toReplaceChar && replacementTF==false){
						userString=userString.substring(0, i)+ replacementChar + userString.substring (i+1,userStringLength);
						//if needed letter was found, sets boolean to true
						replacementTF=true;
					}
				}
				//if needed boolean wasn't found, outputs user error
				if (charFound==false) {
					System.out.println("The letter was not found in the word");
				}
				//if necessary user input is correct, outputs manipulated string
				else {
					System.out.println(userString);
					// end of replaceFirst functionality
				}
				replacementTF=false;
			}

			else if (userCommand.equalsIgnoreCase("remove all")) {
				//creating removeAll functionality
				charFound=false;
				System.out.println("Enter the character you want to remove");
				toRemoveString=keyboard.nextLine();
				//continually prompts user for single character input while input is not single character
				while (toRemoveString.length()>1) {
					System.out.println("You have entered more than one character. Please only enter one character to remove: ");
					toRemoveString=keyboard.nextLine();
				}
				toRemoveChar=toRemoveString.charAt(0);
				for (int i=0;i<userStringLength;i++) {
					if (userString.charAt(i)==toRemoveChar) {
						//sets boolean to true to confirm that needed character was found
						charFound=true;
					}	
				}

				for (int i=userStringLength-1;i>=0;i--) {
					if (userString.charAt(i)==toRemoveChar) {
						//sets user string to user string without the toRemove character through the use of the exclusive end of the substring
						userString=userString.substring(0, i)+userString.substring(i+1);
						i = userString.length();
						userStringLength=userString.length();

					}
				}
				// if user input was incorrect, outputs error message
				if (charFound==false) {
					System.out.println("The letter was not found in the word");
				}
				//if user input was correct, outputs manupulated string
				else {
					System.out.println(userString);
					// end of replaceFirst functionality
				}
			}

			//checks if user wants to remove a specific character
			else if (userCommand.equalsIgnoreCase("remove")) {
				//creating remove functionality
				charFound=false;
				System.out.println("Enter the character you want to remove");
				toRemoveString=keyboard.nextLine();
				//continually prompts user for single character input while input is not single character
				while (toRemoveString.length()>1) {
					System.out.println("You have entered more than one character. Please only enter one character to remove: ");
					toRemoveString=keyboard.nextLine();
				}
				//gets user input for the number of the character they want to remove
				toRemoveChar=toRemoveString.charAt(0);
				System.out.println("Enter the " + toRemoveChar + " you would like to remove (Not the index- 1=1st, 2=2nd, etc.):");
				toRemoveLocation=keyboard.nextInt();



				for (int i=0; i<userStringLength; i++) {
					if (userString.charAt(i)==toRemoveChar) {
						if(currentLocation==toRemoveLocation) {
							//changes user string to remove the character at the undesired location
							userString=userString.substring(0, i)+userString.substring(i+1);
							i = userString.length();
							userStringLength=userString.length();
							lengthChange=true;

						}
						//if char to remove is found but at incorrect location, increases location till it reaches the user defined location
						else {
							currentLocation++;
						}
					}
				}

				System.out.println(userString);
				//end of remove functionality


			}
			//if user command is not one of the listed ones, outputs error, asks for input again
			else {
				System.out.println("You have entered an invalid command. Please try again.");

			}
			System.out.println("Enter your command (reverse, replace first, replace last, remove all, remove, quit)");
			keyboard.reset();
			userCommand=keyboard.nextLine();



		}
		//exits program when desired by user
		if (userCommand.equalsIgnoreCase("quit")) {
			System.exit(0);

		}
	}
}

//fin.



