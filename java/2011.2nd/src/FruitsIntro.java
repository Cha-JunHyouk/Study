package chajh;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FruitsIntro extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();//�̺�Ʈ�� ������ ã��
		for(int i=0; i<btns.length; i++) {
			if(obj == btns[i]) {
				card.show(
						cardPanel, btnTitles[i]);
				break;//�ݺ�����
			}
		}//��ư�� ������ŭ �ݺ�
//		if(obj == btns[0]) {
//			
//		}else if(obj == btns[1]) {
//			
//		}
	}
	JButton[] btns; JPanel btn_pan;
	JPanel[] fruits; JPanel cardPanel;
	CardLayout card; ImageIcon[] imgs;
	JLabel[] iconLabels;//�����̹����� ���̺�
	JLabel[] introLabels;//���ϼ���� ���̺�
	String path = "src/senior/";//�̹��� ���
	String[] filenames = {"grape.jpg","kiwi.jpg",
		"lemon.jpg","orange.jpg","strawberry.jpg",
		"tangerine.jpg"};//�̹��� ���� �̸�
	String[] intros = {
		"<html>��������� �ٷ� �����ϰ� �־�<br/>"
		+ "Ȳ��ȭ �ۿ��� �մϴ�.</html>",
		"<html>�ó��Ǹ��� �����ϰ� �־�<br/>"
		+ "���⿹�濡 �����ϴ�.</html>",
		"<html>��Ÿ��C�� �ſ� ǳ���մϴ�.<br/>"
		+ "���̾�Ʈ�� �̿뿡 �����ϴ�.</html>",
		"<html>�������� �����ϰ� �־� �Ƿ�ȸ����<br/>"
		+ "�����ϴ�. ��Ÿ��C�� ǳ���մϴ�.</html>",
		"<html>��Ÿ��C�� ǳ���մϴ�.<br/>"
		+ "������ �ֽ��� ���ø� �����ϴ�.</html>",
		"<html>��Ÿ��C�� ���󺸳��̵带 �ٷ�<br/>"
		+ "�����ϰ� �ֽ��ϴ�.</html>"
	};//���� ����
	String[] btnTitles = {"����","Ű��","����",
			"������","����","��"};//��ư�� ����
	public FruitsIntro(String str) {
		super(str);
		card = new CardLayout();
		makeImageIcon();//�̹���������6�� ���� 
		makeIntro();//���ϼҰ����̺� ����
		makeImageLabel();//�������� ���̺� ���� 
		makeButton();//��ư ����
		makePanel();//�г� ���� 
		makeWindow();//������ ����
	}
	void makeWindow() {
		this.add("Center",cardPanel);
		this.add("South",btn_pan);
		this.setResizable(false);//ũ�⺯��Ұ�
		this.setSize(600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		fruits = new JPanel[6];
		cardPanel = new JPanel();
		cardPanel.setLayout(card);
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JPanel();//�гλ���
			fruits[i].add(iconLabels[i]);//�̹���
			fruits[i].add(introLabels[i]);//����
			//�гο� �̹����� ������ ��´�.
			cardPanel.add(fruits[i],btnTitles[i]);
			//�г��� CardLayout�� ����ϴ� �гο� ����
			//���� ��, �гΰ� �г��� �̸��� ����
		}
		card.show(cardPanel, btnTitles[0]);
		//�⺻����гμ���(ù��° "����"�̸��� �г�)
		btn_pan = new JPanel();//��ư�� �����гλ���
		for(int i=0; i<btns.length; i++) {
			btn_pan.add(btns[i]);//��ư���гο�����
		}
	}
	void makeButton() {
		btns = new JButton[6];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].addActionListener(this);
		}
	}
	void makeImageLabel() {
		iconLabels = new JLabel[6];
		for(int i=0; i<iconLabels.length; i++) {
			iconLabels[i] = new JLabel();
			iconLabels[i].setIcon(imgs[i]);
		}
	}
	void makeIntro() {
		introLabels = new JLabel[6];
		for(int i=0; i<introLabels.length; i++) {
			introLabels[i] = new JLabel(intros[i],
					JLabel.CENTER);
		}
	}
	void makeImageIcon() {
		imgs = new ImageIcon[6];//�迭����
		for(int i=0; i<imgs.length; i++) {
			imgs[i] = new ImageIcon(
				path+filenames[i]);
		}//�̹��� ������ 6�� ����
	}
	public static void main(String[] args) {
		new FruitsIntro("���ϼҰ� ver1.0");
	}

}














