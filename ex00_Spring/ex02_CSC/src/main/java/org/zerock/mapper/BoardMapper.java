package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	public List<BoardVO> getList();

	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO board);

	public Integer insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);

	public int getTotalCount(Criteria cri);
}



/*//@Select("select * from tbl_board where bno > 0")
 public List<BoardVO1> getList();

 public void insert(BoardVO1 board);
 public void insertSelectKey(BoardVO1 board);
 
 public BoardVO1 read(Long bno);
 
 public int delete(Long bno);
 
 public int update(BoardVO1 board);*/