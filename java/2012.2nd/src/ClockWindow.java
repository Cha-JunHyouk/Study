package senior;

import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class ClockThread extends Thread{
	JLabel label; Calendar calendar;
	ClockThread(JLabel label){
		this.label = label;
	}
	public void run() {
		StringBuffer buffer = new StringBuffer();//��Ʈ������ ����
		while(true) {
			calendar = new GregorianCalendar();//�޷°�ü ����
			if(calendar.get(Calendar.HOUR_OF_DAY) < 10) {
				buffer.append("0"+calendar.get(Calendar.HOUR_OF_DAY)+":");
			}else {
				buffer.append(calendar.get(Calendar.HOUR_OF_DAY)+":");
			}
			if(calendar.get(Calendar.MINUTE)<10) {
				buffer.append("0"+calendar.get(Calendar.MINUTE)+":");
			}else {
				buffer.append(calendar.get(Calendar.MINUTE)+":");
			}
			if(calendar.get(Calendar.SECOND)<10) {
				buffer.append("0"+calendar.get(Calendar.SECOND));
			}else {
				buffer.append(calendar.get(Calendar.SECOND));
			}
			label.setText(buffer.toString());//��Ʈ�����۸� ��Ʈ�����κ�ȯ
			buffer.delete(0, buffer.length());//��Ʈ�����۸� �����.
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}//end of while
	}//end of run
}
public class ClockWindow extends JFrame {
	JLabel today; JPanel right;
	public ClockWindow(String str) {
		super(str);
		right = new JPanel();		today = new JLabel();
		today.setFont(new Font("���ü",Font.ITALIC, 80));
		right.add(today); 
		this.add("Center",right);
		ClockThread ct = new ClockThread(today);//���̺��� �����������
		ct.setDaemon(true);//�ð轺���带 ���󽺷���� ����
		ct.start();//������ ����
		this.setBounds(100, 150, 300, 300); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ClockWindow("���� �ð��� ����մϴ�.");
	}
}









