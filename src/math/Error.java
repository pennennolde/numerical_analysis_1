package math;

public class Error {

	public static void main(String[] args) {

		double a = 2718.281828; //真の値(厳密解)
		double x = 2718.282137; //近似値(計算解)

		System.out.println("誤差 : " + (x-a));							// x-a;			誤差
		System.out.println("絶対誤差 : " + Math.abs(x-a) );	// |x-a|;			絶対誤差
		System.out.println("相対誤差 : " + (x-a)/a);					// (x-a)/a;	相対誤差


	}
}
