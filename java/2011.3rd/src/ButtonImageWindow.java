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
		}//이미지 아이콘 9개 생성
		btn1 = new JButton();//버튼 생성
		btn1.setIcon(icons[0]);//버튼에 이미지 설정
		btn1.setPressedIcon(icons[1]);//눌렀을때 이미지설정
		btn1.setRolloverIcon(icons[2]);
		//버튼에 마우스가 왔을 때 이미지 설정
		btn2 = new JButton();//버튼 생성
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
		new ButtonImageWindow("이미지 버튼 ver1.0");
	}
}












