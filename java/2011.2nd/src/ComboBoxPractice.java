package chajh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxPractice extends JFrame implements ItemListener {
    public static void main(String[] args) {
        new ComboBoxPractice("������ ����???");
    }

    public ComboBoxPractice(String str) {
        super(str);
        font=new Font("����ü", font.BOLD,30);
        makeLabel();
        makeCombo();
        makePanel();
        makeWindow();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj=e.getSource();
        if(obj==combo[0]) {
            int index=combo[0].getSelectedIndex();
            combo[1].removeAllItems();
            combo[1].addItem("������ ���ÿ�");
            if(index>0) {
                for(int i=0;i<events[index-1].length;i++) {
                    combo[1].addItem(events[index-1][i]);
                }
            }
        } else if(obj==combo[1]) {
            if(combo[1].getSelectedIndex()>0) {
                String str1=(String)combo[0].getSelectedItem();
                String str2=(String)combo[1].getSelectedItem();
                result.setText(title+" : "+str1+ ", "+str2);
            }
        }
    }
    void makeLabel() {
        result=new JLabel("�׷��� �� �Ѵٰ�???");
    }
    void makeCombo() {
        combo=new JComboBox[2];
        for(int i=0;i<combo.length;i++) {
            combo[i]=new JComboBox();
            combo[i].setFont(font);
            combo[i].addItemListener(this);
        }
        for(int i=0;i<dayOfTheWeek.length;i++) {
            combo[0].addItem(dayOfTheWeek);
        }
        combo[1].addItem("�� ���� �����Ͻÿ�");
    }
    void makePanel() {
        pan=new JPanel();
        pan.add(combo[0]);
        pan.add(combo[1]);
    }
    void makeWindow() {
        this.add("Center", pan);
        this.add("South", result);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JComboBox[] combo;
    JLabel result;
    JPanel pan;
    Font font;
    String[] dayOfTheWeek={"������", "ȭ����", "������", "�����", "�ݿ���", "�����", "�Ͽ���"};
    String[][] events={
            {"���亴 ����", "�и����� ����", "�庸��", "7����", "�̿�� �޹�"},
            {"����ϱ�Ⱦ ����", "�庸��", "Ÿ�ھ߳� ���帶��"},
            {"�����ڰ�; ����", "�庸��", "��Ƣ�� ���帶��"},
            {"�ް�����; ����", "�庸��", "������ �ǽù��� �� ��� ��"},
            {"�ݿ����ε���������3�Ͻ��°žƴԺ� ����", "�庸��", "�ʰ��ڵ� ������ ������ ���� ��"},
            {"�ָ���������������־ ����", "�庸��"},
            {"���Ͽ������̳׺� ����", "�庸��"}
    };
    String title="�׷��� �� �Ѵٰ�???";
}
