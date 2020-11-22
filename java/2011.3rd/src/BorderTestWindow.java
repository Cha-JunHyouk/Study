import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class BorderTestWindow extends JFrame {
	JPanel[] pans = new JPanel[9]; Font font;
	JLabel[] lbls = new JLabel[9];
	public BorderTestWindow(String str) {
		super(str);
		font = new Font("����ü",Font.BOLD, 30);
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel((i+1)+"�� �г��Դϴ�.");
			lbls[i].setFont(font);//��Ʈ ����
		}//���̺� 8�� ����
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			pans[i].add(lbls[i]);//�гο� ���̺��� ����
		}//�г� 8�� ����(�гο� ��輱�� ������ ����)
		//�׵θ��� ���� ��輱(Border)��ü
		EmptyBorder b1 = new EmptyBorder(5,3,5,3);
		//5:���ʿ���,3:���ʿ���,5:�Ʒ�����,3:�����ʿ���
		pans[0].setBorder(b1);//ù��° �гο� ��輱����
		//�׵θ����� �����ִ� ��輱 ��ü
		LineBorder b2 = new LineBorder(Color.RED, 3);
		//����, �β� 3
		pans[1].setBorder(b2);//�ι�° �гο� ��輱����
		//Ȩ�� �Ŀ� �ִ� ��輱 ��ü
		EtchedBorder b3 = new EtchedBorder();
		pans[2].setBorder(b3);//����° �гο� ��輱����
		//Ƣ����� ������ ��輱 ��ü
		BevelBorder b4 = new BevelBorder(
				BevelBorder.RAISED);
		pans[3].setBorder(b4);//�׹�° �гο� ��輱����
		//�� ������ ��輱 ��ü
		SoftBevelBorder b5 = new SoftBevelBorder(
				SoftBevelBorder.LOWERED);
		pans[4].setBorder(b5);//�ټ���° �гο� ��輱����
		//�׵θ��� �������� ũ�⸦ �����ϴ� ��輱 ��ü
		MatteBorder b6 = new MatteBorder(5,10,15,20,
				Color.CYAN);
		//5:���β�,10:���ʵβ�,15:�Ʒ��β�,20:�����ʵβ�
		pans[5].setBorder(b6);//������°�гο� ��輱����
		//������ ���� �� �ִ� ��輱 ��ü
		TitledBorder b7 = new TitledBorder("����");
		pans[6].setBorder(b7);
		//������ ��ġ�� �ٲ� �� �ִ�.
		TitledBorder b8 = new TitledBorder(
			new EtchedBorder(), "����", 
			TitledBorder.RIGHT, TitledBorder.TOP,
			new Font("�ü�ü",Font.BOLD,12),
			Color.BLUE);
		pans[7].setBorder(b8);
		//��輱�� ��� ��Ÿ���� �ִ� ��輱��ü
		//���� ��輱�� �����. �ּ� �� ��
		SoftBevelBorder sbb = new SoftBevelBorder(
				SoftBevelBorder.RAISED);
		TitledBorder tb = new TitledBorder("����");
		CompoundBorder b9 = new CompoundBorder(sbb,tb);
		//���񺸴��� �������� ������ ����
		pans[8].setBorder(b9);
		
		JPanel center = new JPanel();
		for(int i=0; i<=8; i++) {
			center.add(pans[i]);
		}
		this.add("Center",center); 
		this.setSize(500, 300); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BorderTestWindow("�پ��� ��輱 ver1.0");
	}

}












