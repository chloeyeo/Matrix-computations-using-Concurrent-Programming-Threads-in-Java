# Matrix-computations-using-Concurrent-Programming-Threads-in-Java
Generates random matrices using Java library, and speeds up basic matrix computations such as matrix multiplication using Concurrent Programming/Threads in Java.

Let matrix C be the product of matrix multiplication between matrix A and matrix B (A*B=C).
For calculating the 1st row of matrix 𝐶, we only
need the 1st row of matrix 𝐴 and access to matrix 𝐵.

The same can be observed for the 2nd row of matrix C -- we only
need the 2nd row of matrix 𝐴 and access to matrix 𝐵. 

Since the computation of these two rows are independent of each other, we can run these
calculations in parallel, using MatrixMultiplication.parallelMatrixMultiply().

This idea can be generalized to multiplying any two matrices 𝐴,𝐵 of finite dimension for which
matrix multiplication is well-defined, i.e., the number of columns in 𝐴 is the same as the number of
rows in 𝐵.
