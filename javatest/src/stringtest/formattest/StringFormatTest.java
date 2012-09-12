package stringtest.formattest;

import java.util.Date;

public class StringFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(String.format("%04d", 12)); //结果："0012"  
		  
		System.out.println(String.format("%4d", 12)); //结果："  12"  
		  
		System.out.println(String.format("%,d", 121212)); //结果："121,212"  
		  
		System.out.println(String.format("%1$5s", "abc"));//结果："  abc"  
		
		System.out.println(String.format("%1$tF %1$tT", new Date()));//结果："2009-01-19 17:39:25"  
	}

}
