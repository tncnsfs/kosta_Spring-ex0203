package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {7L, 8L, 9L, 10L, 11L};

	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	
	// 게시물 댓글을 조회 하기 시작 
	@Test
	public void testList2(){
		Criteria cri = new Criteria(2, 5);

		// bno = 8 번 조회 
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[1]);
		
		replies.forEach(reply -> log.info("GoGo" + reply));
	}
	
/*	// 게시물 댓글을 조회 하기 시작 
	@Test
	public void testList(){
		Criteria cri = new Criteria();
		// 31 번 bno 한번 해보잠 
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[4]);
		
		replies.forEach(reply -> log.info("GoGo" + reply));
	}
*/	
/*	@Test
	public void testUpdate(){
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply ");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT: " + count);
		
		mapper.update(vo);
	}*/
	
/*	@Test
	public void testDelete(){
		Long targetRno = 1L;
		
		mapper.delete(targetRno);
	}*/
	
	
/*	@Test
	public void testRead(){
		Long targetRno = 5L;
		
		ReplyVO vo = mapper.read(targetRno);
	}*/
	
	
/*	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
//			vo.setBno(bnoArr[i%5]);
			vo.setBno(bnoArr[1]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}*/
	
	/*	@Test
	public void test() {
		log.info(mapper);
	}*/
}
