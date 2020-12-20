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
		image = toolkit.getImage(path);//전달받은 이미지경로로 파일open
	}
	public void paint(Graphics g) {
		int w = this.getWidth(); int h = this.getHeight();
		g.clearRect(0, 0, w, h);//패널의 크기만큼의 영역을 깨끗이 지움
		if(image != null) {
			g.drawImage(image, 0, 0, w, h, this);
		}//이미지가 존재하면, 해당 이미지를 패널의 크기만큼 출력
	}
}
public class ImageLoadWindow extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fd = new FileDialog(this,"파일 열기", FileDialog.LOAD);
		//this:파일다이얼로그가 속해있는 윈도우 객체
		//"파일 열기":파일다이얼로그의 제목
		//FileDialog.LOAD:파일다이얼로그의 역할
		//				(파일열기:LOAD, 파일저장:SAVE)
		fd.setVisible(true);//파일 다이얼로그 출력
		String path = fd.getDirectory()+fd.getFile();
		//System.out.println("선택한 파일:"+path);
		text.setText(path);//선택한 파일의 이름과 경로를 텍스트필드에 출력
		li.setPath(path);
		li.repaint();//패널을 다시 그린다.
	}
	FileDialog fd;
	JButton load; JTextField text; JPanel controlPan; LoadImage li;
	public ImageLoadWindow(String str) {
		super(str);
		load = new JButton("이미지 로드");
		load.addActionListener(this);
		text = new JTextField(20);//선택한 파일의 경로가 출력됨
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
		new ImageLoadWindow("이미지 로드 ver1.0");
	}
}















