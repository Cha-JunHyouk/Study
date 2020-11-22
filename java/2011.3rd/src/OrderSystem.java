import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OrderSystem extends JPanel implements ActionListener,ItemListener {
	int kimbabSubTotal=0;
	int mandooSubTotal=0;
	int ramyeonSubTotal=0;
	int tteokbokkiSubTotal=0;
	int twigimSubTotal=0;
	int total=0;
	final int KIMBAB=2500;
	final int MANDOO=3500;
	final int RAMYEON=3000;
	final int TTEOKBOKKI=3000;
	final int TWIGIM=1000;
	JLabel[] labels;
	JToggleButton[] chkbx;
	ButtonGroup[] group;
	JButton[] buttons;
	JTextField[] textFields;
	JComboBox[] combo;
	JPanel[] panels;
	String[] labelTitles={"상품명","갯수","금액",
			"결제수단","포인트 적립","총액","회원번호"};
	String[] checkTitles= {"김밥","만두",
			"라면","떡볶이","모듬튀김","현금","신용카드",
			"예","아니오"};
	GridLayout gridLayout;
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getSource();
		if(obj==chkbx[0]) {
			if(chkbx[0].isSelected()) {
				combo[0].setEnabled(true);
			}else {
				combo[0].setEnabled(false);
				kimbabSubTotal=0;
				textFields[0].setText(kimbabSubTotal +"원");
			}
		}else if(obj==chkbx[1]) {
			if(chkbx[1].isSelected()) {
				combo[1].setEnabled(true);
			}else {
				combo[1].setEnabled(false);
				mandooSubTotal=0;
				textFields[1].setText(mandooSubTotal +"원");
			}
		}else if(obj==chkbx[2]) {
			if(chkbx[2].isSelected()) {
				combo[2].setEnabled(true);
			}else {
				combo[2].setEnabled(false);
				ramyeonSubTotal=0;
				textFields[2].setText(ramyeonSubTotal +"원");
			}
		}else if(obj==chkbx[3]) {
			if(chkbx[3].isSelected()) {
				combo[3].setEnabled(true);
			}else {
				combo[3].setEnabled(false);
				twigimSubTotal=0;
				textFields[3].setText(twigimSubTotal +"원");
			}
		}else if(obj==chkbx[4]) {
			if(chkbx[4].isSelected()) {
				combo[4].setEnabled(true);
			}else {
				combo[4].setEnabled(false);
				tteokbokkiSubTotal=0;
				textFields[4].setText(tteokbokkiSubTotal +"원");
			}
		}
		total=kimbabSubTotal+mandooSubTotal+tteokbokkiSubTotal;
		textFields[5].setText(total+"원");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==buttons[0]) {
			total=0;
			if(chkbx[0].isSelected()) {
				int index = combo[0].getSelectedIndex();
				index=index+1;
				kimbabSubTotal = index * KIMBAB;
				total = total + kimbabSubTotal;
				textFields[0].setText(kimbabSubTotal +"원");
			}
			if(chkbx[1].isSelected()) {
				int index=combo[1].getSelectedIndex();
				index=index+1;
				mandooSubTotal=index*MANDOO;
				total=total+mandooSubTotal;
				textFields[1].setText(mandooSubTotal+"원");
			}
			if(chkbx[2].isSelected()) {
				int index=combo[2].getSelectedIndex();
				index=index+1;
				ramyeonSubTotal=index*RAMYEON;
				total=total+ramyeonSubTotal;
				textFields[2].setText(ramyeonSubTotal+"원");
			}
			if(chkbx[3].isSelected()) {
				int index=combo[3].getSelectedIndex();
				index=index+1;
				tteokbokkiSubTotal=index*TTEOKBOKKI;
				total=total+tteokbokkiSubTotal;
				textFields[3].setText(tteokbokkiSubTotal +"원");
			}
			if(chkbx[4].isSelected()) {
				int index=combo[4].getSelectedIndex();
				index=index+1;
				twigimSubTotal=index*TWIGIM;
				total=total+twigimSubTotal;
				textFields[4].setText(twigimSubTotal +"원");
			}
			textFields[5].setText(total+"원");
		}else if(obj==buttons[1]) {
			textFields[0].setText("");
			textFields[1].setText("");
			textFields[2].setText("");
			textFields[3].setText("");
			textFields[4].setText("");
			textFields[5].setText("");
			combo[0].setSelectedIndex(0);
			combo[1].setSelectedIndex(0);
			combo[2].setSelectedIndex(0);
			combo[3].setSelectedIndex(0);
			combo[4].setSelectedIndex(0);
			chkbx[0].setSelected(false);
			chkbx[1].setSelected(false);
			chkbx[2].setSelected(false);
			chkbx[3].setSelected(false);
			chkbx[4].setSelected(false);
		}
	}
	void makeLabel() {
		labels=new JLabel[7];
		for(int i=0;i<labels.length;i++) {
			labels[i]=new JLabel(labelTitles[i]);
		}
	}
	void makeCheckbox() {
		chkbx=new JToggleButton[9];
		group=new ButtonGroup[2];
		group[0]=new ButtonGroup();
		group[1]=new ButtonGroup();
		for(int i=0;i<chkbx.length;i++) {
			switch(i) {
			case 5:
			case 6:
				chkbx[i]=new JRadioButton(checkTitles[i],false);
				group[0].add(chkbx[i]);
				break;
			case 7:
			case 8:
				chkbx[i]=new JRadioButton(checkTitles[i],false);
				group[1].add(chkbx[i]);
				break;
			default :
				chkbx[i]=new JCheckBox(checkTitles[i],false);
				chkbx[i].addItemListener(this);
			}
		}
	}
	void makeTextfield() {
		textFields=new JTextField[7];
		for(int i=0;i< textFields.length;i++) {
			textFields[i]=new JTextField(10);
		}
	}
	void makeCombobox() {
		combo=new JComboBox[5];
		for(int i=0;i<combo.length;i++) {
			combo[i]=new JComboBox();
			for(int j=1;j<=10;j++) {
				combo[i].addItem(j+"개");
			}
			combo[i].setEnabled(false);
		}
	}
	void makePanel() {
		panels=new JPanel[9];
		for(int i=0; i<panels.length;i++) {
			panels[i]=new JPanel();
		}
		panels[0].add(labels[0]);
		panels[0].add(chkbx[0]);
		panels[0].add(chkbx[1]);
		panels[0].add(chkbx[2]);
		panels[0].add(chkbx[3]);
		panels[0].add(chkbx[4]);
		panels[0].setBackground(Color.WHITE);
		panels[1].add(labels[1]);
		panels[1].add(combo[0]);
		panels[1].add(combo[1]);
		panels[1].add(combo[2]);
		panels[1].add(combo[3]);
		panels[1].add(combo[4]);
		panels[1].setBackground(Color.WHITE);
		panels[2].add(labels[2]);
		panels[2].add(textFields[0]);
		panels[2].add(textFields[1]);
		panels[2].add(textFields[2]);
		panels[2].add(textFields[3]);
		panels[2].add(textFields[4]);
		panels[2].setBackground(Color.WHITE);
		panels[3].add(labels[3]);
		panels[3].add(chkbx[5]);
		panels[3].add(chkbx[6]);
		panels[3].setBackground(Color.WHITE);
		panels[4].add(labels[4]);
		panels[4].add(chkbx[7]);
		panels[4].add(chkbx[8]);
		panels[4].setBackground(Color.WHITE);
		panels[5].add(new JLabel());
		panels[5].add(labels[6]);
		panels[5].add(textFields[6]);
		panels[5].setBackground(Color.WHITE);
		panels[6].add(labels[5]); panels[6].add(textFields[5]);
		panels[6].setBackground(Color.RED);
		panels[7].add(new JLabel());
		panels[7].setBackground(Color.WHITE);
		buttons = new JButton[2];
		buttons[0]=new JButton(" 주문하기 ");
		buttons[0].addActionListener(this);
		buttons[1]=new JButton(" 취소 ");
		buttons[1].addActionListener(this);
		panels[8].add(buttons[0]);
		panels[8].add(buttons[1]);
	}
	void makeWindow() {
		for(int i=0;i<panels.length;i++) {
			this.add(panels[i]);
		}
	}
	public OrderSystem() {
		gridLayout=new GridLayout(9,1,5,5);
		this.setLayout(gridLayout);
		this.setBackground(Color.WHITE);
		makeLabel();
		makeCheckbox();
		makeTextfield();
		makeCombobox();
		makePanel(); makeWindow();
	}
	public static void main(String[] args) {}
}









