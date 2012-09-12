package mathtest;

public class MultiplicationTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiplicationTable().outputtable();
		new MultiplicationTable().reversedTable();
	}
	
	public void outputtable() {
		for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+(i*j)+"\t");
            }
            System.out.println();
        }
	}
	
	public void reversedTable() {
		int[][] num = new int[9][9];
        for (int i = 1; i <= 9;i++ )
        {
            for (int k = 1; k <= (9 - i); k++)
            {
                System.out.print("\t");
            }
            for (int j = i; j >= 1;j-- )
            {
                num[i - 1][j-1] = i * j;
               
                System.out.print(i+"*"+j+"="+num[i-1][j-1]+"\t");
            }
            System.out.println();
        }
	}

}
