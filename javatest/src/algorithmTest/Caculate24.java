package algorithmTest;

public class Caculate24 {
	// ���������� ��������������
	private int operator1, operator2, operator3;

	public int getOperator1() {
		return this.operator1;
	}

	public void setOperator1(int operator1) {
		this.operator1 = operator1;
	}

	public int getOperator2() {
		return this.operator2;
	}

	public void setOperator2(int operator2) {
		this.operator2 = operator2;
	}

	public int getOperator3() {
		return this.operator3;
	}

	public void setOperator3(int operator3) {
		this.operator3 = operator3;
	}

	// �����4�����֣�
	private float[] inputedNumbers = new float[4];
	// �㷨��Ҫ�������4�����ְ�һ����������
	private float[] sortedNumbers = new float[4];
	// �����㷨����Ҫ���±����飺
	private int[][] indexs = { { 0, 1, 2, 3 }, { 0, 1, 3, 2 }, { 0, 2, 1, 3 },
			{ 0, 2, 3, 1 }, { 0, 3, 1, 2 }, { 0, 3, 2, 1 }, { 1, 0, 2, 3 },
			{ 1, 0, 3, 2 }, { 1, 2, 0, 3 }, { 1, 2, 3, 0 }, { 1, 3, 0, 2 },
			{ 1, 3, 2, 0 }, { 2, 0, 1, 3 }, { 2, 0, 3, 1 }, { 2, 1, 0, 3 },
			{ 2, 1, 3, 0 }, { 2, 3, 0, 1 }, { 2, 3, 1, 0 }, { 3, 0, 1, 2 },
			{ 3, 0, 2, 1 }, { 3, 1, 0, 2 }, { 3, 1, 2, 0 }, { 3, 2, 0, 1 },
			{ 3, 2, 1, 0 } };
	// ��ʾ�ǵڼ��غϣ�һ��Ҫ����24�غϣ�
	private int round = 0;

