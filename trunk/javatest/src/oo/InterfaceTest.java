/**
 * 
 */
package oo;

/**
 * @author Qing
 * @date 2011-6-20
 * 
 */
interface Foo {
    int k = 1;          //line 2
}
public class InterfaceTest implements Foo {
    public static void main(String args[]) {
        int i; 
        InterfaceTest test = new InterfaceTest(); 
        i = test.k;     //8
        System.out.println(i);
        i = InterfaceTest.k;     //9
        System.out.println(i);
        i = Foo.k;      //10
        System.out.println(i);
//        if (i>10) throw Exception("something`swrong!"); 
//        if (i>10) throw Exception e ("something`swrong!"); 
//        if (i>10) throw new Exception("something`swrong!"); 
//        if (i>10) throw new Exception e ("something`swrong!"); 

    }
}
 