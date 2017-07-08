package math2;

public class SOR {

	public static void main(String[] args) {

		double A[][] = {{1, 2, 1, 2, 1},
										{2, 3, 2, 3, 2},
										{1, 2, 3, 4, 5},
										{4, 3, 8, 1, 2},
										{8, 2, 4, 1, 9}};

		double b[] ={7, 7, 7, 7, 7};




		int n = A.length;

		double x0[] = new double[n]; // 初期値
		for(int i=0; i<n; i++) {
			x0[i] = 0.0;
		}
		double ε = 1.0E-10; // 許容誤差
		int N = 100; // 最大反復回数

		double x[] = new double[n]; // x_m が1つずつ x_m+1 に塗り替えられていく
		double x_cld[] = new double[n];
		double x_old[] = new double[n]; // 収束判定用に1つ前のxをとっておく

		double ω = 1; // パラメータ

		System.out.println("ω=" + ω);
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
				x_cld[i] = (b[i]-sum)/A[i][i];
				x[i] = (1-ω)*x[i] + ω*x_cld[i];
			}
			// 収束判定
			if( (Calc.vecNormInf(Calc.subVec(x, x_old)))/(Calc.vecNormInf(x))<ε) { // 相対誤差∞ノルム
				System.out.println("m=" + m);
				System.out.println("相対誤差ノルム : " + (Calc.vecNormInf(Calc.subVec(x, x_old)))/(Calc.vecNormInf(x)));
				break;
			}
			if(m==N) {
				System.out.println("収束しない");
				System.out.println("相対誤差ノルム : " + (Calc.vecNormInf(Calc.subVec(x, x_old)))/(Calc.vecNormInf(x)));
			}
			//System.out.print("m=" + m +" ：");
			//Calc.printVec(x);
			//System.out.println(Calc.vecNormInf(Calc.subVec(x, x_old))/(Calc.vecNormInf(x)));
		}
		System.out.print("解：");
		Calc.printVec(x);

	}
}
