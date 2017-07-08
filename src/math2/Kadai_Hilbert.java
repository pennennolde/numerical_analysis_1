package math2;

public class Kadai_Hilbert {

	public static void main(String[] args) {

		/*
		メソッドに渡した引数がメソッド内で値が変わると
		メソッドを呼び出したクラス側の値も変わる
			→メソッドでもとの値を変えたくない引数はコピーをとってそちらを使って記述すればよい
		*/

		int n = 5;
		System.out.println("n=" + n);
		System.out.println();

		double A[][] = new double[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = 1.0/((i+1)+(j+1)-1.0);
			}
		}


		// (1)
		double κ = Calc.Condition_Number(A);
		System.out.println("(1)");
		System.out.print("条件数：κ_∞ = ");
		System.out.printf("%E", κ);
		System.out.println();

		// (2)
		double xstar[] = new double[n]; // 真の解
		for(int i=0; i<n; i++) {
			xstar[i] = 1.0;
		}
		double b[] = new double[n];
		for(int i=0; i<n; i++) {
			b[i] = Calc.matVec(A, xstar)[i];
		}
		double x1[] = new double[n]; // 近似解
		x1 = Calc.PivotGauss(A, b);
		System.out.println("(2)");
		System.out.print("残差ノルム(∞)：");
		System.out.println(Calc.vecNormInf(Calc.residual(A, x1, b)));
		System.out.print("誤差ノルム(∞)：");
		System.out.println(Calc.vecNormInf(Calc.subVec(xstar, x1)));
		System.out.println();

		// (3)-1 右辺
		double Right =0.0; // 右辺
		double[] Δb = new double[n];
		Δb[0] = 0.001*b[0];
		for(int i=1; i<n; i++) {
			Δb[i] = 0.0;
		}
		Right = κ *(Calc.vecNormInf(Δb) / Calc.vecNormInf(b));
		System.out.println("(3)-1");
		System.out.print("(||Δx||_∞)/(||x*||_∞) <= κ_∞(A)*((||Δb||_∞)/(||b||_∞)) = ");
		System.out.println(Right);

		// (3)-2 解に含まれる誤差の上限
		double EMax = 0.0;
		EMax = Right*Calc.vecNormInf(xstar);
		System.out.println("(3)-2");
		System.out.print("||Δx||_∞ <= (||x*||_∞)*(κ_∞(A))*((||Δb||_∞)/(||b||_∞)) = ");
		System.out.println(EMax);
		System.out.println();

		// (4)
		double[] x2 = new double[n]; //近似解
		x2 = Calc.PivotGauss(A, Calc.addVec(b, Δb));
		System.out.println("(4)");
		System.out.print("誤差ノルム||x*-x2||_∞ = ");
		System.out.println(Calc.vecNormInf(Calc.subVec(xstar, x2)));
		System.out.println();

	}
}
