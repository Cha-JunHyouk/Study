
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PieChartWindow extends JFrame implements ActionListener{
	class PieChart extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			int startAngle = 0;
			for(int i=0; i<data.length; i++) {
				g.setColor(color[i]);//데이터마다 다른색을 지정
				g.drawString(title[i]+" "+
						Math.round(angle[i]*100./360.)+"%", 
						50 + i * 100, 20);
			}//제목을 데이터의 갯수만큼 그린다.
			for(int i=0; i<data.length; i++) {
				g.setColor(color[i]);//데이터마다 다른색을 지정
				g.fillArc(100, 50, 300, 300, startAngle, angle[i]);
				startAngle = startAngle + angle[i];
			}//파이차트를 데이터의 갯수만큼 그린다.
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		JTextField obj = (JTextField)arg0.getSource();
		try {
			int value = Integer.parseInt(obj.getText());
			//엔터를 입력한 텍스트필드에서 값을 읽어온다.
		}catch(Exception e) {
			obj.setText("0");//알파벳이 입력된 경우,0으로 바꾼다.
			JOptionPane.showMessageDialog(this, 
				"데이터는 숫자로 입력하세요.");
		}
		drawPieChart();//파이 차트를 그린다.
	}
	public void drawPieChart() {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			data[i] = Integer.parseInt(inputs[i].getText());
			sum = sum + data[i];//데이터의 합계를 계산
		}
		if(sum == 0) return;//데이터가 없으면, 메서드 종료
		for(int i=0; i<data.length; i++) {
			angle[i] = (int)Math.round(
				(double)data[i]/(double)sum * 360);
		}
		pc.repaint();//패널 갱신
	}
	PieChart pc;
	int[] data = {0,0,0,0};//그래프에서 사용할 데이터
	int[] angle = new int[4];//4개 파이챠트의 각도
	Color[] color = {Color.RED, Color.GREEN, Color.BLUE,
			Color.BLACK};//4개 파이차트에서 사용할 색
	String[] title = {"오전","오후","저녁","새벽"};//4개 파이차트 제목
	JTextField[] inputs = new JTextField[4];
	JPanel pan;
	public PieChartWindow(String str) {
		super(str);
		pan = new JPanel();
		for(int i=0; i<title.length; i++) {
			inputs[i] = new JTextField("0",5);//0을 기본값으로 설정
			inputs[i].addActionListener(this);
			pan.add(new JLabel(title[i])); pan.add(inputs[i]);
		}//텍스트필드를 4개 생성, 패널에 레이블과 텍스트필드를 붙임
		pc = new PieChart();
		this.add("Center", pc);//윈도우 가운데 파이 차트
		this.add("North",pan);//윈도우 위에 패널을 붙임
		this.setBounds(200, 100, 500, 500); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new PieChartWindow("파이그래프 ver1.0");
	}
}












