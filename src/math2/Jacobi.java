package math2;

public class Jacobi {

	public static void main(String[] args) {

		double A[][] = {{6, 1, 1, 1, 0},
										{1, 7, 1, 1, 1},
										{0, 1, 8, 1, 1},
										{0, 0, 1, 9, 1},
										{0, 0, 0, 1, 10}};

		double b[] = {9, 11, 11, 11, 11};


		int n = A.length;

		double x0[] = new double[n]; // 初期値
		for(int i=0; i<n; i++) {
			x0[i] = 0.0;
		}
		double ε = 1.0E-10; // 許容誤差
		int N = 100; // 最大反復回数

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
			if( (Calc.vecNormInf(Calc.subVec(x_new, x_old)))/(Calc.vecNormInf(x_new))<ε) { // 相対誤差∞ノルム
				System.out.println("m=" + m);
				break;
			}
			for(int i=0; i<n; i++) {
				x_old[i] = x_new[i];
			}
			if(m==N) {
				System.out.println("収束しません。");
			}
		}
		System.out.print("解：");
		Calc.printVec(x_old);

	}
}
