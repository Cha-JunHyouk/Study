package chajh;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class IdCheckWindow extends JFrame {
	IdCheckWindow(){
		this.setSize(100, 80);
		this.add("Center",
				new JLabel("사용가능합니다."));
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE);
	}
}
public class HRSystem extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == idCheck) {//중복검사버튼을 클릭
			new IdCheckWindow();
			//중복검사 진행
//			JOptionPane.showMessageDialog(
//					this, "사용가능합니다.");
		}
	}
	String[] labelTitles = {"사번","이름","성별",
			"부서","주소","입사일","생일"};
	JLabel[] labels; JTextField[] inputs;
	JRadioButton[] gender; ButtonGroup group;
	JComboBox[] combo; 
	String[] deptTitles = {"영업부","홍보부",
			"개발부","총무부","기획부"};
	JButton[] btns; JButton idCheck;//사번중복조회
	String[] btnsTitles = {" 삽입 "," 삭제 ",
			" 변경 "," 조회 ","지우기"};
	Font font; JPanel[] panels; 
	JPanel center,south;
	public HRSystem(String str) {
		super(str);
		makeLabel();
		makeTextField();
		makeComboBox();
		makeRadio();
		makeButton();
		makePanel();
		makeWindow();
	}
	void makeWindow() {
		this.add("Center",center);
		this.add("South", south);
		this.setSize(800, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		panels = new JPanel[7];
		//사번,이름,성별,부서,주소,입사일,생일
		center=new JPanel(); south=new JPanel();
		center.setLayout(new GridLayout(7,1));
		south.setBackground(Color.GREEN);
		for(int i=0;i<panels.length;i++) {
			panels[i] = new JPanel();//패널생성
			panels[i].add(labels[i]);//레이블붙임
			panels[i].setBackground(Color.ORANGE);
			switch(i) {
			case 0://1행
				panels[i].add(inputs[i]);
				panels[i].add(idCheck); break;
			case 1://2행
				panels[i].add(inputs[i]); break;
			case 2://3행
				panels[i].add(gender[0]);
				panels[i].add(gender[1]); break;
			case 3://4행
				panels[i].add(combo[0]);break;
			case 4://5행
				panels[i].add(inputs[2]); break;
			case 5://6행
				panels[i].add(new JButton("달력"));
				break;
			case 6://7행
				panels[i].add(combo[1]);
				panels[i].add(combo[2]);
				panels[i].add(combo[3]);
				panels[i].add(new JButton("확인"));
			}//switch의 끝
			center.add(panels[i]);
		}//for의 끝
		for(int i=0; i<btns.length; i++) {
			south.add(btns[i]);
		}//버튼을 south에 붙임
	}
	void makeRadio() {
		gender = new JRadioButton[2];
		gender[0] = new JRadioButton("남자");
		gender[1] = new JRadioButton("여자");
		group = new ButtonGroup();
		group.add(gender[0]); group.add(gender[1]);
	}
	void makeButton() {
		btns = new JButton[5];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnsTitles[i]);
		}
		idCheck = new JButton("중복검사");
		idCheck.addActionListener(this);
	}
	void makeLabel() {
		labels = new JLabel[7];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(labelTitles[i]);
		}
	}
	void makeComboBox() {
		combo = new JComboBox[4];//부서명,년,월,일
		for(int i=0; i<combo.length; i++) {
			combo[i] = new JComboBox();
			switch(i) {
			case 0://부서명을 채움
				combo[i].addItem("부서명을 선택하세요.");
				for(int j=0; j<deptTitles.length;j++) {
					combo[i].addItem(deptTitles[j]);
				}
				break;
			case 1://2020부터 1920을 채움
				combo[i].addItem("년도를 선택하세요.");
				for(int j=2020; j>=1920; j--) {
					combo[i].addItem(j);
				}
				break;
			case 2://1부터 12를 채움
				combo[i].addItem("월을 선택하세요.");
				for(int j=1; j<=12; j++) {
					combo[i].addItem(j);
				}
				break;
			case 3:
				combo[i].addItem("일을 선택하세요.");
			}
		}
	}
	void makeTextField() {
		inputs = new JTextField[3];
		for(int i=0;i<inputs.length;i++) {
			switch(i) {
			case 0: inputs[i] = new JTextField(
					"사번을 입력하세요.",20);
					break;
			case 1: inputs[i] = new JTextField(
					"이름을 입력하세요.",20);
					break;
			case 2: inputs[i] = new JTextField(
					"주소를 입력하세요.",20);
					break;
			}
		}
	}
	public static void main(String[] args) {
		new HRSystem("사원 관리 시스템 ver1.0");
	}
}









