package matrix;

public class TestMatrixMultiply {
	public static void main(String[] args) {
		int[][] newRandomMatrix1 = MatrixGenerator.generateMatrix(1001, 1003); // m by n
		int[][] newRandomMatrix2 = MatrixGenerator.generateMatrix(1003, 1002); // n by p
		
		long start_time = System.currentTimeMillis();
		MatrixMultiplication.matrixMultiply(newRandomMatrix1, newRandomMatrix2);
		long end_time = System.currentTimeMillis();
		System.out.println("Running time for standard non-parallel matrix multiplication: " + (end_time-start_time));
		
		start_time = System.currentTimeMillis();
		MatrixMultiplication.parallelMatrixMultiply(newRandomMatrix1, newRandomMatrix2);
		end_time = System.currentTimeMillis();
		System.out.println("Running time for parallel matrix multiplication: " + (end_time-start_time));
	}
}
