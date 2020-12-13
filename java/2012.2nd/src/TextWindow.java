package senior;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
class RandomText extends Thread{
	Container container;
	RandomText(Container container){
		this.container = container;//전달받은 윈도우 패널을 저장
	}
	public void run() {
		while(true) {
			int x=(int)(Math.random()*container.getWidth());
			int y=(int)(Math.random()*container.getHeight());
			JLabel label = new JLabel("환영합니다~");
			int rnd = (int)(Math.random()*51)+30;//30~80중 난수
			Font font = new Font("고딕체",Font.BOLD,rnd);
			label.setFont(font);//레이블에 폰트 적용
			label.setSize(rnd*10, rnd);
			label.setLocation(x, y);
			container.add(label);//윈도우에 레이블을 붙임
			container.repaint();//윈도우 갱신
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			container.remove(label);//윈도우에서 레이블을 삭제
			container.repaint();//윈도우 갱신
		}//무한 반복
	}
}
public class TextWindow extends JFrame {
	RandomText rt;
	public TextWindow(String str) {
		super(str);
		this.setLayout(null);//배치관리자 해제
		Container c = this.getContentPane();//윈도우 패널 저장
		rt = new RandomText(c);//스레드에 윈도우패널 전달
		rt.start();//스레드 시작
		this.setBounds(100, 150, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TextWindow("문자가 무작위로 출력됩니다.");
	}
}










