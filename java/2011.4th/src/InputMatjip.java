package senior;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputMatjip extends JPanel {
	String[] titles= {"������ȣ","�����̸�","�����ּ�",
			"��ȭ��ȣ","�ڵ��� ��ȣ"};
	JLabel[] lbls; JTextField[] inputs; JPanel[] pans;
	Font font;
	public InputMatjip() {//������
		font=new Font("���ü",Font.BOLD, 26);
		makeLabel();
		makeTextField();
		makePanel();
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];//�迭����
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
			lbls[i].setFont(font);//���̺� ��Ʈ ����
		}//JLabel ����
	}
	void makeTextField() {
		inputs = new JTextField[titles.length];
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = new JTextField(20);
			inputs[i].setFont(font);//�ؽ�Ʈ�ʵ忡 ��Ʈ����
		}
	}
	void makePanel() {
		pans = new JPanel[titles.length];
		this.setLayout(new GridLayout(5,1));//5��1��
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			pans[i].add(lbls[i]);//�гο� ���̺� ����
			pans[i].add(inputs[i]);//�гο� �ؽ�Ʈ�ʵ����
			this.add(pans[i]);//���� �гο� ������ �гκ���
		}
	}
}












