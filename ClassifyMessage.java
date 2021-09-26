/*
 * ClassifyMessage.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 09/11/19
 *
 * Purpose: This program takes a "tweet" inputted
 *  by the user and splits the string up based on 4 pieces of information:
 *  "raw category," "message," "latitude," and "longitude."
 *  "raw category" is then put through a series of decision statements in
 *   order to further classify it into a final category. Finally, the 
 *   longitude and latitude provided by the user is tested against a 
 *   constant set of north, south, east, and west points to check if the
 *   location of the tweet is in-range. Category, Raw Category, Message,
 *   Longitude, Latitude, and whether or not the tweet is In Range is then
 *   output for the user.
 *  
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 *	CSCI 1301: Lab 4 Page 4
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


public class ClassifyMessage {
	
	enum MessageCategory {NEED,OFFER,ALERT,INFO,UNKNOWN}; 

	//Geographic Boundary Constant Initialization
	
	final static double south = 39.882343;  
	final static double north = 40.231315;
	final static double west = -105.743511;
	final static double east = -104.907864;
	
	public static void main(String[] args) { 
		
		//Variables
		String Catstring=new String();
		String Payload= new String();
		MessageCategory Category;  
		Boolean isInRange = false; 
		double latitude;
		double longitude;
		
		//Setting up the Scanner
		Scanner keyboard = new Scanner(System.in);
		
		//Asking for formatted user input, Obtaining Input
		System.out.println("Please enter a formatted message:");
		Catstring=keyboard.next();
		latitude=keyboard.nextDouble();
		longitude=keyboard.nextDouble();
		Payload=keyboard.nextLine();
		keyboard.close();
		
		
		//Deciding Message Category
		if (Catstring.equalsIgnoreCase("fire") || Catstring.equalsIgnoreCase("smoke")){
			Category= MessageCategory.ALERT;
		}
		
		else if (Catstring.equalsIgnoreCase("need")) {
			Category=MessageCategory.NEED;
		}
		else if (Catstring.equalsIgnoreCase("offer")) {
			Category=MessageCategory.OFFER;
		}
		
		else if (Catstring.equalsIgnoreCase("structure") || Catstring.equalsIgnoreCase("road")
				|| Catstring.equalsIgnoreCase("photo")|| Catstring.equalsIgnoreCase("evac")){
			Category= MessageCategory.INFO;
		}
		else {
			Category=MessageCategory.UNKNOWN;
		}
		
		//Determining if Latitude/Longitude is in-bounds
		if (latitude >= south && latitude <= north){
			if (longitude >= west && longitude <= east){	
				isInRange=true;
			}
		}
		
		
		
		//Output
		System.out.println("Category:\t"+ Category);
		Catstring = Catstring.trim();
		System.out.println("Raw Cat:\t"+ Catstring);
		Payload = Payload.trim();
		System.out.println("Message:\t"+ Payload);
		System.out.println("Latitude:\t"+ latitude);
		System.out.println("Longitude:\t"+ longitude);
		System.out.println("In Range:\t"+ isInRange);
		
		
	}

}
