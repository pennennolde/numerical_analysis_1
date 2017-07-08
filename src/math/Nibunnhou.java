package math;

public class Nibunnhou {

	public static void main(String[] args) {

		double a = 1.5;
		double b = 3.0;
		double c = 0.0;
		double e = 1.0e-12;

		int iter =0;

		while((Math.abs(b-a))/2 >= e) {
			iter++;
			c = (a+b)/2;
			double z = f(a)*f(c);
			if( z>0 ) {
				a = c;
			} else if( z<0 ) {
				b = c;
			} else if( z==0 ) {
				System.out.println("解が求まりました");
				break;
			}
		}
		System.out.println("近似解 : " + c);
		System.out.println("反復回数 : " + iter);
		System.out.println("|f(c)|=" + Math.abs(f(c)));
	}

	static double f(double x) {
		double y = x*x*x -2*x*x -x +2;
		return y;
	}

}
