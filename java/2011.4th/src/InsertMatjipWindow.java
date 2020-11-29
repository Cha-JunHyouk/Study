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
		if(obj == search) {//��ȸ��ư�� �������
			String seqno = im.inputs[0].getText();
			if(seqno.equals("")) {//������ȣ�� ���� ���
				JOptionPane.showMessageDialog(this, 
					"��ȸ�� ������ȣ�� �Էµ��� �ʾҽ��ϴ�.");
			}else {
				MatjipUtility util = new MatjipUtility(this);
				if(util.db_conn()) {
					Matjip matjip = util.select(
							Integer.parseInt(seqno));
					if(matjip == null) {
						JOptionPane.showMessageDialog(this, 
							"��ȸ����� �������� �ʽ��ϴ�.");
					}else {
						im.inputs[0].setText(matjip.getNumber()+"");
						im.inputs[1].setText(matjip.getName());
						im.inputs[2].setText(matjip.getAddr());
						im.inputs[3].setText(matjip.getTel());
						im.inputs[4].setText(matjip.getMobile());
						JOptionPane.showMessageDialog(this, 
							"��ȸ�� �Ϸ�Ǿ����ϴ�.");
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB�� ���ӵ��� �ʾҽ��ϴ�.");
				}
			}
		}else if(obj == change) {//�����ư�� �������
			String seqno = im.inputs[0].getText();
			if(seqno.equals("")) {
				JOptionPane.showMessageDialog(this, 
					"������ ������ȣ�� �Էµ��� �ʾҽ��ϴ�.");
			}else {
				int s=JOptionPane.showConfirmDialog(this, 
					"������ �����Ͻðڽ��ϱ�?");
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
							"�����۾��� �Ϸ�Ǿ����ϴ�.");
					}else {
						JOptionPane.showMessageDialog(this, 
							"�����۾� �� ������ �߻��߽��ϴ�.");
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB ���ӿ� �����߽��ϴ�.");
				}
			}
		}else if(obj == insert) {//��Ϲ�ư�� �������
			//���̾�α׸� ����.
			int input=JOptionPane.showConfirmDialog(this, 
				"������ ����Ͻðڽ��ϱ�?");
			if(input == JOptionPane.OK_OPTION) {
			//���� �������,DB����->����->DB��������
				MatjipUtility util = new MatjipUtility(this);
				if(util.db_conn()) {//���Ӽ����ΰ��
					Matjip matjip = new Matjip();//DTO�� �����Ѵ�.
					matjip.setNumber(
						Integer.parseInt(im.inputs[0].getText()));
					matjip.setName(im.inputs[1].getText());
					matjip.setAddr(im.inputs[2].getText());
					matjip.setTel(im.inputs[3].getText());
					matjip.setMobile(im.inputs[4].getText());
					util.insert2(matjip);
//					if(util.insert1(matjip)) {//���Լ����ΰ��
//						JOptionPane.showMessageDialog(this, 
//							"���������� ��ϵǾ����ϴ�.");
//					}else {//���Խ����ΰ��
//						JOptionPane.showMessageDialog(this, 
//							"���������� ��ϵ��� �ʾҽ��ϴ�.");
//					}
				}else {//���ӽ����� ���
					JOptionPane.showMessageDialog(this, 
						"DB���ӿ� �����߽��ϴ�.");
				}
			}
		}else if(obj == cancel) {//��ҹ�ư�� �������
			int input=JOptionPane.showConfirmDialog(this, 
				"������ ����Ͻðڽ��ϱ�?");
			if(input == JOptionPane.OK_OPTION) {
			//�Է�â�� �Էµ� ��� �����͸� �����.
				im.inputs[0].setText("");//������ȣ
				im.inputs[1].setText("");//�̸�
				im.inputs[2].setText("");//�ּ�
				im.inputs[3].setText("");//��ȭ��ȣ
				im.inputs[4].setText("");//�������
			}
		}
	}
	JButton insert,cancel,search,change; JPanel pan; Font font;
	InputMatjip im;
	public InsertMatjipWindow(String str) {
		super(str);
		im = new InputMatjip();
		font = new Font("���ü",Font.BOLD,26);
		search = new JButton("������ȸ");
		search.setFont(font);
		search.addActionListener(this);
		change = new JButton("��������");
		change.setFont(font);
		change.addActionListener(this);
		insert =new JButton("�������");
		insert.setFont(font);//��ư�� ��Ʈ ����
		insert.addActionListener(this);
		cancel = new JButton(" ��� ");
		cancel.setFont(font);//��ư�� ��Ʈ ����
		cancel.addActionListener(this);
		pan = new JPanel();//��ư�� �� �г� ����
		pan.add(insert); pan.add(search); pan.add(change);
		pan.add(cancel);//�гο� ��ư����
		this.add("Center",im);
		this.add("South",pan);//�г��� ������ �Ʒ��� ����
		this.setSize(600, 600); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new InsertMatjipWindow("���� ��� ver1.0");
	}
}









