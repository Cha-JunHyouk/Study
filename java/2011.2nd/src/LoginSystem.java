package chajh;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSystem extends JFrame {
	JPanel r1, r2, r3, center;
	JButton ok,cancel; JTextField id;
	JPasswordField pwd; JLabel lblId, lblPwd;
	String[] lblTitles = {"������ �Է��ϼ���",
			"��ȣ�� �Է��ϼ���"};
	String[] btnTitles = {"�α���","�� ��"};
	public LoginSystem(String str) {
		super(str);
		makeLabel(); makeButton(); makeTextfield(); 
		makePanel(); makeWindow();
	}
	void makeLabel() {
		lblId = new JLabel(lblTitles[0]);
		lblPwd = new JLabel(lblTitles[1]);
	}
	void makeButton() {
		ok = new JButton(btnTitles[0]);
		cancel = new JButton(btnTitles[1]);
	}
	void makeTextfield() {
		id = new JTextField("������ �Է��ϼ���",20);
		pwd=new JPasswordField(20);
	}
	void makePanel() {
		r1 = new JPanel(); r2 = new JPanel();
		r3 = new JPanel(); center = new JPanel();
		center.setLayout(new GridLayout(3,1));
		r1.add(lblId); r1.add(id);//1��
		r2.add(lblPwd); r2.add(pwd);//2��
		r3.add(ok); r3.add(cancel);//3��
		center.add(r1); center.add(r2);
		center.add(r3);
	}
	void makeWindow() {
		this.add("Center",center);
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new LoginSystem("�α��� ver1.0");
	}
}









