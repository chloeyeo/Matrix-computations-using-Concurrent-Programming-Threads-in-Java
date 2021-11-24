package matrix;

import java.util.Random;

public class MatrixGenerator {
	/**
	 * This is a class that can be used to generate a random matrix of a given
	 * dimension, where the dimension is specified by the user, and print a nicely
	 * formatted representation of any given matrix.
	 */

	public static int[][] generateMatrix(int rows, int columns) {
		/**
		 * Generates a random integer matrix of dimension rows * columns. All entries of
		 * this random matrix should be in the range 0 to 9. Uses the JAVA built-in
		 * class java.util.Random and its method nextInt() to generate entries.
		 */

		int[][] random_integer_matrix = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				Random random = new Random();

				/**
				 * nextInt(x) generates a random integer from 0 to x-1 inclusive. So,
				 * nextInt(10) generates a random integer from 0 to 9 inclusive.
				 */
				random_integer_matrix[i][j] = random.nextInt(10);
			}
		}

		return random_integer_matrix;
	}

	public static void printMatrix(int[][] matrix) {
		/**
		 * Prints in the command line/terminal a nicely formatted string representation
		 * of matrix. Each row of the matrix appears in a new line, and entries of a row
		 * are divided by a single space.
		 */
		
		int numberOfRows = matrix.length;
		int numberOfColumns = matrix[0].length;
		
		for (int i=0; i < numberOfRows; i++) {
			for (int j=0; j < numberOfColumns; j++) {
				System.out.print(matrix[i][j]);
				if (j != numberOfColumns-1) {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
