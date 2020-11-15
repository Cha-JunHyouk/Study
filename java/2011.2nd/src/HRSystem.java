package chajh;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class IdCheckWindow extends JFrame {
	IdCheckWindow(){
		this.setSize(100, 80);
		this.add("Center",
				new JLabel("��밡���մϴ�."));
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE);
	}
}
public class HRSystem extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == idCheck) {//�ߺ��˻��ư�� Ŭ��
			new IdCheckWindow();
			//�ߺ��˻� ����
//			JOptionPane.showMessageDialog(
//					this, "��밡���մϴ�.");
		}
	}
	String[] labelTitles = {"���","�̸�","����",
			"�μ�","�ּ�","�Ի���","����"};
	JLabel[] labels; JTextField[] inputs;
	JRadioButton[] gender; ButtonGroup group;
	JComboBox[] combo; 
	String[] deptTitles = {"������","ȫ����",
			"���ߺ�","�ѹ���","��ȹ��"};
	JButton[] btns; JButton idCheck;//����ߺ���ȸ
	String[] btnsTitles = {" ���� "," ���� ",
			" ���� "," ��ȸ ","�����"};
	Font font; JPanel[] panels; 
	JPanel center,south;
	public HRSystem(String str) {
		super(str);
		makeLabel();
		makeTextField();
		makeComboBox();
		makeRadio();
		makeButton();
		makePanel();
		makeWindow();
	}
	void makeWindow() {
		this.add("Center",center);
		this.add("South", south);
		this.setSize(800, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		panels = new JPanel[7];
		//���,�̸�,����,�μ�,�ּ�,�Ի���,����
		center=new JPanel(); south=new JPanel();
		center.setLayout(new GridLayout(7,1));
		south.setBackground(Color.GREEN);
		for(int i=0;i<panels.length;i++) {
			panels[i] = new JPanel();//�гλ���
			panels[i].add(labels[i]);//���̺����
			panels[i].setBackground(Color.ORANGE);
			switch(i) {
			case 0://1��
				panels[i].add(inputs[i]);
				panels[i].add(idCheck); break;
			case 1://2��
				panels[i].add(inputs[i]); break;
			case 2://3��
				panels[i].add(gender[0]);
				panels[i].add(gender[1]); break;
			case 3://4��
				panels[i].add(combo[0]);break;
			case 4://5��
				panels[i].add(inputs[2]); break;
			case 5://6��
				panels[i].add(new JButton("�޷�"));
				break;
			case 6://7��
				panels[i].add(combo[1]);
				panels[i].add(combo[2]);
				panels[i].add(combo[3]);
				panels[i].add(new JButton("Ȯ��"));
			}//switch�� ��
			center.add(panels[i]);
		}//for�� ��
		for(int i=0; i<btns.length; i++) {
			south.add(btns[i]);
		}//��ư�� south�� ����
	}
	void makeRadio() {
		gender = new JRadioButton[2];
		gender[0] = new JRadioButton("����");
		gender[1] = new JRadioButton("����");
		group = new ButtonGroup();
		group.add(gender[0]); group.add(gender[1]);
	}
	void makeButton() {
		btns = new JButton[5];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnsTitles[i]);
		}
		idCheck = new JButton("�ߺ��˻�");
		idCheck.addActionListener(this);
	}
	void makeLabel() {
		labels = new JLabel[7];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(labelTitles[i]);
		}
	}
	void makeComboBox() {
		combo = new JComboBox[4];//�μ���,��,��,��
		for(int i=0; i<combo.length; i++) {
			combo[i] = new JComboBox();
			switch(i) {
			case 0://�μ����� ä��
				combo[i].addItem("�μ����� �����ϼ���.");
				for(int j=0; j<deptTitles.length;j++) {
					combo[i].addItem(deptTitles[j]);
				}
				break;
			case 1://2020���� 1920�� ä��
				combo[i].addItem("�⵵�� �����ϼ���.");
				for(int j=2020; j>=1920; j--) {
					combo[i].addItem(j);
				}
				break;
			case 2://1���� 12�� ä��
				combo[i].addItem("���� �����ϼ���.");
				for(int j=1; j<=12; j++) {
					combo[i].addItem(j);
				}
				break;
			case 3:
				combo[i].addItem("���� �����ϼ���.");
			}
		}
	}
	void makeTextField() {
		inputs = new JTextField[3];
		for(int i=0;i<inputs.length;i++) {
			switch(i) {
			case 0: inputs[i] = new JTextField(
					"����� �Է��ϼ���.",20);
					break;
			case 1: inputs[i] = new JTextField(
					"�̸��� �Է��ϼ���.",20);
					break;
			case 2: inputs[i] = new JTextField(
					"�ּҸ� �Է��ϼ���.",20);
					break;
			}
		}
	}
	public static void main(String[] args) {
		new HRSystem("��� ���� �ý��� ver1.0");
	}
}









