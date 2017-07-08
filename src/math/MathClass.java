package math;

public class MathClass {

	public static void main(String[] args) {

		// 問題1(1)
		double a = Math.sqrt( Math.pow(5, 9) / Math.pow(8, 7) );
		System.out.println(a);

		System.out.println();

		// 問題1(2)
		double b = Math.abs( Math.sin( 3*Math.PI/4) - Math.pow(Math.E, 2)*Math.sqrt(Math.log(3)) );
		System.out.println(b);

		System.out.println();

		// 問題2
		double[] F = new double[55];
		F[0] = 0;
		F[1] = 1;
		for( int n = 0; n <= 48; n++ ) {
			F[n+2] = F[n+1] + F[n];
			System.out.println("F[" + (n+2) +"] = " + F[n+2]);
		}

		System.out.println();

		// 問題3
		double an =1;
		int n = 0;
		double s = 0;
		do{
			n++;
			an = an/n;
			s = s + an;
		}while( an>=1E-8 );
		System.out.println("a[" + n + "] = " + an );
		System.out.println("s =" + s );

		System.out.println();

		// 問題4
		double[][] A = new double[3][3];
		double[][] B = new double[3][3];
		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				A[i][j] = Math.pow( (i+1)+(j+1), -1);
				B[i][j] = Math.sqrt( (i+1)*(j+1) );
			}
		}
		double[][] AB = new double[3][3];
		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				for( int k = 0; k < 3; k++ ) {
					AB[i][j] = AB[i][j] + A[i][k]*B[k][j];
				}
			}
		}
		for( int l = 0; l < 3; l++ ) {
			for( int m = 0; m < 3; m++ ) {
				System.out.print( AB[l][m] + ", " );
			}
			System.out.println();
		}


		System.out.println();
		double x = 3.0e6;
		double y = 1.0e-6;
		double z = (Math.sqrt(x+y)+Math.sqrt(x))/y;
		System.out.println(z);

	}
}
