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
		if(obj == insert) {//��ǰ��� ��ư�� �������
			int select = JOptionPane.showConfirmDialog(this,
				"������ �����Ͻðڽ��ϱ�?");
			if(select == JOptionPane.OK_OPTION) {//���� �������
				DBUtility db = new DBUtility();
				if(db.db_conn()) {//DB�� ����
					String code=ii.inputs[0].getText();
					String name=ii.inputs[1].getText();
					String intro=ii.inputs[2].getText();
					int price=Integer.parseInt(
							ii.inputs[3].getText());
					String origin=ii.inputs[4].getText();
					Item item = new Item();//DTO����
					item.setCode(code); item.setName(name);
					item.setIntro(intro);item.setPrice(price);
					item.setOrigin(origin);
					if(db.insert(item) > 0) {
						db.db_disconn();//DB���� ����
						JOptionPane.showMessageDialog(this, 
							"��ǰ������ ��ϵǾ����ϴ�.");
					}else {
						JOptionPane.showMessageDialog(this, 
							"��ǰ������ ��ϵ��� �ʾҽ��ϴ�.");
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB�� ���ӵ��� �ʾҽ��ϴ�.");
				}
			}
		}else if(obj == cancel) {//��ҹ�ư�� �������
			
		}
	}
	JButton insert,cancel; JPanel pan; Font font; 
	InputItem ii;//��ǰ���ȭ�� �г�
	public InsertItemWindow(String str) {
		super(str);
		ii = new InputItem();//��ǰ���ȭ�� ����
		//this:����ִ� InsertItemWindow�ν��Ͻ�(��,������)
		font = new Font("���ü",Font.BOLD,26);
		insert = new JButton(" ��ǰ��� ");
		insert.addActionListener(this);
		insert.setFont(font);//��ư�� ��Ʈ����
		cancel = new JButton(" ��� ");
		cancel.addActionListener(this);
		cancel.setFont(font);//��ư�� ��Ʈ����
		pan = new JPanel();//��ư�� �� �гλ���
		pan.add(insert); pan.add(cancel);//�гο� ��ư����
		this.add("Center",ii);
		this.add("South", pan);//ȭ��Ʒ��� ��ư�� ����
		this.setSize(600, 700); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new InsertItemWindow("��ǰ��� ver1.0");
	}
}









