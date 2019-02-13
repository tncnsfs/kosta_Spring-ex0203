package com.mapper;

import java.util.List;

import com.service.ListBoard;

public interface ListBoardMapper {
	
	int insertlist(ListBoard listboard);
	List<ListBoard> listBoard20(int checklist_no);
	ListBoard detailBoard20(int list_no);
	int updateBoard20(ListBoard listboard);
	int deleteBoard20(ListBoard listboard);

	
	
}
