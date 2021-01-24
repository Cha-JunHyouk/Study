package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBS;

public class Crud {
	//SqlSession이 매퍼에 있는 SQL을 처리한다.
	
	public List<BBS> getAllBBS(){//모든 게시글 검색
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
		SqlSession session = getSession();//SqlSession을 생성한다.
		Integer max = null;//최대 글번호가 들어갈 변수
		try {
			String stmt = "mapper.myMapper.getMaxSeqno";
			max = session.selectOne(stmt);
			//매퍼에 있는 select 쿼리를 실행 : selectOne, selectList
			//selectOne:쿼리(select)의 결과가 1건일 때 사용
			//selectList:쿼리(select)의 결과가 여러건일 때 사용 
			if(max == null) max = 0;
			//가장 큰 글번호가 null -> 게시판에 최초로 글을 등록
		}finally {
			session.close();//SqlSession객체를 닫는다.
		}
		return max;
	}//매퍼에 있는 가장 큰 글번호를 검색하는 메서드(서블릿에서 호출)
	public Integer putBBS(BBS bbs) {
		SqlSession session = getSession();
		Integer result = null;//삽입의 결과(성공 양수,실패 음수)
		try {
			String stmt="mapper.myMapper.insertBBS";
			result = session.insert(stmt, bbs);
			if(result > 0) session.commit();
			else session.rollback();
		}finally {
			session.close();
		}
		return result;
	}//테이블에 게시글을 삽입하는 메서드(서블릿에서 호출)
	
	
	private SqlSession getSession() {//SqlSession객체를 생성하는 메서드
		String config = "mybatisConfig.xml";//환경설정파일의 이름
		InputStream is = null;//파일에서 입력을 위한 객체
		try {
			is=Resources.getResourceAsStream(config);//환경설정파일 연다.
		}catch(Exception e) {
			
		}
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
}










