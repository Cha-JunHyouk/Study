package senior;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InsertDataWindow extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == change) {//변경 버튼을 누른 경우
			String id = inputData.inputs[0].getText();//계정을 불러옴
			int r = JOptionPane.showConfirmDialog(this, 
				"정말로 변경하시겠습니까?");
			if(r == JOptionPane.OK_OPTION) {//예를 누른경우
				if(id.equals("")) {//계정이 없는 경우
					JOptionPane.showMessageDialog(this, 
						"변경할 계정이 입력되지 않았습니다.");
				}else {//계정이 있는 경우
					//DB접속->변경->DB해제
					MyDB db = new MyDB(this);
					if(db.db_conn()) {
						Remeber_jaegu jaegu=new Remeber_jaegu();
						jaegu.setId(inputData.inputs[0].getText());
						jaegu.setPassword(inputData.inputs[1].getText());
						jaegu.setGender(inputData.inputs[2].getText());
						jaegu.setAddress(inputData.inputs[3].getText());
						jaegu.setName(inputData.inputs[4].getText());
						jaegu.setPhonenumber(inputData.inputs[5].getText());
						jaegu.setStar(inputData.inputs[6].getText());
						boolean s = db.change(jaegu);//s:true,false
						if(s) {
							JOptionPane.showMessageDialog(this, 
								"변경작업이 완료되었습니다.");
						}else {
							JOptionPane.showMessageDialog(this, 
								"변경작업 중 문제가 발생했습니다.");
						}
					}else {
						JOptionPane.showMessageDialog(this, 
							"DB접속에 실패했습니다.");
					}
				}
			}
		}else if(obj == select) {//조회버튼을 누른 경우
			String id = inputData.inputs[0].getText();
			if(id.equals("")) {//계정이 입력되지 않은 경우
				JOptionPane.showMessageDialog(this, 
					"조회할 계정이 입력되지 않았습니다.");
			}else {//계정이 입력된 경우
				MyDB db = new MyDB(this);
				if(db.db_conn()) {//접속
					Remeber_jaegu jaegu = db.select(id);
					//조회된 계정,암호,이름,주소,성별,별자리
					if(jaegu == null) {
						JOptionPane.showMessageDialog(this, 
							"조회결과가 존재하지 않습니다.");
					}else {
						inputData.inputs[0].setText(jaegu.getId());
						inputData.inputs[1].setText(jaegu.getPassword());
						inputData.inputs[2].setText(jaegu.getGender());
						inputData.inputs[3].setText(jaegu.getAddress());
						inputData.inputs[4].setText(jaegu.getName());
						inputData.inputs[5].setText(jaegu.getPhonenumber());
						inputData.inputs[6].setText(jaegu.getStar());
						JOptionPane.showMessageDialog(this, 
							"조회가 완료되었습니다.");
					}
					db.db_disconn();//접속 해제
				}
			}
		}else if(obj == delete) {//삭제버튼을 누른 경우
			int select=JOptionPane.showConfirmDialog(this,
					"정말로 삭제하시겠습니까?");
			if(select == JOptionPane.OK_OPTION) {//예
				MyDB db = new MyDB(this);
				Remeber_jaegu j = new Remeber_jaegu();
				j.setId(inputData.inputs[0].getText());
				j.setPassword(inputData.inputs[1].getText());
				j.setGender(inputData.inputs[2].getText());
				j.setAddress(inputData.inputs[3].getText());
				j.setName(inputData.inputs[4].getText());
				j.setPhonenumber(inputData.inputs[5].getText());
				j.setStar(inputData.inputs[6].getText());
				if(db.db_conn()) {
					db.delete(j);
					db.db_disconn();
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB접속에 실패했습니다.");
				}
			}
		}else if(obj == insert) {//등록버튼을 누른 경우
			//버튼 2개짜리 다이얼로그 만듬//시작
			String[] str = {"예","아니오"};//버튼 제목
			int select = JOptionPane.showOptionDialog(this, 
				"원하시는 작업을 선택하세요", 
				"대화상자", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, str, str[0]);
			if(select == JOptionPane.OK_OPTION) {
				//예를 누른경우
				//DB접속->입력한데이터를 삽입->DB해제
				MyDB myDB = new MyDB(this);
				if(myDB.db_conn()) {
					//입력한 데이터를 불러온다.
					String id=inputData.inputs[0].getText();//계정
					String pwd=inputData.inputs[1].getText();//암호
					String gender=inputData.inputs[2].getText();//성별
					String addr=inputData.inputs[3].getText();//주소
					String name=inputData.inputs[4].getText();//이름
					String number=inputData.inputs[5].getText();//연락처
					String star=inputData.inputs[6].getText();//별자리
					//DTO를 생성하고 세터를 사용하여 데이터를 넣는다.
					Remeber_jaegu jaegu=new Remeber_jaegu();
					jaegu.setId(id); jaegu.setPassword(pwd);
					jaegu.setGender(gender); jaegu.setAddress(addr);
					jaegu.setName(name); jaegu.setPhonenumber(number);
					jaegu.setStar(star);
					//삽입한다.
					myDB.insert(jaegu);
					myDB.db_disconn();//DB해제
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB접속에 실패했습니다.");
				}
			}else if(select == JOptionPane.NO_OPTION) {
				//아니오를 누른경우
				
			}
			//버튼 2개짜리 다이얼로그 만듬//끝
//			int input = JOptionPane.showConfirmDialog(this, 
//				"정말로 등록하시겠습니까?");
//			if(input == JOptionPane.OK_OPTION) {
//				//예를 누른경우
//				System.out.println("예를 누름");
//			}else if(input == JOptionPane.NO_OPTION) {
//				//아니로를 누른경우
//				System.out.println("아니오를 누름");
//			}else if(input == JOptionPane.CANCEL_OPTION) {
//				//취소를 누른경우
//				System.out.println("취소를 누름");
//			}
		}else if(obj == cancel) {//취소버튼을 누른경우
			int input = JOptionPane.showConfirmDialog(this, 
				"정말로 취소하시겠습니까?");
		}
	}
	InputData inputData; 
	JButton insert,cancel,delete,select,change;
	JPanel btnPan;
	public InsertDataWindow(String str) {
		super(str);
		inputData = new InputData();
		this.add("Center",inputData);
		insert = new JButton(" 등록 ");
		insert.addActionListener(this);
		delete = new JButton(" 삭제 ");
		delete.addActionListener(this);
		select = new JButton(" 조회 ");
		select.addActionListener(this);
		change = new JButton(" 변경 ");
		change.addActionListener(this);
		cancel = new JButton(" 취소 ");
		cancel.addActionListener(this);
		btnPan = new JPanel(); 
		btnPan.add(insert); btnPan.add(delete);
		btnPan.add(select); btnPan.add(change); btnPan.add(cancel);
		this.add("South", btnPan);
		this.setSize(400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new InsertDataWindow("자료등록 ver1.0");
	}
}










