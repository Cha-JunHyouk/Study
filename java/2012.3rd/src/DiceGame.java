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
		panel = dg.center;//�������� ��� �г��� ����
	}
	@Override
	public void run() {
		int count = 0;//�ֻ����� ������ Ƚ��
		while(true) {
			panel.removeAll();//�г� �ȿ� �ִ� ������ �����.
			JLabel lbl1 = new JLabel();//ù��° �ֻ����̹����� ���̺�
			int r = (int)(Math.random()*6+1);//ù��° �ֻ��� ����
			ImageIcon icon1 = putIcon1(r);//�ֻ��� �����̹��� ����
			lbl1.setIcon(icon1);//���̺� �̹��������� ����
			lbl1.setSize(icon1.getIconWidth(), icon1.getIconHeight());
			panel.add(lbl1);//�гο� ���̺��� ����
			JLabel lbl2 = new JLabel();
			int r2 = (int)(Math.random()*6+1);//�ι�° �ֻ��� ����
			ImageIcon icon2 = putIcon2(r2);//�ֻ��� �����̹��� ����
			lbl2.setIcon(icon2);//���̺� �̹��������� ����
			lbl2.setSize(icon2.getIconWidth(), icon2.getIconHeight());
			panel.add(lbl2);//�гο� ���̺��� ����
			panel.updateUI();//�г� ������ ����Ǿ����Ƿ� ����
			try {
				Thread.sleep(100);//0.1�� ���
			}catch(Exception e) {}
			count++;//Ƚ�� ����
			if(count == 10) {
				String title = "�ֻ��� ���� ver2.0 ";//���� ����������
				if(r > r2) {
					title = title + " ���� �¸�!!!";
				}else if(r < r2) {
					title = title + " ������ �¸�!!!";
				}else {
					title = title + " ���º�!!!";
				}
				dg.setTitle(title);//�������� ������ ���� ����
				break;//10ȸ �̸� �ݺ�����
			}
		}//end of while
	}//end of run
	ImageIcon putIcon2(int r) {
	//r�� �ִ� ���ڿ� �ش��ϴ� �̹����������� �����ϰ� �����Ѵ�.
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
	//r�� �ִ� ���ڿ� �ش��ϴ� �̹����������� �����ϰ� �����Ѵ�.
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
		dt = new DiceThread(this);//������ ����
		dt.start();//������ ����
	}
	JPanel center, south; JButton button; DiceThread dt;
	public DiceGame(String str) {
		super(str);
		center = new JPanel();
		center.setLayout(new FlowLayout());
		south = new JPanel();
		button = new JButton(" ���� ");
		button.addActionListener(this);
		south.add(button); 
		this.add("Center", center);
		this.add("South", south);
		this.setBounds(100, 150, 800, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new DiceGame("�ֻ��� ���� ver2.0");
	}
}












