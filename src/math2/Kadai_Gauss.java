package math2;

public class Kadai_Gauss {

	public static void main(String[] args) {

		for(int r=0; r<100; r++) {

			System.out.print(r+1 + ":");
			System.out.print(" ");

			double A[][] = new double[100][100];
			double b[] = new double[100];

			double originA[][] = new double[100][100];
			double originb[] = new double[100];

			int n = A.length;

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					A[i][j] = Math.random();
					originA[i][j] = A[i][j];
				}
				b[i] = Math.random();
				originb[i] = b[i];
			}

			double α = 0.0;

			// Pivot選択なし
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

			// 後退代入過程
			int k = b.length-1;
			b[k] = b[k]/A[k][k];
			for(int i=k-1; i>=0; i--) {
				α = 0.0;
				for(int j=k; j>i; j--) {
					α += A[i][j]*b[j];
				}
				b[i] = (b[i]-α)/A[i][i];
			}

			// 残差2ノルム
			System.out.print(Calc.vecNorm2(Calc.residual(originA, b, originb)));
			System.out.print(" ");



			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					A[i][j] = originA[i][j];
				}
				b[i] = originb[i];
			}

			// Pivot選択あり
			for(int m=0; m<n-1; m++) {
				// Step 1-1 : Pivotの選択
				int l=m;
				for(int i=m; i<n; i++) {
					double x = Math.abs(A[l][m]);
					double y = Math.abs(A[i][m]);
					if(x<y) {
						l = i;
					}
				}
				// Step 1-2 : Pivotの例外処理
				if(A[l][m]==0) {
					System.out.println("例外処理：絶対値最大数が0");
				}
				// Step 1-3 : k行目とl行目を入れ替える
				double temp;
				for(int j=m; j<n; j++) {
					temp = A[m][j];
					A[m][j] = A[l][j];
					A[l][j] = temp;
				}
				temp = b[m];
				b[m] = b[l];
				b[l] = temp;
				// Step 1-4 : 第k列目を消去
				α = 0.0;
				for(int i=m+1; i<n; i++) {
					α = A[i][m]/A[m][m];
					for(int j=m+1; j<n; j++) {
						A[i][j] = A[i][j] - α*A[m][j];
					}
					b[i] = b[i] - α*b[m];
				}
			}
			//  Step 2 : 後退代入
			α = 0.0;
			int m = b.length-1;
			b[m] = b[m]/A[m][m];
			for(int i=m-1; i>=0; i--) {
				α = 0.0;
				for(int j=m; j>i; j--) {
					α += A[i][j]*b[j];
				}
				b[i] = (b[i]-α)/A[i][i];
			}

			System.out.println(":" + Calc.vecNorm2(Calc.residual(originA, b, originb)));
		}
	}
}
