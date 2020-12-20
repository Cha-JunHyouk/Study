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
		toolkit = Toolkit.getDefaultToolkit();//toolkit생성
		image = toolkit.getImage("src/senior/Tulips.jpg");
		//패널에 출력할 이미지 경로
	}
	//paint메서드를 오버라이드 한다.
	@Override
	public void paint(Graphics g) {
		int width = this.getWidth(); int height = this.getHeight();
		//현재 패널의 가로길이와 세로길이를 얻어온다.
//		int width = image.getWidth(this);
//		int height = image.getHeight(this);
		//원본 이미지파일의 가로길이와 세로길이를 얻어온다.
		if(image != null) {
			g.drawImage(image, 0, 0, width, height, this);
		}//이미지가 설정되어 있으면 출력한다.
	}
}
public class ImagePanelWindow extends JFrame {
	public ImagePanelWindow(String str) {
		super(str);
		ImagePanel ip = new ImagePanel();//이미지 패널 생성
		this.add("Center", ip);//이미재 패널을 윈도우 가운데 배치
		this.setBounds(200, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ImagePanelWindow("이미지 출력 ver1.0");
	}
}









