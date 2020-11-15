package chajh;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FruitsIntro extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();//이벤트의 고향을 찾음
		for(int i=0; i<btns.length; i++) {
			if(obj == btns[i]) {
				card.show(
						cardPanel, btnTitles[i]);
				break;//반복종료
			}
		}//버튼의 갯수만큼 반복
//		if(obj == btns[0]) {
//			
//		}else if(obj == btns[1]) {
//			
//		}
	}
	JButton[] btns; JPanel btn_pan;
	JPanel[] fruits; JPanel cardPanel;
	CardLayout card; ImageIcon[] imgs;
	JLabel[] iconLabels;//과일이미지용 레이블
	JLabel[] introLabels;//과일설명용 레이블
	String path = "src/senior/";//이미지 경로
	String[] filenames = {"grape.jpg","kiwi.jpg",
		"lemon.jpg","orange.jpg","strawberry.jpg",
		"tangerine.jpg"};//이미지 파일 이름
	String[] intros = {
		"<html>폴리페놀을 다량 함유하고 있어<br/>"
		+ "황상화 작용을 합니다.</html>",
		"<html>시네피린을 함유하고 있어<br/>"
		+ "감기예방에 좋습니다.</html>",
		"<html>비타민C가 매우 풍부합니다.<br/>"
		+ "다이어트나 미용에 좋습니다.</html>",
		"<html>구연산을 포함하고 있어 피로회복에<br/>"
		+ "좋습니다. 비타민C도 풍부합니다.</html>",
		"<html>비타민C가 풍부합니다.<br/>"
		+ "생과일 주스로 마시면 좋습니다.</html>",
		"<html>비타민C나 폴라보노이드를 다량<br/>"
		+ "함유하고 있습니다.</html>"
	};//과일 설명
	String[] btnTitles = {"포도","키위","레몬",
			"오렌지","딸기","귤"};//버튼의 제목
	public FruitsIntro(String str) {
		super(str);
		card = new CardLayout();
		makeImageIcon();//이미지아이콘6개 생성 
		makeIntro();//과일소개레이블 생성
		makeImageLabel();//아이콘을 레이블에 설정 
		makeButton();//버튼 생성
		makePanel();//패널 생성 
		makeWindow();//윈도우 생성
	}
	void makeWindow() {
		this.add("Center",cardPanel);
		this.add("South",btn_pan);
		this.setResizable(false);//크기변경불가
		this.setSize(600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		fruits = new JPanel[6];
		cardPanel = new JPanel();
		cardPanel.setLayout(card);
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JPanel();//패널생성
			fruits[i].add(iconLabels[i]);//이미지
			fruits[i].add(introLabels[i]);//설명
			//패널에 이미지와 설명을 담는다.
			cardPanel.add(fruits[i],btnTitles[i]);
			//패널을 CardLayout을 사용하는 패널에 담음
			//담을 때, 패널과 패널의 이름을 설정
		}
		card.show(cardPanel, btnTitles[0]);
		//기본출력패널설정(첫번째 "포도"이름의 패널)
		btn_pan = new JPanel();//버튼을 담을패널생성
		for(int i=0; i<btns.length; i++) {
			btn_pan.add(btns[i]);//버튼을패널에담음
		}
	}
	void makeButton() {
		btns = new JButton[6];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].addActionListener(this);
		}
	}
	void makeImageLabel() {
		iconLabels = new JLabel[6];
		for(int i=0; i<iconLabels.length; i++) {
			iconLabels[i] = new JLabel();
			iconLabels[i].setIcon(imgs[i]);
		}
	}
	void makeIntro() {
		introLabels = new JLabel[6];
		for(int i=0; i<introLabels.length; i++) {
			introLabels[i] = new JLabel(intros[i],
					JLabel.CENTER);
		}
	}
	void makeImageIcon() {
		imgs = new ImageIcon[6];//배열생성
		for(int i=0; i<imgs.length; i++) {
			imgs[i] = new ImageIcon(
				path+filenames[i]);
		}//이미지 아이콘 6개 생성
	}
	public static void main(String[] args) {
		new FruitsIntro("과일소개 ver1.0");
	}

}














