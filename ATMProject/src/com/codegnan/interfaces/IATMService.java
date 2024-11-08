package com.codegnan.interfaces;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;

public interface IATMService {
	// To get the user type whether the user is operator or normal user
	public abstract String getUserType() throws NotAOperatorException;

	// To withdrawAmount
	// 1.will throw InvalidAmountException if the Amount is not a valid denomination
	// 2.will throw InsufficientBalanceException if the customer has insufficient
	// amount in her/his account
	// 3.will throw InsufficientMachineBalanceException if the machine has
	// insufficient
	public abstract double withdrawAmount(double wthAount)
			throws InvalidAmountException, InsufficientBalanceException, InsufficientMachineBalanceException;

	// To deposit amount
	public abstract void depositAmount(double deptAmount) throws InvalidAmountException;

	// To check balance
	public abstract double checkAccountBalance();

	// To change pin number
	public void changePinNumber(int pinNumber);

	// get PIN Number
	public abstract int getPinNumber();

	// To get the user Name
	public abstract String getUserName();

	// To decrease the number of chances while enter the wrong pin number
	public abstract void decreaseChances();

	// To get the chances of Pin Number
	public abstract int getChances();

	// To reset the pin Number chances by bank operator
	public abstract void resetPinChances();

	// To generate mini-statement
	public abstract void generateMiniStatement();

}
