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
		
		int midRow = data[0].length / 2;
		int midCol = data.length / 2;

//		Generic array to store the data
		T[] e = (T[]) new Object[midRow + midCol];

		int len = e.length;

		int maxRow = 0;
		int maxCol = 0;
		int minRow = 0;
		int minCol = 0;


		if (row < midRow && column < midCol) {				//		Check for first Quadrant

//			initialize the veriables according to the first quadrant	
			maxRow = midRow - 1;
			maxCol = midCol - 1;
			minRow = 0;
			minCol = 0;

			while (len > minCol) {

				e[len - 1] = data[maxRow][maxCol];

				if (maxCol > 0) {
					maxCol--;
				} else {
					maxCol = midCol - 1;
					maxRow--;
				}

				--len;
			}

		} else if (row < midRow && column > midCol) {       // Check for second Quadrant

//			initialize the veriables according to the second quadrant	

			maxRow = midRow - 1;
			maxCol = data[0].length - 1;
			minRow = 0;
			minCol = midCol;

			while (len > 0) {

				e[len - 1] = data[maxRow][maxCol];

				if (maxCol > minCol) {
					maxCol--;
				} else {
					maxCol = data[0].length - 1;
					maxRow--;
				}

				--len;
			}

		} else if (row > midRow && column < midCol) {		// Check for third Quadrant

//			initialize the veriables according to the third quadrant	

			maxRow = data[0].length - 1;
			maxCol = midCol - 1;
			minRow = midRow;
			minCol = 0;

			while (len > minCol) {

				e[len - 1] = data[maxRow][maxCol];

				if (maxCol > 0) {
					maxCol--;
				} else {
					maxCol = midCol - 1;
					maxRow--;
				}

				--len;
			}

		} else if (row > midRow && column > midCol) {			// Check for fourth Quadrant

//			initialize the veriables according to the fourth quadrant	

			maxRow = data[0].length - 1;
			maxCol = data.length - 1;
			minRow = midRow;
			minCol = midCol;

			while (len > 0) {

				e[len - 1] = data[maxRow][maxCol];
				System.out.println(data[maxRow][maxCol]);
				if (maxCol > minCol) {
					maxCol--;
				} else {
					maxCol = data[0].length - 1;
					maxRow--;
				}

				--len;
			}
		}

		return e;
	}

	public T[] getRowCol(String rowCol, int index) {

		int midCol = data[0].length / 2;
		int midRow = data.length / 2;

		T[] e = (T[]) new Object[midRow + midCol];

		if (rowCol.equals("row")) {

			int rowNum = index - 1;
			int len = data[0].length - 1;

			while (len >= 0) {
				e[len] = data[rowNum][len];
				len--;
			}
		} else if (rowCol.equals("col")) {

			int colNum = index - 1;
			int len = data.length - 1;

			while (len >= 0) {
				e[len] = data[len][colNum];
				System.out.println(data[len][colNum]);
				len--;
			}

		}

		return e;
	}
}
