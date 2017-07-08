package math2;

public class Gauss_Seidel {

	public static void main(String[] args) {

		// 間違ってない? mが1小さい

		double A[][] = {{1, 1, 1, 1, 0},
										{1, 2, 1, 1, 1},
										{0, 1, 3, 1, 1},
										{0, 0, 1, 4, 1},
										{0, 0, 0, 1, 5}};

		double b[] = {4, 6, 6, 6, 6};



		int n = A.length;

		double x0[] = new double[n]; // 初期値
		for(int i=0; i<n; i++) {
			x0[i] = 0.0;
		}
		double ε = 1.0E-10; // 許容誤差
		int N = 100; // 最大反復回数

		double x[] = new double[n]; // x_m が1つずつ x_m+1 に塗り替えられていく
		double x_old[] = new double[n]; // 収束判定用に1つ前のxをとっておく
		double sum;

		for(int i=0; i<n; i++) {
			x[i] = x0[i];
		}

		for(int m=0; m<=N; m++) {
			for(int i=0; i<n; i++) {
				x_old[i] = x[i];
			}
			for(int i=0; i<n; i++) {
				sum =0.0;
				for(int j=0; j<n; j++) {
					if(i!=j) {
						sum += A[i][j]*x[j];
					}
				}
				x[i] = (b[i]-sum)/A[i][i];
			}
			// 収束判定
			if( (Calc.vecNormInf(Calc.subVec(x, x_old)))/(Calc.vecNormInf(x))<ε) { // 相対誤差∞ノルム
				System.out.println("m=" + m);
				break;
			}
			System.out.println(Calc.vecNormInf(Calc.subVec(x, x_old)));
			if(m==N) {
				System.out.println("収束しない");
			}
			System.out.print("m=" + m +" ：");
			Calc.printVec(x);
		}
		System.out.print("解：");
		Calc.printVec(x);


	}
}
