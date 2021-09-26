/*
 * Adventure.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 11/07/19
 *
 * Purpose: This is the main program for the Interactive Fiction game and thus uses the Key, Lamp, Map, Room,
 * and Player classes in order to create a game whereupon the user traverses his/her way through a map looking for 
 * a lamp, key, and chest so that he/she can find a treasure. The user must, during this time, beware a monster which
 * may kill them and end the game accordingly.
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
public class Adventure {

	public static void main(String[] args) {

		//variable declaration, instantiation
		String userCommand="";
		boolean gameOver=false;
		
		//creates a new player object named player
		Player player=new Player();

		//creates a new map object named map
		Map map=new Map();

		//creates new room object named room
		Room room= map.getRoom(player.getX(), player.getY());

		//creates new lamp object named lamp
		Lamp lamp=new Lamp();


		//creates new chest object named chest
		Chest chest=new Chest();


		Scanner keyboard = new Scanner(System.in);

		//sets current player x and y coordinates to (0,0)
		player.setX(0);
		player.setY(0);

		//Prints out initial welcome statement and original room description
		System.out.println("Welcome to UGA Adventures: Episode I \nThe Adventure of the Cave of Redundancy Adventure \nBy: Sudhan Chitgopkar");
		System.out.println();
		System.out.println(room.getDescription());

		//inputs user command
		userCommand=keyboard.nextLine();

		//creates loop that keeps the game continuing until player either wins or gets eaten
		while (gameOver==false) {

			//get lamp command
			if(userCommand.equalsIgnoreCase("GET LAMP")) {
				if (room.getLamp()!=null) {
					//player gets lamp
					player.setLamp(lamp);
					//lamp removed from room
					room.clearLamp();
					//player gets confirmation of getting the lamp
					System.out.println("OK");
					//asks for new user input
					userCommand=keyboard.nextLine();
				}
				else {
					//if no lamp present, outputs that lamp is not in room
					System.out.println("No lamp present");
					//asks for new user input
					userCommand=keyboard.nextLine();
				}
			}
			
			// light lamp command
			else if (userCommand.equalsIgnoreCase("LIGHT LAMP")) {
				//if player has lamp
				if(player.getLamp()!=null) {
					//lamp is lit
					lamp.setIsLit(true);
					//affirmation printed to user
					System.out.println("OK");
					//asks for new user command
					userCommand=keyboard.nextLine();
				}
				else {
					//if user doesn't have lamp, corresponding statement is printed
					System.out.println("You don't have the lamp to light");
					//asks for new user input
					userCommand=keyboard.nextLine();
					
				}
			}
			//north command
			else if (userCommand.equalsIgnoreCase("NORTH")) {
				//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
				if(room.isDark()==true && (player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
					//print corresponding statement
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					//exit program
					System.exit(0);
				}
				//otherwise,
				else {
					//check if room is valid
					if(room.canGoNorth()==true) {
						//sets new player location
						player.setX(player.getX()-1);
						//gets new room
						room=map.getRoom(player.getX(), player.getY());
						//if the room is dark and the player either doesn't have a lamp or the lamp the player has isn't lit,
						if(room.isDark()==true &&(player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
							//outputs the corresponding statement
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							//asks for new user input
							userCommand=keyboard.nextLine();
						}
						//otherwise,
						else {
							//creates new room
							room=map.getRoom(player.getX(), player.getY());
							//outputs description of newly created room
							System.out.println(room.getDescription());
							//asks for new user command
							userCommand=keyboard.nextLine();
						}
					}
					//otherwise,
					else {
						//prints corresponding statement
						System.out.println("Can't go that way");
						//asks for new user input
						userCommand=keyboard.nextLine();
					}
				}
			}
			//south command
			else if (userCommand.equalsIgnoreCase("SOUTH")) {
				//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
				if(room.isDark()==true && (player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
					//prints corresponding statement
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					//exits program
					System.exit(0);
				}
				else {
					//check if room is valid
					if(room.canGoSouth()==true) {
						//changes player location
						player.setX(player.getX()+1);
						//creates new room
						room=map.getRoom(player.getX(), player.getY());
						//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
						if(room.isDark()==true &&(player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
							//prints corresponding statement
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							//asks for new user command
							userCommand=keyboard.nextLine();
						}
						//otherwise
						else {
							//creates new room
							room=map.getRoom(player.getX(), player.getY());
							//outputs description of the newly created room
							System.out.println(room.getDescription());
							//asks for new user command
							userCommand=keyboard.nextLine();
						}
					}
					//otherwise,
					else {
						//outputs corresponding statement
						System.out.println("Can't go that way");
						//asks for new user command
						userCommand=keyboard.nextLine();
					}
				}
			}
			// east command
			else if (userCommand.equalsIgnoreCase("EAST")) {
				//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
				if(room.isDark()==true && (player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
					//outputs corresponding statement
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					//exits program
					System.exit(0);
				}
				//otherwise,
				else {
					//check if room is valid
					if(room.canGoEast()==true) {
						//changes user position
						player.setY(player.getY()+1);
						//creates new room
						room=map.getRoom(player.getX(), player.getY());
						//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
						if(room.isDark()==true &&(player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
							//outputs corresponding statement
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							// asks for new user input
							userCommand=keyboard.nextLine();
						}
						//otherwise
						else {
							//creates new room
							room=map.getRoom(player.getX(), player.getY());
							//outputs description of newly created room
							System.out.println(room.getDescription());
							//asks for new user input
							userCommand=keyboard.nextLine();
						}
					}
					//otherwise,
					else {
						//outputs corresponding command
						System.out.println("Can't go that way");
						//asks for new user input
						userCommand=keyboard.nextLine();
					}
				}
			}
			//west command
			else if (userCommand.equalsIgnoreCase("WEST")) {
				//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
				if(room.isDark()==true && (player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
					//outputs corresponding message
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					//exists program
					System.exit(0);
				}
				//otherwise,
				else {
					//check if room is valid
					if(room.canGoWest()==true) {
						//sets new player location
						player.setY(player.getY()-1);
						//creates new room
						room=map.getRoom(player.getX(), player.getY());
						//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
						if(room.isDark()==true &&(player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
							//outputs corresponding statement
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							//asks for user command
							userCommand=keyboard.nextLine();
						}
						//otherwise,
						else {
							//creates new room
							room=map.getRoom(player.getX(), player.getY());
							//outputs description of newly created room
							System.out.println(room.getDescription());
							//asks for new user input
							userCommand=keyboard.nextLine();
						}
					}
					//otherwise,
					else {
						//outputs corresponding statement
						System.out.println("Can't go that way");
						//asks for new user command
						userCommand=keyboard.nextLine();
					}
				}
			}
			//look command
			else if(userCommand.equalsIgnoreCase("LOOK")) {
				//if the room is dark and the player either doesn't have a lamp or the lamp they have isn't lit,
				if(room.isDark()==true &&(player.getLamp()==null || (player.getLamp()!=null && lamp.getIsLit()==false))) {
					//outputs corresponding statement
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					//asks for new user input
					userCommand=keyboard.nextLine();
				}
				//otherwise,
				else {
					//prints room description
					System.out.println(room.getDescription());
					//if lamp in room, prints corresponding statement
					if(room.getLamp()!=null) {
						System.out.println("There is an old oil lamp here that was made long ago");
					}
					//if key in room, prints corresponding statement
					if (room.getKey()!=null) {
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					}
					//if chest in room, prints corresponding statement
					if (room.getChest()!=null) {
						System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it");
					}
					//prints all possible exits
					System.out.print("Exits are: ");
					if(room.canGoNorth()==true) {
						System.out.println("north");
					}
					if(room.canGoSouth()==true) {
						System.out.println("south");
					}
					if(room.canGoEast()==true) {
						System.out.println("east");
					}
					if(room.canGoWest()==true) {
						System.out.println("west");
					}
					//asks for new user command
					userCommand=keyboard.nextLine();
				}
			}
			//get key command
			else if(userCommand.equalsIgnoreCase("GET KEY")) {
				//if key is present,
				if(room.getKey()!=null) {
					//player gets key
					player.setKey(map.getRoom(player.getX(), player.getY()).getKey());
					//key is removed from the room
					room.clearKey();
					//outputs affirmation to user
					System.out.println("OK");
					//asks for new user input
					userCommand=keyboard.nextLine();
				}
				//otherwise,
				else {
					//prints corresponding statement
					System.out.println("No key present");
					//asks for new user command
					userCommand=keyboard.nextLine();
				}
			}
			//unlock chest command
			else if(userCommand.equalsIgnoreCase("UNLOCK CHEST")) {
				//if player has key and chest is in room,
				if(player.getKey()!=null && room.getChest()!=null) {
					//key is used on chest
					player.getKey().use(map.getRoom(player.getX(), player.getY()).getChest());
					//affirmation printed to user
					System.out.println("OK");
					//asks for new user input
					userCommand=keyboard.nextLine();
				}
				//otherwise, if no key found
				else if(player.getKey()==null) {
					//outputs corresponding statement
					System.out.println("Need a key to do any unlocking!");
					//asks for new user input
					userCommand=keyboard.nextLine();
				}
				//if chest is not in the room
				else if (room.getChest()==null) {
					//prints corresponding statement
					System.out.println("No chest to unlock.");
					//asks for new user command
					userCommand=keyboard.nextLine();
				}
			}
			//open chest command
			else if (userCommand.equalsIgnoreCase("OPEN CHEST")) {
				//if chest is in room and unlocked
				if(room.getChest()!=null && !(map.getRoom(player.getX(), player.getX()).getChest().isLocked())) {
					//prints chest contents
					System.out.println(room.getChest().getContents());
					//exits program
					System.exit(0);
				}
				//otherwise,
				else if(room.getChest()==null) {
					//outputs corresponding statement
					System.out.println("No chest present.");
					//asks for new user command
					userCommand=keyboard.nextLine();
				}
				//otherwise,
				else if(chest.isLocked()==true) {
					//outputs corresponding statement
					System.out.println("The chest is locked.");
					//asks for new user command
					userCommand=keyboard.nextLine();
				}
			}
			//otherwise, 
			else {
				//outputs corresponding statement
				System.out.println("I'm sorry, I don't know how to do that.");
				//asks for new user command
				userCommand=keyboard.nextLine();
			}

		}
	}
}