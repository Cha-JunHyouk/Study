import javax.swing.*;

public class MenuWindow extends JFrame {
	JMenuBar menuBars;
	JMenu menuA, menuB, menuC;
	JMenuItem option, exit, properties, maximize;
	JMenuItem zoomIn, zoomOut;
	JTabbedPane tabs;
	public MenuWindow(String str) {
		super(str);
		menuBars=new JMenuBar();
		menuA=new JMenu("File(F)");
		menuB=new JMenu("View(V)");
		menuC=new JMenu("View option");
		zoomIn=new JMenuItem("Zoom in");
		zoomOut=new JMenuItem("Zoom out");
		option=new JMenuItem("Option");
		exit=new JMenuItem("Exit");
		properties=new JMenuItem("Properties");
		maximize=new JMenuItem("Maximize");
		menuA.add(option);
		menuA.add(exit);
		menuB.add(properties);
		menuB.add(maximize);
		menuC.add(zoomIn);
		menuC.add(zoomOut);
		menuB.addSeparator();
		menuB.add(menuC);
		menuBars.add(menuA);
		menuBars.add(menuB);
		this.setJMenuBar(menuBars);
		tabs=new JTabbedPane();
		JPanel p1=new MenuInfo();
		JPanel p2=new OrderSystem();
		tabs.addTab("메뉴 안내", p1);
		tabs.addTab("주문", p2);
		this.add("Center",tabs);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MenuWindow("분식 주문 시스템 ver1.0");
	}
}











