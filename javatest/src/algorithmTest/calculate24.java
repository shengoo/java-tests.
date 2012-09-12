package algorithmTest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class calculate24 extends JFrame{

 /**
	 * 
	 */
	private static final long serialVersionUID = -2721548622736577140L;
private javax.swing.JPanel jContentPane = null;
 private JLabel jLabel = null;
 private JLabel jLabel1 = null;
 private JTextField jTextField = null;
 private JTextField jTextField1 = null;
 private JTextArea jTextArea = null;
 private JLabel jLabel2 = null;
 private JButton jButton = null;
 private JScrollPane jScrollPane = null;
 
 private JButton jButton1 = null;
 private JButton jButton2 = null;
 private JButton jButton3 = null;
 private JButton jButton4 = null;
 private JButton jButton5 = null;
 private JButton jButton6 = null;
 private JButton jButton7 = null;
 private JButton jButton8 = null;
 private JButton jButton9 = null;
 private JButton jButton10 = null;
 /**
  * This is the default constructor
  */
 public calculate24() {
  super();
  initialize();
 }

 /**
  * This method initializes this
  * 
  * @return void
  */
 private void initialize() {
  this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
  this.setBounds(200, 200, 565, 452);
  this.setContentPane(getJContentPane());
  this.setTitle("24µã");
 }

 /**
  * This method initializes jContentPane
  * 
  * @return javax.swing.JPanel
  */
 private javax.swing.JPanel getJContentPane() {
  if (jContentPane == null) {
   jLabel2 = new JLabel();
   jLabel1 = new JLabel();
   jLabel = new JLabel();
   jContentPane = new javax.swing.JPanel();
   jContentPane.setLayout(null);
   jLabel.setBounds(66, 52, 150, 45);
   jLabel.setText("please unter four number");
   jLabel1.setBounds(253, 52, 282, 45);
   jLabel1.setText("please unter how many result do you want to get");
   jLabel2.setBounds(354, 201, 70, 36);
   jLabel2.setText("result");
   jContentPane.add(getJButton(), null);
   jContentPane.add(jLabel, null);
   jContentPane.add(jLabel1, null);
   jContentPane.add(getJTextField(), null);
   jContentPane.add(getJTextField1(), null);
   jContentPane.add(jLabel2, null);
   jContentPane.add(getJScrollPane(), null);
   jContentPane.add(getJButton1(), null);
   jContentPane.add(getJButton2(), null);
   jContentPane.add(getJButton3(), null);
   jContentPane.add(getJButton4(), null);
   jContentPane.add(getJButton5(), null);
   jContentPane.add(getJButton6(), null);
   jContentPane.add(getJButton7(), null);
   jContentPane.add(getJButton8(), null);
   jContentPane.add(getJButton9(), null);
   jContentPane.add(getJButton10(), null);
  }
  return jContentPane;
 }

 /**
  * This method initializes jTextField
  * 
  * @return javax.swing.JTextField
  */
 private JTextField getJTextField() {
  if (jTextField == null) {
   jTextField = new JTextField();
   jTextField.setBounds(67, 84, 149, 41);
   jTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
    public void focusGained(java.awt.event.FocusEvent e) {    
     jTextField.select(0,jTextField.getText().length());
    }
   });
  }
  return jTextField;
 }

 /**
  * This method initializes jTextField1
  * 
  * @return javax.swing.JTextField
  */
 private JTextField getJTextField1() {
  if (jTextField1 == null) {
   jTextField1 = new JTextField();
   jTextField1.setBounds(293, 81, 161, 41);
   jTextField1.setNextFocusableComponent(jButton);
  }
  return jTextField1;
 }

 /**
  * This method initializes jTextArea
  * 
  * @return javax.swing.JTextArea
  */
 private JTextArea getJTextArea() {
  if (jTextArea == null) {
   jTextArea = new JTextArea();
   jTextArea.setTabSize(8);
  }
  return jTextArea;
 }


 public static String bbb(List list1, List list2) {
  float result = 0;
  for (int i = list1.size(); i > 0; i-- ) {
   if (list1.contains("*")) {
    int j = list1.indexOf("*");
    result = Float.parseFloat((String)list2.get(j))
     * Float.parseFloat((String)list2.get(j + 1));
    list1.remove(j);
    list2.remove(j);
    list2.remove(j);
    list2.add(j, String.valueOf(result));
   } else if (list1.contains("/")) {
    int j = list1.indexOf("/");
    result = Float.parseFloat((String)list2.get(j))
     / Float.parseFloat((String)list2.get(j + 1));
    list1.remove(j);
    list2.remove(j);
    list2.remove(j);
    list2.add(j, String.valueOf(result));
   } else if (list1.contains("+")) {
    int j = list1.indexOf("+");
    result = Float.parseFloat((String)list2.get(j))
     + Float.parseFloat((String)list2.get(j + 1));
    list1.remove(j);
    list2.remove(j);
    list2.remove(j);
    list2.add(j, String.valueOf(result));
   } else if (list1.contains("-")) {
    int j = list1.indexOf("-");
    result = Float.parseFloat((String)list2.get(j))
     - Float.parseFloat((String)list2.get(j + 1));
    list1.remove(j);
    list2.remove(j);
    list2.remove(j);
    list2.add(j, String.valueOf(result));
   }
  }
  return (String)list2.get(0);
 }

 private static void bbb(String str, String sPrint, List list) {
  if (!"".equals(str.trim()) ? false : list.add(sPrint))
   ;
  for (int i = 0; i < str.length() && ( !"".equals(str.trim()) ); i++ )
   if (str.charAt(i) != ' ')
    bbb(str.replace(str.charAt(i), ' '), sPrint + str.charAt(i),
     list);
 }

 private static List bbb(String str, List list) {
  List result = new ArrayList();
  String a1 = str.substring(0, 1);
  String b1 = str.substring(1, 2);
  String c1 = str.substring(2, 3);
  String d1 = str.substring(3, 4);
  String[] a11 = new String[] { a1, b1, c1, d1 };
  for (int i = 0; i < list.size(); i++ ) {
   String temp = (String)list.get(i);
   int a = Integer.parseInt(temp.substring(0, 1));
   int b = Integer.parseInt(temp.substring(1, 2));
   int c = Integer.parseInt(temp.substring(2, 3));
   int d = Integer.parseInt(temp.substring(3, 4));
   String tempStr = a11[a] + a11[b] + a11[c] + a11[d];
   if(!result.contains(tempStr)){
    result.add(tempStr);
   }
   
  }
  return result;
 }

 public List test(String param, int x) {
  int y = 0;
  List result = new ArrayList();
  List a11 = new ArrayList();
  calculate24.bbb("0123", "", a11);
  List a1 = calculate24.bbb(param, a11);
  for (int m = 0; m < a1.size(); m++ ) {
   String param1 = (String)a1.get(m);
   int[] a = new int[] { Integer.parseInt(param1.substring(0, 1)),
   Integer.parseInt(param1.substring(1, 2)),
   Integer.parseInt(param1.substring(2, 3)),
   Integer.parseInt(param1.substring(3, 4)) };
   String[] e = new String[] { "*", "/", "+", "-" };
   for (int i = 0; i < 4; i++ ) {
    for (int j = 0; j < 4; j++ ) {
     for (int k = 0; k < 4; k++ ) {
      List aa = new ArrayList();
      aa.add(String.valueOf(a[0]));
      aa.add(String.valueOf(a[1]));
      aa.add(String.valueOf(a[2]));
      aa.add(String.valueOf(a[3]));
      List bb = new ArrayList();
      bb.add(e[i]);
      bb.add(e[j]);
      bb.add(e[k]);
      String s = a[0] + e[i] + a[1] + e[j] + a[2] + e[k]
       + a[3];
      String tempS = s;
      s = calculate24.bbb(bb, aa);
      if (Float.parseFloat(s) == 24) {
       y++ ;
       result.add(tempS + "=24");
       if (y == x) {
        return result;
       }
      }

      List temp1 = new ArrayList();
      List temp2 = new ArrayList();
      temp1.add(String.valueOf(a[0]));
      temp1.add(String.valueOf(a[1]));
      temp2.add(e[i]);
      String temp = calculate24.bbb(temp2, temp1);
      aa.clear();
      aa.add(temp);
      aa.add(String.valueOf(a[2]));
      aa.add(String.valueOf(a[3]));
      bb.clear();
      bb.add(e[j]);
      bb.add(e[k]);
      s = "(" + a[0] + e[i] + a[1] + ")" + e[j] + a[2] + e[k]
       + a[3];
      tempS = s;
      s = calculate24.bbb(bb, aa);
      if (Float.parseFloat(s) == 24) {
       y++ ;
       result.add(tempS + "=24");
       if (y == x) {
        return result;
       }
      }

      temp1.clear();
      temp2.clear();
      temp1.add(String.valueOf(a[1]));
      temp1.add(String.valueOf(a[2]));
      temp2.add(e[j]);
      temp = calculate24.bbb(temp2, temp1);
      aa.clear();
      aa.add(String.valueOf(a[0]));
      aa.add(temp);
      aa.add(String.valueOf(a[3]));
      bb.clear();
      bb.add(e[i]);
      bb.add(e[k]);
      s = a[0] + e[i] + "(" + a[1] + e[j] + a[2] + ")" + e[k]
       + a[3];
      tempS = s;
      s = calculate24.bbb(bb, aa);
      if (Float.parseFloat(s) == 24) {
       y++ ;
       result.add(tempS + "=24");
       if (y == x) {
        return result;
       }
      }

      temp1.clear();
      temp2.clear();
      temp1.add(String.valueOf(a[2]));
      temp1.add(String.valueOf(a[3]));
      temp2.add(e[k]);
      temp = calculate24.bbb(temp2, temp1);
      aa.clear();
      aa.add(String.valueOf(a[0]));
      aa.add(String.valueOf(a[1]));
      aa.add(temp);
      bb.clear();
      bb.add(e[i]);
      bb.add(e[j]);
      s = a[0] + e[i] + a[1] + e[j] + "(" + a[2] + e[k]
       + a[3] + ")";
      tempS = s;
      s = calculate24.bbb(bb, aa);
      if (Float.parseFloat(s) == 24) {
       y++ ;
       result.add(tempS + "=24");
       if (y == x) {
        return result;
       }
      }

      temp1.clear();
      temp2.clear();
      temp1.add(String.valueOf(a[0]));
      temp1.add(String.valueOf(a[1]));
      temp1.add(String.valueOf(a[2]));
      temp2.add(e[i]);
      temp2.add(e[j]);
      temp = calculate24.bbb(temp2, temp1);
      aa.clear();
      aa.add(temp);
      aa.add(String.valueOf(a[3]));
      bb.clear();
      bb.add(e[k]);
      s = "(" + a[0] + e[i] + a[1] + e[j] + a[2] + ")" + e[k]
       + a[3];
      tempS = s;
      s = calculate24.bbb(bb, aa);
      if (Float.parseFloat(s) == 24) {
       y++ ;
       result.add(tempS + "=24");
       if (y == x) {
        return result;
       }
      }

      temp1.clear();
      temp2.clear();
      temp1.add(String.valueOf(a[1]));
      temp1.add(String.valueOf(a[2]));
      temp1.add(String.valueOf(a[3]));
      temp2.add(e[j]);
      temp2.add(e[k]);
      temp = calculate24.bbb(temp2, temp1);
      aa.clear();
      aa.add(String.valueOf(a[0]));
      aa.add(temp);
      bb.clear();
      bb.add(e[i]);
      s = a[0] + e[i] + "(" + a[1] + e[j] + a[2] + e[k]
       + a[3] + ")";
      tempS = s;
      s = calculate24.bbb(bb, aa);
      if (Float.parseFloat(s) == 24) {
       y++ ;
       result.add(tempS + "=24");
       if (y == x) {
        return result;
       }
      }

      temp1.clear();
      temp2.clear();
      temp1.add(String.valueOf(a[0]));
      temp1.add(String.valueOf(a[1]));
      temp2.add(e[i]);
      temp = calculate24.bbb(temp2, temp1);

      List temp3 = new ArrayList();
      List temp4 = new ArrayList();
      temp3.add(String.valueOf(a[2]));
      temp3.add(String.valueOf(a[3]));
      temp4.add(e[k]);
      String temp11 = calculate24.bbb(temp4, temp3);
      aa.clear();
      aa.add(temp);
      aa.add(temp11);
      bb.clear();
      bb.add(e[j]);
      s = "(" + a[0] + e[i] + a[1] + ")" + e[j] + "(" + a[2]
       + e[k] + a[3] + ")";
      tempS = s;
      s = calculate24.bbb(bb, aa);
      if (Float.parseFloat(s) == 24) {
       y++ ;
       result.add(tempS + "=24");
       if (y == x) {
        return result;
       }
      }
     }
    }
   }
  }
  return result;
 }

 public static boolean check(String param1) {
  Pattern pattern = Pattern.compile("[0-9]{4}");
  Matcher matcher = pattern.matcher((CharSequence)param1);
  boolean result = matcher.matches();
  if (result == false) {
   JOptionPane.showMessageDialog(null, "please enter correct number");
   return false;
  } else {
   return true;
  }

 }

 public static boolean check1(String param2) {
  if(param2 == null){
   JOptionPane.showMessageDialog(null, "please enter correct number");
   return false;
  }
  Pattern pattern = Pattern.compile("[0-9]{0,99}");
  Matcher matcher = pattern.matcher((CharSequence)param2);
  boolean result = matcher.matches();
  if (result == false) {
   JOptionPane.showMessageDialog(null, "please enter correct number");
   return false;
  } else {
   return true;
  }

 }

 /**
  * This method initializes jButton
  * 
  * @return javax.swing.JButton
  */
 private JButton getJButton() {
  if (jButton == null) {
   jButton = new JButton();
   jButton.setBounds(81, 275, 110, 54);
   jButton.setText("calculate");
   jButton.addKeyListener(new java.awt.event.KeyAdapter() { 
    public void keyPressed(java.awt.event.KeyEvent e) {    
     if(e.getKeyCode()==10){
      if (check(jTextField.getText())
       && check1(jTextField1.getText())) {
       if(!jTextField1.getText().equals("0")){
        List b = test(jTextField.getText(), Integer
         .parseInt(jTextField1.getText()));
        String temp = "";
        for (int i = 0; i < b.size(); i++ ) {
         temp = temp + b.get(i) + "\n";
        }
        if (b.size() == 0) {
         jTextArea.setText("NO RESULT");
        } else {
         jTextArea.setText(temp);
        }
       }else{
        JOptionPane.showMessageDialog(null, "please enter correct number");
       }
      }
     }
    }
   });
   jButton.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent e) {
     
     if (check(jTextField.getText())
      && check1(jTextField1.getText())) {
      if(!jTextField1.getText().equals("0")){
       List b = test(jTextField.getText(), Integer
        .parseInt(jTextField1.getText()));
       String temp = "";
       for (int i = 0; i < b.size(); i++ ) {
        temp = temp + b.get(i) + "\n";
       }
       if (b.size() == 0) {
        jTextArea.setText("NO RESULT");
       } else {
        jTextArea.setText(temp);
       }
      }else{
       JOptionPane.showMessageDialog(null, "please enter correct number");
      }
     }

    }
   });
  }
  return jButton;
 }

 /**
  * This method initializes jScrollPane
  * 
  * @return javax.swing.JScrollPane
  */
 private JScrollPane getJScrollPane() {
  if (jScrollPane == null) {
   jScrollPane = new JScrollPane();
   jScrollPane.setBounds(267, 238, 216, 124);
   jScrollPane.setViewportView(getJTextArea());
  }
  return jScrollPane;
 }

 /**
  * This method initializes jButton1 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton1() {
  if (jButton1 == null) {
   jButton1 = new JButton();
   jButton1.setBounds(40, 148, 42, 28);
   jButton1.setText("1");
   jButton1.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"1");
    }
   });
  }
  return jButton1;
 }
 /**
  * This method initializes jButton2 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton2() {
  if (jButton2 == null) {
   jButton2 = new JButton();
   jButton2.setBounds(90, 148, 42, 28);
   jButton2.setText("2");
   jButton2.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"2");
    }
   });
  }
  return jButton2;
 }
 /**
  * This method initializes jButton3 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton3() {
  if (jButton3 == null) {
   jButton3 = new JButton();
   jButton3.setBounds(140, 148, 42, 28);
   jButton3.setText("3");
   jButton3.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"3");
    }
   });
  }
  return jButton3;
 }
 /**
  * This method initializes jButton4 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton4() {
  if (jButton4 == null) {
   jButton4 = new JButton();
   jButton4.setBounds(190, 148, 42, 28);
   jButton4.setText("4");
   jButton4.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"4");
    }
   });
  }
  return jButton4;
 }
 /**
  * This method initializes jButton5 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton5() {
  if (jButton5 == null) {
   jButton5 = new JButton();
   jButton5.setBounds(240, 148, 42, 28);
   jButton5.setText("5");
   jButton5.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"5");
    }
   });
  }
  return jButton5;
 }
 /**
  * This method initializes jButton6 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton6() {
  if (jButton6 == null) {
   jButton6 = new JButton();
   jButton6.setBounds(40, 188, 42, 28);
   jButton6.setText("6");
   jButton6.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"6");
    }
   });
  }
  return jButton6;
 }
 /**
  * This method initializes jButton7 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton7() {
  if (jButton7 == null) {
   jButton7 = new JButton();
   jButton7.setBounds(90, 188, 42, 28);
   jButton7.setText("7");
   jButton7.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"7");
    }
   });
  }
  return jButton7;
 }
 /**
  * This method initializes jButton8 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton8() {
  if (jButton8 == null) {
   jButton8 = new JButton();
   jButton8.setBounds(140, 188, 42, 28);
   jButton8.setText("8");
   jButton8.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"8");
    }
   });
  }
  return jButton8;
 }
 /**
  * This method initializes jButton9 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton9() {
  if (jButton9 == null) {
   jButton9 = new JButton();
   jButton9.setBounds(190, 188, 42, 28);
   jButton9.setText("9");
   jButton9.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"9");
    }
   });
  }
  return jButton9;
 }
 /**
  * This method initializes jButton10 
  *  
  * @return javax.swing.JButton 
  */    
 private JButton getJButton10() {
  if (jButton10 == null) {
   jButton10 = new JButton();
   jButton10.setBounds(240, 188, 42, 28);
   jButton10.setText("0");
   jButton10.addMouseListener(new java.awt.event.MouseAdapter() { 
    public void mouseClicked(java.awt.event.MouseEvent e) {    
     jTextField.setText(jTextField.getText()+"0");
    }
   });
  }
  return jButton10;
 }
           /**
  * Launches this application
  */
 public static void main(String[] args) {
  calculate24 application = new calculate24();
  application.show();

 }
} //  @jve:decl-index=0:visual-constraint="10,10"