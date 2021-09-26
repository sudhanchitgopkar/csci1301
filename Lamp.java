/*
 * Stat.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 10/29/19
 *
 * Purpose: This program supplements the Interactive Fiction game by creating a new lamp class
 * which allows the lamp to either be lit up or put out using a setter method. The class also
 * includes a getter method so that the state of the lamp can be determined.
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

public class Lamp {

	/*
	 * Instance variables and methods go here, you're responsible for 
	 * choosing and naming them.
	 */

	//variable declaration
	private boolean isLit;

	//setter method allowing the lamp to either be lit or out by calling the setLit method 
	public void setIsLit(boolean lit) {
		this.isLit=lit;			
	}

	//getter method getting the current state of the lamp
	public boolean getIsLit() {
		return isLit;
	}

}