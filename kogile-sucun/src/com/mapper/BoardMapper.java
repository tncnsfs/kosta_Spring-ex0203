package com.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.service.Board;
import com.service.ListBoard;
import com.service.Search;

public interface BoardMapper {
	
	int insertchecklist(Board board);
	
	List<Board> checklistBoard();
	
	Board detailBoard(int checklist_no);
	
	int updateBoard(Board board);
	
	int deleteBoard(Board board);

	
}
