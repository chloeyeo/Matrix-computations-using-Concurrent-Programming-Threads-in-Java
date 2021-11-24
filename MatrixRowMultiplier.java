package matrix;

public class MatrixRowMultiplier extends Thread {
	/**
	 * This class supports parallel matrix multiplication by multiplying one row at
	 * a time. The fields of the class store the row and matrix values.
	 */

	private int[] row;
	private int[][] matrix;
	private int[] productRowVector; // product of row and matrix.

	public MatrixRowMultiplier(int[] row, int[][] matrix) {
		/**
		 * The class constructor stores the given row and matrix for use in the
		 * multiplication process.
		 */
		this.row = row;
		this.matrix = matrix;
	}

	public void multiplyByRow() {
		/**
		 * Computes the product between the stored row and matrix and stores the result
		 * so that it can be returned later. Assumes that the matrix multiplication is
		 * well-defined.
		 */

		int matrixColumns = matrix[0].length;
		productRowVector = new int[matrixColumns];
		for (int j = 0; j < matrixColumns; j++) {
			productRowVector[j] = 0;
			for (int k = 0; k < row.length; k++) {
				productRowVector[j] += row[k] * matrix[k][j];
			}
		}
	}

	public int[] getResult() {
		/**
		 * Returns the row vector named productRowVector that corresponds to the product
		 * of row and matrix. This method assumes that multiplyByRow() has been called
		 */
		return productRowVector;
	}

	public void run() {
		/**
		 * Overrides the inherited method run() from the superclass Thread. Calls the
		 * method multiplyByRow()
		 */
		multiplyByRow();
	}
}
