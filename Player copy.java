/*
 * Player.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 11/07/19
 *
 * Purpose: This program supplements the Interactive Fiction Game by creating a Player class for the 
 * user playing the Interactive Fiction Game. The player will have a location consisting of an x and
 * a y coordinate which can be manipulated via setter methods and have their state known through getter 
 * methods. The same is also true for lamp and key objects which the player may pick up during the game.
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
//creates new Player class
public class Player {
	
	//variable declarations
	private int xCoordinate;
	private int yCoordinate;
	private Lamp lamp;
	private Key key;
	
	//method to set the xCoordinate of the player location
	public void setX(int x) {
		this.xCoordinate=x;
	}
	//method to set the yCoordinate of the player location
	public void setY(int y) {
		this.yCoordinate=y;
	}
	//setter method to give the player a new key from the key class
	public void setKey(Key key) {
		this.key=key;
	}
	//setter method to give the player a new lamp from the lamp class
	public void setLamp(Lamp lamp) {
		this.lamp=lamp;
	}
	//method to get the xCoordinate of the player location
	public int getX() {
		return xCoordinate;
	}
	//method to get the yCoordinate of the player location
	public int getY() {
		return yCoordinate;
	}
	//getter method to get the state of the player's key- null if no key
	public Key getKey() {
		return key;
	}
	//getter method to get the state of the player's lamp- null if no lamp
	public Lamp getLamp() {
		return lamp;
	}



}
