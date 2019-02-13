package com.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.ListBoardMapper;
import com.service.ListBoard;

public class ListDao {
	private static ListDao dao = new ListDao();
	public static ListDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSession() {
		
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	// insertlist
	//	--------------------------------------------------------------
	
	public int insertlist(ListBoard listboard) {
		SqlSession sqlSession = dao.getSession().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ListBoardMapper.class).insertlist(listboard);
			if(re >0) {
				System.out.println("insertRE ?001:" + re);
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}
	

	//	--------------------------------------------------------------
	
		public List<ListBoard> listBoard20(int checklist_no) {
		SqlSession sqlSession = dao.getSession().openSession();
		List<ListBoard> list = null;
		
		try {
			list = sqlSession.getMapper(ListBoardMapper.class).listBoard20(checklist_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}

	
	public ListBoard detailBoard20(int list_no) {
		SqlSession sqlSession = getSession().openSession(); 
		ListBoard listdetail = null;
		try {
			listdetail = sqlSession.getMapper(ListBoardMapper.class).detailBoard20(list_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return listdetail;
	}


	
	public int deleteBoard20(ListBoard deleteBoard20) {
		int re = -1;
		SqlSession sqlSession = getSession().openSession();
		
		try {
			re = sqlSession.getMapper(ListBoardMapper.class).deleteBoard20(deleteBoard20);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
		
	}

	public int updateBoard20(ListBoard updateBoard20){
		int re = -1;
		SqlSession sqlSession = getSession().openSession();
		
		try {
			re = sqlSession.getMapper(ListBoardMapper.class).updateBoard20(updateBoard20);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}


	
}
