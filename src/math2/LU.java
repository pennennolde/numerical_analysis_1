package math2;

public class LU {

	public static void main(String[] args) {

		double A[][] = {{2, -1, 2},
										{-4, 4, -5},
										{6, -7, 10}};

		double b[] = {7, 7, 7};


		// 前進消去過程
		int n = A.length;

		for(int k=0; k<n-1; k++) {
			for(int i=k+1; i<n; i++) {
				A[i][k] = A[i][k]/A[k][k];
				for(int j=k+1; j<n; j++) {
					A[i][j] = A[i][j] - A[i][k]*A[k][j];
				}
				//b[i] = b[i] - A[i][k]*b[k];
			}
		}
		// α=A[i][k]

		Calc.printMat(A);

		System.out.println();

		// A=LU
		/*
		double L[][] = new double[n][n];
		double U[][] = new double[n][n];

		// Lを視覚化
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i>j) L[i][j] = A[i][j];
				if(i==j) L[i][j] = 1;
				if(i<j) L[i][j] =0;
			}
		}
		Calc.printMat(L);

		System.out.println();

		// Uを視覚化
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i>j)  U[i][j] = 0;
				if(i<=j)  U[i][j] = A[i][j];
			}
		}
		Calc.printMat(U);

		System.out.println();
		*/


		// 前進代入 L
		double y[] = new double[n];
		for(int i=0; i<n; i++) {
			y[i] = b[i];
			for(int j=0; j<i; j++) {
				y[i] -= A[i][j]*y[j];
			}
		}
		Calc.printVec(y);

		System.out.println();

		// 後退代入 U
		double x[] = new double[n];
		for(int i=n-1; i>=0; i--) {
			x[i] = y[i];
			for(int j=n-1; j>i; j--) {
				x[i] -= A[i][j]*x[j];
			}
			x[i] = x[i]/A[i][i];
		}
		Calc.printVec(x); // 解

	}
}
