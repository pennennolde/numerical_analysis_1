package math;

public class Float {

	public static void main(String[] args) {

		//float a = 0.5f;
		//System.out.printf("%.16f\n", x);

		// 問題1
		float a  = 0.1f;
		float b = 0.3f;
		float c = 0.4f;
		System.out.println( (a+b)+c );
		System.out.println( a+(b+c) );


		// 問題2
		//double x = 0.0000001;
		//double x = Math.pow(10,  -7);
		double x = 1e-7;
		double fx = (1- Math.cos(x))/(x*x);
		System.out.println(fx);
		double fx2 = (2*Math.pow(Math.sin(x/2), 2))/(x*x);
		System.out.println(fx2);
		double fx3 = (Math.pow(Math.sin(x), 2))/(x*x*(1+Math.cos(x)));
		System.out.println(fx3);
		System.out.println(Math.cos(1e-7));
		System.out.println(1+Math.cos(1e-7));
		System.out.println(1-Math.cos(1e-7)-1);



		// 問題3-1
		float n = 50000f;
		float S1 = 0f;
		for( float k=1f; k<=n; k++) {
			float y = S1 + 1/(k*k);
			if( y == S1 ) {
				System.out.println("N1=" + (k-1));
				break;
			} else {
				S1 = y;
				System.out.println( S1);
			}
		}
		System.out.println( S1 );

		float S2 = 0f;
		/*
		for( float k=n; k>=1; k--) {
			S2 = S2 + 1/(k*k);
		}
		System.out.println( S2 );
		*/
		for( float k=n; k>=1; k--) {
			float z = S2+ 1/(k*k);
			if( z == S2 ) {
				System.out.println("N2=" + (k+1));
				break;
			} else {
				S2 = z;
				System.out.println( S2);
			}
		}
		System.out.println( S2 );


		System.out.println();
		double e = 1;
		for( int k=1; k<21; k++ ) {
			double s = 1;
			for( int i=k; i>0; i--) {
				s*=i;
			}
			e+=(1/s);
		}
		System.out.println(e);


	}
}

//system.out.printf("%.16f\n", a);