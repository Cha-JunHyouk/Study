package chajh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxPractice extends JFrame implements ItemListener {
    public static void main(String[] args) {
        new ComboBoxPractice("오늘은 뭐함???");
    }

    public ComboBoxPractice(String str) {
        super(str);
        font=new Font("명조체", font.BOLD,30);
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
            combo[1].addItem("요일을 고르시오");
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
        result=new JLabel("그래서 뭘 한다고???");
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
        combo[1].addItem("할 일을 선택하시오");
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
    String[] dayOfTheWeek={"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
    String[][] events={
            {"월요병 발작", "분리수거 배출", "장보기", "7일장", "미용실 휴무"},
            {"출근하기싫어병 발작", "장보기", "타코야끼 포장마차"},
            {"늦잠자고싶어병 발작", "장보기", "뻥튀기 포장마차"},
            {"휴가쓰고싶어병 발작", "장보기", "오전에 피시방이 텅 비는 날"},
            {"금요일인데연차쓰면3일쉬는거아님병 발작", "장보기", "늦게자도 다음날 지장이 적은 날"},
            {"주말에어딜나가집에있어병 발작", "장보기"},
            {"내일월요일이네병 발작", "장보기"}
    };
    String title="그래서 뭘 한다고???";
}
