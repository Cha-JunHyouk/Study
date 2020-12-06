package senior;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TotalSystem extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();//이벤트의 소스(근원지)를 불러옴
		if(obj == i1) {//첫번째 메뉴아이템을 클릭한 경우
			card.show(slide, "고객관리");
		}else if(obj == i2) {//두번째 메뉴아이템을 클릭한 경우
			card.show(slide, "상품관리");
		}else if(obj == i3) {//세번째 메뉴아이템을 클릭한 경우
			card.show(slide, "맛집관리");
		}else if(obj == i4) {//네번재 메뉴아이템을 클릭한 경우
			//모든 메뉴를 비활성화 한다.
			custom.setEnabled(false);
			item.setEnabled(false);
			matjip.setEnabled(false);
			logout.setEnabled(false);
			//윈도우의 제목에서 계정을 삭제한다.
			this.setTitle("종합정보시스템 ver1.0");
			//화면을 "로그인"으로 바꾼다.
			card.show(slide, "로그인");
			//"로그인"에 사용했던 계정과 암호를 지운다.
			ls.id.setText(""); ls.pwd.setText("");
		}
	}
	JMenuBar mb; JMenu custom, item, matjip, logout; 
	JMenuItem i1,i2,i3,i4;
	CardLayout card; JPanel slide;
	public TotalSystem(String str) {
		super(str);
		mb = new JMenuBar();
		custom = new JMenu("고객관리 시스템");
		item = new JMenu("물품관리 시스템");
		matjip = new JMenu("맛집관리 시스템");
		logout = new JMenu("로그아웃");
		i1 = new JMenuItem("고객관리 시스템 실행");
		i1.addActionListener(this);
		i2 = new JMenuItem("물품관리 시스템 실행");
		i2.addActionListener(this);
		i3 = new JMenuItem("맛집관리 시스템 실행");
		i3.addActionListener(this);
		i4 = new JMenuItem("로그아웃 실행");
		i4.addActionListener(this);
		custom.add(i1); item.add(i2); matjip.add(i3); logout.add(i4);
		mb.add(custom); mb.add(item); mb.add(matjip); 
		mb.add(Box.createHorizontalGlue());//로그아웃을 맨 오른쪽으로 함
		mb.add(logout);
		this.setJMenuBar(mb);
		makePanel();
		this.setSize(800, 600); this.setVisible(true);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	LoginSystem ls;
	void makePanel() {
		card = new CardLayout();
		ls = new LoginSystem(this);
		slide = new JPanel(); slide.setLayout(card);//배치관리자 설정
		slide.add(ls,"로그인");
		slide.add(new InsertDataWindow(),"고객관리");
		slide.add(new InsertItemWindow(),"상품관리");
		slide.add(new InsertMatjipWindow(),"맛집관리");
		card.show(slide, "로그인");//"로그인"이름의 패널을 출력
		this.add("Center", slide);
		//아래. 모든 메뉴를 비활성화 한다. 왜? 로그인하기 전이므로
		custom.setEnabled(false); item.setEnabled(false);
		matjip.setEnabled(false); logout.setEnabled(false);
	}
	public static void main(String[] args) {
		new TotalSystem("종합정보시스템 ver1.0");
	}
}