	public int getRound() {
		return this.round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	// ���㷨������Ҫ�����ݽṹ��ģ���������result[0]�Ǹ���㣬����õ�result[0]��ֵΪ24�����������
	private float result[] = new float[9];

	private void print(String s) {
		System.out.println(s);
	}

	// ��ȡ�����4�����֣���������inputedNumbers
	private boolean setNumbers(String[] str) {
		if (str.length != 4) {
			print("Please input 4 Integers!");
			return false;
		}
		try {
			inputedNumbers[0] = Integer.parseInt(str[0]);
			inputedNumbers[1] = Integer.parseInt(str[1]);
			inputedNumbers[2] = Integer.parseInt(str[2]);
			inputedNumbers[3] = Integer.parseInt(str[3]);
		} catch (Exception ex) {
			print("Please input 4 Integers!");
			return false;
		}
		return true;
	}

	// ����������ָ����㸳ֵ��
	private void setResult(int index, float value) {
		result[index] = value;
	}

	// �õ���������ָ������ֵ��
	private float getResult(int index) {
		return result[index];
	}

	private void clearResult() {
		for (int i = 0; i < 9; i++) {
			result[i] = 0;
		}
	}

	// ������ʽ��
	private String getNumSentence(int intOptr, float opnd1, float opnd2,
			float rst) {
		String ret = "";
		switch (intOptr) {
		case 0:
			ret = opnd1 + "+" + opnd2 + "=" + rst;
			// ԭ�ȴ���һ�����ص�bug����rstд����result������Calculator����result��ͻ��
			break;
		case 1:
			ret = opnd1 + "-" + opnd2 + "=" + rst;
			break;
		case 2:
			ret = opnd2 + "-" + opnd1 + "=" + rst;
			break;
		case 3:
			ret = opnd1 + "*" + opnd2 + "=" + rst;
			break;
		case 4:
			ret = opnd1 + "/" + opnd2 + "=" + rst;
			break;
		case 5:
			ret = opnd2 + "/" + opnd1 + "=" + rst;
			break;

		}
		return ret;
	}

	// ��ӡ������Ľ����
	// ��Ϊ�����ֽṹ�Ķ�����������Ҫ���������ֱ��Ӧ������
	private void printResult() {
		/** TODO */
		int optr1, optr2, optr3;
		optr1 = this.getOperator1();
		optr2 = this.getOperator2();
		optr3 = this.getOperator3();
		print("Round " + (this.getRound() + 1) + ":");
		print("Step 1:  "
				+ this.getNumSentence(optr1, this.getResult(3), this
						.getResult(4), this.getResult(1)));
		print("Step 2:  "
				+ this.getNumSentence(optr2, this.getResult(5), this
						.getResult(6), this.getResult(2)));
		print("Step 3:  "
				+ this.getNumSentence(optr3, this.getResult(1), this
						.getResult(2), this.getResult(0)));
	}

	private void printResult_1() {
		/** TODO */
		int optr1, optr2, optr3;
		optr1 = this.getOperator1();
		optr2 = this.getOperator2();
		optr3 = this.getOperator3();
		print("Round " + (this.getRound() + 1) + ":");
		print("Step 1:  "
				+ this.getNumSentence(optr1, this.getResult(7), this
						.getResult(8), this.getResult(3)));
		print("Step 2:  "
				+ this.getNumSentence(optr2, this.getResult(3), this
						.getResult(4), this.getResult(1)));
		print("Step 3:  "
				+ this.getNumSentence(optr3, this.getResult(1), this
						.getResult(2), this.getResult(0)));

	}

	// ���򷽷���
	private void sortNumbers(int rnd) {
		if (rnd < 0 || rnd > 23) {
			print("Error!");
			return;
		}
		sortedNumbers[0] = inputedNumbers[indexs[rnd][0]];
		sortedNumbers[1] = inputedNumbers[indexs[rnd][1]];
		sortedNumbers[2] = inputedNumbers[indexs[rnd][2]];
		sortedNumbers[3] = inputedNumbers[indexs[rnd][3]];
	}

	// ������������롢2�����������õ��м�����
	private float getMidValue(int i, float m, float n) {
		float ret = 0f;
		switch (i) {
		case 0:
			ret = m + n;
			break;

		case 1:
			ret = m - n;
			break;

		case 2:
			ret = n - m;
			break;

		case 3:
			ret = m * n;
			break;

		case 4:
			try {
				ret = m / n;
			} catch (Exception ex1) {
				ret = Float.MAX_VALUE;
			}
			break;

		case 5:
			try {
				ret = n / m;
			} catch (Exception ex2) {
				ret = Float.MAX_VALUE;
			}
			break;

		}
		return ret;
	}

	// ��Ϊ�����ֽṹ�Ķ�����������24���㷨Ҳ�����֣�
	private void calculate() {
		clearResult();
		setResult(3, sortedNumbers[0]);
		setResult(4, sortedNumbers[1]);
		setResult(5, sortedNumbers[2]);
		setResult(6, sortedNumbers[3]);
		for (int i = 0; i < 6; i++) {
			setResult(1, getMidValue(i, getResult(3), getResult(4)));
			for (int j = 0; j < 6; j++) {
				setResult(2, getMidValue(j, getResult(5), getResult(6)));
				for (int k = 0; k < 6; k++) {
					setResult(0, getMidValue(k, getResult(1), getResult(2)));
					if (Math.abs(getResult(0) - 24) < 0.0000001) {
						this.setOperator1(i);
						this.setOperator2(j);
						this.setOperator3(k);
						printResult();
						return;
					}
					if (i == 5 && j == 5 && k == 5) {
						calculate_1();
					}
				}
			}
		}
	}

	// ��2�ֺ��㷨��
	private void calculate_1() {
		clearResult();
		setResult(7, sortedNumbers[0]);
		setResult(8, sortedNumbers[1]);
		setResult(4, sortedNumbers[2]);
		setResult(2, sortedNumbers[3]);
		for (int i = 0; i < 6; i++) {
			setResult(3, getMidValue(i, getResult(7), getResult(8)));
			for (int j = 0; j < 6; j++) {
				setResult(1, getMidValue(j, getResult(3), getResult(4)));
				for (int k = 0; k < 6; k++) {
					setResult(0, getMidValue(k, getResult(1), getResult(2)));
					if (Math.abs(getResult(0) - 24) < 0.0000001) {
						this.setOperator1(i);
						this.setOperator2(j);
						this.setOperator3(k);
						printResult_1();
						return;
					} else if (i == 5 && j == 5 && k == 5) {
						print("No solution at round " + (this.getRound() + 1)
								+ "!");
						return;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Caculate24 cal = new Caculate24();
		if (!cal.setNumbers(args)) {
			return;
		}
		for (int i = 0; i < 24; i++) {
			cal.setRound(i);
			cal.sortNumbers(i);
			cal.calculate();
		}
	}
}