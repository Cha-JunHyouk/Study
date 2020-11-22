import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonImageWindow extends JFrame {
	ImageIcon[] icons; String path = "src/senior/";
	String[] files = {"b1.gif","b1d.gif","b1p.gif",
		"b2.gif","b2d.gif","b2p.gif",
		"b3.gif","b3d.gif","b3p.gif"};
	JButton btn1, btn2, btn3; JPanel pan;
	public ButtonImageWindow(String title) {
		super(title);
		icons = new ImageIcon[9];
		for(int i=0; i<icons.length; i++) {
			icons[i] = new ImageIcon(path+files[i]);
		}//�̹��� ������ 9�� ����
		btn1 = new JButton();//��ư ����
		btn1.setIcon(icons[0]);//��ư�� �̹��� ����
		btn1.setPressedIcon(icons[1]);//�������� �̹�������
		btn1.setRolloverIcon(icons[2]);
		//��ư�� ���콺�� ���� �� �̹��� ����
		btn2 = new JButton();//��ư ����
		btn2.setIcon(icons[3]);
		btn2.setPressedIcon(icons[4]);
		btn2.setRolloverIcon(icons[5]);
		btn3 = new JButton();
		btn3.setIcon(icons[6]);
		btn3.setPressedIcon(icons[7]);
		btn3.setRolloverIcon(icons[8]);
		pan = new JPanel(); 
		pan.add(btn1); pan.add(btn2); pan.add(btn3);
		this.add("Center",pan);
		this.setSize(400, 300); this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ButtonImageWindow("�̹��� ��ư ver1.0");
	}
}












