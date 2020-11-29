package senior;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputMatjip extends JPanel {
	String[] titles= {"맛집번호","맛집이름","맛집주소",
			"전화번호","핸드폰 번호"};
	JLabel[] lbls; JTextField[] inputs; JPanel[] pans;
	Font font;
	public InputMatjip() {//생성자
		font=new Font("고딕체",Font.BOLD, 26);
		makeLabel();
		makeTextField();
		makePanel();
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];//배열생성
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
			lbls[i].setFont(font);//레이블에 폰트 적용
		}//JLabel 생성
	}
	void makeTextField() {
		inputs = new JTextField[titles.length];
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = new JTextField(20);
			inputs[i].setFont(font);//텍스트필드에 폰트적용
		}
	}
	void makePanel() {
		pans = new JPanel[titles.length];
		this.setLayout(new GridLayout(5,1));//5행1열
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			pans[i].add(lbls[i]);//패널에 레이블 붙임
			pans[i].add(inputs[i]);//패널에 텍스트필드붙임
			this.add(pans[i]);//현재 패널에 생성된 패널붙임
		}
	}
}












