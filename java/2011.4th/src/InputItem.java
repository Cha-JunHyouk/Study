package senior;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputItem extends JPanel {
	String[] titles = {"��ǰ��ȣ","��ǰ�̸�","��ǰ�Ұ�",
			"��ǰ����","��ǰ������"};
	JLabel[] lbls; JTextField[] inputs; JPanel[] pans;
	Font font;
	public InputItem() {//������
		font = new Font("���ü",Font.BOLD, 26);
		makeLabel();
		makeTextField();
		makePanel();
	}
	private void makePanel() {
		this.setLayout(new GridLayout(7,1));//7��1��
		pans = new JPanel[7];//7���� ���� �гι迭
		//ù��° ��� ���������� ����.
		pans[0] = new JPanel(); pans[6] = new JPanel();
		pans[0].add(new JLabel()); 
		pans[6].add(new JLabel());
		pans[1] = new JPanel();//2��
		pans[1].add(lbls[0]); pans[1].add(inputs[0]);
		pans[2] = new JPanel();//3��
		pans[2].add(lbls[1]); pans[2].add(inputs[1]);
		pans[3] = new JPanel();//4��
		pans[3].add(lbls[2]); pans[3].add(inputs[2]);
		pans[4] = new JPanel();//5��
		pans[4].add(lbls[3]); pans[4].add(inputs[3]);
		pans[5] = new JPanel();//6��
		pans[5].add(lbls[4]); pans[5].add(inputs[4]);
		//1����� 7���� ���� �г�(7��1��)�� ���δ�.
		for(int i=0; i<pans.length; i++) {
			this.add(pans[i]);
		}
	}
	private void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
			lbls[i].setFont(font);//��Ʈ ����
		}
	}
	private void makeTextField() {
		inputs = new JTextField[titles.length];
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = new JTextField(20);
			inputs[i].setFont(font);//��Ʈ����
		}
	}
}















