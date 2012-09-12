/**
 * 
 */
package stringtest;

/**
 * @author Qing
 * @date 2011-4-28
 * 
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//³£Á¿³Ø(constant pool)
		
		String s0 = "punkll";
		String s1 = "punkll";
		String s2 = "punk" + "ll";

		System.out.println(s0 == s1);
		System.out.println(s0 == s2);

		String s01 = "punkll";
		String s11 = new String("punkll");
		String s21 = "punk" + new String("ll");

		System.out.println(s01 == s11);
		System.out.println(s01 == s21);
		System.out.println(s11 == s21);
	}

}
