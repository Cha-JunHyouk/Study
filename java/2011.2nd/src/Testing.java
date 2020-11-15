package chajh;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Testing extends JFrame 
	implements ActionListener,ItemListener{
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == chb[0]) {
			if(chb[0].isSelected()) {
				combo[0].setEnabled(true);//Ȱ��ȭ
			}else {
				combo[0].setEnabled(false);//��Ȱ��ȭ
				elementATotal = 0;
				txt[0].setText(elementATotal+"��");
			}
		}else if(obj == chb[1]) {
			if(chb[1].isSelected()) {//���õ� ���
				combo[1].setEnabled(true);//Ȱ��ȭ	
			}else {//������ ������ ���
				combo[1].setEnabled(false);//��Ȱ��ȭ
				elementBTotal = 0;
				txt[1].setText(elementBTotal+"��");
			}
		}else if(obj == chb[2]) {
			if(chb[2].isSelected()) {//���õ� ���
				combo[2].setEnabled(true);//Ȱ��ȭ
			}else {//���� ������ ���
				combo[2].setEnabled(false);//Ȱ��ȭ
				elementCTotal = 0;
				txt[2].setText(elementCTotal+"��");
			}
		}//if�� ��
		total = elementATotal+elementBTotal+
					elementCTotal;
		txt[3].setText(total+"��");
	}
	int elementATotal = 0;
	int elementBTotal = 0;
	int elementCTotal = 0;
	int total = 0;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btns[0]) {//Ȯ�� ��ư�� �������
			total=0;//�Ѿ��� ���� ����
			//� ���Ḧ �����ߴ����� ã�´�.
			if(chb[0].isSelected()) {
			//ù��° ���ᰡ ���õ� ���
				int index = combo[0].getSelectedIndex();
				index=index+1;//������ ����
				elementATotal = index * NESCAFE;
				total = total + elementATotal;
				txt[0].setText(elementATotal+"��");//�Ұ����
			}
			if(chb[1].isSelected()) {
			//�ι�° ���ᰡ ���õ� ���
				int index = combo[1].getSelectedIndex();
				index=index+1;//������ ����
				elementBTotal = index * ESPRESSO;
				total = total + elementBTotal;
				txt[1].setText(elementBTotal+"��");//�Ұ����
			}
			if(chb[2].isSelected()) {
			//����° ���ᰡ ���õ� ���
				int index = combo[2].getSelectedIndex();
				index=index+1;//������ ����
				elementCTotal = index * AMERICANO;
				total = total + elementCTotal;
				txt[2].setText(elementCTotal+"��");//�Ұ����
			}
			//�Ѿ� ���
			txt[3].setText(total+"��");//�Ѿ����
		}else if(obj == btns[1]) {//��ҹ�ư
			txt[0].setText("");//�׽�ī��Ұ�����
			txt[1].setText("");//���������ҼҰ�����
			txt[2].setText("");//�Ƹ޸�ī��Ұ�����
			txt[3].setText("");//�Ѿ�����
			
			combo[0].setSelectedIndex(0);
			combo[1].setSelectedIndex(0);
			combo[2].setSelectedIndex(0);
			//��� �޺��ڽ��� ������ ù��°�� ����
			chb[0].setSelected(false);
			chb[1].setSelected(false);
			chb[2].setSelected(false);
			//��� üũ�ڽ��� ������ ������ ����
		}
	}
	final int NESCAFE = 2000;//�׽�ī���� ����
	final int ESPRESSO = 1500;//������������ ����
	final int AMERICANO = 1000;//�Ƹ޸�ī���� ����
	JLabel[] lbls; JToggleButton[] chb;
	ButtonGroup[] group; JButton[] btns;
	JTextField[] txt; JComboBox[] combo; 
	JPanel[] pans;
	String[] labelTitles={"��ǰ��","�� ��","�� ��",
		"��������","����Ʈ ����","�� ��"};
	String[] checkTitles= {"�׽�ī��","����������",
			"�Ƹ޸�ī��","����","�ſ�ī��",
			"��","�ƴϿ�"};
	GridLayout gl;
	void makeLabel() {
		lbls = new JLabel[6];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(labelTitles[i]);
		}
	}
	void makeCheckbox() {
		chb = new JToggleButton[7];
		group = new ButtonGroup[2];
		group[0]= new ButtonGroup();//�������ܿ�
		group[1]=new ButtonGroup();//����Ʈ ������
		for(int i=0; i<chb.length; i++) {
			switch(i) {
			case 3://���ݿ� 
			case 4://�ſ�ī���
				chb[i]=new JRadioButton(
					checkTitles[i],false);
				group[0].add(chb[i]);
				break;
			case 5://����Ʈ ����, ��
			case 6://����Ʈ ����, �ƴϿ�
				chb[i]=new JRadioButton(
					checkTitles[i],false);
				group[1].add(chb[i]);
				break;
			default :
				chb[i]=new JCheckBox(
					checkTitles[i],false);
				chb[i].addItemListener(this);
			}//switch�� ��
		}
	}
	void makeTextfield() {
		txt=new JTextField[4];
		for(int i=0; i<txt.length; i++) {
			txt[i]=new JTextField(10);
		}
	}
	void makeCombobox() {
		combo = new JComboBox[3];
		for(int i=0; i<combo.length; i++) {
			combo[i] = new JComboBox();
			for(int j=1; j<=10; j++) {
				combo[i].addItem(j+"��");
			}//�޺��ڽ����� 1���� 10���� ä��
			combo[i].setEnabled(false);//��Ȱ��ȭ
		}//�޺��ڽ� 3�� ����
	}
	void makePanel() {
		pans = new JPanel[9];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
		}
		//1��
		pans[0].add(lbls[0]);pans[0].add(chb[0]);
		pans[0].add(chb[1]);pans[0].add(chb[2]);
		//2��
		pans[1].add(lbls[1]);pans[1].add(combo[0]);
		pans[1].add(combo[1]);pans[1].add(combo[2]);
		//3��
		pans[2].add(lbls[2]);pans[2].add(txt[0]);
		pans[2].add(txt[1]);pans[2].add(txt[2]);
		//4��
		pans[3].add(lbls[3]);pans[3].add(chb[3]);
		pans[3].add(chb[4]);
		//5��
		pans[4].add(lbls[4]);pans[4].add(chb[5]);
		pans[4].add(chb[6]);
		//6��
		pans[5].add(lbls[5]); pans[5].add(txt[3]);
		pans[5].setBackground(Color.GREEN);
		//7��,8��
		pans[6].add(new JLabel());
		pans[7].add(new JLabel());
		btns = new JButton[2];
		btns[0] = new JButton(" Ȯ �� ");
		btns[0].addActionListener(this);
		btns[1] = new JButton(" �� �� ");
		btns[1].addActionListener(this);
		//9��
		pans[8].add(btns[0]);pans[8].add(btns[1]);
		pans[8].setBackground(Color.ORANGE);
	}
	void makeWindow() {
		for(int i=0; i<pans.length; i++) {
			this.add(pans[i]);
		}//�г�9���� �����쿡 ����
		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public Testing(String str) {
		super(str);
		gl = new GridLayout(9,1,5,5);
		this.setLayout(gl);
		makeLabel();
		makeCheckbox();
		makeTextfield();
		makeCombobox();
		makePanel(); makeWindow();
	}
	public static void main(String[] args) {
		new CafeSystem("Testing");
	}
}








