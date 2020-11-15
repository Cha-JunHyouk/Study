package chajh;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

//���콺 �̺�Ʈ(MouseEvent), 
//���콺 ��� �̺�Ʈ(MouseMotionEvent)
public class MouseEventTest extends JFrame 
	implements MouseListener,MouseMotionListener{
	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("���콺 �巡��");
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println(arg0.getX()+","+
					arg0.getY());
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("���콺 Ŭ��");
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println(
			"���콺�� ������ ������ ����");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println(
			"���콺�� ������ ������ ����");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("���콺 ��ư�� ����");
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("���콺 ��ư�� ����");
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
		new MouseEventTest("���콺 �̺�Ʈ");
	}
}







