package com.codegnan.cards;

import java.util.ArrayList;
import java.util.Collections;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;

public class HDFCDebitCard implements  IATMService{
	String name;
	long debitCardNumber;
	double accountBalance;
	int pinNumber;
	ArrayList<String> statement;
	final String type = "user";
	int chances;


	public HDFCDebitCard(long debitCardNumber, String name, double accountBalance, int pinNumber) {
		chances = 3;
		this.name = name;
		this.accountBalance = accountBalance;
		this.pinNumber = pinNumber;
		statement = new ArrayList<>();
	}

	@Override
	public String getUserType() throws NotAOperatorException {
		return type;
	}

	@Override
	public double withdrawAmount(double wthAmount)
			throws InvalidAmountException, InsufficientBalanceException, InsufficientMachineBalanceException {

		if (wthAmount <= 0) {
			throw new InvalidAmountException("You can enter Zero(0) amount to withdraw.Please enter valid Amount");
		}
		else if(wthAmount%100!=0) {
			throw new InvalidAmountException("Please withdraw Multiples of 100");
		}
		else if(wthAmount<500) {
			throw new InsufficientBalanceException("Please withdraw more than 500 rupees");
		}
		else if(wthAmount>accountBalance) {
			throw new InsufficientBalanceException("You don't have sufficient balance to withdraw,Please check your account balance");
		}
		else {
			accountBalance=accountBalance-wthAmount;
			statement.add("Debited : "+ wthAmount);
			return wthAmount;
		}
	}

	@Override
	public void depositAmount(double deptAmount) throws InvalidAmountException {
		if(deptAmount<=0||deptAmount%100!=0||deptAmount<500) {
			throw new InvalidAmountException("please deposit multiples of 100 and deposit more than 500");
		}
		else {
			accountBalance=accountBalance+deptAmount;
			statement.add("Creadited : "+deptAmount);
		}

	}

	@Override
	public double checkAccountBalance() {
		
		return accountBalance;
	}

	@Override
	public void changePinNumber(int pinNumber) {
		this.pinNumber=pinNumber;

	}

	@Override
	public int getPinNumber() {
		
		return pinNumber;
	}

	@Override
	public String getUserName() {
		
		return name;
	}

	@Override
	public void decreaseChances() {
		--chances;

	}

	@Override
	public int getChances() {
		
		return chances;
	}

	@Override
	public void resetPinChances() {
		chances=3;

	}

	@Override
	public void generateMiniStatement() {
		int count=5;
		if(statement.size()==0) {
			System.out.println("There are no transactions Happened");
			return;
		}
		System.out.println("================= List 5 Transactions ================");
		Collections.reverse(statement);
		for(String trans:statement) {
			if(count==0) {
				break;
			}
			System.out.println(trans);
			count--;
		}
		Collections.reverse(statement);
	}

}
