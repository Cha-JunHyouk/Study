package senior;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
class RandomBubble extends Thread{
	Container container;
	RandomBubble(Container container){
		this.container = container;//윈도우 화면을 얻어와서 저장
	}//생성자
	public void run() {//스레드의 메인메서드
		while(true) {
			int x = (int)(Math.random()*container.getWidth());
			int y = (int)(Math.random()*container.getHeight());
			int r = (int)(Math.random()*6);//0~5
			ImageIcon icon = null;
			switch(r) {
			case 0:icon=new ImageIcon("src/senior/b0.png");break;
			case 1:icon=new ImageIcon("src/senior/b1.png");break;
			case 2:icon=new ImageIcon("src/senior/b2.png");break;
			case 3:icon=new ImageIcon("src\\senior\\b3.png");break;
			case 4:icon=new ImageIcon("src\\senior\\b4.png");break;
			case 5:icon=new ImageIcon("src\\senior\\b5.png");break;
			}
			JLabel label = new JLabel();//레이블 생성
			label.setIcon(icon);//레이블에 이미지 아이콘 설정
			label.setSize(icon.getIconWidth(), icon.getIconHeight());
			//레이블의 크기를 이미지 아이콘의 크기(가로,세로)로 설정
			label.setLocation(x, y);//레이블의 위치를 설정
			container.add(label);//윈도우 화면에 레이블을 붙임
			container.repaint();//윈도우 화면 갱신
			try {
				Thread.sleep(300);//0.3초대기,즉0.3초 간격으로 풍선출력
			}catch(Exception e) {}
		}
	}
}
public class BubbleWindow extends JFrame {
	RandomBubble rb;
	public BubbleWindow(String str) {
		super(str);
		this.setLayout(null);//배치관리자 해제,즉 좌표를 이용해서 출력
		Container c = this.getContentPane();//윈도우 화면을 변수에 저장
		rb = new RandomBubble(c);//스레드에 윈도우 화면을 넘겨줌
		rb.start();//스레드 시작
		this.setBounds(100, 150, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BubbleWindow("풍선이 무작위로 출력됩니다.");
	}
}








