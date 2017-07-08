package math;

public class Secant2 {

	public static void main(String[] args) {

		// 相対誤差による収束判定法
		double x0 = -6.0;
		double x1 = -5.0;
		double e = 1.0e-10;
		int Nmax = 300;

		double xk0 = x0;
		double xk1 = x1;
		int iter = 0;

		while( iter <= Nmax) {
			double xk02 = xk1;
			xk1 = xk1 - func(xk1)*(xk0-xk1)/(func(xk0)-func(xk1));
			xk0 = xk02;
			iter++;
			if( Math.abs((xk0-xk1)/xk1)<e ) {
				break;
			}
		}

		if( iter==51) {
			System.out.println("収束しない");
		} else {
			System.out.println("反復回数 : " + iter);
			System.out.println("近似解 : " + xk1);
		}
	}

	static double func(double x) {
		double y = x*x*x -4.0*x*x +13.0*x/4.0 -3.0/4.0;
		return y;

	}

}
