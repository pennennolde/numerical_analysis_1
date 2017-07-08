package math2;

public class Condition_Number {

	public static void main(String[] args) {

		// 条件数をもとめる (∞ノルム)

		int n = 5;

		double A[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = 1.0/((i+1)+(j+1)-1.0);
			}
		}
		//Calc.printMat(A);

		double originA[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				originA[i][j] = A[i][j];
			}
		}

		double E[][] = new double[n][n];
		for( int i=0; i<n; i++) {
			for( int j=0; j<n; j++) {
				if( i==j ) {
					E[i][j] = 1;
				} else {
					E[i][j] = 0;
				}
			}
		}

		/*
		System.out.println("A=");
		Calc.printMat(A);
		System.out.println();

		System.out.println("E=");
		Calc.printMat(E);
		System.out.println();
		*/

		// A=LU と分解する
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

		/*
		System.out.println("A= (LU=)");
		Calc.printMat(A);

		System.out.println();
		*/


		// 前進代入により Ly_i=e_i を解く
		double y[][] = new double[n][n];
		for(int a=0; a<n; a++) {
			for(int i=0; i<n; i++) {
				y[i][a] = E[i][a];
				for(int j=0; j<i; j++) {
					y[i][a] = y[i][a] - A[i][j]*y[j][a];
				}
			}
		}

		// 後退代入により Ux_i=y_i を解く
		double x[][] = new double[n][n];
		for(int a=0; a<n; a++) {
			for(int i=n-1; i>=0; i--) {
				x[i][a] = y[i][a];
				for(int j=n-1; j>i; j--) {
					x[i][a] = x[i][a]- A[i][j]*x[j][a];
				}
				x[i][a] = x[i][a]/A[i][i];
			}
		}
		//System.out.println("Ainv=");
		//Calc.printMat(x);

		double κ = (Calc.matNormInf(originA))*(Calc.matNormInf(x));
		System.out.println("条件数：κ_∞ = " + κ);

	}
}
