/**
 * 
 */
package oj;

import java.util.Scanner;

/**
 * @author Qing
 * @date 2011-5-24
 * 
 */
public class P1001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		String s;
		int n;
		while (true) {
			s=cin.nextLine();
			if (s.isEmpty()) {
				break;
			}
			n=cin.nextInt();
			System.out.println(Double.parseDouble(s));
			System.out.println((float)Math.pow(Double.parseDouble(s), n));
		}
	}

}
