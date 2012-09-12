public class Temperature {

	private float degree;
	private char msm;


	public Temperature() {
		degree = 0;
		msm = 'c';
	}

	public Temperature(float d, char m) {
		if (m == 'c' || m == 'f') {
			degree = d;
			msm = m;
		} else {
			System.out.println("input wrong");
		}
	}

	/**
	 * ���������ϼ������¶�
	 * 
	 * @return
	 */
	public float getdegreesC() {
		if (msm == 'f') {
			return 5 * (degree - 32) / 9;
		} else {
			return degree;
		}
	}

	/**
	 * ���ػ����¶�
	 * 
	 * @return
	 */
	public float getdegreesF() {
		if (msm == 'c') {
			return (9 * (degree) / 5) + 32;
		} else {
			return degree;
		}
	}

	/**
	 * �����¶�ֵ
	 * 
	 * @param d
	 */
	public void setDegree(float d) {
		degree = d;
	}

	/**
	 * ���ü�����λ
	 * 
	 * @param c
	 */
	public void setDegree(char c) {
		if (c == 'c' || c == 'f') {
			msm = c;
		} else {
			System.out.println("input wrong");
		}

	}

	/**
	 * ͬʱ�����¶�ֵ�ͼ�����λ
	 * 
	 * @param d
	 * @param c
	 */
	public void setDegree(float d, char c) {
		if (c == 'c' || c == 'f') {
			degree = d;
			msm = c;
		} else {
			System.out.println("input wrong");
		}
	}

	/**
	 * �Ƿ������¶����
	 * 
	 * @param t
	 * @return
	 */
	public boolean isSameWith(Temperature t) {
		return this.getdegreesC() == t.getdegreesC();
	}

	/**
	 * �Ƚ�һ���¶ȴ�����һ���¶�
	 * 
	 * @param t
	 * @return
	 */
	public boolean isBiggerThan(Temperature t) {
		return this.getdegreesC() > t.getdegreesC();
	}

	/**
	 * �Ƚ�һ���¶�С����һ���¶�
	 * 
	 * @param t
	 * @return
	 */
	public boolean isSmallerThan(Temperature t) {
		return this.getdegreesC() < t.getdegreesC();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Temperature t1 = new Temperature();
		Temperature t2 = new Temperature(32, 'f');
		System.out.println(t1.isSameWith(t2));
		System.out.println(t1.isBiggerThan(t2));
		System.out.println(t1.isSmallerThan(t2));
	}

}
