package senior;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
class RandomText extends Thread{
	Container container;
	RandomText(Container container){
		this.container = container;//���޹��� ������ �г��� ����
	}
	public void run() {
		while(true) {
			int x=(int)(Math.random()*container.getWidth());
			int y=(int)(Math.random()*container.getHeight());
			JLabel label = new JLabel("ȯ���մϴ�~");
			int rnd = (int)(Math.random()*51)+30;//30~80�� ����
			Font font = new Font("���ü",Font.BOLD,rnd);
			label.setFont(font);//���̺� ��Ʈ ����
			label.setSize(rnd*10, rnd);
			label.setLocation(x, y);
			container.add(label);//�����쿡 ���̺��� ����
			container.repaint();//������ ����
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			container.remove(label);//�����쿡�� ���̺��� ����
			container.repaint();//������ ����
		}//���� �ݺ�
	}
}
public class TextWindow extends JFrame {
	RandomText rt;
	public TextWindow(String str) {
		super(str);
		this.setLayout(null);//��ġ������ ����
		Container c = this.getContentPane();//������ �г� ����
		rt = new RandomText(c);//�����忡 �������г� ����
		rt.start();//������ ����
		this.setBounds(100, 150, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TextWindow("���ڰ� �������� ��µ˴ϴ�.");
	}
}










