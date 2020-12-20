package senior;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class GraphPanel extends JPanel {
	public void paint(Graphics arg0) {
		arg0.drawLine(50, 250, 350, 250);
		for(int cnt=1; cnt<11; cnt++) {
			arg0.drawString(cnt*10+"", 25, 255-20*cnt);
			arg0.drawLine(50, 250-20*cnt, 350, 250-20*cnt);
		}//end of for
		arg0.setColor(Color.RED);
		arg0.fillRect(110, 50, 20, 200);
	}
}
public class Lesson1Test extends JFrame {
	GraphPanel gp;
	public Lesson1Test(String s) {
		super(s);
		gp = new GraphPanel();
		this.add("Center",gp);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Lesson1Test("그래픽의 처리");
	}
}







