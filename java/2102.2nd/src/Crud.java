package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBS;
import model.Item;
import model.Jaegu;

public class Crud {
	//SqlSession�� ���ۿ� �ִ� SQL�� ó���Ѵ�.
	
	private final String namespace = "mapper.myMapper";//������ �̸�
	
	public Integer putUser(Jaegu j) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace+".putUser";
			result = session.insert(stmt, j);
			if(result > 0) session.commit();
			else session.rollback();
		}finally {
			session.close();
		}
		return result;
	}
	
	public String selectId(String id) {
		SqlSession session = getSession();
		String result = null;//�˻��� ������ ����� ����
		try {
			String stmt = namespace+".selectId";
			result = session.selectOne(stmt, id);
		}finally {
			session.close();
		}
		return result;
	}
	
	public List<Item> getItembyPage(Integer pageNo){
		SqlSession session = getSession();
		List<Item> itemList = null;
		try {
			String stmt =namespace+".getItembyPage";
			itemList = session.selectList(stmt, pageNo);
		}finally {
			session.close();
		}
		return itemList;
	}
	
	public Item getItem(Integer pid) {//Ư�� ��ǰ�� �˻��ؼ� ����
		SqlSession session = getSession();
		Item item = null;//�˻��� ��ǰ�� ����� ����
		try {
			String stmt = namespace+".getItem";
			item = session.selectOne(stmt, pid);
		}finally {
			session.close();
		}
		return item;
	}
	
	public List<Item> getAllItems(){//��� ��ǰ�� ����
		SqlSession session = getSession();
		List<Item> allItems = null;
		try {
			String stmt = namespace+".getAllItems";
			allItems = session.selectList(stmt);
		}finally {
			session.close();
		}
		return allItems;
	}
	
	public Integer getAllItemsCount() {//��� ��ǰ�� ���� ����
		SqlSession session = getSession();
		Integer totalCount = null;
		try {
			String stmt = namespace+".getAllItemsCount";
			totalCount = session.selectOne(stmt);
			if(totalCount == null) totalCount = 0;
		}finally {
			session.close();
		}
		return totalCount;
	}
	
	public Integer putItem(Item item) {//��ǰ���� ���,�����̸� ���,���и� ��������
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace+".putItem";
			result = session.insert(stmt, item);
			if(result > 0) session.commit();
			else session.rollback();
		}finally {
			session.close();
		}
		return result;
	}
	
	public Integer getMaxPid() {//���� ū ��ǰ��ȣ ����
		SqlSession session = getSession();
		Integer max = null;
		try {
			String stmt = namespace + ".getMaxPid";
			max = session.selectOne(stmt);
			if(max == null) max = 0;
		}finally {
			session.close();
		}
		return max;
	}
	
	public List<BBS> getBBSbyPage(Integer pageno){
		SqlSession session = getSession();
		List<BBS> bbsList = null;//�˻������ ������ ����
		try {
			String stmt = namespace+".getBBSbyPage";
			bbsList = session.selectList(stmt, pageno);
		}finally {
			session.close();
		}
		return bbsList;
	}
	
	public int getTotalCount() {//��ü ���� ������ �˻�
		SqlSession session = getSession();
		Integer totalCount = null;
		try {
			String stmt = namespace+".getTotalCount";
			totalCount = session.selectOne(stmt);
			if(totalCount == null) totalCount = 0;
		}finally {
			session.close();
		}
		return totalCount;
	}
	
	public BBS getBBS(Integer seqno){//Ư�� �Խñ� �˻�
		SqlSession session = getSession();
		BBS bbs = null;//�˻��� ����� ����� ����
		try {
			String stmt = namespace+".getBBS";
			bbs = session.selectOne(stmt,seqno);
		}finally {
			session.close();
		}
		return bbs;
	}
	
	public List<BBS> getAllBBS(){//��� �Խñ� �˻�
		SqlSession session = getSession();
		List<BBS> bbs = null;//�˻��� ����� ����� ����
		try {
			String stmt = "mapper.myMapper.getAllBBS";
			bbs = session.selectList(stmt);
		}finally {
			session.close();
		}
		return bbs;
	}
	
	public Integer getMaxSeqno() {
		SqlSession session = getSession();//SqlSession�� �����Ѵ�.
		Integer max = null;//�ִ� �۹�ȣ�� �� ����
		try {
			String stmt = "mapper.myMapper.getMaxSeqno";
			max = session.selectOne(stmt);
			//���ۿ� �ִ� select ������ ���� : selectOne, selectList
			//selectOne:����(select)�� ����� 1���� �� ���
			//selectList:����(select)�� ����� �������� �� ��� 
			if(max == null) max = 0;
			//���� ū �۹�ȣ�� null -> �Խ��ǿ� ���ʷ� ���� ���
		}finally {
			session.close();//SqlSession��ü�� �ݴ´�.
		}
		return max;
	}//���ۿ� �ִ� ���� ū �۹�ȣ�� �˻��ϴ� �޼���(�������� ȣ��)
	public Integer putBBS(BBS bbs) {
		SqlSession session = getSession();
		Integer result = null;//������ ���(���� ���,���� ����)
		try {
			String stmt="mapper.myMapper.insertBBS";
			result = session.insert(stmt, bbs);
			if(result > 0) session.commit();
			else session.rollback();
		}finally {
			session.close();
		}
		return result;
	}//���̺� �Խñ��� �����ϴ� �޼���(�������� ȣ��)
	
	
	private SqlSession getSession() {//SqlSession��ü�� �����ϴ� �޼���
		String config = "mybatisConfig.xml";//ȯ�漳�������� �̸�
		InputStream is = null;//���Ͽ��� �Է��� ���� ��ü
		try {
			is=Resources.getResourceAsStream(config);//ȯ�漳������ ����.
		}catch(Exception e) {
			
		}
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
}










