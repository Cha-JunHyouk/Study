package senior;

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

class BaseballModel extends AbstractTableModel {
	Object[][] data; int row, col; String[] columnName;
	void setRow(ResultSet rs) {//last()������ ResultSet
		try {
			rs.last();
			row = rs.getRow();
			rs.close();
		}catch(Exception e) {}
	}
	void setData(ResultSet rs) {//next()�� ������ ResultSet
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			col = rsmd.getColumnCount();
			columnName = new String[col];
			for(int x=0; x<col; x++) {
				columnName[x] = rsmd.getColumnName(x + 1);
			}
			data = new Object[row][col];
			int r = 0;
			while(rs.next()) {
				for(int k = 0; k < col; k++) {
					data[r][k] = rs.getObject(k + 1);
				}
				r++;
			}
			rs.close();
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}
}

class BaseballDB {
	Connection conn; PreparedStatement pstmt; 
	ResultSet rs; ResultSet rs2;
	String insert = "insert into bb_player values(?,?,?,?)";
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String select = "select * from bb_player where 1=1 ";
	ResultSet select2(BaseballPlayer bp) {
		try {
			if( ! bp.getTeam().equals("")) {//���̸��� �Էµ� ���
				select = select + " and team='"+bp.getTeam()+"'";
			}
			if( bp.getNum() != null) {//���ȣ�� null�� �ƴ� ���
				select = select + " and num="+bp.getNum();
			}
			if( ! bp.getName().equals("")) {//�����̸��� �Էµ� ���
				select = select + " and name='"+bp.getName()+"'";
			}
			if( ! bp.getPosition().equals("")) {//�������� �ԷµȰ��
				select = select + " and position='"+bp.getPosition()+"'";
			}
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs2 = pstmt.executeQuery();//last()�� ������ ResultSet
		}catch(Exception e) {
			
		}
		return rs2;
	}
	ResultSet select1(BaseballPlayer bp) {
		try {
			if( ! bp.getTeam().equals("")) {//���̸��� �Էµ� ���
				select = select + " and team='"+bp.getTeam()+"'";
			}
			if( bp.getNum() != null) {//���ȣ�� null�� �ƴ� ���
				select = select + " and num="+bp.getNum();
			}
			if( ! bp.getName().equals("")) {//�����̸��� �Էµ� ���
				select = select + " and name='"+bp.getName()+"'";
			}
			if( ! bp.getPosition().equals("")) {//�������� �ԷµȰ��
				select = select + " and position='"+bp.getPosition()+"'";
			}
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();//next()�� ������ ResultSet
		}catch(Exception e) {
			
		}
		return rs;
	}
	
	
	int insert(BaseballPlayer bp) {
		int flag = 0;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, bp.getTeam());
			pstmt.setInt(2, bp.getNum());
			pstmt.setString(3, bp.getName());
			pstmt.setString(4, bp.getPosition());
			pstmt.executeUpdate();//DB�� ����
		}catch(Exception e) {
			flag = 1;
		}
		return flag;//0�̸� ���Լ���, 1�̸� ����
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

