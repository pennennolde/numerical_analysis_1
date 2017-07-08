package math2;

public class PivotGauss {

	public static void main(String[] args) {

		int n=5;

		double A[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = 1.0/((i+1)+(j+1)-1.0);
			}
		}

		double b[] = new double[n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				b[i] = b[i] + A[i][j];
			}
		}


		double originA[][] = new double[n][n];
		double originb[] = new double[n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				originA[i][j] = A[i][j];
			}
			originb[i] = b[i];
		}

		/*
		 ここ ここで初期値をとっておいても
		 	なぜかbとともに変更されてしまうから
		 	最期に初期値をもう一度入力することにする
		 	originA = A;では、結局同じ場所を参照することになってしまう?
		 	配列のセルごとにコピーすればいい?
		double originA[][] = new double[A.length][A[0].length];
		double originb[] = new double[b.length];
		originA = A;
		originb = b;
		*/

		//int n = A.length;

		for(int k=0; k<n-1; k++) {
			// Step 1-1 : Pivotの選択
			int l=k;
			for(int i=k; i<n; i++) {
				double x = Math.abs(A[l][k]);
				double y = Math.abs(A[i][k]);
				if(x<y) {
					l = i;
				}
			}
			// Step 1-2 : Pivotの例外処理
			if(A[l][k]<10e-10) {
				System.out.println("例外処理：絶対値最大数が0または非常に小さい場合");
			}
			// Step 1-3 : k行目とl行目を入れ替える
			double temp;
			for(int j=k; j<n; j++) {
				temp = A[k][j];
				A[k][j] = A[l][j];
				A[l][j] = temp;
			}
			temp = b[k];
			b[k] = b[l];
			b[l] = temp;

			// Step 1-4 : 第k列目を消去
			double α = 0.0;
			for(int i=k+1; i<n; i++) {
				α = A[i][k]/A[k][k];
				for(int j=k+1; j<n; j++) {
					A[i][j] = A[i][j] - α*A[k][j];
				}
				b[i] = b[i] - α*b[k];
			}
		}
		Calc.printMat(A);

		System.out.println();


		//  Step 2 : 後退代入
		double α = 0.0;
		int k = b.length-1;
		b[k] = b[k]/A[k][k];
		for(int i=k-1; i>=0; i--) {
			α = 0.0;
			for(int j=k; j>i; j--) {
				α += A[i][j]*b[j];
			}
			b[i] = (b[i]-α)/A[i][i];
		}
		Calc.printVec(b); // 解w

	}
}
