import java.util.Scanner;


public class SqrtTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(System.in);
			double d = scanner.nextDouble();
			System.out.println(Math.sqrt(d));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("input wrong");
		}
	}

}
