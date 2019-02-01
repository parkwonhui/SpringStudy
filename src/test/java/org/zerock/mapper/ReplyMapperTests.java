package org.zerock.mapper;

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
	
	// 테스트 전에 해당 번호의 게시물이 존재 하는지 반드시 확인할 것
	private Long[] bnoArr = {8L,11L,21L, 44L, 45L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
/*	@Test
	public void testCreate(){
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			// 게시물 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트"+i);
			vo.setReplyer("replyer"+i);
			System.out.println("왜 안되?"+i);
			mapper.insert(vo);
		});
	}*/

/*	
	@Test
	public void testMapper(){
		log.info(mapper);
	}
	*/
	
	/*@Test
	public void testRead(){
		Long targetRno = 31L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}*/
	
	@Test
	public void testDelete(){
		Long targetRno = 31L;
		mapper.delete(targetRno);
	}
	
	@Test
	public void testUpdate(){
		Long targetRno = 32L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT:"+count);
	}
}
