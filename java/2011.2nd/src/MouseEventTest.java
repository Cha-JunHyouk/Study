package chajh;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

//마우스 이벤트(MouseEvent), 
//마우스 모션 이벤트(MouseMotionEvent)
public class MouseEventTest extends JFrame 
	implements MouseListener,MouseMotionListener{
	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("마우스 드래그");
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println(arg0.getX()+","+
					arg0.getY());
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("마우스 클릭");
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println(
			"마우스가 윈도우 안으로 들어옴");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println(
			"마우스가 윈도우 밖으로 나감");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("마우스 버튼을 누름");
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("마우스 버튼을 놓음");
	}
	public MouseEventTest(String str) {
		super(str);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MouseEventTest("마우스 이벤트");
	}
}







