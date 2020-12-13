package senior;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickWord extends JLabel implements Runnable{
	int delay;
	FlickWord(String text, int delay){
		super(text);//���ڿ��� ����(JLabel)���� ����
		this.delay = delay;
		this.setOpaque(true);//���� ������ �����ϵ��� ����
		Thread thread = new Thread(this);
		thread.start();//���� ������ ����
	}
	public void run() {
		int n = 0;//�� ������ ���� ����
		while(true) {
			if(n == 0) {
				this.setBackground(Color.RED);//�������� ���� ����
				n = 1;
			}else {
				this.setBackground(Color.YELLOW);//��������� ��漳��
				n = 0;
			}
			try {
				Thread.sleep(delay);//�Էµ� ����ŭ ���
			}catch(Exception e) {}
		}//���ѹݺ��ϸ鼭 ���� �����Ѵ�.
	}
}
public class WarningWord extends JFrame {
	JLabel label; Font font; FlickWord word;
	public WarningWord(String str) {
		super(str);
		font = new Font("���ü",Font.BOLD, 60);
		this.setLayout(new FlowLayout());//��ġ������ ����
		word = new FlickWord("�۾� �� �������� ���ÿ�", 500);//0.5�ʰ���
		word.setFont(font);
		label = new JLabel("�۾� �� �������� ���ÿ�");
		label.setFont(font);
		this.add(word); this.add(label);
		this.setBounds(100, 150, 400, 300); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new WarningWord("�����̴� ���� ver1.0");
	}

}












