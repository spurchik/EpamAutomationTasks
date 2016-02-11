package javaHomeTask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
	Scanner scan = new Scanner(System.in);
	private int mtrxLineCapacity;

	public int getMtrxCapacity() {
		return mtrxLineCapacity * mtrxLineCapacity;
	}

	public void setMtrxCapacity() {
		System.out.println("Enter the size of matrix (from 1 to 20)");
		try {
			mtrxLineCapacity = scan.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("I just asked you to enter a number, Karl !!!");
			return;
		}
		if (mtrxLineCapacity > 20 || mtrxLineCapacity < 1) {
			System.out.println("From 1 to 20, Karl !!!");
			setMtrxCapacity();
		}
	}

	public int randomNumber() {
		int randNum = (int) (100 * Math.random());
		if (randNum > 100 || randNum < 1) {
			randomNumber();
		}
		return randNum;

	}
}
