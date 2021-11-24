package matrix;

public class MatrixMultiplication {
	/**
	 * This is a class that contains two methods: one that implements standard,
	 * non-parallel matrix multiplication, and another one that implements parallel
	 * matrix multiplication using the MatrixRowMultiplier class.
	 */

	public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {
		/**
		 * Computes and returns the product of matrix1 and matrix2. This method assumes
		 * that the matrix multiplication is well-defined, i.e. number of columns in
		 * matrix1 = the number of rows in matrix2. matrix1 will have dimension m*n,
		 * matrix2 will have dimension n*p, and the resulting product matrix will have
		 * dimension m*p.
		 */
		int rowsMatrix1 = matrix1.length; // m
		int columnsMatrix1 = matrix1[0].length; // n (this is the same as rowsMatrix2 = matrix2.length)
		int columnsMatrix2 = matrix2[0].length; // p

		/** The resulting matrix which is the product of matrix1 and matrix2. */
		int[][] productMatrix = new int[rowsMatrix1][columnsMatrix2];

		for (int i = 0; i < rowsMatrix1; i++) {
			for (int j = 0; j < columnsMatrix2; j++) {
				productMatrix[i][j] = 0;
				for (int k = 0; k < columnsMatrix1; k++) {
					productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}

		return productMatrix;
	}
    
	public static int[][] parallelMatrixMultiply(int[][] matrix1, int[][] matrix2) {
		/**
		 * This method supports parallel matrix multiplication, by concurrently
		 * multiplying two matrices in a row-wise fashion, using the MatrixRowMultiplier
		 * class.
		 * 
		 * Create and start matrix1.length many threads using the class
		 * MatrixRowMultiplier, join the threads together, combine all the resulting
		 * vectors from multiple threads into a single matrix, and finally, return that
		 * matrix.
		 * Join threads together by creating an array, storing the thread t's in the array
		 * then after for loop ends iterate over the array and do t.join()
		 */
		int rowsMatrix1 = matrix1.length;
		int columnsMatrix2 = matrix2[0].length;
		MatrixRowMultiplier[] arrayOfThreads = new MatrixRowMultiplier[rowsMatrix1];
		
		// no need to do Thread t = new Thread(new MatrixRowMultiplier(...));
		// because MatrixRowMultiplier class already extends the Thread class.
		// MatrixRowMultiplier is a subclass of Thread so it creates a thread object.
		for (int i=0; i < rowsMatrix1; i++) {
			MatrixRowMultiplier t = new MatrixRowMultiplier(matrix1[i],matrix2);
			arrayOfThreads[i] = t;
			arrayOfThreads[i].start();
		}
		
		int[][] resultingSingleMatrix = new int[rowsMatrix1][columnsMatrix2];
		
		for (int i=0; i < rowsMatrix1; i++) {
			try {
				arrayOfThreads[i].join();
				resultingSingleMatrix[i] = arrayOfThreads[i].getResult();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		return resultingSingleMatrix;
	}
}
