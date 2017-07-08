package math;

public class RSA {

	public static void main(String[] args) {

		String plaintext = "abcde";	//平文入力
		System.out.println("平文 : " + plaintext);

		char[] chars = plaintext.toCharArray();	//1文字ずつコード番号化し配列に入れる
		plaintext = "";
		for( int i = 0; i<chars.length; i++) {
			plaintext += Integer.toString(chars[i]);	//配列の中身を文字列化
		}
		System.out.println("平文(String) : " + plaintext);

		int Nplaintext = Integer.parseInt( plaintext );	//文字列を数値化
		//int Nplaintext = Integer.valueOf( plaintext );
		System.out.println("平文(int) : " + Nplaintext);


	}
}
