package com.kappa.kindly.utils;

import java.util.InputMismatchException;

public class CPF {

	private static int CPF_LENGTH = 11;

	private static char getVerificationDigit(String CPF, int weight) {
		int sum, number;

		sum = number = 0;
		
		for (int i = 0; i < (weight - 1); i++) {
			number = (int) (CPF.charAt(i) - 48);

			sum += (number * weight);
			weight--;
		}
		
		int result = CPF_LENGTH - (sum % CPF_LENGTH);

		if (result == (CPF_LENGTH - 1) || result == CPF_LENGTH)
			return '0';
		else
			return (char) (result + 48);
	}

	public static boolean isValid(String CPF) {
		char firstDigit = CPF.charAt(0);
		boolean sameDigit = true;

		for (int i = 1; i < CPF.length() - 1; i++) {
			if (firstDigit != CPF.charAt(i))
				sameDigit = false; 
		}

		if (sameDigit || CPF.length() != CPF_LENGTH)
			return false;

		char digit10, digit11;

		try {
			digit10 = getVerificationDigit(CPF, 10);
			digit11 = getVerificationDigit(CPF, 11);

			if ((digit10 != CPF.charAt(9)) || (digit11 != CPF.charAt(10)))
				return false;
			
			return true;

		} catch (InputMismatchException ime) {
			return false;
		}
	}

	public static String format(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}
}
