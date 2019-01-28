package com.mapper;

import java.util.List;

import com.model.Board;

public interface BoardMapper {
	int insertBoard(Board board);

	
	List<Board> listBoard();
	Board detailBoard(int seq);
	int updateBoard(Board board);
	int deleteBoard(Board board);


	Board getBoard(int seq);
}








