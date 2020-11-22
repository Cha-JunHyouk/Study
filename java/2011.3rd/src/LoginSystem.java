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
		//로그인버튼인지 취소버튼인지를 찾는다.
		Object obj = arg0.getSource();
		if(obj == ok || obj == pwd) {
		//로그인버튼을 누른경우 이거나,
			//암호를 입력한 후 Enter를 눌렀을 때
		//원래,DB에서 계정을 찾아야 하지만,
		//여기서는 특정한 계정/암호를 로그인계정으로 사용
		//테스트 계정/암호 - tiger/member
			String inputId = id.getText();//계정을 읽음
			String passwd = 
					new String(pwd.getPassword());
			//입력된 암호를 읽어서 문자열로 변경:toString()
			if(inputId.equals("tiger")) {
			//계정이 일치하는 경우
				if(passwd.equals("member")) {
					//암호가 일치하는 경우->로그인 성공
					JOptionPane.showMessageDialog(
						m2w, "환영합니다~"+inputId+"님~");
					//윈도우 제목에 계정을 출력한다.
					m2w.setTitle(
						"메뉴윈도우 ver2.0 - 환영합니다,"+inputId+"님");
					m2w.m1.setEnabled(true);//메뉴활성화
					m2w.m2.setEnabled(true);
					m2w.m3.setEnabled(true);
					m2w.m4.setEnabled(true);
					m2w.card.show(m2w.slide,"과일안내");//화면을 바꿈
				}else {//암호가 일치하지 않는 경우
					JOptionPane.showMessageDialog(
						m2w, "암호가 일치하지 않습니다.");
				}
			}else {//계정이 일치하지 않는 경우
				JOptionPane.showMessageDialog(
					m2w, "계정이 일치하지 않습니다.");
			}
		}else if(obj == cancel) {//취소버튼을 누른경우
			id.setText(""); pwd.setText("");
		}
	}
	
	JPanel r1, r2, r3, center;
	JButton ok,cancel; JTextField id;
	JPasswordField pwd; JLabel lblId, lblPwd;
	String[] lblTitles = {"계정을 입력하세요",
			"암호를 입력하세요"};
	String[] btnTitles = {"로그인","취 소"};
	Menu2Window m2w;//윈도우
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
		id = new JTextField("계정을 입력하세요",20);
		pwd=new JPasswordField(20);
		pwd.addActionListener(this);
	}
	void makePanel() {
		r1 = new JPanel(); r2 = new JPanel();
		r3 = new JPanel(); center = new JPanel();
		center.setLayout(new GridLayout(3,1));
		r1.add(lblId); r1.add(id);//1행
		r2.add(lblPwd); r2.add(pwd);//2행
		r3.add(ok); r3.add(cancel);//3행
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
//		new LoginSystem("로그인 ver1.0");
	}
}









