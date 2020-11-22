import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu2Window extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == i4) {//윈도우 종료 메뉴아이템인 경우
			
		}
	}
	JMenuBar mb;//메뉴바
	JMenu m1,m2,m3,m4;//메뉴바에 들어갈 메뉴
	JMenuItem i1,i2,i3,i4;//메뉴에 들어갈 메뉴아이템
	CardLayout card; JPanel slide;//카드레이아웃사용 패널
	public Menu2Window(String str) {
		super(str);
		mb = new JMenuBar();
		m1 = new JMenu("과일안내SYS");
		m2 = new JMenu("사원관리SYS");
		m3 = new JMenu("음료수 주문 SYS");
		m4 = new JMenu("로그아웃");
		i1 = new JMenuItem("과일안내SYS 실행");
		i2 = new JMenuItem("사원관리SYS 실행");
		i3 = new JMenuItem("음료수 주문 SYS 실행");
		i4 = new JMenuItem("로그아웃 실행");
		m1.add(i1); m2.add(i2); m3.add(i3); m4.add(i4);
		mb.add(m1); mb.add(m2); mb.add(m3); 
		//m4메뉴를 오른쪽 끝으로 이동
		mb.add(Box.createHorizontalGlue());
		//메뉴바에 수평방향의 오른쪽 끝을 위한 설정
		mb.add(m4);
		this.setJMenuBar(mb);//윈도우에 메뉴바 설정
		makePanel();
		this.setSize(800, 500); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		card = new CardLayout();//카드레이아웃 생성
		slide = new JPanel();
		slide.setLayout(card);//패널에 배치관리자 설정
		//slide에 로그인,과일안내,사원관리,음료수주문을 붙임
		slide.add(new LoginSystem(this),"로그인");
		slide.add(new MenuInfo(),"과일안내");
		slide.add(new HRSystem(),"사원관리");
		slide.add(new OrderSystem(),"음료주문");
		card.show(slide, "로그인");
		//"로그인"이름의 패널을 기본으로 출력
		this.add("Center", slide);
		//로그인 전이므로 모든 메뉴를 비활성화 한다.
		m1.setEnabled(false);
		m2.setEnabled(false);
		m3.setEnabled(false);
		m4.setEnabled(false);
	}
	public static void main(String[] args) {
		new Menu2Window("메뉴윈도우 ver2.0");
	}
}










