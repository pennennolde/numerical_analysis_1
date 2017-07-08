package math;

public class Newton2 {

	public static void main(String[] args) {

		// 相対誤差による収束判定
		double x0 = 5.0;
		double e = 1.0e-10;
		int Nmax = 50;

		double xk = x0;

		for( int k=0; k<=Nmax; k++) {
			double xk1 = xk - f1(xk)/f2(xk);
			if( Math.abs( (xk1-xk)/xk1)<e ) {
				System.out.println( k+1 );
				System.out.println( xk1 );
				break;
			}
			xk = xk1;
			System.out.println("反復"+k);
		}
		System.out.println("終了");
	}

	static double f1(double x) {
		double y = Math.sin(x)/(x-1);
		return y;
	}

	static double f2(double x) {
		double y = ((x-1)*Math.cos(x)-Math.sin(x))/Math.pow((x-1), 2);
		return y;
	}

}
