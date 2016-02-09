package javaHomeTask;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix instance = new Matrix();
		instance.setMtrxCapacity();

		final int MATRIX_CAPACITY = instance.getMtrxCapacity();
		int[][] mtrxArr = new int[MATRIX_CAPACITY][MATRIX_CAPACITY];
		double enteredNumber = Math.sqrt(MATRIX_CAPACITY);
		String dataSaver;

		int beginLineNumber = 0;
		int endLineNumber = (int) (enteredNumber - 1);
		int stepCutLine = 1;
		int elementCounter = 0;

		try (FileWriter writer = new FileWriter("C:\\Selenium\\matrix.txt",
				false)) {

			// filling array by random numbers and saving in a matrix form
			writer.write("Matrix form" + "\n" + "\n");
			for (int i = 0; i < enteredNumber; i++) {
				for (int j = 0; j < enteredNumber; j++) {
					mtrxArr[i][j] = instance.randomNumber();
					dataSaver = mtrxArr[i][j] + " ";
					writer.write(dataSaver);
					if (j == enteredNumber - 1) {
						dataSaver = "\n";
						writer.write(dataSaver);
					}
				}
			}

			// converting matrix by spiral way
			writer.write("\n" + "Numbers in spiral way" + "\n" + "\n");

			// counter of sides of a matrix
			for (int j = 0; j < enteredNumber / 2; j++) {

				// creating spiral top side
				for (int i = beginLineNumber; i <= endLineNumber; i++) {
					dataSaver = mtrxArr[beginLineNumber][i] + " ";
					writer.write(dataSaver);
					elementCounter++;
					/*if (elementCounter % enteredNumber == 0) {
						writer.write("\n");
					}*/
				}
				// cycle break after central element output
				if (j >= ((enteredNumber - 1) / 2)) {
					break;
				}
				// creating spiral right side
				for (int i = beginLineNumber + stepCutLine; i < endLineNumber; i++) {
					dataSaver = mtrxArr[i][endLineNumber] + " ";
					writer.write(dataSaver);
					elementCounter++;
					/*if (elementCounter % enteredNumber == 0) {
						writer.write("\n");
					}*/
				}
				// creating spiral bottom side
				for (int i = endLineNumber; i >= beginLineNumber; i--) {
					dataSaver = mtrxArr[endLineNumber][i] + " ";
					writer.write(dataSaver);
					elementCounter++;
					/*if (elementCounter % enteredNumber == 0) {
						writer.write("\n");
					}*/
				}
				// creating spiral left side
				for (int i = endLineNumber - stepCutLine; i >= beginLineNumber
						+ stepCutLine; i--) {
					dataSaver = mtrxArr[i][beginLineNumber] + " ";
					writer.write(dataSaver);
					elementCounter++;
					/*if (elementCounter % enteredNumber == 0) {
						writer.write("\n");
					}*/
				}
				endLineNumber--;
				beginLineNumber++;
			}
			writer.flush();
			System.out.println("check result in:" + "\n"
					+ "C:\\Selenium\\matrix.txt");
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}
}
