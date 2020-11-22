import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuInfo extends JPanel
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		for(int i=0;i<btns.length;i++) {
			if(obj==btns[i]) {
				card.show(cardPanel, btnTitles[i]);
				break;
			}
		}
	}
	JButton[] btns;
	JPanel btn_pan;
	JPanel[] menus;
	JPanel cardPanel;
	CardLayout card;
	ImageIcon[] imgs;
	JLabel[] iconLabels;
	JLabel[] introLabels;
	String path="src/";
	String[] filenames={"kimbab.jpg","mandoo.jpg",
		"ramyeon.jpg","tteokbocki.jpg","twigim.jpg"};
	String[] intros={
		"<html>����˲�! ���� ǳ��!<br/>"
		+ "�������� �ǰ� ������ ���� ä�� �ǰ� ���<br/>"
				+ "(2500��)</html>",
		"<html>����ϰ� ���� ���� ����!<br/>"
		+ "���� ������ ���� ���� ����<br/>"
				+ "(3500��)</html>",
		"<html>�ѱ����� ����!<br/>"
		+ "������ ���� �Բ� ���� ���<br/>"
				+ "(3000��)</html>",
		"<html>���޴����� ���� �̱��̱��� �Ҷ��� ��ȭ!<br/>"
		+ "������ �ſ���� �ŷ����� �Ҷ�����<br/>"
				+ "(3000��)</html>",
		"<html>���� �ٻ�! ���� ����!<br/>"
		+ "���� ��Ḧ ������ �⸧�� Ƣ�ܳ� ��� Ƣ��<br/>"
				+ "(1000��/��)</html>",
	};
	String[] btnTitles={
			"���","����","���","������","Ƣ��"
	};
	public MenuInfo() {
		card=new CardLayout();
		makeImageIcon();
		makeIntro();
		makeImageLabel();
		makeButton();
		makePanel();
		makeWindow();
	}
	void makeWindow() {
		this.setLayout(new BorderLayout());
		this.add("Center",cardPanel);
		this.add("South",btn_pan);
	}
	void makePanel() {
		menus=new JPanel[5];
		cardPanel=new JPanel();
		cardPanel.setLayout(card);
		for(int i=0;i< menus.length;i++) {
			menus[i]=new JPanel();
			menus[i].add(iconLabels[i]);
			menus[i].add(introLabels[i]);
			cardPanel.add(menus[i],btnTitles[i]);
		}
		card.show(cardPanel, btnTitles[0]);
		btn_pan=new JPanel();
		for(int i=0;i<btns.length;i++) {
			btn_pan.add(btns[i]);
		}
	}
	void makeButton() {
		btns=new JButton[5];
		for(int i=0;i<btns.length;i++) {
			btns[i]=new JButton(btnTitles[i]);
			btns[i].addActionListener(this);
		}
	}
	void makeImageLabel() {
		iconLabels=new JLabel[5];
		for(int i=0;i<iconLabels.length;i++) {
			iconLabels[i]=new JLabel();
			iconLabels[i].setIcon(imgs[i]);
		}
	}
	void makeIntro() {
		introLabels=new JLabel[5];
		for(int i=0;i<introLabels.length;i++) {
			introLabels[i]=new JLabel(intros[i], JLabel.CENTER);
		}
	}
	void makeImageIcon() {
		imgs=new ImageIcon[5];
		for(int i=0;i<imgs.length;i++) {
			imgs[i]=new ImageIcon(path+filenames[i]);
		}
	}
	public static void main(String[] args) {
	}

}














