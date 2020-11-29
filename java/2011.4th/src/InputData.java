package senior;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InputData extends JPanel {
	JTextField[] inputs; JLabel[] lbls; JPanel[] pans;
	String[] titles = {"계정","암호","성별","주소","이름",
		"전화번호","별자리"};
	public InputData() {
		this.setLayout(new GridLayout(9,1));//9행1열
		lbls = new JLabel[titles.length];
		inputs = new JTextField[titles.length];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
		}//레이블7개 생성
		for(int i=0; i<inputs.length; i++) {
			if(i==1) {
				inputs[i]= new JPasswordField(20);
			}else {
				inputs[i]= new JTextField(20);
			}
		}//테스트필드(테스트입력창)7개 생성
		pans = new JPanel[7];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			pans[i].add(lbls[i]);//패널에 레이블 붙임
			pans[i].add(inputs[i]);//패널에 입력창 붙임
		}//패널 7개 생성
		this.add(new JLabel());//1행
		for(int i=0; i<pans.length; i++) {
			this.add(pans[i]);//2행~8행
		}
		this.add(new JLabel());//9행
	}
}












