import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu2Window extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == i4) {//������ ���� �޴��������� ���
			
		}
	}
	JMenuBar mb;//�޴���
	JMenu m1,m2,m3,m4;//�޴��ٿ� �� �޴�
	JMenuItem i1,i2,i3,i4;//�޴��� �� �޴�������
	CardLayout card; JPanel slide;//ī�巹�̾ƿ���� �г�
	public Menu2Window(String str) {
		super(str);
		mb = new JMenuBar();
		m1 = new JMenu("���Ͼȳ�SYS");
		m2 = new JMenu("�������SYS");
		m3 = new JMenu("����� �ֹ� SYS");
		m4 = new JMenu("�α׾ƿ�");
		i1 = new JMenuItem("���Ͼȳ�SYS ����");
		i2 = new JMenuItem("�������SYS ����");
		i3 = new JMenuItem("����� �ֹ� SYS ����");
		i4 = new JMenuItem("�α׾ƿ� ����");
		m1.add(i1); m2.add(i2); m3.add(i3); m4.add(i4);
		mb.add(m1); mb.add(m2); mb.add(m3); 
		//m4�޴��� ������ ������ �̵�
		mb.add(Box.createHorizontalGlue());
		//�޴��ٿ� ��������� ������ ���� ���� ����
		mb.add(m4);
		this.setJMenuBar(mb);//�����쿡 �޴��� ����
		makePanel();
		this.setSize(800, 500); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		card = new CardLayout();//ī�巹�̾ƿ� ����
		slide = new JPanel();
		slide.setLayout(card);//�гο� ��ġ������ ����
		//slide�� �α���,���Ͼȳ�,�������,������ֹ��� ����
		slide.add(new LoginSystem(this),"�α���");
		slide.add(new MenuInfo(),"���Ͼȳ�");
		slide.add(new HRSystem(),"�������");
		slide.add(new OrderSystem(),"�����ֹ�");
		card.show(slide, "�α���");
		//"�α���"�̸��� �г��� �⺻���� ���
		this.add("Center", slide);
		//�α��� ���̹Ƿ� ��� �޴��� ��Ȱ��ȭ �Ѵ�.
		m1.setEnabled(false);
		m2.setEnabled(false);
		m3.setEnabled(false);
		m4.setEnabled(false);
	}
	public static void main(String[] args) {
		new Menu2Window("�޴������� ver2.0");
	}
}










