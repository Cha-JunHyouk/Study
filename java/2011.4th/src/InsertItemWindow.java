package senior;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InsertItemWindow extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == insert) {//상품등록 버튼을 누른경우
			int select = JOptionPane.showConfirmDialog(this,
				"정말로 저장하시겠습니까?");
			if(select == JOptionPane.OK_OPTION) {//예를 누른경우
				DBUtility db = new DBUtility();
				if(db.db_conn()) {//DB와 접속
					String code=ii.inputs[0].getText();
					String name=ii.inputs[1].getText();
					String intro=ii.inputs[2].getText();
					int price=Integer.parseInt(
							ii.inputs[3].getText());
					String origin=ii.inputs[4].getText();
					Item item = new Item();//DTO생성
					item.setCode(code); item.setName(name);
					item.setIntro(intro);item.setPrice(price);
					item.setOrigin(origin);
					if(db.insert(item) > 0) {
						db.db_disconn();//DB접속 해제
						JOptionPane.showMessageDialog(this, 
							"상품정보가 등록되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, 
							"상품정보가 등록되지 않았습니다.");
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB와 접속되지 않았습니다.");
				}
			}
		}else if(obj == cancel) {//취소버튼을 누른경우
			
		}
	}
	JButton insert,cancel; JPanel pan; Font font; 
	InputItem ii;//상품등록화면 패널
	public InsertItemWindow(String str) {
		super(str);
		ii = new InputItem();//상품등록화면 생성
		//this:살아있는 InsertItemWindow인스턴스(즉,윈도우)
		font = new Font("고딕체",Font.BOLD,26);
		insert = new JButton(" 상품등록 ");
		insert.addActionListener(this);
		insert.setFont(font);//버튼에 폰트적용
		cancel = new JButton(" 취소 ");
		cancel.addActionListener(this);
		cancel.setFont(font);//버튼에 폰트적용
		pan = new JPanel();//버튼이 들어갈 패널생성
		pan.add(insert); pan.add(cancel);//패널에 버튼담음
		this.add("Center",ii);
		this.add("South", pan);//화면아래에 버튼을 붙임
		this.setSize(600, 700); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new InsertItemWindow("상품등록 ver1.0");
	}
}









