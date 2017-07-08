package math2;

public class Gauss {
	// Gaussの消去法(前進消去過程)
	// Gaussの消去法(後退代入過程)

	public static void main(String[] args) {

		double A[][] = {{1, 2, 1, 2, 1},
										{2, 3, 2, 3, 2},
										{1, 2, 3, 4, 5},
										{4, 3, 8, 1, 2},
										{8, 2, 4, 1, 9}};

		double b[] ={7, 7, 7, 7, 7};


			/*
			 ここで初期値をとっておいても
		 	なぜかbとともに変更されてしまうから
		 	最期に初期値をもう一度入力することにする
		 	originA = A;では、結局同じ場所を参照することになってしまう?
		 	配列のセルごとにコピーすればいい?
			double originA[][] = new double[A.length][A[0].length];
			double originb[] = new double[b.length];
			originA = A;
			originb = b;
			*/


			int n = A.length;

			double originA[][] = new double[n][n];
			double originb[] = new double[n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					originA[i][j] = A[i][j];
				}
				originb[i] = b[i];
			}

			double α = 0.0;

			// 前進消去過程
			for(int k=0; k<n-1; k++) {  // 第k+1列目の消去を計算
				for(int i=k+1; i<n; i++) {  // i行
					α = A[i][k]/A[k][k];
					for(int j=k+1; j<n; j++) {  // j列
						A[i][j] = A[i][j] - α*A[k][j];
					}
					b[i] = b[i] - α*b[k];
				}
			}
			Calc.printMat(A);
			System.out.println();
			Calc.printVec(b);
			System.out.println();

			// 後退代入過程
			/*
			int k = b.length-1;
			b[k] = b[k]/A[k][k];
			for(int i=k-1; i>=0; i--) {
				α = 0.0;
				for(int j=k; j>i; j--) {
					α += A[i][j]*b[j];
				}
				b[i] = (b[i]-α)/A[i][i];
			}
			Calc.printVec(b); // 解
			*/

			for(int i=n-1; i>=0; i--) {
				for(int j=n-1; j>i; j--) {
					b[i] -= A[i][j]*b[j];
				}
				b[i] = b[i]/A[i][i];
			}
			Calc.printVec(b); // 解
			System.out.println();

			// 残差2ノルムを求める
			System.out.println(Calc.vecNorm2(Calc.residual(originA, b, originb)));
		}
}
