package Test;
/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lesson2 extends JFrame implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {     //Overriding 필수. 아이템의 상태가 변화했을때 호출된다
        Object obj=e.getSource();
        if(obj==combo[0]) {                         //첫번째 콤보박스가 변화했을 경우
            int index=combo[0].getSelectedIndex();  //첫번째 콤보박스에서 몇번째 index를 선택하였는가?
            combo[1].removeAllItems();              //이전에 선택한 첫번째 콤보박스에 딸린 두번째 콤보박스의 index들을 삭제
            combo[1].addItem("Select element 'B'"); //두번째 콤보박스의 default index
            if(index > 0) {                         //첫번째 콤보박스의 default index가 선택되어 있을 경우 두번째 콤보박스의 default index만을 출력하게 만드는 method
                for(int i=0;i<hotPlace[index-1].length;i++) {
                    combo[1].addItem(hotPlace[index-1][i]);     //첫번째 콤보박스의 index가 정해지면 그에 맞는 두번째 콤보박스의 index를 set
                }
            }
        } else if(obj==combo[1]) {                  //두번째 콤보박스가 변화했을 경우
            if(combo[1].getSelectedIndex() > 0) {               //두번째 콤보박스에 default index 이외의 index가 선택되었을 경우
                String str1=(String)combo[0].getSelectedItem(); //첫번째 콤보박스에 선택된 index를 variable에 set
                String str2=(String)combo[1].getSelectedItem(); //두번째 콤보박스에 선택된 index를 variable에 set
                result.setText(
                        title[2]+":"+str1+","+str2);            //레이블에출력
            }
        }
    }
    void makeLabel( ) {
        result=new JLabel("Result");            //Label의 생성
    }
    void makeCombo() {                              //콤보박스 생성을 위한 method
        combo=new JComboBox[2];                     //콤보박스 2개를 생성하는 배열
        for(int i=0;i<combo.length;i++) {
            combo[i]=new JComboBox();
            combo[i].setFont(font);                 //콤보박스의 폰트 설정
            combo[i].addItemListener(this);;    //itemListener를 콤보박스에 장착
        }
        for(int i=0;i<towns.length;i++) {           //콤보박스에 index 삽입
            combo[0].addItem(towns[i]);
        }
        combo[1].addItem("Select element 'B'");     //두번째 콤보박스의 default index
    }
    void makePanel() {
        pan=new JPanel(); pan.add(combo[0]);        //Panel을 생성하고 내용을 삽입
        pan.add(combo[1]);
    }
    void makeWindow() {                             //Window의 layout을 설계
        this.add("Center", pan); this.add("South", result);
        this.setSize(600,400); this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //종료버튼 입력 시 종료되도록 trigger 추가
    }
    JComboBox[] combo; JLabel result;
    JPanel pan; Font font;
    String[] towns= {"Select element 'A'", "A", "B", "C", "D", "E", "F"};
    String[][] hotPlace= {
            {"1", "2" , "3", "4", "5"},
            {"a", "b", "c", "d", "e"},
            {"Z", "Y", "X"},
            {"z", "y", "x"},
            {"One", "Two", "Three", "Four"},
            {"First", "Second", "Third", "Fourth"}
    };
    String[] title = {"Select element 'A'",
            "Select element 'B'","Result"};
    public Lesson2(String str) {
        super(str);
        font=new Font("Sans",Font.BOLD,20);
        makeLabel();
        makeCombo();
        makePanel();
        makeWindow();
    }

    public static void main(String[] args) {
        new Lesson2("Testing");
    }

}
*/