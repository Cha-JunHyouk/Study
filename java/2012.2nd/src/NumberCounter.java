package senior;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyCounter extends Thread {
	JLabel label;
	MyCounter(JLabel label){
		this.label = label;//�������� ���̺��� �޾ƿ´�.
	}//������
	@Override
	public void run() {
		int count = 0;
		while(count <= 10) {
			label.setText(count+"");
			count++;
			try {
				Thread.sleep(1000);//1�� ���
			}catch(Exception e) {}
		}//���� �ݺ�
	}
}

public class NumberCounter extends JFrame {
	public NumberCounter(String str) {
		super(str);
		JLabel counterLabel = new JLabel();//���̺� ����
		Font font = new Font("���ü",Font.BOLD, 50);//��Ʈ ����
		counterLabel.setFont(font);//���̺� ��Ʈ ����
		this.add("Center",counterLabel);
		
		MyCounter counter = new MyCounter(counterLabel);
		counter.start();
		
		this.setBounds(100, 150, 500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new NumberCounter("������ ī��Ʈ ver1.0");
	}
}














