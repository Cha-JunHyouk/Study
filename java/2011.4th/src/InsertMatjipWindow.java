package senior;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InsertMatjipWindow extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == search) {//조회버튼을 누른경우
			String seqno = im.inputs[0].getText();
			if(seqno.equals("")) {//맛집번호가 없는 경우
				JOptionPane.showMessageDialog(this, 
					"조회할 맛집번호가 입력되지 않았습니다.");
			}else {
				MatjipUtility util = new MatjipUtility(this);
				if(util.db_conn()) {
					Matjip matjip = util.select(
							Integer.parseInt(seqno));
					if(matjip == null) {
						JOptionPane.showMessageDialog(this, 
							"조회결과가 존재하지 않습니다.");
					}else {
						im.inputs[0].setText(matjip.getNumber()+"");
						im.inputs[1].setText(matjip.getName());
						im.inputs[2].setText(matjip.getAddr());
						im.inputs[3].setText(matjip.getTel());
						im.inputs[4].setText(matjip.getMobile());
						JOptionPane.showMessageDialog(this, 
							"조회가 완료되었습니다.");
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB에 접속되지 않았습니다.");
				}
			}
		}else if(obj == change) {//변경버튼을 누른경우
			String seqno = im.inputs[0].getText();
			if(seqno.equals("")) {
				JOptionPane.showMessageDialog(this, 
					"변경할 맛집번호가 입력되지 않았습니다.");
			}else {
				int s=JOptionPane.showConfirmDialog(this, 
					"정말로 변경하시겠습니까?");
				MatjipUtility util = new MatjipUtility(this);
				if(util.db_conn()) {
					Matjip matjip = new Matjip();
					matjip.setNumber(Integer.parseInt(
							im.inputs[0].getText()));
					matjip.setName(im.inputs[1].getText());
					matjip.setAddr(im.inputs[2].getText());
					matjip.setTel(im.inputs[3].getText());
					matjip.setMobile(im.inputs[4].getText());
					boolean b = util.change(matjip);
					if(b) {
						JOptionPane.showMessageDialog(this, 
							"변경작업이 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, 
							"변경작업 중 문제가 발생했습니다.");
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB 접속에 실패했습니다.");
				}
			}
		}else if(obj == insert) {//등록버튼을 누른경우
			//다이얼로그를 띄운다.
			int input=JOptionPane.showConfirmDialog(this, 
				"정말로 등록하시겠습니까?");
			if(input == JOptionPane.OK_OPTION) {
			//예를 누른경우,DB접속->삽입->DB접속해제
				MatjipUtility util = new MatjipUtility(this);
				if(util.db_conn()) {//접속성공인경우
					Matjip matjip = new Matjip();//DTO를 생성한다.
					matjip.setNumber(
						Integer.parseInt(im.inputs[0].getText()));
					matjip.setName(im.inputs[1].getText());
					matjip.setAddr(im.inputs[2].getText());
					matjip.setTel(im.inputs[3].getText());
					matjip.setMobile(im.inputs[4].getText());
					util.insert2(matjip);
//					if(util.insert1(matjip)) {//삽입성공인경우
//						JOptionPane.showMessageDialog(this, 
//							"맛집정보가 등록되었습니다.");
//					}else {//삽입실패인경우
//						JOptionPane.showMessageDialog(this, 
//							"맛집정보가 등록되지 않았습니다.");
//					}
				}else {//접속실패인 경우
					JOptionPane.showMessageDialog(this, 
						"DB접속에 실패했습니다.");
				}
			}
		}else if(obj == cancel) {//취소버튼을 누른경우
			int input=JOptionPane.showConfirmDialog(this, 
				"정말로 취소하시겠습니까?");
			if(input == JOptionPane.OK_OPTION) {
			//입력창에 입력된 모든 데이터를 지운다.
				im.inputs[0].setText("");//맛집번호
				im.inputs[1].setText("");//이름
				im.inputs[2].setText("");//주소
				im.inputs[3].setText("");//전화번호
				im.inputs[4].setText("");//모바일폰
			}
		}
	}
	JButton insert,cancel,search,change; JPanel pan; Font font;
	InputMatjip im;
	public InsertMatjipWindow(String str) {
		super(str);
		im = new InputMatjip();
		font = new Font("고딕체",Font.BOLD,26);
		search = new JButton("맛집조회");
		search.setFont(font);
		search.addActionListener(this);
		change = new JButton("맛집변경");
		change.setFont(font);
		change.addActionListener(this);
		insert =new JButton("맛집등록");
		insert.setFont(font);//버튼에 폰트 적용
		insert.addActionListener(this);
		cancel = new JButton(" 취소 ");
		cancel.setFont(font);//버튼에 폰트 적용
		cancel.addActionListener(this);
		pan = new JPanel();//버튼이 들어갈 패널 생성
		pan.add(insert); pan.add(search); pan.add(change);
		pan.add(cancel);//패널에 버튼넣음
		this.add("Center",im);
		this.add("South",pan);//패널을 윈도우 아래에 붙임
		this.setSize(600, 600); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new InsertMatjipWindow("맛집 등록 ver1.0");
	}
}









