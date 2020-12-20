package senior;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
class BarchartPanel extends JPanel{
	//막대그래프를 그린다. BarcharWindow에 있는 data1,data2,data3이 필요하다.
	int d1,d2,d3;
	void setData(int n1, int n2, int n3) {
		d1 = n1; d2 = n2; d3 = n3;//수신한 정수 3개를 d1부터 d3에 넣는다.
	}
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());//패널을 깨끝이 지운다.
		g.drawLine(50, 250, 350, 250);
		for(int cnt=1; cnt<11; cnt++) {
			g.drawString(cnt*10+"", 25, 255-20*cnt);
			g.drawLine(50, 250-20*cnt, 350, 250-20*cnt);
		}//end of for
		g.setColor(Color.RED);
		g.drawLine(50, 20, 50, 250);//수직선을 그린다.
		g.drawString("10월", 100, 270); g.drawString("11월", 200, 270);
		g.drawString("12월", 300, 270);//막대그래프의 제목을 그린다.
		if(d1 > 0) {g.fillRect(110, 250-d1*2, 10, d1*2);}
		if(d2 > 0) {g.fillRect(210, 250-d2*2, 10, d2*2);}
		if(d3 > 0) {g.fillRect(310, 250-d3*2, 10, d3*2);}
	}
}
public class BarchartWindow extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int data1 = 0, data2 = 0, data3 = 0;
		try {
			if(! inputs[0].getText().equals("")) {
				data1 = Integer.parseInt(inputs[0].getText());
			}
			if(! inputs[1].getText().equals("")) {
				data2 = Integer.parseInt(inputs[1].getText());
			}
			if(! inputs[2].getText().equals("")) {
				data3 = Integer.parseInt(inputs[2].getText());
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "숫자만 입력해 주세요.");
		}
		bp = new BarchartPanel();
		this.add("Center",bp);
		bp.updateUI();//패널 자체를 갱신
		bp.setData(data1, data2, data3);
	}
	JButton btn; JLabel[] titles; JTextField[] inputs;
	JPanel panel; BarchartPanel bp;
	void makePanel() {
		panel = new JPanel();
		for(int i=0; i<titles.length; i++) {
			panel.add(titles[i]); panel.add(inputs[i]);
		}
		panel.add(btn);
	}
	void makeLabel() {
		titles = new JLabel[3];
		titles[0] = new JLabel("10월"); titles[1]=new JLabel("11월");
		titles[2] = new JLabel("12월");
	}
	void makeTextField() {
		inputs = new JTextField[3]; inputs[0] = new JTextField(3);
		inputs[1] = new JTextField(3); inputs[2] = new JTextField(3);
	}
	public BarchartWindow(String str) {
		super(str);
		btn = new JButton(" 막대 그래프 그리기 "); btn.addActionListener(this);
		makeLabel();
		makeTextField();
		makePanel();
		//bp = new BarchartPanel();
		panel.setBackground(Color.ORANGE);
		//this.add("Center", bp);
		this.add("South", panel);
		this.setSize(500,400); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BarchartWindow("막대그래프 ver1.0");
	}
}





