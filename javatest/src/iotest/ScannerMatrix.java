package iotest;

import java.util.Scanner;

public class ScannerMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sioScanner = new Scanner(System.in);
		System.out.println(" ‰»Î3X3æÿ’Û°£");
		int[][] m = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = sioScanner.nextInt();
			}
		}
		System.out.println();
	}

}
