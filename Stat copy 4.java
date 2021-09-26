/*
 * Stat.java
 * Author: Sudhan Chitgopkar
 * Submission Date: 11/11/19
 *
 * Purpose: This program contains methods for a stat class which can be used to get and set a double array called data.
 * This double array can then be used to manipulate the values within it through a series of methods and can be used alongside 
 * arrays of different types including integers, longs, and floats. Specifically, this class gives the user the ability to append 
 * values to the initial data array, find the minimum, maximum, mode, mean, variance, and standard deviation of the array. 
 * Furthermore, the program can tell when a particular array is empty, and can handle null parameters gracefully.
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
		data= new double[0];
	}

	public Stat(double [] d) {
		if(d!=null) {
			//creates a constructor with a double array parameter and sets data to the values within the double array
			data=new double [d.length];
			for (int j=0;j<d.length;j++) {
				data[j]=d[j];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double [0];
		}
	}

	public Stat(int [] i) {
		if(i!=null) {
			//creates a constructor with a integer array parameter and sets data to the values within the integer array
			data=new double [i.length];
			for (int j=0;j<i.length;j++) {
				data[j]=i[j];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double [0];
		}
	}

	public Stat(long [] lo) {
		if(lo!=null) {
			//creates a constructor with a long array parameter and sets data to the values within the long array
			data=new double [lo.length];
			for (int j=0;j<lo.length;j++) {
				data[j]=lo[j];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double [0];
		}
	}

	public Stat(float [] f) {
		if(f!=null) {
			//creates a constructor with a float array parameter and sets data to the values within the float array
			data=new double [f.length];
			for (int j=0;j<f.length;j++) {
				data[j]=f[j];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double [0];
		}
	}
	//creates a method which allows for data to be set through a integer array parameter
	public void setData(int[] i) {
		if(i!=null) {
			//if parameter isn't null, sets data array equal to a copy of parameter array
			data=new double[i.length];
			for (int j=0;j<i.length;j++) {
				data[j]=i[j];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double[0];
		}
	}
	//creates a method which allows for data to be set through a long array parameter
	public void setData(long[] lo) {
		if(lo!=null) {
			//if parameter isn't null, sets data array equal to a copy of parameter array
			data=new double[lo.length];
			for (int j=0;j<lo.length;j++) {
				data[j]=lo[j];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double[0];
		}
	}
	//creates a method which allows for data to be set through a float array parameter
	public void setData(float[] f) {
		if(f!=null) {
			//if parameter isn't null, sets data array equal to a copy of parameter array
			data=new double[f.length];
			for (int j=0;j<f.length;j++) {
				data[j]=f[j];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double [0];
		}
	}


	//creates a method which allows for data to be set through a double array parameter
	public void setData(double [] d) {
		if(d!=null) {
			//if parameter isn't null, sets data array equal to a copy of parameter array
			data=new double[d.length];
			for (int i=0;i<d.length;i++) {
				data[i]=d[i];
			}
		}
		else {
			//if parameter is null, sets data to empty array
			data=new double [0];
		}
	}

	//creates a method which returns a copy of the instance variable data
	public double [] getData(){
		//checks to make sure that data array has at least one value
		if(data.length<0) {
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


	//creates a method that tests whether or not the data array equals the parameter array
	public boolean equals(Stat s) {
		//creates boolean initialized to true
		boolean equals=true;

		if(s==null) {
			//if parameter is null, sets returns false
			equals=false;
			return equals;
		}
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
		//returns equals boolean if not already returned through decision statements
		return equals;
	}

	//resets data array to empty array
	public void reset() {
		//creates new empty array
		double [] emptyArray=new double [0];
		data=emptyArray;
	}

	//appends the parameter array onto the end of the data array
	public void append (double [] d) {
		if(d!=null) {
			//if parameter is not null, appends
			double [] appendedData= new double[data.length+d.length];
			for(int i=0;i<data.length;i++) {
				appendedData[i]=data[i];
			}
			//sets first part of appended array to original data array ^
			for (int i=data.length;i<data.length+d.length;i++) {
				appendedData[i]=d[i-data.length];
			}
			data=appendedData;
			//sets second part of appended array to parameter array ^
		}
	}

	//appends the parameter array onto the end of the data array
	public void append (int [] i) {
		if(i!=null) {
			//if parameter is not null, appends
			double [] appendedData= new double[data.length+i.length];
			for(int j=0;j<data.length;j++) {
				appendedData[j]=data[j];
			}
			for (int j=data.length;j<data.length+i.length;j++) {
				appendedData[j]=i[j-data.length];
			}
			data=appendedData;
			//sets second part of appended array to parameter array ^
		}
	}
	//appends the parameter array onto the end of the data array 
	public void append (long [] lo) {
		if(lo!=null) {
			//if parameter is not null, appends
			double [] appendedData= new double[data.length+lo.length];
			//sets first part of appended array to original data array ^
			for(int j=0;j<data.length;j++) {
				appendedData[j]=data[j];
			}
			for (int j=data.length;j<data.length+lo.length;j++) {
				appendedData[j]=lo[j-data.length];
			}
			data=appendedData;
			//sets second part of appended array to parameter array ^
		}
	}

	//appends the parameter array onto the end of the data array 
	public void append (float [] f) {
		if(f!=null) {
			//if parameter is not null, appends
			double [] appendedData= new double[data.length+f.length];
			for(int j=0;j<data.length;j++) {
				appendedData[j]=data[j];
			}
			//sets first part of appended array to original data array ^
			for (int j=data.length;j<data.length+f.length;j++) {
				appendedData[j]=f[j-data.length];
			}
			data=appendedData;
			//sets second part of appended array to parameter array ^
		}
	}

	//checks if the data array is empty
	public boolean isEmpty() {
		//initializes boolean isEmpty to false
		boolean isEmpty=false;
		//boolean becomes true if data array has no values
		if(data.length==0) {
			isEmpty=true;
		}
		//returns boolean
		return isEmpty;
	}

	//creates a method to convert data into a simple-to-read string which can be output to the user
	public String toString() {
		//Variable declaration, initialization
		String toString="";
		int iCount=0;
		//checks to make sure the length of data array is non-negative
		if(data.length<=0) {
			toString="[]";
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

		//checks to make sure the length of data is non-zero & positive
		if(data.length<=0) {
			return Double.NaN;
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

		//checks to make sure the length of data is non-negative or zero
		if(data.length<=0) {
			return Double.NaN;
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
		//makes sure that data length is non-negative or zero
		if(data.length<=0) {
			return Double.NaN;
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
		//variable declaration, initialization
		double threshold=0.00001;
		int modeC=0;
		int numC=0;
		double modeTest=0;
		double mode=0;

		//returns not-a-number if data length is zero or negative
		if(data.length<=0) {
			return Double.NaN;
		}

		else {
			for (int i=0;i<data.length;i++) {
				//iteration 1
				modeTest=data[i];
				numC=0;
				for (int j=i;j<data.length;j++) {
					//iteration 2
					if(Math.abs(modeTest-data[j])<threshold) {
						numC=numC+1;
					}
				}
				//case for new mode found
				if (numC>modeC) {
					mode=modeTest;
					modeC=numC;
				}
				//case for multiple modes
				else if (numC==modeC) {
					mode=Double.NaN;
					return mode;
				}

			}
			//returns final mode found
			return mode;
		}
	}

	public double variance() {
		//variable declaration, initialization
		double variance;
		double [] differenceArray=new double[data.length];
		double sum=0;
		double tempNum=0;
		double mean=0;

		//checks if data is negative or 0, returns not-a-number if true
		if(data.length<=0) {
			return Double.NaN;
		}
		else {
			//calculates mean
			for (int i=0;i<data.length;i++) {
				//sums complete data set
				mean=mean+data[i];
			}
			//divides by amount of terms
			mean=mean/data.length;

			for(int i=0;i<data.length;i++) {
				//sets up differenceArray for usage
				tempNum=data[i]-mean;
				differenceArray[i]=tempNum*tempNum;
			}
			for(int i=0;i<data.length;i++) {
				//sums differenceArray values
				sum=sum+differenceArray[i];
			}
			//calculates variance
			variance=sum/data.length;
			//returns variance
			return variance;
		}
	}

	public double standardDeviation(){
		//variable declaration, initialization
		double variance;
		double standardDeviation=0;
		double [] differenceArray=new double[data.length];
		double sum=0;
		double tempNum=0;
		double mean=0;

		//checks if data is negative or 0, returns not-a-number if true
		if(data.length<=0) {
			return Double.NaN;
		}
		else {
			//calculates mean
			for (int i=0;i<data.length;i++) {
				//sums complete data set
				mean=mean+data[i];
			}
			//divides by amount of terms
			mean=mean/data.length;

			for(int i=0;i<data.length;i++) {
				//sets up differenceArray for usage
				tempNum=data[i]-mean;
				differenceArray[i]=tempNum*tempNum;
			}
			for(int i=0;i<data.length;i++) {
				//sums differenceArray values
				sum=sum+differenceArray[i];
			}
			//calculates variance
			variance=sum/data.length;
			//returns variance
			standardDeviation=Math.sqrt(variance);
			return standardDeviation;
		}
	}



}
