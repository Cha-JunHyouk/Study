package senior;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class LoadImage extends JPanel{
	Image image; Toolkit toolkit;
	void setPath(String path) {
		toolkit = Toolkit.getDefaultToolkit();
		image = toolkit.getImage(path);//���޹��� �̹�����η� ����open
	}
	public void paint(Graphics g) {
		int w = this.getWidth(); int h = this.getHeight();
		g.clearRect(0, 0, w, h);//�г��� ũ�⸸ŭ�� ������ ������ ����
		if(image != null) {
			g.drawImage(image, 0, 0, w, h, this);
		}//�̹����� �����ϸ�, �ش� �̹����� �г��� ũ�⸸ŭ ���
	}
}
public class ImageLoadWindow extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fd = new FileDialog(this,"���� ����", FileDialog.LOAD);
		//this:���ϴ��̾�αװ� �����ִ� ������ ��ü
		//"���� ����":���ϴ��̾�α��� ����
		//FileDialog.LOAD:���ϴ��̾�α��� ����
		//				(���Ͽ���:LOAD, ��������:SAVE)
		fd.setVisible(true);//���� ���̾�α� ���
		String path = fd.getDirectory()+fd.getFile();
		//System.out.println("������ ����:"+path);
		text.setText(path);//������ ������ �̸��� ��θ� �ؽ�Ʈ�ʵ忡 ���
		li.setPath(path);
		li.repaint();//�г��� �ٽ� �׸���.
	}
	FileDialog fd;
	JButton load; JTextField text; JPanel controlPan; LoadImage li;
	public ImageLoadWindow(String str) {
		super(str);
		load = new JButton("�̹��� �ε�");
		load.addActionListener(this);
		text = new JTextField(20);//������ ������ ��ΰ� ��µ�
		controlPan = new JPanel();
		controlPan.add(text); controlPan.add(load);
		li = new LoadImage();
		this.add("Center",li);
		this.add("South",controlPan);
		this.setBounds(200, 100, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ImageLoadWindow("�̹��� �ε� ver1.0");
	}
}















