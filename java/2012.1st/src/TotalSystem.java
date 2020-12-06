package senior;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TotalSystem extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();//�̺�Ʈ�� �ҽ�(�ٿ���)�� �ҷ���
		if(obj == i1) {//ù��° �޴��������� Ŭ���� ���
			card.show(slide, "������");
		}else if(obj == i2) {//�ι�° �޴��������� Ŭ���� ���
			card.show(slide, "��ǰ����");
		}else if(obj == i3) {//����° �޴��������� Ŭ���� ���
			card.show(slide, "��������");
		}else if(obj == i4) {//�׹��� �޴��������� Ŭ���� ���
			//��� �޴��� ��Ȱ��ȭ �Ѵ�.
			custom.setEnabled(false);
			item.setEnabled(false);
			matjip.setEnabled(false);
			logout.setEnabled(false);
			//�������� ���񿡼� ������ �����Ѵ�.
			this.setTitle("���������ý��� ver1.0");
			//ȭ���� "�α���"���� �ٲ۴�.
			card.show(slide, "�α���");
			//"�α���"�� ����ߴ� ������ ��ȣ�� �����.
			ls.id.setText(""); ls.pwd.setText("");
		}
	}
	JMenuBar mb; JMenu custom, item, matjip, logout; 
	JMenuItem i1,i2,i3,i4;
	CardLayout card; JPanel slide;
	public TotalSystem(String str) {
		super(str);
		mb = new JMenuBar();
		custom = new JMenu("������ �ý���");
		item = new JMenu("��ǰ���� �ý���");
		matjip = new JMenu("�������� �ý���");
		logout = new JMenu("�α׾ƿ�");
		i1 = new JMenuItem("������ �ý��� ����");
		i1.addActionListener(this);
		i2 = new JMenuItem("��ǰ���� �ý��� ����");
		i2.addActionListener(this);
		i3 = new JMenuItem("�������� �ý��� ����");
		i3.addActionListener(this);
		i4 = new JMenuItem("�α׾ƿ� ����");
		i4.addActionListener(this);
		custom.add(i1); item.add(i2); matjip.add(i3); logout.add(i4);
		mb.add(custom); mb.add(item); mb.add(matjip); 
		mb.add(Box.createHorizontalGlue());//�α׾ƿ��� �� ���������� ��
		mb.add(logout);
		this.setJMenuBar(mb);
		makePanel();
		this.setSize(800, 600); this.setVisible(true);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	LoginSystem ls;
	void makePanel() {
		card = new CardLayout();
		ls = new LoginSystem(this);
		slide = new JPanel(); slide.setLayout(card);//��ġ������ ����
		slide.add(ls,"�α���");
		slide.add(new InsertDataWindow(),"������");
		slide.add(new InsertItemWindow(),"��ǰ����");
		slide.add(new InsertMatjipWindow(),"��������");
		card.show(slide, "�α���");//"�α���"�̸��� �г��� ���
		this.add("Center", slide);
		//�Ʒ�. ��� �޴��� ��Ȱ��ȭ �Ѵ�. ��? �α����ϱ� ���̹Ƿ�
		custom.setEnabled(false); item.setEnabled(false);
		matjip.setEnabled(false); logout.setEnabled(false);
	}
	public static void main(String[] args) {
		new TotalSystem("���������ý��� ver1.0");
	}
}














