package senior;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class SoccerModel extends AbstractTableModel {
	Object[][] data; int row,col; String[] columnName;
	void setRow(ResultSet rs) {//�హ���� �����ϴ� �޼���
		try {
			rs.last();	row = rs.getRow();	rs.close();
		}catch(Exception e) {}
	}
	void setData(ResultSet rs) {//2�����迭�� DB��ȸ����� �����ϴ¸޼���
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			col = rsmd.getColumnCount();
			columnName = new String[col];
			for(int i=0; i<col; i++) {
				columnName[i] = rsmd.getColumnName(i + 1);
			}
			data = new Object[row][col];
			int r = 0;
			while(rs.next()) {
				for(int i=0; i<col; i++) {
					data[r][i] = rs.getObject(i + 1);
				}
				r++;
			}
		}catch(Exception e) {}
	}
	@Override
	public int getColumnCount() {
		return col;
	}
	@Override
	public int getRowCount() {
		return row;
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}
	@Override
	public String getColumnName(int arg0) {
		return columnName[arg0];
	}
}

class SoccerDB {
	Connection conn; PreparedStatement pstmt; 
	ResultSet rs; ResultSet rs2;
	String insert = "insert into fb_player values(?,?,?,?,?)";
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String select = "select * from fb_player where 1=1 ";
	
