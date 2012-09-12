package stringtest.split;

public class SplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "398020|60056553013|Things (digitally Remastered 01)(Dean Martin |µÒ¶÷ÂíÍ¡)";
		String[] ss=str.split("\\|", 3);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}

}
