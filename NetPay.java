/*
* NetPay.java
* Author: Sudhan Chitgopkar
* Submission Date: 08/26/19
* Purpose: This program takes a given user input regarding the number of hours he/she worked
*  and calculates out their gross and net pay with regard to given salary and applicable tax.
*  These aforementioned values are then outputted for the user to view.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* * or modified code from any source other than the course webpage
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

public class NetPay {
	
	//Constants

	public static final double FEDERAL_TAX_PERCENT=10.00;
	public static final double STATE_TAX_PERCENT=4.5;
	public static final double SS_PERCENT=6.2;
	public static final double MEDICARE_PERCENT=1.45;
	public static final double PAY_PER_HOUR=7.25;


	public static void main(String[] args) {

		// Variable instantiation
		
		double HoursPerWeek=0;
		double GrossPay=0;
		double NetPay=0;
			// Ded = Deduction
		double TotalDed=0;
		double FedDed=0;
		double StateDed=0;
		double SSDed=0;
		double MedDed=0;
									
		// User Input
			
		Scanner keyboard= new Scanner (System.in);
		System.out.println("Please enter the amount of hours you've worked:");
		HoursPerWeek= keyboard.nextDouble();
		
		//Computation
		
		GrossPay= HoursPerWeek *PAY_PER_HOUR;
		FedDed= (FEDERAL_TAX_PERCENT/100)* GrossPay;
		StateDed=(STATE_TAX_PERCENT/100)*GrossPay;
		SSDed= (SS_PERCENT/100)*GrossPay;
		MedDed= (MEDICARE_PERCENT/100)*GrossPay;
		TotalDed=MedDed+SSDed+StateDed+FedDed;
		NetPay=GrossPay-TotalDed;
		
		//Output
		
		System.out.println("Hours per Week:"+"\t\t"+HoursPerWeek);
		System.out.println("Gross Pay:" + "\t\t"+GrossPay);
		System.out.println("Net Pay:"+"\t\t"+NetPay);
		System.out.println("");
		System.out.println("Deductions");
		System.out.println("Federal:"+"\t\t"+ FedDed);
		System.out.println("State:"+"\t\t\t"+ StateDed);
		System.out.println("Social Security:"+"\t"+SSDed);
		System.out.println("Medicare:"+"\t\t"+MedDed);
		
		//Fin.
				
		
		
	}

}
