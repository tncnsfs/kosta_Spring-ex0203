package com.mapper;

import java.util.List;

import com.model.Board;

public interface BoardMapper {
	int insertBoard(Board board);
	List<Board> listBoard();
	Board getBoard(int seq);
	int updateBoard(Board board);
}








