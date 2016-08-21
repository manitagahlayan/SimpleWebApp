package itu.oops.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class calculates future investment value based upon inputs provided user for 
 * investment, rate and time
 *
 */
public class FutureInvestmentCalculator {
	
	/**
	 * @param args
	 * This method is the starting point of the program and args will be the input from user
	 */
	public static void main(String[] args) {
		
		//declare and initialize the local variable
		double futureInvestmentValue = 0.0;
		double investmentAmount = 0.0;
		double annualRate = 0.0;
		double monthlyInterestRate = 0.0;
		double accumulatedInterest = 0.0;
		float duration = 0.0F;
		float years = 0.0F;
		
		//Object to scan the input entered by user
		Scanner scanner = new Scanner(System.in);
		
		//investment amount input from user
		System.out.print("Enter Investment Amount: ");
		investmentAmount = Double.parseDouble(scanner.next());
		
		// Annual interest rate input from user
		System.out.print("Enter Annual Interest Rate: ");
		annualRate = Double.parseDouble(scanner.next());
		
		// time frame input from user
		System.out.print("Enter Number of Years: ");
		years = Float.parseFloat(scanner.next());
		
		//Conversion of annual rate to monthly rate
		monthlyInterestRate = annualRate / (12*100);
		//calculating total no of years for investment
		duration = years * 12;
		//calculation for accumulated interest over the time
		accumulatedInterest = Math.pow(1 + monthlyInterestRate, duration);
		//calculating final investment value
		futureInvestmentValue = investmentAmount * (accumulatedInterest);
		
		
		//Restrict the investmentValue to two decimal places
		DecimalFormat df = new DecimalFormat("#.##");
		futureInvestmentValue = Double.valueOf(df.format(futureInvestmentValue));
		
		//Display formatted Future investment value to the user
		System.out.println("Accumulated value is : "+ futureInvestmentValue);
		
		scanner.close();

	}

}

