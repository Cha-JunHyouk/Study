package senior;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
class RandomBubble extends Thread{
	Container container;
	RandomBubble(Container container){
		this.container = container;//������ ȭ���� ���ͼ� ����
	}//������
	public void run() {//�������� ���θ޼���
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
			JLabel label = new JLabel();//���̺� ����
			label.setIcon(icon);//���̺� �̹��� ������ ����
			label.setSize(icon.getIconWidth(), icon.getIconHeight());
			//���̺��� ũ�⸦ �̹��� �������� ũ��(����,����)�� ����
			label.setLocation(x, y);//���̺��� ��ġ�� ����
			container.add(label);//������ ȭ�鿡 ���̺��� ����
			container.repaint();//������ ȭ�� ����
			try {
				Thread.sleep(300);//0.3�ʴ��,��0.3�� �������� ǳ�����
			}catch(Exception e) {}
		}
	}
}
public class BubbleWindow extends JFrame {
	RandomBubble rb;
	public BubbleWindow(String str) {
		super(str);
		this.setLayout(null);//��ġ������ ����,�� ��ǥ�� �̿��ؼ� ���
		Container c = this.getContentPane();//������ ȭ���� ������ ����
		rb = new RandomBubble(c);//�����忡 ������ ȭ���� �Ѱ���
		rb.start();//������ ����
		this.setBounds(100, 150, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BubbleWindow("ǳ���� �������� ��µ˴ϴ�.");
	}
}








