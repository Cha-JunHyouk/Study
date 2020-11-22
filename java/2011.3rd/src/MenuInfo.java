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
		"<html>내용꽉꽉! 영양 풍부!<br/>"
		+ "여러가지 건강 속재료로 속을 채운 건강 김밥<br/>"
				+ "(2500원)</html>",
		"<html>담백하고 알찬 속이 가득!<br/>"
		+ "당일 정성껏 빚은 수제 만두<br/>"
				+ "(3500원)</html>",
		"<html>한국인은 역시!<br/>"
		+ "갖가지 재료와 함께 끓인 라면<br/>"
				+ "(3000원)</html>",
		"<html>매콤달콤한 양념과 쫄깃쫄깃한 쌀떡의 조화!<br/>"
		+ "적절한 매운맛이 매력적인 쌀떡볶이<br/>"
				+ "(3000원)</html>",
		"<html>겉은 바삭! 속은 촉촉!<br/>"
		+ "각종 재료를 깨끗한 기름에 튀겨낸 모듬 튀김<br/>"
				+ "(1000원/개)</html>",
	};
	String[] btnTitles={
			"김밥","만두","라면","떡볶이","튀김"
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














