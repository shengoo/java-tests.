package algorithmTest;

public class YanghuiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Row = 10;
		int yh[][] = new int[Row][Row];
		for (int i = 0; i < Row; i++) {
			yh[i][0] = 1;
			yh[i][i] = 1;
		}
		for (int i = 2; i < Row; i++) {
			for (int j = 1; j < Row; j++) {
					yh[i][j] = yh[i - 1][j - 1] + yh[i - 1][j];
			}
		}
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(yh[i][j] + " ");
			}
			System.out.println();
		}
	}

}
