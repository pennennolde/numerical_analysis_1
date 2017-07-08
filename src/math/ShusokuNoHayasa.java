package math;

public class ShusokuNoHayasa {

	public static void main(String[] args) {

		// 残差による収束判定
		double x0 = -10;
		double e = 1.0e-13;
		int Nmax = 50;
		double ek = 0; // =|xk-a|
		double a = -3;

		double xk = x0;

		for( int k = 0; k<=Nmax; k++ ) {
			if( Math.abs( func1(xk))<e ){
				System.out.println( k );
				break;
			}else{
				System.out.println(k);
				xk = xk - func1(xk)/func2(xk);
				System.out.println(xk);
				ek = Math.abs(xk-a);
				System.out.println(ek);
			}
		}
	}

	// f(x) = x^3+x^2-5x+3

	// f の解を計算するメソッド
		static double func1(double x) {
			double y = x*x*x+x*x-5*x+3;
			return y;
		}

	// fダッシュ の解を計算するメソッド
		static double func2(double x) {
			double y = 3*x*x+2*x-5;
			return y;
		}

}
