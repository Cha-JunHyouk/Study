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
	//SqlSession이 매퍼에 있는 SQL을 처리한다.
	
	private final String namespace = "mapper.myMapper";//매퍼의 이름
	
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
		String result = null;//검색된 계정이 저장될 변수
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
	
	public Item getItem(Integer pid) {//특정 상품을 검색해서 리턴
		SqlSession session = getSession();
		Item item = null;//검색된 상품이 저장될 변수
		try {
			String stmt = namespace+".getItem";
			item = session.selectOne(stmt, pid);
		}finally {
			session.close();
		}
		return item;
	}
	
	public List<Item> getAllItems(){//모든 상품을 리턴
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
	
	public Integer getAllItemsCount() {//모든 상품의 갯수 리턴
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
	
	public Integer putItem(Item item) {//상품정보 등록,성공이면 양수,실패면 음수리턴
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
	
	public Integer getMaxPid() {//가장 큰 상품번호 리턴
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
		List<BBS> bbsList = null;//검색결과를 저장할 변수
		try {
			String stmt = namespace+".getBBSbyPage";
			bbsList = session.selectList(stmt, pageno);
		}finally {
			session.close();
		}
		return bbsList;
	}
	
	public int getTotalCount() {//전체 글의 갯수를 검색
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
	
	public BBS getBBS(Integer seqno){//특정 게시글 검색
		SqlSession session = getSession();
		BBS bbs = null;//검색의 결과가 저장될 변수
		try {
			String stmt = namespace+".getBBS";
			bbs = session.selectOne(stmt,seqno);
		}finally {
			session.close();
		}
		return bbs;
	}
	
	public List<BBS> getAllBBS(){//모든 게시글 검색
		SqlSession session = getSession();
		List<BBS> bbs = null;//검색의 결과가 저장될 변수
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










