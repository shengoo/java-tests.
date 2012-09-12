import java.util.Scanner;

public class Biggest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sioScanner = new Scanner(System.in);
		int big = 0;
		int temp;
		for (int i = 0; i < 20; i++) {
			temp = sioScanner.nextInt();
			if (temp > big) {
				big = temp;
			}
		}
		System.out.println(big);
	}

}
