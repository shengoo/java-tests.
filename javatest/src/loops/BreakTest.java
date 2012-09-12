/**
 * 
 */
package loops;

/**
 * @author Qing
 * @date 2011-5-24
 * 
 */
public class BreakTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(BreakTest.class.getName());
		// TODO Auto-generated method stub
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				System.out.println(i);
				continue;
			}
			switchCase: switch (i) {
			case 3:
				i++;
				break switchCase;

			default:
				System.out.println(i);
				break;
			}
		}

		outer: for (int i = 0; i < 5; i++) {
			System.out.println(i);
			inner: for (int j = 6; j < 10; j++) {
				if (j > 8) {

					break inner;// ok
				}
				System.out.println(j);
				continue inner;// ok
				// break outer;//ok
				// continue outer;//ok

			}
			if (i > 3) {

				break outer;// ok
			} else {

				continue outer;// ok
			}

			// break inner;//error
			// continue inner;//error

		}
	}

}
