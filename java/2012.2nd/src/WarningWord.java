package senior;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickWord extends JLabel implements Runnable{
	int delay;
	FlickWord(String text, int delay){
		super(text);//문자열을 조상(JLabel)으로 전달
		this.delay = delay;
		this.setOpaque(true);//배경색 변경이 가능하도록 설정
		Thread thread = new Thread(this);
		thread.start();//현재 스레드 시작
	}
	public void run() {
		int n = 0;//색 변경을 위한 변수
		while(true) {
			if(n == 0) {
				this.setBackground(Color.RED);//적색으로 배경색 설정
				n = 1;
			}else {
				this.setBackground(Color.YELLOW);//노란색으로 배경설정
				n = 0;
			}
			try {
				Thread.sleep(delay);//입력된 수만큼 대기
			}catch(Exception e) {}
		}//무한반복하면서 색을 변경한다.
	}
}
public class WarningWord extends JFrame {
	JLabel label; Font font; FlickWord word;
	public WarningWord(String str) {
		super(str);
		font = new Font("고딕체",Font.BOLD, 60);
		this.setLayout(new FlowLayout());//배치관리자 설정
		word = new FlickWord("작업 중 접근하지 마시오", 500);//0.5초간격
		word.setFont(font);
		label = new JLabel("작업 중 접근하지 마시오");
		label.setFont(font);
		this.add(word); this.add(label);
		this.setBounds(100, 150, 400, 300); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new WarningWord("깜박이는 글자 ver1.0");
	}

}












