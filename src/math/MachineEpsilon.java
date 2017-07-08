package math;

public class MachineEpsilon {

	public static void main(String[] args) {

		double eps = 1.0;

		while( 1.0+eps > 1.0 ) {
			eps = eps/2.0;

		}

		System.out.println("machine epsilon = " + 2.0*eps);
		System.out.println();
		System.out.println("1.0 + eps = " + (1.0+2.0*eps));
		System.out.println("1.0 + eps/2 = " + (1.0+eps));

	}

}
