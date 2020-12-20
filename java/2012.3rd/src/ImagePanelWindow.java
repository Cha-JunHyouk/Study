package senior;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
class ImagePanel extends JPanel{
	Image image;
	Toolkit toolkit;
	ImagePanel(){
		toolkit = Toolkit.getDefaultToolkit();//toolkit����
		image = toolkit.getImage("src/senior/Tulips.jpg");
		//�гο� ����� �̹��� ���
	}
	//paint�޼��带 �������̵� �Ѵ�.
	@Override
	public void paint(Graphics g) {
		int width = this.getWidth(); int height = this.getHeight();
		//���� �г��� ���α��̿� ���α��̸� ���´�.
//		int width = image.getWidth(this);
//		int height = image.getHeight(this);
		//���� �̹��������� ���α��̿� ���α��̸� ���´�.
		if(image != null) {
			g.drawImage(image, 0, 0, width, height, this);
		}//�̹����� �����Ǿ� ������ ����Ѵ�.
	}
}
public class ImagePanelWindow extends JFrame {
	public ImagePanelWindow(String str) {
		super(str);
		ImagePanel ip = new ImagePanel();//�̹��� �г� ����
		this.add("Center", ip);//�̹��� �г��� ������ ��� ��ġ
		this.setBounds(200, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ImagePanelWindow("�̹��� ��� ver1.0");
	}
}









