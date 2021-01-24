package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBS;

public class Crud {
	//SqlSession�� ���ۿ� �ִ� SQL�� ó���Ѵ�.
	
	public List<BBS> getAllBBS(){//��� �Խñ� �˻�
		SqlSession session = getSession();
		List<BBS> bbs = null;
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










