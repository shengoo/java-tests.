package enumtest;

public class enumtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eee aEee = new Eee();
		aEee.setType(Types.java);
		System.out.println(aEee.getType().toString());
		Eee bEee = new Eee();
		bEee.setType(Types.valueOf("cs"));
		System.out.println(bEee.getType());
		System.out.println(aEee.getType() == Types.java);
		System.out.println(aEee.getType() == Types.cs);
		switch (aEee.getType()) {
		case cs:
			System.out.println("cs");
			break;
		case java:
			System.out.println("java");
			break;

		default:
			break;
		}
	}

	
}
class Eee{
		Types type;

		public Types getType() {
			return type;
		}

		public void setType(Types type) {
			this.type = type;
		}
	}
	