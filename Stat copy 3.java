/*
 * Stat.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 10/29/19
 *
 * Purpose: This program contains methods for a stat class which can be used to get and set a double array called data.
 * This double array can then be used to manipulate the values within it through a series of methods including equals,
 *  toString, min, max, average, and mode. Equals tests the data array against another array to determine if both arrays
 *  contain all the same values. toString returns the data array in an easy-to-read, printable format. min and max return
 *  the minimum and maximum values present within the array respectively. Average computes the average of the data array 
 *  while mode returns the number that appears the most often within the data set.
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

public class Stat {
	//creates an instance variable of type double array named data
	private double [] data;

	//creates a constructor taking in no parameters which sets data to a single cell with the value 0.0
	public Stat() {
		data= new double[1];
		data[0]=0.0;
	}

	//creates a constructor with a double array parameter and sets data to the values within the double array
	public Stat(double [] d) {
		//creates array data which is the same size as the d array
		data = new double [d.length];
		//iterates through each value of d, setting data to that value
		for (int i=0;i<d.length;i++) {
			data[i]=d[i];
		}
	}

	//creates a method which returns a copy of the instance variable data
	public double [] getData(){
		//checks to make sure that data array has at least one value
		if(data.length<=0) {
			return new double [0];
		}
		//creates new double array called dataCopy with the same size as the data array
		double [] dataCopy=new double [data.length];

		//iterates through each value of data, setting dataCopy to that value
		for (int i=0; i<data.length;i++) {
			dataCopy[i]=data[i];
		}
		return dataCopy;

	}

	//creates a method which allows for data to be set through a double array parameter
	public void setData(double [] d) {
		data=new double[d.length];
		for (int i=0;i<d.length;i++) {
			data[i]=d[i];
		}

	}

	//creates a method that tests whether or not the data array equals the parameter array
	public boolean equals(Stat s) {
		//creates boolean initialized to true
		boolean equals=true;
		//sets boolean to false if the length of data is not equal to the data length in Stat Object S
		if(s.data.length!=data.length) {
			equals=false;
			return equals;
		}
		//sets boolean to false if each array cell of data and S.data aren't equal to one another
		for (int i=0;i<data.length;i++) {
			if(s.data[i]!=data[i]) {
				equals=false;
				return equals;

			}

		}

		return equals;

	}

	//creates a method to convert data into a simple-to-read string which can be output to the user
	public String toString() {
		//Variable declaration, initialization
		String toString="";
		int iCount=0;
		//checks to make sure the length of data array is non-negative
		if(data.length<=0) {
			return toString;
		}
		//returns each value in the data array with an open bracket and close bracket as well as commas separating each value
		toString="[";
		for (int i=0;i<data.length-1;i++) {
			toString=toString+data[i];
			if(iCount<=i) {
				toString=toString+",";
			}
			iCount++;
		}
		toString=toString+data[data.length-1]+"]";
		return toString;
	}

	//creates a method to find the minimum value within the data array
	public double min() {
		//creates variable called min, set to maximum value a double can take on
		double min=Double.MAX_VALUE;

		//checks to make sure the length of data is non-negative
		if(data.length<=0) {
			return min;
		}
		//iterates through each value in the array, setting the minimum value found to the variable min
		for(int i=0;i<data.length;i++) {
			if(data[i]<min) {
				min=data[i];
			}
		}

		return min;
	}

	//creates a method to find the maximum value within the data array
	public double max() {
		//creates variable called max, set to minimum value a double can take on
		double max=Double.MIN_VALUE;

		//checks to make sure the length of data is non-negative
		if(data.length<=0) {
			return 0.0;
		}
		if(data.length==1) {
			return 0.0;
		}
		//iterates through each value in the array, setting the maximum value found to the variable max
		for(int i=0;i<data.length;i++) {
			if(data[i]>max) {
				max=data[i];
			}
		}

		return max;
	}

	//creates a method by which the average of the values within the data array are found
	public double average() {
		//creates new variable named average set to 0
		double average=0;	
		//makes sure that data length is non-negative
		if(data.length<=0) {
			return average;
		}
		//sums all of the values within the data array
		for(int i=0;i<data.length;i++) {
			average=average+data[i];
		}
		//divides sum by length of data array
		average=average/data.length;

		return average;
	}

	//creates a method by which the mode of the data array is calculated and returned
	public double mode() {
		//variable declarations
		double [] countArray;
		double [] valueArray;
		double mode=Double.NaN;
		boolean valueFound=false;
		int currentIndex=0;
		double maxValue=Double.MIN_VALUE;
		int maxValueIndex=0;
		boolean multipleModes=false;

		//checks to make sure the data length is non-negative
		if (data.length<=0) {
			return mode;
		}
		//creates new arrays, called countArray and valueArray
		countArray=new double [data.length];
		valueArray=new double [data.length];

		for (int i=0;i<data.length;i++) {
			//sets the first value of valueArray to the first value in data, sets the first value of countArray to 1
			if(i==0) {
				valueArray[i]=data[i];
				countArray[i]=1;
			}
			//sets up a for-loop looking for each value within valueArray within data
			else {
				for (int j=0;j<valueArray.length;j++) {

					if (data[i]==valueArray[j]) {
						countArray[j]=countArray[j]+1;
						valueFound=true;
						currentIndex++;

					}

				}
				//if the value that is being searched for is not found, iterates to the next value within data
				if(valueFound==false) {
					valueArray[currentIndex]=data[i];
					countArray[currentIndex]=1;
					valueFound=true;
				}

			}

		}
		//searches through countArray for the highest count and finds its index
		for(int i=0;i<countArray.length;i++) {
			if(countArray[i]>countArray[maxValueIndex]) {
				maxValue=countArray[i];
				maxValueIndex=i;	
			}

		}

		for(int i=0;i<countArray.length;i++) {
			if((countArray[i]==maxValue) && (i!=maxValueIndex)) {
				multipleModes=true;
			}
		}
		//returns the value in the same index position just found but within the valueArray (mode)
		if(multipleModes==false) {
			mode=valueArray[maxValueIndex];
			return mode;
		}
		else {
			mode=Double.NaN;
			return mode;
		}

	}




}
