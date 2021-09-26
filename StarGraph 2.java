/*
* StarGraph.java
* Author: Sudhan Chitgopkar
* Submission Date: Oct. 7, 2019
*
* Purpose: This program takes user input for 3 values (x values to process, minimum value of x, and increments for x,)
* and uses these aforementioned inputs to run through a formula whereupon each x value will be multiplied by 20 times 
* the absolute value of its sin. These will be the y values which correspond to each individual x value. The x values 
* and y values are output to the user. After this, a graph of the sin function based upon the aforementioned x and y 
* values will be output to the user whereupon an asterisk makes up the individual body unit of the sin graph.
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
import java.util.Scanner;
import java.math.*;
public class StarGraph {

	public static void main(String[] args) {

		int arraySize;
		Double xMin;
		Double increment;

		//setting up the scanner to receive user input from keyboard
		Scanner keyboard=new Scanner (System.in);

		//receiving user input for arraySize
		System.out.print("Please enter the number of x values to process: ");
		arraySize=keyboard.nextInt();

		//if incorrect user input detected, outputs error message and terminates
		if (arraySize<=0) {
			System.out.println("The number of x values must be an integer greater than 0.");
			System.exit(0);
		}
		//receiving user input for xMin
		System.out.print("Enter a minimum value for x: ");
		xMin=keyboard.nextDouble();

		//receiving user input for xIncrement
		System.out.print("Enter the amount to increment x: ");
		increment=keyboard.nextDouble();

		//if incorrect user input detected, outputs error message and terminates
		if (increment<=0) {
			System.out.println("The increment must be a decimal number greater than 0.");
			System.exit(0);
		}

		//closing the keyboard after all input has been received
		keyboard.close();

		//creating arrays of User Input Length
		Double [] xValue = new Double [arraySize];
		Double [] yValue = new Double [arraySize];


		//setting first array value in xValues array to user input x minimum
		xValue[0]=xMin;
		
		//creating the remainder of the xValues array by incrementing the xValue per user input
		for (int i=1;i<arraySize;i++) {
			xValue[i]=xValue[i-1]+increment;
		}

		//assigning y-values through given computation of each x value
		for (int i=0;i<arraySize;i++) {
			yValue[i]=(20.0*(Math.abs(Math.sin(xValue[i]))));
		}

		//Setting up value output to the user
		System.out.println();
		System.out.println("Values");

		//printing each array value to the user
		for (int i=0;i<arraySize;i++) {
			System.out.print("x: ");
			//formatting xValues to 3 decimal places
			System.out.printf("%.3f",xValue[i]);
			System.out.print(", y: ");
			//formatting yValues to 3 decimal places
			System.out.printf("%.3f",yValue[i]);
			System.out.println();
		}

		//printing the star graph
		for (int i=0;i<arraySize;i++) {
			System.out.print(": ");
			yValue[i]=Math.floor(yValue[i]);
			for (int j=0;j<yValue[i];j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		//fin.
		
	}

}
