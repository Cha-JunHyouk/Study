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
		StringBuffer buffer = new StringBuffer();//스트링버퍼 생성
		while(true) {
			calendar = new GregorianCalendar();//달력객체 생성
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
			label.setText(buffer.toString());//스트링버퍼를 스트링으로변환
			buffer.delete(0, buffer.length());//스트링버퍼를 지운다.
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
		today.setFont(new Font("고딕체",Font.ITALIC, 80));
		right.add(today); 
		this.add("Center",right);
		ClockThread ct = new ClockThread(today);//레이블을 스레드로전달
		ct.setDaemon(true);//시계스레드를 데몬스레드로 설정
		ct.start();//스레드 시작
		this.setBounds(100, 150, 300, 300); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ClockWindow("현재 시간을 출력합니다.");
	}
}









