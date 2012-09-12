package frametest;

import java.io.*;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NoteBook extends JFrame implements ActionListener, ItemListener,
		WindowListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = this.getContentPane();
	JMenuBar jmb = new JMenuBar();
	JColorChooser jcc = new JColorChooser();

	JMenu jm1 = new JMenu("文件(F)");
	JMenu jm2 = new JMenu("编辑(E)");
	JMenu jm3 = new JMenu("格式(O)");
	JMenu jm4 = new JMenu("查看(V)");
	JMenu jm5 = new JMenu("帮助(H)");

	JMenuItem jmi1 = new JMenuItem("新建(N)");
	JMenuItem jmi2 = new JMenuItem("打开(O)");
	JMenuItem jmi3 = new JMenuItem("保存(S)");
	JMenuItem jmi4 = new JMenuItem("退出(X)");

	JMenuItem jmi5 = new JMenuItem("撤消(U)");
	JMenuItem jmi6 = new JMenuItem("复制(C)");
	JMenuItem jmi7 = new JMenuItem("粘贴(P)");
	JMenuItem jmi8 = new JMenuItem("剪切(T)");
	JMenuItem jmi12 = new JMenuItem("日期和时间");

	JMenuItem jmi9 = new JMenuItem("字体(E)");
	JCheckBoxMenuItem jcbmi = new JCheckBoxMenuItem("自动换行(W)");

	JMenuItem jmi10 = new JMenuItem("删除(S)");

	JMenuItem jmi11 = new JMenuItem("背景颜色(H)");

	JTextArea jta = new JTextArea(15, 15);

	JScrollPane jsp = new JScrollPane(jta);

	// PupolMenu pm = new Pupolmenu();

	NoteBook() {
		this.addWindowListener(this);
		c.setLayout(new BorderLayout());
		c.add(jmb, BorderLayout.NORTH);
		this.setTitle("新建 文本文档");
		jmb.add(jm1);
		jm1.setMnemonic('f');
		jm1.addActionListener(this);
		jmb.add(jm2);
		jm2.setMnemonic('e');
		jmb.add(jm3);
		jm3.setMnemonic('o');
		jmb.add(jm4);
		jm4.setMnemonic('v');
		jmb.add(jm5);
		jm5.setMnemonic('h');

		jm1.add(jmi1);
		jmi1.addActionListener(this);
		jmi1.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK,false));
		jm1.addSeparator();
		jm1.add(jmi2);
		jmi2.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK,false));
		jmi2.addActionListener(this);
		jm1.addSeparator();
		jm1.add(jmi3);
		jmi3.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK,false));
		jmi3.addActionListener(this);
		jm1.addSeparator();
		jm1.add(jmi4);
		jmi1.setMnemonic('n');
		jmi2.setMnemonic('o');
		jmi3.setMnemonic('s');
		jmi4.setMnemonic('x');
		jmi4.addActionListener(this);

		jm2.add(jmi5);
		jm2.addSeparator();
		jm2.add(jmi6);
		jm2.addSeparator();
		jm2.add(jmi7);
		jm2.addSeparator();
		jm2.add(jmi8);
		jm2.add(jmi12);
		jmi12.addActionListener(this);

		jm3.add(jcbmi);
		jcbmi.addItemListener(this);
		jm3.addSeparator();
		jm3.add(jmi9);

		jm4.add(jmi10);
		jmi10.addActionListener(this);

		jm5.add(jmi11);
		jmi11.addActionListener(this);

		c.add(jsp);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jmi1) {
			jta.setText("");
			this.setTitle("无标题 - 记事本");
		}
		if (e.getSource() == jmi2) {
			File f1;
			JFileChooser jfc1 = new JFileChooser();
			int num1 = jfc1.showOpenDialog(this);
			if (num1 == JFileChooser.APPROVE_OPTION) {
				try {
					f1 = jfc1.getSelectedFile();
					this.setTitle(f1.getName());
					FileReader fr = new FileReader(f1);
					BufferedReader br = new BufferedReader(fr);
					String str;
					while ((str = br.readLine()) != null) {
						jta.append(str);
						jta.append("\n");
					}
					fr.close();
					br.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		if (e.getSource() == jmi3) {
			File f2 = null;
			JFileChooser jfc2 = new JFileChooser();
			int num2 = jfc2.showSaveDialog(this);
			if (num2 == JFileChooser.APPROVE_OPTION) {
				f2 = jfc2.getSelectedFile();
				this.setTitle(f2.getName());
				try {
					FileWriter fw = new FileWriter(f2);
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write(jta.getText());
					bw.close();
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}

		}
		if (e.getSource() == jmi4) {
			int a = JOptionPane.showConfirmDialog(this, "文件已被改变，是否要保存？", "提示",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (a == 1) {
				this.dispose();
			} else if (a == 0) {
				File f2 = null;
				JFileChooser jfc2 = new JFileChooser();
				int num2 = jfc2.showSaveDialog(this);
				if (num2 == JFileChooser.APPROVE_OPTION) {
					f2 = jfc2.getSelectedFile();
					this.setTitle(f2.getName());
					try {
						FileWriter fw = new FileWriter(f2);
						BufferedWriter bw = new BufferedWriter(fw);

						bw.write(jta.getText());
						bw.close();
						fw.close();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					this.dispose();
				}

			}
		}
		if (e.getSource() == jmi12) {
			Calendar c1 = Calendar.getInstance();
			int y = c1.get(Calendar.YEAR);
			int m = c1.get(Calendar.MONTH);
			int d = c1.get(Calendar.DATE);
			int h = c1.get(Calendar.HOUR);
			int m1 = c1.get(Calendar.MINUTE);
			int m2 = m + 1;
			jta.setText(y + "年" + m2 + "月" + d + "日" + h + ":" + m1);
		}
		if (e.getSource() == jmi11) {
			Color ccc = JColorChooser.showDialog(this, "color", Color.BLACK);
			jta.setSelectedTextColor(ccc);
			jta.setBackground(ccc);
		}
		if (e.getSource() == jmi10) {
			jta
					.replaceRange("", jta.getSelectionStart(), jta
							.getSelectionEnd());
		}

	}

	public void itemStateChanged(ItemEvent e2) {
		if (e2.getItemSelectable() == jcbmi) {
			jta.setLineWrap(true);
		} else
			jta.setLineWrap(false);

	}

	public static void main(String[] args) {
		new NoteBook();
	}

	public void windowOpened(WindowEvent arg0) {

	}

	public void windowClosing(WindowEvent arg0) {

		int a = JOptionPane.showConfirmDialog(this, "文件已被改变，是否要保存？", "提示",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (a == 1) {
			this.dispose();
		} else if (a == 0) {
			File f2 = null;
			JFileChooser jfc2 = new JFileChooser();
			int num2 = jfc2.showSaveDialog(this);
			if (num2 == JFileChooser.APPROVE_OPTION) {
				f2 = jfc2.getSelectedFile();
				this.setTitle(f2.getName());
				try {
					FileWriter fw = new FileWriter(f2);
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write(jta.getText());
					bw.close();
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			if (a == 2) {
				// //????/????????????????????????????????????????????????????????????????//
			}
		}
	}

	public void windowClosed(WindowEvent arg0) {

	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}