	ResultSet selectAll1() {//next()�� ������ ResultSet����
		try {
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs;
	}
	ResultSet selectAll2() {//last()�� ������ ResultSet����
		try {
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs2;
	}
	
	ResultSet select2(SoccerPlayer sp) {//last()������ ResultSet����
		try {
			if( !sp.getTeam_name().equals("")) {//������ �ԷµȰ��
				select=
					select + " and team_name='"+sp.getTeam_name()+"'";
			}
			if( !sp.getName().equals("")) {//�������� �Էµ� ���
				select=select+" and name='"+sp.getName()+"'";
			}
			if( sp.getBack_num() != null) {//���ȣ�� �Էµ� ���
				select=select+" and back_num="+sp.getBack_num();
			}
			if( !sp.getPosition().equals("")) {//�������� �Էµ� ���
				select=select+" and position='"+sp.getPosition()+"'";
			}
			if( sp.getGoal()!=null) {//�������� �Էµ� ���
				select = select + " and goal="+sp.getGoal();
			}
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs2;
	}
	ResultSet select1(SoccerPlayer sp) {//next()��������ResultSet����
		try {
			if( !sp.getTeam_name().equals("")) {//������ �ԷµȰ��
				select=
					select + " and team_name='"+sp.getTeam_name()+"'";
			}
			if( !sp.getName().equals("")) {//�������� �Էµ� ���
				select=select+" and name='"+sp.getName()+"'";
			}
			if( sp.getBack_num() != null) {//���ȣ�� �Էµ� ���
				select=select+" and back_num="+sp.getBack_num();
			}
			if( !sp.getPosition().equals("")) {//�������� �Էµ� ���
				select=select+" and position='"+sp.getPosition()+"'";
			}
			if( sp.getGoal()!=null) {//�������� �Էµ� ���
				select = select + " and goal="+sp.getGoal();
			}
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs;
	}
	
	boolean insert(SoccerPlayer player) {
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, player.getTeam_name());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3, player.getBack_num());
			pstmt.setString(4, player.getPosition());
			pstmt.setInt(5, player.getGoal());
			pstmt.executeUpdate();//DB�� ����
			flag = true;
		}catch(Exception e) {
			
		}
		return flag;//�����̸� true, �����̸� false ����
	}
	
	boolean db_conn() {
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"hr","hr");
			flag = true;
		}catch(Exception e) {}
		return flag;
	}
	void db_disconn() {
		try {
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
}
class SoccerPlayer {
	private String team_name;//���̸�
	private String name;//�����̸�
	private Integer back_num;//���ȣ
	private String position;//������
	private Integer goal;//������
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBack_num() {
		return back_num;
	}
	public void setBack_num(Integer back_num) {
		this.back_num = back_num;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getGoal() {
		return goal;
	}
	public void setGoal(Integer goal) {
		this.goal = goal;
	}
}
public class SoccerSystem extends JFrame 
	implements ActionListener, MouseListener{
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//Ŭ���� ���� ���ȣ�� ã�´�.
		int row = table.getSelectedRow();
		//1�� ���� 5�������� �����͸� �ؽ�Ʈ�ʵ忡 ����Ѵ�.
		txts[0].setText(table.getValueAt(row, 0)+"");//1�� ���
		txts[1].setText(table.getValueAt(row, 1)+"");//2�����
		txts[2].setText(table.getValueAt(row, 2)+"");//3�� ���
		txts[3].setText(table.getValueAt(row, 3)+"");//4�� ���
		txts[4].setText(table.getValueAt(row, 4)+"");//5�� ���
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btns[0]) {//���� ��� ��ư�� ���� ���
			boolean flag = true;//��� �׸� �����Ͱ� �Էµ� ��� true
			for(int i=0; i<txts.length; i++) {
				if(txts[i].getText().equals("")) {//�����Ͱ� ���°��
					JOptionPane.showMessageDialog(this, 
						titles[i]+"��(��) �Էµ��� �ʾҽ��ϴ�.");
					flag = false;//�����Ͱ� �Էµ��� �ʾҽ��� �ǹ�
					break;//�ݺ��� ����
				}
			}//��� �ؽ�Ʈ�ʵ带 �ݺ��ϸ鼭 �˻�
			if(flag) {//flag�� true�� ���,�� ��� �����Ͱ� �ԷµȰ��
				//DTO�� �Էµ����͸� �Է��ϰ�, DB�� �����Ѵ�.
				SoccerDB db = new SoccerDB();
				SoccerPlayer sp = new SoccerPlayer();//DTO����
				sp.setTeam_name(txts[0].getText());
				sp.setName(txts[1].getText());
				sp.setBack_num(Integer.parseInt(txts[2].getText()));
				sp.setPosition(txts[3].getText());
				sp.setGoal(Integer.parseInt(txts[4].getText()));
				if(db.db_conn()) {
					int re = JOptionPane.showConfirmDialog(this, 
						"������ ����Ͻðڽ��ϱ�?");
					if(re == JOptionPane.OK_OPTION) {//���� �����Ѱ��
						boolean y = db.insert(sp);
						ResultSet rs1 = db.selectAll1();//next()����
						ResultSet rs2 = db.selectAll2();//last()����
						SoccerModel sm = new SoccerModel();
						sm.setRow(rs2);
						sm.setData(rs1);
						table.setModel(sm);
						table.updateUI();
						db.db_disconn();//DB���� ����
						if(y) {//����� ������ ���
							JOptionPane.showMessageDialog(this, 
								"������ ��ϵǾ����ϴ�.");
						}else {//����� ������ ���
							JOptionPane.showMessageDialog(this, 
								"������ ��ϵ��� �ʾҽ��ϴ�.");
						}
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB�� ������� �ʾҽ��ϴ�.");
				}
			}else {//��� �����Ͱ� �Էµ��� ���� ���
				//�̹� �޼����� ��µǾ����Ƿ� �ƹ��ϵ� ���� �ʴ´�.
			}
		}else if(obj == btns[1]) {//���� ��ȸ ��ư�� ���� ���
			SoccerDB db = new SoccerDB();
			SoccerPlayer sp = new SoccerPlayer();//DTO����
			sp.setTeam_name(txts[0].getText());
			sp.setName(txts[1].getText());
			if(txts[2].getText().equals("")) {//���ȣ�� �Էµ��� ����
				sp.setBack_num(null);
			}else {
				sp.setBack_num(Integer.parseInt(txts[2].getText()));
			}
			sp.setPosition(txts[3].getText());
			if(txts[4].getText().equals("")) {//�������� �Էµ��� ����
				sp.setGoal(null);
			}else {
				sp.setGoal(Integer.parseInt(txts[4].getText()));
			}
			if(db.db_conn()) {
				//DB���� �˻�->�˻������ �𵨷�����->JTable�� ���
				ResultSet rs1 = db.select1(sp);
				ResultSet rs2 = db.select2(sp);
				SoccerModel sm = new SoccerModel();
				sm.setRow(rs2);//last()�� ������ ResultSet�� ����
				sm.setData(rs1);//next()�� ������ ResultSet�� ����
				table.setModel(sm);//JTable�� ���� ����
				table.updateUI();//JTable ����
			}else {
				JOptionPane.showMessageDialog(this, 
					"DB�� ������� �ʾҽ��ϴ�.");
			}
		}
	}
	String[] titles = {"���̸�","������","���ȣ","������","������"};
	String[] btnTitles = {"�������", "������ȸ"};
	JLabel[] lbls; JTextField[] txts; JButton[] btns;
	JTable table; JScrollPane span; JPanel[] pans;
	JPanel centerPan; JPanel centerLeft; Font font;
	public SoccerSystem(String str) {
		super(str);
		font = new Font("���ü",Font.BOLD, 20);
		makeLabel(); makeTextField(); makeButton(); makePanel();
		makeWindow();
	}
	void makeWindow() {
		table = new JTable(); 
		table.addMouseListener(this);
		span = new JScrollPane(table);
		centerPan = new JPanel(); 
		centerPan.setLayout(new GridLayout(1,2));//1�� 2��
		centerPan.add(centerLeft); centerPan.add(span);
		this.add("Center", centerPan);
		this.setBounds(100, 150, 800, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(6,1));//6��1��
		pans = new JPanel[6];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			if(i == 5) {//6��° �г��� ���
				pans[i].add(btns[0]); pans[i].add(btns[1]);
			}else {//6��° �г��� �ƴ� ���
				pans[i].add(lbls[i]); pans[i].add(txts[i]);
			}
			centerLeft.add(pans[i]);//������ �г��� centerLeft�� ����
		}
	}
	void makeButton() {
		btns = new JButton[btnTitles.length];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].setFont(font);//������ ��ư�� ��Ʈ ����
			btns[i].addActionListener(this);
		}
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i = 0; i< lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
			lbls[i].setFont(font);//������ ���̺� ��Ʈ ����
		}
	}
	void makeTextField() {
		txts = new JTextField[titles.length];
		for(int i=0; i < txts.length; i++) {
			txts[i] = new JTextField(20);
			txts[i].setFont(font);//������ �ؽ�Ʈ�ʵ忡 ��Ʈ ����
		}
	}
	public static void main(String[] args) {
		new SoccerSystem("�౸���� ���� �ý��� ver1.0");
	}
}












