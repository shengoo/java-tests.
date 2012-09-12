package javaPuzzlers;
import java.util.Properties;

/**
 * 
 */

/**
 * @author Qing
 * @date 2011-5-20
 * 
 */
public class SimpleQuestion {

    static boolean yesOrNo(String s) {
        s = s.toLowerCase();
        if (s.equals("yes") || s.equals("y") || s.equals("t")) {
            s = "true";
        }

//    	Properties   p   =   System.getProperties();   
//        p.setProperty(s,   "true"); 
        return Boolean.getBoolean(s);
    }
    
    public static boolean isOdd(int i){
//    	return i%2 == 1;
//    	return i%2 != 0;
    	return (i&1) != 0;
    }

    public static void main(String[] args) {  
        System.out.println(yesOrNo("true") + " " + yesOrNo("Yes"));
        System.out.println(2.00f - 1.10f);
        System.out.println(2.00 - 1.10);
        System.out.println(isOdd(-1) + " " + isOdd(-2));
    }
}