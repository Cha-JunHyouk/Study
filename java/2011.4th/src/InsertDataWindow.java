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
		if(obj == change) {//���� ��ư�� ���� ���
			String id = inputData.inputs[0].getText();//������ �ҷ���
			int r = JOptionPane.showConfirmDialog(this, 
				"������ �����Ͻðڽ��ϱ�?");
			if(r == JOptionPane.OK_OPTION) {//���� �������
				if(id.equals("")) {//������ ���� ���
					JOptionPane.showMessageDialog(this, 
						"������ ������ �Էµ��� �ʾҽ��ϴ�.");
				}else {//������ �ִ� ���
					//DB����->����->DB����
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
								"�����۾��� �Ϸ�Ǿ����ϴ�.");
						}else {
							JOptionPane.showMessageDialog(this, 
								"�����۾� �� ������ �߻��߽��ϴ�.");
						}
					}else {
						JOptionPane.showMessageDialog(this, 
							"DB���ӿ� �����߽��ϴ�.");
					}
				}
			}
		}else if(obj == select) {//��ȸ��ư�� ���� ���
			String id = inputData.inputs[0].getText();
			if(id.equals("")) {//������ �Էµ��� ���� ���
				JOptionPane.showMessageDialog(this, 
					"��ȸ�� ������ �Էµ��� �ʾҽ��ϴ�.");
			}else {//������ �Էµ� ���
				MyDB db = new MyDB(this);
				if(db.db_conn()) {//����
					Remeber_jaegu jaegu = db.select(id);
					//��ȸ�� ����,��ȣ,�̸�,�ּ�,����,���ڸ�
					if(jaegu == null) {
						JOptionPane.showMessageDialog(this, 
							"��ȸ����� �������� �ʽ��ϴ�.");
					}else {
						inputData.inputs[0].setText(jaegu.getId());
						inputData.inputs[1].setText(jaegu.getPassword());
						inputData.inputs[2].setText(jaegu.getGender());
						inputData.inputs[3].setText(jaegu.getAddress());
						inputData.inputs[4].setText(jaegu.getName());
						inputData.inputs[5].setText(jaegu.getPhonenumber());
						inputData.inputs[6].setText(jaegu.getStar());
						JOptionPane.showMessageDialog(this, 
							"��ȸ�� �Ϸ�Ǿ����ϴ�.");
					}
					db.db_disconn();//���� ����
				}
			}
		}else if(obj == delete) {//������ư�� ���� ���
			int select=JOptionPane.showConfirmDialog(this,
					"������ �����Ͻðڽ��ϱ�?");
			if(select == JOptionPane.OK_OPTION) {//��
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
						"DB���ӿ� �����߽��ϴ�.");
				}
			}
		}else if(obj == insert) {//��Ϲ�ư�� ���� ���
			//��ư 2��¥�� ���̾�α� ����//����
			String[] str = {"��","�ƴϿ�"};//��ư ����
			int select = JOptionPane.showOptionDialog(this, 
				"���Ͻô� �۾��� �����ϼ���", 
				"��ȭ����", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, str, str[0]);
			if(select == JOptionPane.OK_OPTION) {
				//���� �������
				//DB����->�Է��ѵ����͸� ����->DB����
				MyDB myDB = new MyDB(this);
				if(myDB.db_conn()) {
					//�Է��� �����͸� �ҷ��´�.
					String id=inputData.inputs[0].getText();//����
					String pwd=inputData.inputs[1].getText();//��ȣ
					String gender=inputData.inputs[2].getText();//����
					String addr=inputData.inputs[3].getText();//�ּ�
					String name=inputData.inputs[4].getText();//�̸�
					String number=inputData.inputs[5].getText();//����ó
					String star=inputData.inputs[6].getText();//���ڸ�
					//DTO�� �����ϰ� ���͸� ����Ͽ� �����͸� �ִ´�.
					Remeber_jaegu jaegu=new Remeber_jaegu();
					jaegu.setId(id); jaegu.setPassword(pwd);
					jaegu.setGender(gender); jaegu.setAddress(addr);
					jaegu.setName(name); jaegu.setPhonenumber(number);
					jaegu.setStar(star);
					//�����Ѵ�.
					myDB.insert(jaegu);
					myDB.db_disconn();//DB����
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB���ӿ� �����߽��ϴ�.");
				}
			}else if(select == JOptionPane.NO_OPTION) {
				//�ƴϿ��� �������
				
			}
			//��ư 2��¥�� ���̾�α� ����//��
//			int input = JOptionPane.showConfirmDialog(this, 
//				"������ ����Ͻðڽ��ϱ�?");
//			if(input == JOptionPane.OK_OPTION) {
//				//���� �������
//				System.out.println("���� ����");
//			}else if(input == JOptionPane.NO_OPTION) {
//				//�ƴϷθ� �������
//				System.out.println("�ƴϿ��� ����");
//			}else if(input == JOptionPane.CANCEL_OPTION) {
//				//��Ҹ� �������
//				System.out.println("��Ҹ� ����");
//			}
		}else if(obj == cancel) {//��ҹ�ư�� �������
			int input = JOptionPane.showConfirmDialog(this, 
				"������ ����Ͻðڽ��ϱ�?");
		}
	}
	InputData inputData; 
	JButton insert,cancel,delete,select,change;
	JPanel btnPan;
	public InsertDataWindow(String str) {
		super(str);
		inputData = new InputData();
		this.add("Center",inputData);
		insert = new JButton(" ��� ");
		insert.addActionListener(this);
		delete = new JButton(" ���� ");
		delete.addActionListener(this);
		select = new JButton(" ��ȸ ");
		select.addActionListener(this);
		change = new JButton(" ���� ");
		change.addActionListener(this);
		cancel = new JButton(" ��� ");
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
		new InsertDataWindow("�ڷ��� ver1.0");
	}
}










