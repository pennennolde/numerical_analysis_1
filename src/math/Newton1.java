package math;

public class Newton1 {

	public static void main(String[] args) {

		// 残差による収束判定
		double x0 = 50;
		double e = 1.0e-10;
		int Nmax = 50;

		double xk = x0;

		for( int k = 0; k<=Nmax; k++ ) {
			if( Math.abs( func1(xk))<e ){
				System.out.println( k );
				System.out.println( xk );
				break;
			}else{
			xk = xk - func1(xk)/func2(xk);
			System.out.println(k+1 + ", " + xk);
			}
		}
	}

	// f(x) = x^2-5

	// f の解を計算するメソッド
		static double func1(double x) {
			double y = 1-4/x-32/(x*x);
			return y;
		}

	// fダッシュ の解を計算するメソッド
		static double func2(double x) {
			double y = 4/(x*x)+64/(x*x*x);
			return y;
		}

}
