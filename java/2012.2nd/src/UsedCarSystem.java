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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class UsedCarModel extends AbstractTableModel {
	Object[][] data; int row,col; String[] columnName;
	void setRow(ResultSet rs) {
		try {
			rs.last(); row = rs.getRow(); rs.close();
		}catch(Exception e) {}
	}
	void setData(ResultSet rs) {
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
				for(int i = 0; i<col; i++) {
					data[r][i] = rs.getObject(i + 1);
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
	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}
	@Override
	public String getColumnName(int arg0) {
		return columnName[arg0];
	}
}

class UsedCarDB {
	Connection conn; PreparedStatement pstmt; 
	ResultSet rs; ResultSet rs2;
	String insert = "insert into used_car values(?,?,?,?,?,?,?)";
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String select = "select * from used_car where 1=1 ";
	
	ResultSet selectAllLast() {
		try {
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs;
	}
	ResultSet selectAllNext() {
		try {
			pstmt = conn.prepareStatement(select);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs2;
	}
	ResultSet selectLast(UsedCar uc) {
		try {
			if( ! uc.getNum().equals("")) {//������ȣ�� �Էµ� ���
				select=select+" and num='"+uc.getNum()+"'";
			}
			if( uc.getMaker() != null) {//�����簡 �Էµ� ���(�޺�)
				select=select+" and maker='"+uc.getMaker()+"'";
			}
			//�����͸� �Է��ϴ� ���� �ƴϰ�, �޺��ڽ����� �����ϴ� ���̹Ƿ�
			//�Է��� ������ ������(���̰� ���� ���ڿ�)�� ���ϴ� ���� �ƴ϶�,
			//�����ߴ����� ���ϴ� ���̹Ƿ� null�� ���ؾ� �Ѵ�.
			if( ! uc.getModel().equals("")) {//�𵨸��� �Էµ� ���
				select=select+" and model='"+uc.getModel()+"'";
			}
			if( uc.getMake_year() != null) {//�������� �ԷµȰ��(�޺�)
				select=select+" and make_year='"+uc.getMake_year()+"'";
			}
			if(uc.getKm() != null) {//����Ÿ�(����)�� �Էµ� ���
				select=select+" and km="+uc.getKm();
			}
			if( uc.getFuel() != null) {//���������� �Էµ� ���(�޺�)
				select=select+" and fuel='"+uc.getFuel()+"'";
			}
			if(uc.getPrice() != null) {//������ �Էµ� ���
				select=select+" and price="+uc.getPrice();
			}
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;//last()�� ������ ResultSet�� ����
	}
	ResultSet selectNext(UsedCar uc) {
		try {
			if( ! uc.getNum().equals("")) {//������ȣ�� �Էµ� ���
				select=select+" and num='"+uc.getNum()+"'";
			}
			if( uc.getMaker() != null) {//�����簡 �Էµ� ���
				select=select+" and maker='"+uc.getMaker()+"'";
			}
			if( ! uc.getModel().equals("")) {//�𵨸��� �Էµ� ���
				select=select+" and model='"+uc.getModel()+"'";
			}
			if( uc.getMake_year() != null) {//�������� �ԷµȰ��
				select=select+" and make_year='"+uc.getMake_year()+"'";
			}
			if(uc.getKm() != null) {//����Ÿ�(����)�� �Էµ� ���
				select=select+" and km="+uc.getKm();
			}
			if( uc.getFuel() != null) {//���������� �Էµ� ���
				select=select+" and fuel='"+uc.getFuel()+"'";
			}
			if(uc.getPrice() != null) {//������ �Էµ� ���
				select=select+" and price="+uc.getPrice();
			}
			pstmt = conn.prepareStatement(select);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {
			
		}
		return rs2;//next()�� ������ ResultSet�� ����
	}
	
	boolean insert(UsedCar uc) {
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, uc.getNum());
			pstmt.setString(2, uc.getMaker());
			pstmt.setString(3, uc.getModel());
			pstmt.setString(4, uc.getMake_year());
			pstmt.setInt(5, uc.getKm());
			pstmt.setString(6, uc.getFuel());
			pstmt.setInt(7, uc.getPrice());
			pstmt.executeUpdate();//DB�� ����
			flag = true;//���� ������ �ǹ�
		}catch(Exception e) {
			
		}
		return flag;
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
class UsedCar {
	private String num;//������ȣ
	private String maker;//������
	private String model;//�𵨸�
	private String make_year;//������
	private Integer km;//����Ÿ�
	private String fuel;//��������
	private Integer price;//����
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake_year() {
		return make_year;
	}
	public void setMake_year(String make_year) {
		this.make_year = make_year;
	}
	public Integer getKm() {
		return km;
	}
	public void setKm(Integer km) {
		this.km = km;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}

public class UsedCarSystem extends JFrame 
	implements ActionListener, MouseListener{
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = table.getSelectedRow();//������ ���ȣ ȹ��
		txts[0].setText(table.getValueAt(row, 0)+"");//ù��° �����
		combos[0].setSelectedItem(table.getValueAt(row, 1));
		//������ �����Ϳ� ��ġ�ϴ� �׸����� �޺��ڽ��� ����Ѵ�.
		txts[1].setText(table.getValueAt(row, 2)+"");//����° �����
		combos[1].setSelectedItem(table.getValueAt(row, 3));
		txts[2].setText(table.getValueAt(row, 4)+"");//�ټ���° �����
		combos[2].setSelectedItem(table.getValueAt(row, 5));
		txts[3].setText(table.getValueAt(row, 6)+"");//������° �����
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btns[0]) {//���� ����� �������
			//��� �׸��� �Է��� �Ǿ����� �˻��Ѵ�.
			boolean flag = true;
			for(int i=0; i<titles.length; i++) {
				switch(i) {
				case 0: if(txts[0].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[0]+"�� �Էµ��� �ʾҽ��ϴ�.");
							flag = false;
						}
						break;
				case 1: 
						int pos = combos[0].getSelectedIndex();
						if(pos == 0) {
							JOptionPane.showMessageDialog(this, 
								titles[1]+"�� ���õ��� �ʾҽ��ϴ�.");
							flag = false;
						}
						break;
				case 2: if(txts[1].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[2]+"�� �Էµ��� �ʾҽ��ϴ�.");
							flag = false;
						}
						break;
				case 3:
						int pos1 = combos[1].getSelectedIndex();
						if(pos1 == 0) {
							JOptionPane.showMessageDialog(this, 
								titles[3]+"�� ���õ��� �ʾҽ��ϴ�.");
							flag = false;
						}
						break;
				case 4:if(txts[2].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[4]+"�� �Էµ��� �ʾҽ��ϴ�.");
							flag = false;
						}
						break;
				case 5: 
						int pos2 = combos[2].getSelectedIndex();
						if(pos2 == 0) {
							JOptionPane.showMessageDialog(this, 
								titles[5]+"�� ���õ��� �ʾҽ��ϴ�.");
							flag = false;
						}
						break;
				case 6: if(txts[3].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[6]+"�� �Էµ��� �ʾҽ��ϴ�.");
							flag = false;
						}//end of if
				}//end of switch
				if(flag == false) break;//�ݺ� �ߴ�
			}//end of for
			if(flag) {//flag�� true�� ���,��, ��� �׸��� �Էµ� ���
				int j = JOptionPane.showConfirmDialog(this, 
					"������ ����Ͻðڽ��ϱ�?");
				if(j == JOptionPane.OK_OPTION) {//���� ������ ���
					UsedCarDB db = new UsedCarDB();
					UsedCar uc = new UsedCar();//DTO����
					uc.setNum(txts[0].getText());//������ȣ
					uc.setMaker(combos[0].getSelectedItem()+"");
					uc.setModel(txts[1].getText());//�𵨸�
					uc.setMake_year(combos[1].getSelectedItem()+"");
					uc.setKm(Integer.parseInt(txts[2].getText()));
					uc.setFuel(combos[2].getSelectedItem()+"");
					uc.setPrice(Integer.parseInt(txts[3].getText()));
					if(db.db_conn()) {//DB���� ����
						boolean result = db.insert(uc);//DB�� ����

						ResultSet rsLast = db.selectAllLast();
						ResultSet rsNext = db.selectAllNext();
						UsedCarModel um = new UsedCarModel();
						um.setRow(rsLast);
						um.setData(rsNext);
						table.setModel(um);
						table.updateUI();
						
						db.db_disconn();//DB�� ���� ����
						if(result) {//������ ������ ���
							JOptionPane.showMessageDialog(this, 
								"���������� ��ϵǾ����ϴ�.");
						}else {//������ ������ ���
							JOptionPane.showMessageDialog(this, 
								"�������� ����� ���� �ʾҽ��ϴ�.");
						}
					}else {//DB���� ���� 
						JOptionPane.showMessageDialog(this, 
							"DB�� ������� �ʾҽ��ϴ�.");
					}
				}
			}else {//flag�� false�� ��� ��,��� �׸��� �Էµ��� �������
				
			}
		}else if(obj == btns[1]) {//���� ��ȸ�� �������
			UsedCar uc = new UsedCar();//DTO ����
			//������ DTO�� ȭ�鿡 �Էµ� �����͸� �ִ´�.
			uc.setNum(txts[0].getText());
			if(combos[0].getSelectedIndex()!=0) {//�����縦 �����Ѱ��
				uc.setMaker(combos[0].getSelectedItem()+"");
			}
			uc.setModel(txts[1].getText());
			if(combos[1].getSelectedIndex()!=0) {//�������������Ѱ��
				uc.setMake_year(combos[1].getSelectedItem()+"");
			}
			if(txts[2].getText().equals("")) {//����Ÿ��� ���°��
				uc.setKm(null);
			}else {//����Ÿ��� �ִ� ���
				uc.setKm(Integer.parseInt(txts[2].getText()));
			}
			if(combos[2].getSelectedIndex()!=0) {//���Ḧ�����Ѱ��
				uc.setFuel(combos[2].getSelectedItem()+"");
			}
			if(txts[3].getText().equals("")) {//�������Է������������
				uc.setPrice(null);
			}else {
				uc.setPrice(Integer.parseInt(txts[3].getText()));
			}
			UsedCarDB db = new UsedCarDB();
			if(db.db_conn()) {
				ResultSet rsLast = db.selectLast(uc);
				ResultSet rsNext = db.selectNext(uc);
				UsedCarModel model = new UsedCarModel();
				model.setRow(rsLast);
				model.setData(rsNext);
				table.setModel(model);
				table.updateUI();
				db.db_disconn();//DB�� ���� ����
			}else {
				JOptionPane.showMessageDialog(this, 
					"DB�� ������� �ʾҽ��ϴ�.");
			}
		}
	}
	String[] titles= {"������ȣ","������","�𵨸�","������","����Ÿ�",
			"��������","�� ��"};
	String[] btnTitles = {"���� ���","���� ��ȸ"};
	JTextField[] txts; JComboBox[] combos; JPanel[] pans;
	JLabel[] lbls; Font font; JButton[] btns;
	JPanel centerPan, centerLeft; JTable table; JScrollPane span; 
	String[] makerNames = {"�����縦 �����ϼ���","����","���","�ֿ�","����","BMW","�ƿ��",
			"����Ÿ","�Ͻ�","ȥ��"};
	String[] fuelNames = {"���������� �����ϼ���","����","�ֹ���","���͸�"};
	void makeWindow() {
		centerPan = new JPanel(); 
		centerPan.setLayout(new GridLayout(1,2));//1�� 2��
		centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(8,1));//8�� 1��
		for(int i=0; i<pans.length; i++) {
			centerLeft.add(pans[i]);
		}//centerLeft�� �г�8���� ���δ�.
		table = new JTable(); 
		table.addMouseListener(this);
		span = new JScrollPane(table);
		centerPan.add(centerLeft); centerPan.add(span);
		this.add("Center", centerPan);
		this.setBounds(100, 150, 600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		pans = new JPanel[8];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			switch(i) {
			case 0:pans[i].add(lbls[0]); pans[i].add(txts[0]);break;
			case 1:pans[i].add(lbls[1]); pans[i].add(combos[0]);break;
			case 2:pans[i].add(lbls[2]); pans[i].add(txts[1]);break;
			case 3:pans[i].add(lbls[3]); pans[i].add(combos[1]);break;
			case 4:pans[i].add(lbls[4]); pans[i].add(txts[2]);break;
			case 5:pans[i].add(lbls[5]); pans[i].add(combos[2]);break;
			case 6:pans[i].add(lbls[6]); pans[i].add(txts[3]);break;
			case 7:pans[i].add(btns[0]); pans[i].add(btns[1]);break;
			}
		}
	}
	void makeButton() {
		btns = new JButton[btnTitles.length];
		for(int i = 0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].setFont(font);
			btns[i].addActionListener(this);
		}
	}
	void makeCombo() {//������,������,���������� �޺��ڽ��� �Ѵ�.
		combos = new JComboBox[3];
		for(int i=0; i<combos.length; i++) {
			combos[i] = new JComboBox(); combos[i].setFont(font);
			switch(i) {
			case 0: for(int x=0; x<makerNames.length; x++) {
						combos[i].addItem(makerNames[x]);
					}//ù��° �޺��ڽ��� �������̸��� �ִ´�.
					break;
			case 1: combos[i].addItem("�������� �����ϼ���");
					for(int x=2020; x>=1980; x--) {
						combos[i].addItem(x+"");
					}//�ι�° �޺��ڽ��� 2020���� 1980�� �ִ´�.
					break;
			case 2: for(int x=0; x<fuelNames.length; x++) {
						combos[i].addItem(fuelNames[x]);
					}//����° �޺��ڽ��� ����,�ֹ���,���͸��� �ִ´�.
			}
		}
	}
	void makeTextField() {
		txts = new JTextField[4];//������ȣ,�𵨸�,����Ÿ�,���ݿ�
		for(int i=0; i<txts.length; i++) {
			txts[i] = new JTextField(15);
			txts[i].setFont(font);
		}
	}
	public UsedCarSystem(String str) {
		super(str);
		font = new Font("���ü",Font.BOLD, 14);
		makeLabel(); makeTextField(); makeCombo(); makeButton();
		makePanel(); makeWindow();
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
			lbls[i].setFont(font);
		}
	}
	public static void main(String[] args) {
		new UsedCarSystem("�߰��� ���,��ȸ �ý��� ver1.0");
	}
}











