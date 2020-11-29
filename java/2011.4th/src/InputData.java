package senior;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InputData extends JPanel {
	JTextField[] inputs; JLabel[] lbls; JPanel[] pans;
	String[] titles = {"����","��ȣ","����","�ּ�","�̸�",
		"��ȭ��ȣ","���ڸ�"};
	public InputData() {
		this.setLayout(new GridLayout(9,1));//9��1��
		lbls = new JLabel[titles.length];
		inputs = new JTextField[titles.length];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
		}//���̺�7�� ����
		for(int i=0; i<inputs.length; i++) {
			if(i==1) {
				inputs[i]= new JPasswordField(20);
			}else {
				inputs[i]= new JTextField(20);
			}
		}//�׽�Ʈ�ʵ�(�׽�Ʈ�Է�â)7�� ����
		pans = new JPanel[7];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			pans[i].add(lbls[i]);//�гο� ���̺� ����
			pans[i].add(inputs[i]);//�гο� �Է�â ����
		}//�г� 7�� ����
		this.add(new JLabel());//1��
		for(int i=0; i<pans.length; i++) {
			this.add(pans[i]);//2��~8��
		}
		this.add(new JLabel());//9��
	}
}












