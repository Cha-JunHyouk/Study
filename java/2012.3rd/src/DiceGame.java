package senior;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class DiceThread extends Thread {
	DiceGame dg; JPanel panel;
	DiceThread(DiceGame f){
		dg = f;
		panel = dg.center;//윈도우의 가운데 패널을 저장
	}
	@Override
	public void run() {
		int count = 0;//주사위를 돌리는 횟수
		while(true) {
			panel.removeAll();//패널 안에 있는 내용을 지운다.
			JLabel lbl1 = new JLabel();//첫번째 주사위이미지용 레이블
			int r = (int)(Math.random()*6+1);//첫번째 주사위 눈금
			ImageIcon icon1 = putIcon1(r);//주사위 눈금이미지 생성
			lbl1.setIcon(icon1);//레이블에 이미지아이콘 설정
			lbl1.setSize(icon1.getIconWidth(), icon1.getIconHeight());
			panel.add(lbl1);//패널에 레이블을 붙임
			JLabel lbl2 = new JLabel();
			int r2 = (int)(Math.random()*6+1);//두번째 주사위 눈금
			ImageIcon icon2 = putIcon2(r2);//주사위 눈금이미지 생성
			lbl2.setIcon(icon2);//레이블에 이미지아이콘 설정
			lbl2.setSize(icon2.getIconWidth(), icon2.getIconHeight());
			panel.add(lbl2);//패널에 레이블을 붙임
			panel.updateUI();//패널 내용이 변경되었으므로 갱신
			try {
				Thread.sleep(100);//0.1초 대기
			}catch(Exception e) {}
			count++;//횟수 증가
			if(count == 10) {
				String title = "주사위 게임 ver2.0 ";//기존 윈도우제목
				if(r > r2) {
					title = title + " 왼쪽 승리!!!";
				}else if(r < r2) {
					title = title + " 오른쪽 승리!!!";
				}else {
					title = title + " 무승부!!!";
				}
				dg.setTitle(title);//윈도우의 제목을 새로 설정
				break;//10회 이면 반복종료
			}
		}//end of while
	}//end of run
	ImageIcon putIcon2(int r) {
	//r에 있는 숫자에 해당하는 이미지아이콘을 생성하고 리턴한다.
		ImageIcon icon = null;
		switch(r) {
		case 1:icon=new ImageIcon("src/senior/one.png");break;
		case 2:icon=new ImageIcon("src/senior/two.png");break;
		case 3:icon=new ImageIcon("src/senior/three.png");break;
		case 4:icon=new ImageIcon("src/senior/four.png");break;
		case 5:icon=new ImageIcon("src/senior/five.png");break;
		case 6:icon=new ImageIcon("src/senior/siz.png");break;
		}
		return icon;
	}
	ImageIcon putIcon1(int r) {
	//r에 있는 숫자에 해당하는 이미지아이콘을 생성하고 리턴한다.
		ImageIcon icon = null;
		switch(r) {
		case 1:icon=new ImageIcon("src/senior/dice1.png");break;
		case 2:icon=new ImageIcon("src/senior/dice2.png");break;
		case 3:icon=new ImageIcon("src/senior/dice3.png");break;
		case 4:icon=new ImageIcon("src/senior/dice4.png");break;
		case 5:icon=new ImageIcon("src/senior/dice5.png");break;
		case 6:icon=new ImageIcon("src/senior/dice6.png");break;
		}
		return icon;
	}
}//end of thread
public class DiceGame extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dt = new DiceThread(this);//스레드 생성
		dt.start();//스레드 시작
	}
	JPanel center, south; JButton button; DiceThread dt;
	public DiceGame(String str) {
		super(str);
		center = new JPanel();
		center.setLayout(new FlowLayout());
		south = new JPanel();
		button = new JButton(" 시작 ");
		button.addActionListener(this);
		south.add(button); 
		this.add("Center", center);
		this.add("South", south);
		this.setBounds(100, 150, 800, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new DiceGame("주사위 게임 ver2.0");
	}
}












