package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_=@Autowired)
	public BoardService service;
	
	
	@Test
	public void testGetList() {
//		service.getList().forEach(boa -> log.info(boa));
		service.getList(new Criteria(2, 10)).forEach(boa -> log.info(boa));
		
	}
	
	
	
	
/*	@Test
	public void testDelete() {
		// 게시물의 존재 여부를 확인후 테스트 
		log.info("remove result: " + service.remove(5l));
	}*/
	
/*	@Test
	public void testUpdate() {
			
		BoardVO board = service.get(3l);
		
		if(board == null){
			log.info("없는 값을 줘서 밖으로 나가기");
			return;
		}
		
		board.setTitle("제목을 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
		
	}*/
	
/*	@Test
	public void testGet() {
			
			log.info(service.get(1l));
	}*/
	

	
/*	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info(service);
		assertNotNull(service);
	}*/
	
/*	@Test
	public void test() {
		
		log.info(service);
		assertNotNull(service);
	}
*/


}
