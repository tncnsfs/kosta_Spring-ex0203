package kosta.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mapper.BoardMapper;

@Repository
public class BoardDao {
	private SqlSessionTemplate sqlTemplate;

	@Autowired
	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}
	
	public void insert(Board board){
		sqlTemplate.getMapper(BoardMapper.class).insertBoard(board);
	}
	
	public List<Board> listBoard(){
		return sqlTemplate.getMapper(BoardMapper.class).listBoard();
	}
	
	public Board getBoard(int seq){
		return sqlTemplate.getMapper(BoardMapper.class).getBoard(seq);
	}
}










