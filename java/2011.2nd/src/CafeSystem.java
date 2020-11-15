package chajh;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class CafeSystem extends JFrame 
	implements ActionListener,ItemListener{
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == chb[0]) {
			if(chb[0].isSelected()) {
				combo[0].setEnabled(true);//활성화
			}else {
				combo[0].setEnabled(false);//비활성화
			}
		}else if(obj == chb[1]) {
			if(chb[1].isSelected()) {//선택된 경우
				combo[1].setEnabled(true);//활성화	
			}else {//선택이 해제된 경우
				combo[1].setEnabled(false);//비활성화
			}
		}else if(obj == chb[2]) {
			if(chb[2].isSelected()) {//선택된 경우
				combo[2].setEnabled(true);//활성화
			}else {//선택 해제된 경우
				combo[2].setEnabled(false);//활성화
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btns[0]) {//확인 버튼을 누른경우
			int total=0;//총액을 위한 변수
			//어떤 음료를 선택했는지를 찾는다.
			if(chb[0].isSelected()) {
			//첫번째 음료가 선택된 경우
				int subTotal = 0;//네스카페 총액
				int index = combo[0].getSelectedIndex();
				index=index+1;//음료의 갯수
				subTotal = index * NESCAFE;
				total = total + subTotal;
				txt[0].setText(subTotal+"원");//소계출력
			}
			if(chb[1].isSelected()) {
			//두번째 음료가 선택된 경우
				int subTotal = 0;//에스프레소 총액
				int index = combo[1].getSelectedIndex();
				index=index+1;//음료의 갯수
				subTotal = index * ESPRESSO;
				total = total + subTotal;
				txt[1].setText(subTotal+"원");//소계출력
			}
			if(chb[2].isSelected()) {
			//세번째 음료가 선택된 경우
				int subTotal =0;//아메리카노 총액
				int index = combo[2].getSelectedIndex();
				index=index+1;//음료의 갯수
				subTotal = index * AMERICANO;
				total = total + subTotal;
				txt[2].setText(subTotal+"원");//소계출력
			}
			//총액 출력
			txt[3].setText(total+"원");//총액출력
		}else if(obj == btns[1]) {//취소버튼
			txt[0].setText("");//네스카페소계지움
			txt[1].setText("");//에스프레소소계지움
			txt[2].setText("");//아메리카노소계지움
			txt[3].setText("");//총액지움
			
			combo[0].setSelectedIndex(0);
			combo[1].setSelectedIndex(0);
			combo[2].setSelectedIndex(0);
			//모든 콤보박스의 선택을 첫번째로 설정
			chb[0].setSelected(false);
			chb[1].setSelected(false);
			chb[2].setSelected(false);
			//모든 체크박스의 선택을 해제로 설정
		}
	}
	final int NESCAFE = 2000;//네스카페의 가격
	final int ESPRESSO = 1500;//에스프레소의 가격
	final int AMERICANO = 1000;//아메리카노의 가격
	JLabel[] lbls; JToggleButton[] chb;
	ButtonGroup[] group; JButton[] btns;
	JTextField[] txt; JComboBox[] combo; 
	JPanel[] pans;
	String[] labelTitles={"상품명","갯 수","금 액",
		"결제수단","포인트 적립","총 액"};
	String[] checkTitles= {"네스카페","에스프레소",
			"아메리카노","현금","신용카드",
			"예","아니오"};
	GridLayout gl;
	void makeLabel() {
		lbls = new JLabel[6];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(labelTitles[i]);
		}
	}
	void makeCheckbox() {
		chb = new JToggleButton[7];
		group = new ButtonGroup[2];
		group[0]= new ButtonGroup();//결제수단용
		group[1]=new ButtonGroup();//포인트 적립용
		for(int i=0; i<chb.length; i++) {
			switch(i) {
			case 3://현금용 
			case 4://신용카드용
				chb[i]=new JRadioButton(
					checkTitles[i],false);
				group[0].add(chb[i]);
				break;
			case 5://포인트 적립, 예
			case 6://포인트 적립, 아니오
				chb[i]=new JRadioButton(
					checkTitles[i],false);
				group[1].add(chb[i]);
				break;
			default :
				chb[i]=new JCheckBox(
					checkTitles[i],false);
				chb[i].addItemListener(this);
			}//switch의 끝
		}
	}
	void makeTextfield() {
		txt=new JTextField[4];
		for(int i=0; i<txt.length; i++) {
			txt[i]=new JTextField(10);
		}
	}
	void makeCombobox() {
		combo = new JComboBox[3];
		for(int i=0; i<combo.length; i++) {
			combo[i] = new JComboBox();
			for(int j=1; j<=10; j++) {
				combo[i].addItem(j+"개");
			}//콤보박스마다 1부터 10까지 채움
			combo[i].setEnabled(false);//비활성화
		}//콤보박스 3개 생성
	}
	void makePanel() {
		pans = new JPanel[9];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
		}
		//1행
		pans[0].add(lbls[0]);pans[0].add(chb[0]);
		pans[0].add(chb[1]);pans[0].add(chb[2]);
		//2행
		pans[1].add(lbls[1]);pans[1].add(combo[0]);
		pans[1].add(combo[1]);pans[1].add(combo[2]);
		//3행
		pans[2].add(lbls[2]);pans[2].add(txt[0]);
		pans[2].add(txt[1]);pans[2].add(txt[2]);
		//4행
		pans[3].add(lbls[3]);pans[3].add(chb[3]);
		pans[3].add(chb[4]);
		//5행
		pans[4].add(lbls[4]);pans[4].add(chb[5]);
		pans[4].add(chb[6]);
		//6행
		pans[5].add(lbls[5]); pans[5].add(txt[3]);
		pans[5].setBackground(Color.GREEN);
		//7행,8행
		pans[6].add(new JLabel());
		pans[7].add(new JLabel());
		btns = new JButton[2];
		btns[0] = new JButton(" 확 인 ");
		btns[0].addActionListener(this);
		btns[1] = new JButton(" 취 소 ");
		btns[1].addActionListener(this);
		//9행
		pans[8].add(btns[0]);pans[8].add(btns[1]);
		pans[8].setBackground(Color.ORANGE);
	}
	void makeWindow() {
		for(int i=0; i<pans.length; i++) {
			this.add(pans[i]);
		}//패널9개를 윈도우에 붙임
		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public CafeSystem(String str) {
		super(str);
		gl = new GridLayout(9,1,5,5);//9행1열
		this.setLayout(gl);//윈도우에 배치관리자설정
		makeLabel();
		makeCheckbox();
		makeTextfield();
		makeCombobox();
		makePanel(); makeWindow();
	}
	public static void main(String[] args) {
		new CafeSystem("음료 주문관리 ver1.0");
	}
}









