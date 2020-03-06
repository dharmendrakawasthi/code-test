package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil<T> {

	private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

	T[][] data;

	public ArrayQuadrantUtil(T[][] data) {
		this.data = data;
	}

	public T[] getQuadrantValues(int row, int column) {

//		Get middle number of the rows and columns

		int divCol = data[0].length / 2;
		int divRow = data.length / 2;

//		Generic array to store the data.
		T[] arr = (T[]) new Object[divRow + divCol];

		int len = arr.length - 1;

		int minRow = 0;
		int maxRow = 0;
		int minCol = 0;
		int maxCol = 0;

		if (row < divRow && column < divCol) {      // check for first quadrant

			minRow = 0;
			maxRow = divRow - 1;
			minCol = 0;
			maxCol = divCol - 1;

			while (len >= 0) {

				arr[len] = data[maxRow][maxCol];
				if (maxCol > minCol) {
					maxCol--;
				} else {
					maxCol = divCol - 1;
					maxRow--;
				}
				len--;
			}

		} else if (row < divRow && column >= divCol) {     // Check for second quadrant

			minRow = 0;
			maxRow = divRow - 1;
			minCol = divCol;
			maxCol = data[0].length - 1;

			while (len >= 0) {

				arr[len] = data[maxRow][maxCol];

				if (maxCol > minCol) {
					maxCol--;
				} else {
					maxCol = data[0].length - 1;
					maxRow--;
				}
				len--;
			}

		} else if (row >= divRow && column < divCol) {     // check for third quadrant

			minRow = divRow;
			maxRow = data.length - 1;
			minCol = 0;
			maxCol = divCol - 1;

			while (len >= 0) {

				arr[len] = data[maxRow][maxCol];
				if (maxCol > minCol) {
					maxCol--;
				} else {
					maxCol = divCol - 1;
					maxRow--;
				}
				len--;
			}
		} else if (row >= divRow && column >= divCol) {     // check for fourth quadrant

			minRow = divRow;
			maxRow = data.length - 1;
			minCol = divCol;
			maxCol = data[0].length - 1;

			while (len >= 0) {

				arr[len] = data[maxRow][maxCol];

				if (maxCol > minCol) {
					maxCol--;
				} else {
					maxCol = data[0].length - 1;
					maxRow--;
				}
				len--;
			}
		}
		return arr;
	}

	/*
	 * Method  getRowCol(String rowCol, int index) takes two arguments 
	 * rowCol - takes two values either "row" or "col"
	 * index - the row/column need to be returned (asuming row number starts from 1)
	 *  e.g. getRowCol("row", 2) will return the elements of second row 
	 */
	
	public T[] getRowCol(String rowCol, int index) {

// get the middle of rows and columns
		int midCol = data[0].length / 2;
		int midRow = data.length / 2;

		if(index == 0) {
			return null;
		}
		
		T[] arr = (T[]) new Object[midRow + midCol];

//		If query is for "row" return the rows
		if (rowCol.equals("row")) {

			int rowNum = index - 1;
			int len = data[0].length - 1;

			while (len >= 0) {
				arr[len] = data[rowNum][len];
				len--;
			}
		} 
//		if input is for columns return the elements of column
		else if (rowCol.equals("col")) {

			int colNum = index - 1;
			int len = data.length - 1;

			while (len >= 0) {
				arr[len] = data[len][colNum];
				System.out.println(data[len][colNum]);
				len--;
			}

		}

		return arr;
	}
}
