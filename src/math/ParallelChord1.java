package math;

public class ParallelChord1 {

	public static void main(String[] args) {

		// 残差による収束判定法
		double x0 = 3.0;
		double e = 1.0e-12;
		int Nmax = 100;

		double xk = x0;
		int iter = 0;

		while( iter<=Nmax ) {
			xk = xk - f(xk)/f1(x0);
			iter++;
			if(Math.abs(f(xk))<e) {
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

	static double f(double x) {
		double y = x*x*x -3*x*x +4;
		return y;
	}

	static double f1(double x) {
		double y = 3*x*x -6*x;
		return y;
	}

}
