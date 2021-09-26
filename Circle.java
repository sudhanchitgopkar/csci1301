/*
 * Circle.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 10/16/19
 *
 * Purpose: This program sets up a series of instance variables and 
 * circle methods to use alongside the CircleTester.java class and includes 
 * completed versions of the instructions provided in the Lab09 sheet as well
 * as 5 additional methods for circles to use.
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

//*******************************************************
// Circle.java
//
// 
//*******************************************************
import java.util.Scanner;
public class Circle {

	//private Scanner keyboard=new Scanner(System.in);

	// declare the private String instance  name
	private String name;
	// declare the private double instance  radius
	private double radius;
	// declare the private double instance  x
	private double x;
	// declare the private double instance  y
	private double y;

	//Used to compare doubles.  Remember, don't compare doubles directly using ==
	public static final double THRESHOLD = 0.000000001;

	//----------------------------------------------
	// getName - returns the value of name
	//----------------------------------------------
	public String getName() {

		// Your code goes here	
		//returns private string name
		return name;
	}

	//----------------------------------------------
	// getX - returns the value of x
	//----------------------------------------------
	public double getX() {

		// Your code goes here	
		//returns private double x
		return x;
	}


	//----------------------------------------------
	// getY - returns the value of y
	//----------------------------------------------
	public double getY() {

		// Your code goes here	
		//returns private double x
		return y;
	}

	//----------------------------------------------
	// getRadius - returns the value of radius
	//----------------------------------------------
	public double getRadius() {

		// Your code goes here
		//returns private double x
		return radius;
	}

	//----------------------------------------------
	// setName - assigns a new value to name
	//----------------------------------------------
	public void setName(String name) {

		// Your code goes here
		//sets name to new instance of name
		this.name=name;


	}

	//----------------------------------------------
	// setX - assigns a new value to x
	//----------------------------------------------
	public void setX(double x) {

		// Your code goes here	
		//sets x to new instance of x
		this.x=x;
	}

	//----------------------------------------------
	// setY - assigns a new value to y
	//----------------------------------------------
	public void setY(double y) {

		// Your code goes here	
		//sets y to new instance of y
		this.y=y;
	}


	//----------------------------------------------
	// setRadius - assigns a new value to radius
	//----------------------------------------------
	public void setRadius(double radius) {

		// Your code goes here	
		//checks to see if radius value is valid. 
		//if valid, sets radius to new instance of radius, if not, leaves radius unchanged
		if( radius >= 0) {
			this.radius=radius;
		}
	}

	//--------------------------------------------------------
	// area - returns the area of the circle
	//--------------------------------------------------------
	public double area() {

		// Your code goes here
		//creates new var named area, set to radius^2 times pi, returns area
		double area = radius * radius * Math.PI;
		return area;
	}

	//--------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	//--------------------------------------------------------
	public double perimeter() {

		// Your code goes here
		//creates new var perimeter, set to 2 times radius times pi, returns perimeter
		double perimeter = 2 * radius * Math.PI;
		return perimeter;
	}

	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------
	public double diameter() {

		// Your code goes here	
		//creates new var diameter, set to 2 times radius, returns diameter
		double diameter = 2 * radius;
		return diameter;
	}


	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	//                is 1 and its center is (0,0) and false
	//      	      otherwise.
	//--------------------------------------------------------
	public boolean isUnitCircle() {

		// Your code goes here
		//creates new boolean named unitCircle, originally initialized to false
		boolean isUnitCircle=false;
		//if x,y = 0 and radius= 1, changes isUnitCircle to true
		if ((x<THRESHOLD && x>-THRESHOLD) && (y<THRESHOLD && y>-THRESHOLD) && radius-1<THRESHOLD) {
			isUnitCircle=true;
		}
		//returns isUnitCircle
		return isUnitCircle;
	}

	//--------------------------------------------------------
	// toString - return a String representation of
	//            this circle in the following format:
	//			  name: name
	//            center:(x,y)
	//            radius: r
	//--------------------------------------------------------
	public  String toString() {
		// Your code goes here
		//creates new var, output
		String output;
		//sets output to formatting as specified
		output= "\n name: " + name + "\n" + " center: (" + x + "," + y + ")" + "\n " + "radius: " + radius;
		//returns var output
		return output;		
	}

	public boolean equals(Circle anotherCircle) {
		//creates new boolean named equals, initialized to false
		boolean equals=false;
		//if x, y, and radius values of instance var = anotherCircle, sets equals boolean to true
		if (radius-anotherCircle.radius<THRESHOLD && x-anotherCircle.x<THRESHOLD && y-anotherCircle.y<THRESHOLD) {
			equals=true;
		}	
		//returns equals
		return equals;
	}

	public double distance(Circle anotherCircle) {
		//variable declarations
		double distance;
		double argument;
		double base1;
		double base2;
		//calculating distance formula
		base1=x-anotherCircle.x;
		base2=y-anotherCircle.y;
		argument=Math.pow(base1,2)+Math.pow(base2, 2);
		//setting distance formula operation equal to var distance
		distance=Math.sqrt(argument);
		//returns distance
		return distance;

	}

	public boolean isSmaller(Circle anotherCircle) {
		//creating new variable isSmaller, initialized to false
		boolean isSmaller=false;
		//uses diameter method to check if instance var is smaller. If true, sets isSmaller to true
		if (diameter()<anotherCircle.diameter()) {
			isSmaller=true;
		}
		//returns isSmaller
		return isSmaller;
	}

	public int compareTo(Circle anotherCircle) {
		//declares new int var, compareTo initialized to 0
		int compareTo=0;
		//checks if instance is smaller than anotherCircle using isSmaller method above.
		//if true, changes compareTo to 1
		if(isSmaller(anotherCircle)==true) {
			compareTo=-1;
		}
		//checks if instance is larger than anotherCircle
		//if true, changes compareTo to -1
		else if (diameter()>anotherCircle.diameter()) {
			compareTo=1;
		}
		// returns compareTo value
		return compareTo;
	}
	public boolean intersects(Circle anotherCircle) {
		//declares new boolean var, intersects, initialized to false
		boolean intersects=false;
		//if criterion for intersection between instance and anotherCircle are met, sets intersects to true
		if (distance(anotherCircle)<(radius+anotherCircle.radius)) {
			intersects=true;
		}
		//returns intersects
		return intersects;

	}
}