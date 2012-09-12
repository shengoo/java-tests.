public class Test {
	public static void main(String[] args) {
		System.out.println(Test.class.getName());
		int i = 10;
		int j = i++;
		System.out.println(j);
		int k = --j;
		System.out.println(k);
		char a='a';
		char b='a';
		System.out.println(a==b);
		System.out.println(String.format("%1$,09d", -3123));
		System.out.println(String.format("%1$s", "0000000"));
		System.out.println("a".format("%1$s", "0000000"));
		float a1 =  (float)(800/600);
		System.out.println(a1);
	}
}
