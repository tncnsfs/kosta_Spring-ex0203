package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {27L, 28L, 29L, 30L, 31L};

	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testUpdate(){
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply ");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT: " + count);
		
		mapper.update(vo);
	}
	
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
	
	
	/*@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void test() {
		log.info(mapper);
	}*/
}
