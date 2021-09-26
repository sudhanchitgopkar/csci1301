/*
 * ParseTheTweet.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 09/03/19
 *
 * Purpose: This program takes a "tweet" inputted
 *  by the user and splits the string up based on 5 pieces of information:
 *  "type," "details," "location," Latitude," and "longitude."
 *  Each of these pieces of information are then outputted separately in an
 *  organized fashion so that they can be read as individual pieces more easily.
 *   
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
CSCI 1301: Lab 2 Page 4
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

public class ParseTheTweet {

	public static void main(String[] args) {

		//Scanner 
		Scanner keyboard = new Scanner (System.in);

		// Information-type Variable Declarations
		String type = new String ();
		String detail = new String();
		String location = new String();
		String latitude = new String ();
		String longitude = new String ();

		// Start & Finish Variable Declarations
		int start;
		int finish;

		// Asking the user for his/her tweet
		System.out.println("Please enter your tweet below:");
		String tweet= keyboard.nextLine();
		keyboard.close();

		//instantiating start & finish vars for first hastag
		start= tweet.indexOf("#");
		start=start +5;
		finish= tweet.indexOf(";");

		//Finding and Outputting "Type"
		type=tweet.substring(start,finish);
		type= type.toUpperCase();
		type=type.trim();
		System.out.println();
		System.out.println("Type:"+ "\t"+"\t" + type);

		//Deleting used part of Tweet
		tweet=tweet.substring(finish + 2);

		//instantiating start and finish vars for second hashtag
		start= tweet.indexOf("#");
		start=start +5;
		finish= tweet.indexOf(";");

		//Finding and Outputting "Detail"
		detail=tweet.substring(start,finish);
		detail=detail.trim();
		System.out.println("Detail:"+ "\t"+"\t" + detail);

		//Deleting used part of Tweet
		tweet=tweet.substring(finish + 2);

		//instantiating start and finish vars for third hashtag
		start= tweet.indexOf("#");
		start=start +5;
		finish= tweet.indexOf(";");

		//Finding and Outputting "Location"
		location=tweet.substring(start,finish);
		location=location.trim();
		System.out.println("Location:"+ "\t" + location);

		//Deleting used part of Tweet
		tweet=tweet.substring(finish + 2);

		//instantiating start and finish vars for fourth hashtag
		start= tweet.indexOf("#");
		start=start +5;
		finish= tweet.indexOf(";");

		//Finding and Outputting "Latitude"
		latitude=tweet.substring(start,finish);
		latitude=latitude.trim();
		System.out.println("Latitude:"+ "\t" + latitude);

		//Deleting used part of Tweet
		tweet=tweet.substring(finish + 2);

		//instantiating start and finish vars for fifth hashtag
		start= tweet.indexOf("#");
		start=start +5;
		finish= tweet.indexOf(";");

		//Finding and Outputting "Longitude"
		longitude=tweet.substring(start,finish);
		longitude=longitude.trim();
		System.out.println("Longitude:"+ "\t" + longitude);

		//Fin.



	}

}