class BaseballPlayer{
	private String team;//���̸�
	private Integer num;//���� ���ȣ
	private String name;//���� �̸�
	private String position;//���� ������
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
public class PlayerSystem extends JFrame 
	implements ActionListener, MouseListener{
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//���콺�� Ŭ���� JTable�� ���ȣ�� ����ȣ�� ã�´�.
		int row=table.getSelectedRow();//Ŭ���� ���ȣ
		int col=table.getSelectedColumn();//Ŭ���� ����ȣ
		//������ ���� 1���� ù��° �ؽ�Ʈ�ʵ忡 ����Ѵ�.
		txts[0].setText(table.getValueAt(row, 0)+"");
		//������ ���� 2���� �ι�° �ؽ�Ʈ�ʵ忡 ����Ѵ�.
		txts[1].setText(table.getValueAt(row, 1)+"");
		//������ ���� 3���� ����° �ؽ�Ʈ�ʵ忡 ����Ѵ�.
		txts[2].setText(table.getValueAt(row, 2)+"");
		//������ ���� 4���� �׹�° �ؽ�Ʈ�ʵ忡 ����Ѵ�.
		txts[3].setText(table.getValueAt(row, 3)+"");
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
		if(obj == btns[0]) {//���� ����� ���� ���
			boolean flag = true;
			for(int i=0; i<txts.length; i++) {
				if(txts[i].getText().equals("")) {
					JOptionPane.showMessageDialog(this, 
						titles[i]+"�� �Էµ��� �ʾҽ��ϴ�.");
					flag = false;
					break;//�ݺ�����
				}
			}//��� �Է»��׿� �����Ͱ� �ԷµǾ����� �˻�
			if(flag) {//��� �׸��� �Էµ� ���
				int j = JOptionPane.showConfirmDialog(this, 
					"������ �����Ͻðڽ��ϱ�?");
				if(j == JOptionPane.OK_OPTION) {//���� �������
					BaseballPlayer bp = new BaseballPlayer();//DTO����
					bp.setTeam(txts[0].getText());
					bp.setNum(Integer.parseInt(txts[1].getText()));
					bp.setName(txts[2].getText());
					bp.setPosition(txts[3].getText());
					BaseballDB db = new BaseballDB();
					if(db.db_conn()) {
						int get = db.insert(bp);
						if(get == 0) {//���Լ���
							JOptionPane.showMessageDialog(this, 
								"���������� ��ϵǾ����ϴ�.");
							db.db_disconn();//DB�� ��������
						}else {//���Խ���
							JOptionPane.showMessageDialog(this, 
								"��������� ���� �ʾҽ��ϴ�.");
						}//���Լ�������if�� ��
					}else {
						JOptionPane.showMessageDialog(this, 
							"DB�� ���ӵ��� �ʾҽ��ϴ�.");
					}//db���� if�� ��
				}//���� ��������� ��
			}
		}else if(obj == btns[1]) {//���� ��ȸ�� ���� ���
			BaseballDB db = new BaseballDB();
			//�Է��� �����͸� �о DTO�� �����Ѵ�.
			BaseballPlayer bp = new BaseballPlayer();//DTO����
			bp.setTeam(txts[0].getText());
			//���� ���ȣ�� �Է��� �ȵȰ��� 0���� ����
			if(txts[1].getText().equals("")) {
				bp.setNum(null);
			}else {
				bp.setNum(Integer.parseInt(txts[1].getText()));
			}
			bp.setName(txts[2].getText());
			bp.setPosition(txts[3].getText());
			//DTO�� ����ؼ� DB���� ��ȸ�Ѵ�.
			if(db.db_conn()) {
				ResultSet rs1 = db.select1(bp);
				ResultSet rs2 = db.select2(bp);//last()����
				BaseballModel bm = new BaseballModel();
				bm.setRow(rs2);
				bm.setData(rs1);
				table.setModel(bm);//JTable�� �� ����
				table.updateUI();//JTable ����
				db.db_disconn();//DB�� ���� ����
			}else {
				JOptionPane.showMessageDialog(this, 
					"DB�� ������� �ʾҽ��ϴ�.");
			}
		}
	}
	JLabel[] lbls; JTextField[] txts; JButton[] btns;
	JPanel[] pans; JTable table; JScrollPane span;
	String[] titles = {"���̸�","���ȣ","�����̸�","������"};
	String[] btnTitles = {"���� ���","���� ��ȸ"};
	JPanel centerPan; JPanel centerLeft;
	void makeWindow() {
		table = new JTable(); 
		table.addMouseListener(this);
		span = new JScrollPane(table);
		centerPan = new JPanel(); 
		centerPan.setLayout(new GridLayout(1,2));
		centerPan.add(centerLeft); centerPan.add(span);
		this.add("Center", centerPan);
		this.setBounds(100, 150, 600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(5,1));//5�� 1��
		pans = new JPanel[5];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			if(i == 4) {//������ �гο��� ��ư�� ���δ�.
				pans[i].add(btns[0]); pans[i].add(btns[1]);
			}else {//������ �г��� ������ �гο� ���̺�,�ؽ�Ʈ�ʵ带 ����
				pans[i].add(lbls[i]);//�гο� ���̺��� ����
				pans[i].add(txts[i]);//�гο� �ؽ�Ʈ�ʵ� ����
			}
			centerLeft.add(pans[i]);//centerLeft�� �г��� ���δ�.
		}//centerLeft�� �� �г� 5�� ����
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i=0; i < lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
		}
	}
	void makeButton() {
		btns = new JButton[btnTitles.length];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].addActionListener(this);
		}
	}
	void makeTextField() {
		txts = new JTextField[titles.length];
		for(int i=0; i< txts.length; i++) {
			txts[i] = new JTextField(20);
		}
	}
	public PlayerSystem(String str) {
		super(str);
		makeLabel();
		makeTextField();
		makeButton();
		makePanel();
		makeWindow();
	}
	public static void main(String[] args) {
		new PlayerSystem("�߱��������� �ý��� ver1.0");
	}

}












