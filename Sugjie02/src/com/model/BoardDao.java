package com.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.BoardMapper;

@Repository
public class BoardDao {
	private SqlSessionTemplate sqlTemplate;
	
	@Autowired
	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}
	
	public void insertBoard(Board board){
		sqlTemplate.getMapper(BoardMapper.class).insertBoard(board);
	}
	
	public void updateBoard(Board board){
		sqlTemplate.getMapper(BoardMapper.class).updateBoard(board);
	}
	
	public void deleteBoard(Board board){
		sqlTemplate.getMapper(BoardMapper.class).deleteBoard(board);
	}
	
	
	public List<Board> listBoard(){
		return sqlTemplate.getMapper(BoardMapper.class).listBoard();
	}
	
	public Board detailBoard(int seq){
		return sqlTemplate.getMapper(BoardMapper.class).detailBoard(seq);
	}
	
	
}
