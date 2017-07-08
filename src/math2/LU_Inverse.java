package math2;

public class LU_Inverse {

	public static void main(String[] args) {

		// AX=E より A^(-1) を求める

		double A[][] = {{6, 1, 1, 1, 0},
										{1, 7, 1, 1, 1},
										{0, 1, 8, 1, 1},
										{0, 0, 1, 9, 1},
										{0, 0, 0, 1, 10}};


		int n = A.length;

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

		System.out.println("A=");
		Calc.printMat(A);
		System.out.println();

		System.out.println("E=");
		Calc.printMat(E);
		System.out.println();

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

		System.out.println("A= (LU=)");
		Calc.printMat(A);

		System.out.println();


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
		System.out.println("Ainv=");
		Calc.printMat(x);

		System.out.println();

		System.out.println("(originA)*(Ainv)=");
		Calc.printMat(Calc.multipleMat(originA, x));

	}
}
