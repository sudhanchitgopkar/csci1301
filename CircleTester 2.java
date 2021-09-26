/*
 * CircleTester.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 10/16/19
 *
 * Purpose: This program uses an amalgamation of the methods written in the
 * Circle.java program and tests them using 2 different Circle objects, Circle1
 * and Circle2. These objects are tested and their characteristics and pass/fail results
 * on a series of method exams are printed to the screen for the user.
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
// CircleTester.java
//
//
//  A client to test the functionality of objects
//  of the class Circle
// 
//*******************************************************
public class CircleTester{
	public static final double THRESHOLD = 0.000000001;

	public static void main(String[] args) {

		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		circle1.setName("Circle 1");
		circle1.setX(0.0);
		circle1.setY(0.0);
		circle1.setRadius(2);
		circle2.setName("Circle 2");
		circle2.setX(2.0);
		circle2.setY(1.0);
		circle2.setRadius(1);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);

		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		//
		circle1.setRadius(-2.0); 

		//This is a unit test.  It is best to have tests output pass or fail instead of just a bunch of values.
		//Notice how the double comparison is done
		if(Math.abs(2-circle1.getRadius()) < THRESHOLD)
			System.out.println("PASSED: Set Radius");
		else
			System.out.println("FAILED: Set Radius");

		//
		// Reset the center of circle1 (-3.0,4.0)
		//
		circle1.setX(-3.0);
		circle1.setY(4.0);


		// print circle1 characteristics (center and radius), use a statement similar 
		// to the previous println statements. Note that is not necessary to call
		//the method toString, why?
		System.out.println("circle1=" + circle1);


		// set the circle2 radius to 5.3
		circle2.setRadius(5.3);

		// print circle2 characteristics (center and radius), use a statement similar to the first and
		// second println statements
		System.out.println("circle2=" + circle2);



		// print circle1 diameter, area and perimeter
		System.out.println("circle1: ");
		System.out.println("diameter: "+ circle1.diameter());
		System.out.println("area: "+ circle1.area());
		System.out.println ("perimeter: " + circle1.perimeter());


		// print circle2 diameter, area and perimeter
		System.out.println("circle2: ");
		System.out.println("diameter: "+ circle2.diameter());
		System.out.println("area: "+ circle2.area());
		System.out.println ("perimeter: " + circle2.perimeter());

		// display whether circle1 is a unit circle
		if (circle1.isUnitCircle()==true) {
			System.out.println("circle1 is a unit circle");		
		}
		else {
			System.out.println ("circle1 is not a unit circle");
		}


		// display whether circle2 is a unit circle
		if (circle2.isUnitCircle()==true) {
			System.out.println("circle2 is a unit circle");		
		}
		else {
			System.out.println ("circle2 is not a unit circle");
		}

		// your additional tests should be placed below here.  Make sure to include at least 2-3 test cases
		// for each method you write.  It is best to write proper unit tests which print pass, fail for each
		// test instead of just dumping values to the screen.

		//equals test 1, should pass
		circle1.setX(0);
		circle1.setY(0);
		circle1.setRadius(1);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if circle1 has the same x, y, and radius as circle 2 , prints pass message, otherwise prints fail message
		if (circle1.equals(circle2)) {
			System.out.println("PASSED: equals");
		}
		else {
			System.out.println("FAILED: equals");
		}

		//equals test 2, should fail
		circle1.setX(1);
		circle1.setY(1);
		circle1.setRadius(1);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if circle1 has the same x, y, and radius as circle 2 , prints pass message, otherwise prints fail message
		if (circle1.equals(circle2)) {
			System.out.println("PASSED: equals");
		}
		else {
			System.out.println("FAILED: equals");
		}

		//equals test 3, should pass
		circle1.setX(0);
		circle1.setY(0);
		circle1.setRadius(0);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if circle1 has the same x, y, and radius as circle 2 , prints pass message, otherwise prints fail message
		if (circle1.equals(circle2)) {
			System.out.println("PASSED: equals");
		}
		else {
			System.out.println("FAILED: equals");
		}

		//--

		//distance test 1, should pass
		circle1.setX(1);
		circle1.setY(1);
		circle1.setRadius(1);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if distance formula output = sqrt(2) , prints pass message, otherwise prints fail message
		if (Math.abs(circle1.distance(circle2)-Math.sqrt(2))<THRESHOLD) {
			System.out.println("PASSED: distance");
		}
		else {
			System.out.println("FAILED: distance");
		}

		//distance test 2, should fail
		circle1.setX(2);
		circle1.setY(2);
		circle1.setRadius(1);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);
		
		//if distance formula output = sqrt(10) , prints pass message, otherwise prints fail message
		if (Math.abs(circle1.distance(circle2)-Math.sqrt(10))<THRESHOLD) {
			System.out.println("PASSED: distance");
		}
		else {
			System.out.println("FAILED: distance");
		}

		//distance test 3, should pass
		circle1.setX(3);
		circle1.setY(3);
		circle1.setRadius(1);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if distance formula output = sqrt(18) , prints pass message, otherwise prints fail message
		if (Math.abs(circle1.distance(circle2)-Math.sqrt(18))<THRESHOLD) {
			System.out.println("PASSED: distance");
		}
		else {
			System.out.println("FAILED: distance");
		}

		//--

		//isSmaller test 1, should pass
		circle1.setX(0);
		circle1.setY(0);
		circle1.setRadius(1);
		circle2.setX(1);
		circle2.setY(1);
		circle2.setRadius(2);

		//if circle1 is smaller than circle2 , prints pass message, otherwise prints fail message
		if (circle1.isSmaller(circle2)) {
			System.out.println("PASSED: isSmaller");
		}
		else {
			System.out.println("FAILED: isSmaller");
		}

		//isSmaller test 2, should fail
		circle1.setX(1);
		circle1.setY(1);
		circle1.setRadius(1);
		circle2.setX(1);
		circle2.setY(1);
		circle2.setRadius(1);

		//if circle1 is smaller than circle2 , prints pass message, otherwise prints fail message
		if (circle1.isSmaller(circle2)) {
			System.out.println("PASSED: isSmaller");
		}
		else {
			System.out.println("FAILED: isSmaller");
		}

		//isSmaller test 3, should pass
		circle1.setX(1);
		circle1.setY(1);
		circle1.setRadius(1);
		circle2.setX(3);
		circle2.setY(3);
		circle2.setRadius(3);

		//if circle1 is smaller than circle2 , prints pass message, otherwise prints fail message
		if (circle1.isSmaller(circle2)) {
			System.out.println("PASSED: isSmaller");
		}
		else {
			System.out.println("FAILED: isSmaller");
		}

		//--

		//compareTo test 1, should pass
		circle1.setX(0);
		circle1.setY(0);
		circle1.setRadius(1);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if compareTo equals 0, prints pass message, otherwise prints fail message
		if (circle1.compareTo(circle2)==0) {
			System.out.println("PASSED: compareTo");
		}
		else {
			System.out.println("FAILED: compareTo");
		}

		//compareTo test 2, should fail
		circle1.setX(1);
		circle1.setY(1);
		circle1.setRadius(2);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if compareTo equals 0, prints pass message, otherwise prints fail message
		if (circle1.compareTo(circle2)==0) {
			System.out.println("PASSED: compareTo");
		}
		else {
			System.out.println("FAILED: compareTo");
		}

		//compareTo test 3, should pass
		circle1.setX(3);
		circle1.setY(3);
		circle1.setRadius(3);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);

		//if compareTo equals 1, prints pass message, otherwise prints fail message
		if (circle1.compareTo(circle2)==1) {
			System.out.println("PASSED: compareTo");
		}
		else {
			System.out.println("FAILED: compareTo");
		}

		//--

		//intersects test 1, should pass
		circle1.setX(1);
		circle1.setY(1);
		circle1.setRadius(5);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(5);

		//if intersection occurs, prints pass message, otherwise prints fail message
		if (circle1.intersects(circle2)==true) {
			System.out.println("PASSED: intersects");
		}
		else {
			System.out.println("FAILED: intersects");
		}


		//intersects test 2, should fail
		circle1.setX(5);
		circle1.setY(5);
		circle1.setRadius(1);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);
		
		//if intersection occurs, prints pass message, otherwise prints fail message
		if (circle1.intersects(circle2)==true) {
			System.out.println("PASSED: intersects");
		}
		else {
			System.out.println("FAILED: intersects");
		}

		//intersects test 3, should pass
		circle1.setX(5);
		circle1.setY(5);
		circle1.setRadius(10);
		circle2.setX(0);
		circle2.setY(0);
		circle2.setRadius(1);
		
		//if intersection occurs, prints pass message, otherwise prints fail message
		if (circle1.intersects(circle2)==true) {
			System.out.println("PASSED: intersects");
		}
		else {
			System.out.println("FAILED: intersects");
		}

	}

}