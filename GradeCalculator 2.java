/*
* GradeCalculator.java
* Author: Sudhan Chitgopkar
* Submission Date: Sept. 20, 2019
*
* Purpose: This program receives an input from the user regarding the letter grade they would like to achieve in a particular class.
* The program then inputs the weight of each of 7 grade components and the scores for them, if applicable. The program then calculates
* the current numerical and letter grade of the user based upon the input information and calculates whether it is possible for them to
* receive the letter grade desired. If it is possible to receive the desired letter grade, the program outputs the specific average the user 
* must receive upon remaining grade components to score the minimum numerical grade to fit into the mark-band on the desired letter grade.
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

import java.util.Scanner;


public class GradeCalculator {

	public static void main(String[] args) {

		//Variables
		String letterGradeWanted;
		//Weight Variables
		Double exam1Weight; 
		Double exam2Weight;
		Double examFinalWeight;
		Double labWeight;
		Double projectWeight;
		Double participationWeight;
		Double quizWeight;
		Double totalKnownGradeWeight;
		//Checks if the User knows a particular grade
		String yesNo;
		//Score Variables
		Double exam1Score=0.0;
		Double exam2Score=0.0;
		Double examFinalScore=0.0;
		Double labAverage=0.0;
		Double projectAverage=0.0;
		Double participationAverage=0.0;
		Double quizAverage=0.0;
		//Calculates Current (numerical) Score
		Double currentScore=0.0;
		//Calculates Current (letter) Score
		String currentLetterScore=new String();
		//Calculates average on remaining assignments needed for LetterGradeWanted
		Double avgToFinalLetterGrade=0.0;
		//Calculates lowest possible score in LetterGradeWanted range
		Double finalOverallScore=0.0;






		//Setting up the Scanner	
		Scanner keyboard = new Scanner(System.in);

		//Output of grade table	
		System.out.println("Grading Scale:");
		System.out.println("A\t90-100");
		System.out.println("B\t80-89");
		System.out.println("C\t70-79");
		System.out.println("D\t60-69");
		System.out.println("F\tbelow 60");

		//Asking for user input
		System.out.print("What letter grade do you want to achieve for the course? ");
		letterGradeWanted=keyboard.next();
		
		//Making sure user has put in a valid letterGradeWanted
		if (letterGradeWanted.equalsIgnoreCase("a") ||letterGradeWanted.equalsIgnoreCase("b") || 
				letterGradeWanted.equalsIgnoreCase("c") || letterGradeWanted.equalsIgnoreCase("d") || letterGradeWanted.equalsIgnoreCase("f")) {

			//Asking for Component Weights
			System.out.println("Enter Percentage Weights:");

			System.out.print("Exam 1:\t\t");
			exam1Weight=keyboard.nextDouble();

			System.out.print("Exam 2:\t\t");
			exam2Weight=keyboard.nextDouble();

			System.out.print("Final Exam:\t");
			examFinalWeight=keyboard.nextDouble();

			System.out.print("Labs:\t\t");
			labWeight=keyboard.nextDouble();

			System.out.print("Projects:\t");
			projectWeight=keyboard.nextDouble();

			System.out.print("Participation:\t");
			participationWeight=keyboard.nextDouble();

			System.out.print("Quizzes:\t");
			quizWeight=keyboard.nextDouble();


			//Calculating, checking total weight to ensure that it makes sense
			totalKnownGradeWeight=quizWeight+participationWeight+projectWeight+labWeight+examFinalWeight+exam2Weight+exam1Weight;
			
			if (totalKnownGradeWeight<100){
				System.out.println("Weights don't add up to 100, exiting...");
				System.exit(0);
			}

			else if (totalKnownGradeWeight>100){
				System.out.println("Weights add up to more than 100, exiting...");
				System.exit(0);
			}
			else {
				System.out.println("Enter your scores out of a 100:");


				//Checking if Exam1 known
				System.out.print("Do you know your exam 1 Score? ");
				yesNo=keyboard.next();

				if (yesNo.equalsIgnoreCase("yes") || yesNo.equalsIgnoreCase("y")) {
					//Asking for exam 1 score	
					System.out.print("Score recieved on Exam 1: ");
					exam1Score=keyboard.nextDouble();
					//checking if exam 1 score is valid, exiting if not
					if (exam1Score<0 || exam1Score>100) {
						System.out.println("This is not a valid score. Program exiting...");
						System.exit(0);
					}
					//Checking if Exam2 known, given Exam1 known
					else { 
						System.out.print("Do you know your exam 2 Score? ");
						yesNo=keyboard.next();

						if (yesNo.equalsIgnoreCase("yes")|| yesNo.equalsIgnoreCase("y")) {
							//Asking for exam 2 score, given Exam 2 score known
							System.out.print("Score recieved on Exam 2: ");
							exam2Score=keyboard.nextDouble();
							//Checking if exam 2 score is valid, exiting if not
							if (exam2Score<0 || exam2Score>100) {
								System.out.println("This is not a valid score. Program exiting...");
								System.exit(0);	
							}
							//Checking to see if final exam score is known, given Exam 1 and Exam 2 scores are known
							else {
								System.out.print("Do you know your Final Exam score? ");
								yesNo=keyboard.next();

								if (yesNo.equalsIgnoreCase("yes")|| yesNo.equalsIgnoreCase("y")) {
									//Asking for final exam score
									System.out.print("Score recieved on final exam: ");
									examFinalScore=keyboard.nextDouble();
									//Checking to see if score is valid, exiting if not valid
									if (examFinalScore<0 || examFinalScore>100) {
										System.out.println("This is not a valid score. Program exiting...");
										System.exit(0);
									}
								}
								//If examFinal unknown, sets weight to 0
								else { examFinalWeight=0.0;}

							}
						}
						//If Exam 2 unknown, sets weight for exam 2 and examFinal to 0
						else { exam2Weight=0.0; examFinalWeight=0.0;}





					}


				}
				//IF Exam 1 unknown, sets weight for exams 1, 2, and final to 0
				else { exam1Weight=0.0; exam2Weight=0.0; examFinalWeight=0.0;}

				// Asking if lab average is known
				System.out.print("Do you know your lab average? ");
				yesNo=keyboard.next();
				//If labAverage known, asks for Grade
				if (yesNo.equalsIgnoreCase("yes")||yesNo.equalsIgnoreCase("y")) {
					System.out.print("Average Lab Grade: ");
					labAverage=keyboard.nextDouble();
					//Checks to see if labAverage is valid
					if(labAverage<0||labAverage>100) {
						System.out.println("This is not a valid score. Program exiting...");
						System.exit(0);
					}
				}
				//If lab average is unknown, sets lab weight to 0
				else { labWeight=0.0;}
				//Asks if project Average is known
				System.out.print("Do you know your project average? ");
				yesNo=keyboard.next();
				//If projeectAverage is known, asks for grade
				if (yesNo.equalsIgnoreCase("yes")||yesNo.equalsIgnoreCase("y")) {
					System.out.print("Average Project Grade: ");
					projectAverage=keyboard.nextDouble();
					// Checks to make sure projectAverage is valid
					if(projectAverage<0|| projectAverage>100) {
						System.out.println("This is not a valid score. Program exiting...");
						System.exit(0);
					}
				}
				//If projectAverage is unknown, sets weight to 0
				else { projectWeight=0.0;}
				//Asks if participationAverage is known
				System.out.print("Do you know your participation average? ");
				yesNo=keyboard.next();
				//If participationAverage is known, gets user input
				if (yesNo.equalsIgnoreCase("yes")|| yesNo.equalsIgnoreCase("y")) {
					System.out.print("Average Participation Grade: ");
					participationAverage=keyboard.nextDouble();
					//Checks to make sure participationAverage is valid, exits if not
					if(participationAverage<0||participationAverage>100) {
						System.out.println("This is not a valid score. Program exiting...");
						System.exit(0);
					}
				}
				// If participationAverage unknown, sets weight to 0
				else {participationWeight=0.0;}
				//Checks to see if quizAverage is known
				System.out.print("Do you know your quiz average? ");
				yesNo=keyboard.next();
				//If quizAverage is known, asks for QuizAverage
				if (yesNo.equalsIgnoreCase("yes")|| yesNo.equalsIgnoreCase("y")) {
					System.out.print("Average Quiz Grade: ");
					quizAverage=keyboard.nextDouble();
					//Checks to make sure quizAverage is valid, exits if not
					if(quizAverage<0|| quizAverage>100) {
						System.out.println("This is not a valid score. Program exiting...");
						System.exit(0);
					}
				}
				//If quizAverage is unknown, sets weight to 0
				else {quizWeight=0.0;}

				//Recalculating totalKnownWeight
				currentScore=-1.0;
				totalKnownGradeWeight=quizWeight+participationWeight+projectWeight+labWeight+examFinalWeight+exam2Weight+exam1Weight;
				//Current Score Calculation
				currentScore=((exam1Weight*exam1Score)+(exam2Weight*exam2Score)+(examFinalWeight*examFinalScore)+(labWeight*labAverage)+(projectWeight*projectAverage)
						+(participationWeight* participationAverage)+(quizWeight*quizAverage))/(totalKnownGradeWeight);
			}
			//Outputting Current Score
			System.out.print("Current Grade Score: ");
			System.out.printf("%1.2f", currentScore);
			System.out.println();

			//Calculating Current Letter Grade

			if (currentScore<60) {
				currentLetterScore="F";
			}
			else if (currentScore>=60.0 && currentScore<70.0) {
				currentLetterScore="D";
			}
			else if (currentScore>=70.0 && currentScore<80.0) {
				currentLetterScore="C";
			}
			else if (currentScore>=80.0 && currentScore<90.0) {
				currentLetterScore="B";
			}
			else if (currentScore>=90.0 && currentScore<=100.0) {
				currentLetterScore="A";
			}
			else {}
			
			//Outputting user's Current Letter Grade
			System.out.println("Your current letter grade is a "+ currentLetterScore);

			//If all grades are entered and current Letter Grade equals Letter Grade Wanted, outputs congratulations message
			if (totalKnownGradeWeight==100) {
				if(currentLetterScore.equalsIgnoreCase(letterGradeWanted)) {
					System.out.println("Congratulations! You recieved the " + letterGradeWanted + " that you wanted!");
				}
			}
				
			else  {
					//Calculate finalOverallScore var
					if (letterGradeWanted.equalsIgnoreCase("A")) {
						finalOverallScore=90.0;
					}
					else if (letterGradeWanted.equalsIgnoreCase("B")) {
						finalOverallScore=80.0;
					}
					else if (letterGradeWanted.equalsIgnoreCase("C")) {
						finalOverallScore=70.0;
					}
					else if (letterGradeWanted.equalsIgnoreCase("D")) {
						finalOverallScore=60.0;
					}
					else if (letterGradeWanted.equalsIgnoreCase("F")) {
						finalOverallScore=0.0;
					}

					//Calculate avgToFinalGrade using previously calculated finalOverallScore
					avgToFinalLetterGrade=((100*finalOverallScore)-((exam1Weight*exam1Score)+(exam2Weight*exam2Score)+(examFinalWeight*examFinalScore)
							+(labWeight*labAverage)+(projectWeight*projectAverage)+(participationWeight* participationAverage)+(quizWeight*quizAverage)))
							/(100-totalKnownGradeWeight);

					if (avgToFinalLetterGrade>100) {
						System.out.println("Sorry, you cannot recieve an " + letterGradeWanted + " in the course");
					}
					else if (avgToFinalLetterGrade<0) {
						//Calculates, outputs lowest possible grade achievable
						System.out.println("You will recieve at least a " + "D" + " no matter what");
					}
					else {
						//Outputs average on remaining items needed to recieve letterGradeWanted
						System.out.print("You have to score greater than or equal to ");
						System.out.printf("%.2f", avgToFinalLetterGrade);
						System.out.print(" in the remaining grade items to recieve an " + letterGradeWanted + " in this course.");
					}
				}
			}
		//Output if users enters invalid letterGradeWanted
		else {
			System.out.println("Input Error");
			System.exit(0);
		}
	}
}


