package chajh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class MyListener implements ActionListener{
	MyListener(Lesson1 le1){
		l1 = le1;
	}
	Lesson1 l1;
	public void actionPerformed(ActionEvent e) {
		l1.lbl.setText("클릭");
	}
}
public class Lesson1 extends JFrame {
	JButton btn; JPanel pan; JLabel lbl;
	public Lesson1(String str) {
		super(str);
		lbl = new JLabel();
		btn = new JButton(" OK ");
		btn.addActionListener(new MyListener(this));
		pan = new JPanel();
		pan.add(btn);
		this.add("South",lbl);
		this.add("Center", pan);
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Lesson1("이벤트 처리");
	}
}








