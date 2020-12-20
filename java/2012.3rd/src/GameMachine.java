package senior;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class NumberThread extends Thread{
	GameMachine gm; JPanel pan;
	NumberThread(GameMachine gm){
		this.gm = gm; pan = gm.center;
	}
	ImageIcon putIcon(int r) {
		ImageIcon icon = null;
		icon = new ImageIcon("src/senior/pic/icon_"+r+".png");
		return icon;//r에 있는 숫자와 일치하는 icon_숫자.png를 리턴
	}
	@Override
	public void run() {
		int count = 0;
		while(true) {
			pan.removeAll();
			JLabel lbl1 = new JLabel();	JLabel lbl2 = new JLabel();
			JLabel lbl3 = new JLabel(); JLabel lbl4 = new JLabel();
			int r1 = (int)(Math.random()*45)+1;
			int r2 = (int)(Math.random()*45)+1;
			int r3 = (int)(Math.random()*45)+1;
			int r4 = (int)(Math.random()*45)+1;
			ImageIcon icon1 = putIcon(r1); lbl1.setIcon(icon1);
			ImageIcon icon2 = putIcon(r2); lbl2.setIcon(icon2);
			ImageIcon icon3 = putIcon(r3); lbl3.setIcon(icon3);
			ImageIcon icon4 = putIcon(r4); lbl4.setIcon(icon4);
			pan.add(lbl1); pan.add(lbl2); pan.add(lbl3); pan.add(lbl4);
			pan.updateUI();
			try {
				Thread.sleep(100);//0.1초 대기
			}catch(Exception e) {}
			count++;
			if(count == 10) break;
		}
	}//end of run
}
public class GameMachine extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		nt = new NumberThread(this); nt.start();
	}
	String title = "게임 머신 ver1.0";
	JPanel center,south; JButton button; NumberThread nt;
	public GameMachine() {
		this.setTitle(title);
		center = new JPanel(); center.setLayout(new FlowLayout());
		south = new JPanel(); button = new JButton(" 번호 돌리기 ");
		button.addActionListener(this); south.add(button);
		this.add("Center", center); this.add("South", south);
		this.setBounds(100, 150, 600, 300); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GameMachine();
	}
}











