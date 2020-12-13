package senior;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyCounter extends Thread {
	JLabel label;
	MyCounter(JLabel label){
		this.label = label;//윈도우의 레이블을 받아온다.
	}//생성자
	@Override
	public void run() {
		int count = 0;
		while(count <= 10) {
			label.setText(count+"");
			count++;
			try {
				Thread.sleep(1000);//1초 대기
			}catch(Exception e) {}
		}//무한 반복
	}
}

public class NumberCounter extends JFrame {
	public NumberCounter(String str) {
		super(str);
		JLabel counterLabel = new JLabel();//레이블 생성
		Font font = new Font("고딕체",Font.BOLD, 50);//폰트 생성
		counterLabel.setFont(font);//레이블에 폰트 적용
		this.add("Center",counterLabel);
		
		MyCounter counter = new MyCounter(counterLabel);
		counter.start();
		
		this.setBounds(100, 150, 500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new NumberCounter("스레드 카운트 ver1.0");
	}
}














