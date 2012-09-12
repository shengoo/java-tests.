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
	 * 返回用摄氏计量的温度
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
	 * 返回华氏温度
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
	 * 设置温度值
	 * 
	 * @param d
	 */
	public void setDegree(float d) {
		degree = d;
	}

	/**
	 * 设置计量单位
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
	 * 同时设置温度值和计量单位
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
	 * 是否两个温度相等
	 * 
	 * @param t
	 * @return
	 */
	public boolean isSameWith(Temperature t) {
		return this.getdegreesC() == t.getdegreesC();
	}

	/**
	 * 比较一个温度大于另一个温度
	 * 
	 * @param t
	 * @return
	 */
	public boolean isBiggerThan(Temperature t) {
		return this.getdegreesC() > t.getdegreesC();
	}

	/**
	 * 比较一个温度小于另一个温度
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
