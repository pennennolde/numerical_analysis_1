package math2;

public class Test {

	public static void main(String[] args) {

		/*
		double a[] = new double[49];
		for(int i=0; i<49; i++) {
			a[i] = Math.pow(i, 0.50);
		}
		Calc.printVec(a);
		System.out.println(Calc.vecNorm2(a));
		*/


		/*
		double A[][] = new double[100][100];
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				A[i][j] = (i+1.0)+(j+1.0);
			}
		}
		double Af = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				Af += Math.pow(Math.abs(A[i][j]), 2.0);
			}
		}
		Af = Math.pow(Af, 0.50);
		System.out.println(Af);
		*/


		/*
		int n = 6;
		double A[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = 1.0/((i+1)+(j+1)-1.0);
			}
		}
		double x_star[] =new double[n];
		for(int i=0; i<n; i++) {
			x_star[i] = 1.0;
		}
		double b[] = new double[n];
		b = Calc.matVec(A, x_star);
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
		for(int k=0; k<n-1; k++) {
			for(int i=k+1; i<n; i++) {
				A[i][k] = A[i][k]/A[k][k];
				for(int j=k+1; j<n; j++) {
					A[i][j] = A[i][j] - A[i][k]*A[k][j];
				}
				//b[i] = b[i] - A[i][k]*b[k];
			}
		}
		double y[][] = new double[n][n];
		for(int a=0; a<n; a++) {
			for(int i=0; i<n; i++) {
				y[i][a] = E[i][a];
				for(int j=0; j<i; j++) {
					y[i][a] = y[i][a] - A[i][j]*y[j][a];
				}
			}
		}
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
		double κ = (Calc.matNormInf(originA))*(Calc.matNormInf(x));
		System.out.println("条件数：κ_∞ = " + κ);
		*/


		/*
		double A[][] = {{0.0, -1.0, 2.0},
										{-4.0, 5.0, 6.0},
										{8.0, 9.0, 10.0}};
		double b[] = {3.0, 7.0, 11.0};
		int n = A.length;
		double x0[] = new double[n]; // 初期値
		for(int i=0; i<n; i++) {
			x0[i] = 0.0;
		}
		double ε = 1.0E-8; // 許容誤差
		int N = 50; // 最大反復回数
		double x_old[] = new double[n]; // x_m
		double x_new[] = new double[n]; // x_(m+1)
		double sum;
		for(int i=0; i<n; i++) {
			x_old[i] = x0[i];
		}
		for(int m=0; m<=N; m++) {
			for(int i=0; i<n; i++) {
				sum =0.0;
				for(int j=0; j<n; j++) {
					if(i!=j) {
						sum += A[i][j]*x_old[j];
					}
				}
				x_new[i] = (b[i]-sum)/A[i][i];
			}
			// 収束判定
			if( (Calc.vecNorm2(Calc.subVec(x_new, x_old)))/(Calc.vecNorm2(x_new))<ε) { // 相対誤差∞ノルム
				System.out.println("m=" + m);
				break;
			}
			for(int i=0; i<n; i++) {
				x_old[i] = x_new[i];
			}
			if(m==N) {
				System.out.println("収束しない");
			}
		}
		System.out.print("解：");
		Calc.printVec(x_old);
		*/



		double A[][] = new double[100][100];
		for(int i=2; i<98; i++) {
			A[i][i-2] = 1.0;
			A[i][i-1]= 2.0;
			A[i][i] = 4.0;
			A[i][i+1]= 2.0;
			A[i][i+2] = 1.0;
		}
		A[0][0] = 4.0;
		A[0][1] = 2.0;
		A[0][2] = 1.0;
		A[1][0] = 2.0;
		A[1][1] = 4.0;
		A[1][2] = 2.0;
		A[1][3] = 1.0;



	}
}
