package stringtest;

public class RegexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "11:33/44\\22:cc*bb?aa<gg>vv\"aa|ff";
		start = start.replaceAll("[/\\\\:*?\"<>|]", "_");
		System.out.println(start);
	}

}
