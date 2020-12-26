
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
				g.setColor(color[i]);//�����͸��� �ٸ����� ����
				g.drawString(title[i]+" "+
						Math.round(angle[i]*100./360.)+"%", 
						50 + i * 100, 20);
			}//������ �������� ������ŭ �׸���.
			for(int i=0; i<data.length; i++) {
				g.setColor(color[i]);//�����͸��� �ٸ����� ����
				g.fillArc(100, 50, 300, 300, startAngle, angle[i]);
				startAngle = startAngle + angle[i];
			}//������Ʈ�� �������� ������ŭ �׸���.
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		JTextField obj = (JTextField)arg0.getSource();
		try {
			int value = Integer.parseInt(obj.getText());
			//���͸� �Է��� �ؽ�Ʈ�ʵ忡�� ���� �о�´�.
		}catch(Exception e) {
			obj.setText("0");//���ĺ��� �Էµ� ���,0���� �ٲ۴�.
			JOptionPane.showMessageDialog(this, 
				"�����ʹ� ���ڷ� �Է��ϼ���.");
		}
		drawPieChart();//���� ��Ʈ�� �׸���.
	}
	public void drawPieChart() {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			data[i] = Integer.parseInt(inputs[i].getText());
			sum = sum + data[i];//�������� �հ踦 ���
		}
		if(sum == 0) return;//�����Ͱ� ������, �޼��� ����
		for(int i=0; i<data.length; i++) {
			angle[i] = (int)Math.round(
				(double)data[i]/(double)sum * 360);
		}
		pc.repaint();//�г� ����
	}
	PieChart pc;
	int[] data = {0,0,0,0};//�׷������� ����� ������
	int[] angle = new int[4];//4�� ����íƮ�� ����
	Color[] color = {Color.RED, Color.GREEN, Color.BLUE,
			Color.BLACK};//4�� ������Ʈ���� ����� ��
	String[] title = {"����","����","����","����"};//4�� ������Ʈ ����
	JTextField[] inputs = new JTextField[4];
	JPanel pan;
	public PieChartWindow(String str) {
		super(str);
		pan = new JPanel();
		for(int i=0; i<title.length; i++) {
			inputs[i] = new JTextField("0",5);//0�� �⺻������ ����
			inputs[i].addActionListener(this);
			pan.add(new JLabel(title[i])); pan.add(inputs[i]);
		}//�ؽ�Ʈ�ʵ带 4�� ����, �гο� ���̺�� �ؽ�Ʈ�ʵ带 ����
		pc = new PieChart();
		this.add("Center", pc);//������ ��� ���� ��Ʈ
		this.add("North",pan);//������ ���� �г��� ����
		this.setBounds(200, 100, 500, 500); this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new PieChartWindow("���̱׷��� ver1.0");
	}
}












