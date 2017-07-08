package math;

public class ParallelChord2 {

	public static void main(String[] args) {

		// 相対誤差による収束判定法
		double x0 = 5.0;
		double e = 1.0e-10;
		int Nmax = 50;

		double xk = x0;
		int iter = 0;

		while( iter<=Nmax ) {
			double xk0 = xk;
			xk = xk - f(xk)/f1(x0);
			iter++;
			if(Math.abs((xk-xk0)/xk)<e) {
				break;
			}
		}

		if( iter==51) {
			System.out.println("収束しない");
		} else {
			System.out.println("反復回数 : " + iter);
			System.out.println("近似解 : " + xk);
		}
	}

	// f(x) = x^2-5

	static double f(double x) {
		double y = Math.pow((x-1), 4);
		return y;
	}

	static double f1(double x) {
		double y = 4*Math.pow((x-1), 3);
		return y;

	}

}
