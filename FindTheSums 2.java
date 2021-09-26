/*
 * FindTheSums.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 11/18/19
 *
 * Purpose: This program contains three methods by which to manipulate a 2d array entered as a parameter. 
 * The first method outputs the array to a simple string which can then be printed to the screen in a clean,
 * organized format. The second and third methods take in an additional parameter called sumToFind which refers
 * to an integer value that would like to be found through the summation of some values within the 2d matrix. The second method,
 * horizontal sums finds these sums through the horizontal rows of the 2d arrays while the third method, called vertical
 * sums, finds the values of the vertical columns in the 2d matrix which may add up to a total of the sumToFind. 
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

public class FindTheSums {
	//method for taking a 2d array and returning it as an organized string
	public static String arrayToString(int[][] a) {
		//declares, initializes string variable
		String stringArray="";
		//for each value in a row, prints value with a space between each value
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[0].length;j++) {
				stringArray=stringArray + a[i][j];
				if(j<a[0].length-1) {
					stringArray=stringArray+ " ";
				}
			}
			//after each row except for the last row, starts new row on line
			if(i<a.length-1) {
				stringArray=stringArray+"\n";
			}
		}
		//returns the string array
		return stringArray;
	}
	//method for taking a 2d array and a sum to be found, finds numbers in the 2d array rows that add to the sum
	public static int[][] horizontalSums(int[][] a, int sumToFind){
		//declares 2 2d arrays, 1 integer array and 1 boolean array
		boolean [] [] horizontalBooleanArray= new boolean [a.length][a[0].length];
		int [] [] horizontalSumArray = new int [a.length][a[0].length];
		//sets every value of the boolean array to false
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[0].length;j++) {
				horizontalBooleanArray[i][j]=false;
			}
		}
		//sets every value of the integer array to 0
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[0].length;j++) {
				horizontalSumArray[i][j]=0;
			}
		}
		//iterates through parameter array
		for (int i=0;i<a.length;i++) {
			for (int startDigitIndex=0;startDigitIndex<a[0].length;startDigitIndex++) {
				//sets the sum length and running sum to 0 for every new row
				int sumLength=0;
				int runningSum=0;
				//sets up the count loop
				for(int k=startDigitIndex;k<a[0].length;k++) {
					//if running sum is less than sum wanted, adds next number and increments sum length
					if (runningSum<sumToFind) {
						runningSum=runningSum+a[i][k];
						sumLength++;
					}
				}
				//if sum equals sum wanted, sets all the sum index values on the boolean array to true
				if (runningSum==sumToFind) {
					for(int k=0;k<sumLength;k++) {
						horizontalBooleanArray[i][startDigitIndex+k]=true;
					}
				}
			}
		}
		//for every value that is true on the boolean array, its value on the sum array is changed to its corresponding parameter array value
		for (int i=0; i<a.length;i++) {
			for (int j=0;j<a[0].length;j++) {
				if(horizontalBooleanArray[i][j]==true) {
					horizontalSumArray[i][j]=a[i][j];
				}
			}
		}
		// returns sum array
		return horizontalSumArray;
	}

	//method for taking a 2d array and a sum to be found, finds numbers in the 2d array columns that add to the sum
	public static int[][] verticalSums(int[][] a, int sumToFind){

		//declares 2 2d arrays, 1 integer array and 1 boolean array
		int [] [] verticalSumArray = new int [a.length][a[0].length];
		boolean [][] verticalBooleanArray= new boolean [a.length][a[0].length];

		//sets every value of the boolean array to be false
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[0].length;j++) {
				verticalBooleanArray[i][j]=false;
			}
		}

		//sets every value of the sum array to be 0
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[0].length;j++) {
				verticalSumArray[i][j]=0;
			}
		}


		//iterates through parameter array
		for (int i=0;i<a[0].length;i++) {
			for (int startDigitIndex=0;startDigitIndex<a.length;startDigitIndex++) {

				//sets the sum length and running sum to 0 for every new column
				int sumLength=0;
				int runningSum=0;

				//sets up the count loop
				for(int k=startDigitIndex;k<a.length;k++) {

					//if running sum is less than sum wanted, adds next number and increments sum length
					if (runningSum<sumToFind) {
						runningSum=runningSum+a[k][i];
						sumLength++;
					}
				}
				//if sum equals sum wanted, sets all the sum index values on the boolean array to true
				if (runningSum==sumToFind) {
					for(int k=0;k<sumLength;k++) {
						verticalBooleanArray[startDigitIndex+k][i]=true;
					}
				}
			}
		}
		//for every value that is true on the boolean array, its value on the sum array is changed to its corresponding parameter array value
		for (int i=0; i<a.length;i++) {
			for (int j=0;j<a[0].length;j++) {
				if(verticalBooleanArray[i][j]==true) {
					verticalSumArray[i][j]=a[i][j];
				}
			}
		}
		// returns sum array
		return verticalSumArray;
	}
}
//fin.
