import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSystem extends JPanel 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//�α��ι�ư���� ��ҹ�ư������ ã�´�.
		Object obj = arg0.getSource();
		if(obj == ok || obj == pwd) {
		//�α��ι�ư�� ������� �̰ų�,
			//��ȣ�� �Է��� �� Enter�� ������ ��
		//����,DB���� ������ ã�ƾ� ������,
		//���⼭�� Ư���� ����/��ȣ�� �α��ΰ������� ���
		//�׽�Ʈ ����/��ȣ - tiger/member
			String inputId = id.getText();//������ ����
			String passwd = 
					new String(pwd.getPassword());
			//�Էµ� ��ȣ�� �о ���ڿ��� ����:toString()
			if(inputId.equals("tiger")) {
			//������ ��ġ�ϴ� ���
				if(passwd.equals("member")) {
					//��ȣ�� ��ġ�ϴ� ���->�α��� ����
					JOptionPane.showMessageDialog(
						m2w, "ȯ���մϴ�~"+inputId+"��~");
					//������ ���� ������ ����Ѵ�.
					m2w.setTitle(
						"�޴������� ver2.0 - ȯ���մϴ�,"+inputId+"��");
					m2w.m1.setEnabled(true);//�޴�Ȱ��ȭ
					m2w.m2.setEnabled(true);
					m2w.m3.setEnabled(true);
					m2w.m4.setEnabled(true);
					m2w.card.show(m2w.slide,"���Ͼȳ�");//ȭ���� �ٲ�
				}else {//��ȣ�� ��ġ���� �ʴ� ���
					JOptionPane.showMessageDialog(
						m2w, "��ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}else {//������ ��ġ���� �ʴ� ���
				JOptionPane.showMessageDialog(
					m2w, "������ ��ġ���� �ʽ��ϴ�.");
			}
		}else if(obj == cancel) {//��ҹ�ư�� �������
			id.setText(""); pwd.setText("");
		}
	}
	
	JPanel r1, r2, r3, center;
	JButton ok,cancel; JTextField id;
	JPasswordField pwd; JLabel lblId, lblPwd;
	String[] lblTitles = {"������ �Է��ϼ���",
			"��ȣ�� �Է��ϼ���"};
	String[] btnTitles = {"�α���","�� ��"};
	Menu2Window m2w;//������
	public LoginSystem(Menu2Window m2w) {
		this.m2w = m2w;
//		super(str);
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
		ok.addActionListener(this);
		cancel.addActionListener(this);
	}
	void makeTextfield() {
		id = new JTextField("������ �Է��ϼ���",20);
		pwd=new JPasswordField(20);
		pwd.addActionListener(this);
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
		this.setLayout(new BorderLayout());
		this.add("Center",center);
//		this.setSize(300, 300);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(
//				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		new LoginSystem("�α��� ver1.0");
	}
}









