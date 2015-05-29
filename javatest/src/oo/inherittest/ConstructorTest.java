package oo.inherittest;

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructorTest test = new ConstructorTest();
		test.new b();
	}
	
	public class a
	{
		public a(){
			System.out.println("a");
		}
	}
	
	public class b extends a
	{
		public b() {
			System.out.println("b");
		}
	}

}
